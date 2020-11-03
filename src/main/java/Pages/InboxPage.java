package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class InboxPage extends BasePage {
    public InboxPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='Inbox']")
    AndroidElement InboxTab;
   public  @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Chats\"]")
    AndroidElement ChatsTab;
   public @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Discussions\"]")
   AndroidElement DisscussionTab;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/userNameTextView")
   AndroidElement Chat;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/groupChatLabelTextView")
   AndroidElement CroupChat;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/topContentViewGroup")
   AndroidElement Disscusion;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/inboxMenuItem")
   AndroidElement Add_Remove_FromInboxbutton;
   @AndroidFindBy (xpath = "//android.widget.ImageButton")
   AndroidElement BackButton;

    public void WaitPresentOFElement(AndroidElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }


    public InboxPage GotoInboxTab(){
        WaitPresentOFElement(InboxTab);
        InboxTab.click();
        return this;
    }
    public InboxPage GotoChatsTab(){
        WaitPresentOFElement(ChatsTab);
        ChatsTab.click();
        return this;
    }
    public InboxPage GotoDisscussinScreen(){
        WaitPresentOFElement(DisscussionTab);
        DisscussionTab.click();
        return this;
    }
    public InboxPage GotoGroupChat(){
        try {
            WaitPresentOFElement(Chat);
            List<AndroidElement> ListOfChats;
            ListOfChats = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/userNameTextView"));
            ListOfChats.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Chat! ");
        }
        return this;
    }
    public InboxPage GotoDisscusion(){
        try {
            WaitPresentOFElement(Disscusion);
            List<AndroidElement> ListOfDisscusions;
            ListOfDisscusions = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/topContentViewGroup"));
            ListOfDisscusions.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any disscusion!");

        }
        return this;
    }

    public boolean IS_Tab_Selected(AndroidElement Element){
        try {
            wait.until(ExpectedConditions.elementToBeSelected(Element));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Tab is not Selected!");
            return false;
        }
    }

    public boolean RemoveCroupChatFromInbox(){
        try {
            WaitPresentOFElement(CroupChat);
            List<AndroidElement> ListOfChats;
            ListOfChats = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/groupChatLabelTextView"));
            ListOfChats.get(0).click();
            WaitPresentOFElement(Add_Remove_FromInboxbutton);
            Add_Remove_FromInboxbutton.click();
            WaitPresentOFElement(BackButton);
            BackButton.click();
            WaitPresentOFElement(ChatsTab);
            try {
                wait.until(ExpectedConditions.visibilityOf(ListOfChats.get(0)));
                Assert.fail("Deleted chat is Displayed!");
                return false;
            } catch (StaleElementReferenceException NoElem){

                return true;
            }

        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any chat to delete!");
            return false;
        }

    }
    public boolean RemoveDisscusionFromInbox(){
        try {
            WaitPresentOFElement(Disscusion);
            List<AndroidElement> ListOfDisscusions = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/topContentViewGroup"));
            ListOfDisscusions.get(0).click();
            WaitPresentOFElement(Add_Remove_FromInboxbutton);
            Add_Remove_FromInboxbutton.click();
            WaitPresentOFElement(BackButton);
            BackButton.click();
            WaitPresentOFElement(DisscussionTab);
            try {
                wait.until(ExpectedConditions.visibilityOf(ListOfDisscusions.get(0)));
                Assert.fail("Deleted chat is Displayed!");
                return false;
            } catch (StaleElementReferenceException NoElem){

                return true;
            }

        }catch (TimeoutException TimeOut){
            Assert.fail("There is no any Discussion!");
            return false;
        }


    }
    public boolean IS_Chat_Disscusion_was_Opened(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/messageEditText")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/inboxMenuItem")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/sendMessageImageView")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Chat or Disscusion was not opened!");
            return false;
        }
    }
}

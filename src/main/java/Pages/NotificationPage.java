package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.weaver.ast.Not;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.Time;
import java.util.List;

public class NotificationPage extends BasePage {
    public NotificationPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
     @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='Notifications']")
    AndroidElement NotificationTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/viewButton")
    AndroidElement ViewButton;
   public  @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Notifications\"]/android.widget.TextView")
    AndroidElement NotificationScreen;
  public   @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Requests\"]")
    AndroidElement RequestsTab;
  @AndroidFindBy (id = "com.jelvix.crowdthinc:id/deleteMenuItem")
  AndroidElement ClearAllButton;
  @AndroidFindBy (xpath = "//android.widget.TextView[@text='Clear all notifications']")
  AndroidElement ClearAllNotificationsButton;
  @AndroidFindBy (xpath = "//android.widget.TextView[@text='Clear all requests']")
  AndroidElement ClearAllRequestsButton;
  @AndroidFindBy (id = "com.jelvix.crowdthinc:id/settingsMenuItem")
  AndroidElement NotificationSettingsButton;

    public void WaitPresentOFElement(AndroidElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public NotificationPage GotoNotificationPage(){
        WaitPresentOFElement(NotificationTab);
        NotificationTab.click();
        return this;
    }
    public NotificationPage GotoNotificationScreen(){
     WaitPresentOFElement(NotificationScreen);
     NotificationScreen.click();
     return this;
    }
    public NotificationPage ClcikOnTheViewButton(){
        try {
            WaitPresentOFElement(ViewButton);
            List<AndroidElement> ListOfViewButtons = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/viewButton"));
            ListOfViewButtons.get(0).click();
        }catch (TimeoutException TimeOut){
            Assert.fail("There is no any View Button");
        }

        return this;
    }
    public NotificationPage ClcikOnTheClearALLButton(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/contentLayout")));
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no content!");
        }
        WaitPresentOFElement(ClearAllButton);
        ClearAllButton.click();
        return this;
    }

    public NotificationPage GotoRequestsScreen(){
        WaitPresentOFElement(RequestsTab);
        RequestsTab.click();
        return this;
    }
    public NotificationPage ClcikOnClearAllNotificationButton(){
        WaitPresentOFElement(ClearAllNotificationsButton);
        ClearAllNotificationsButton.click();
        return this;
    }
    public NotificationPage ClcikOnTheClearAllRequestsButton(){
        WaitPresentOFElement(ClearAllRequestsButton);
        ClearAllRequestsButton.click();
        return this;
    }
    public NotificationPage GotoNotificationSettings(){
        WaitPresentOFElement(NotificationSettingsButton);
        NotificationSettingsButton.click();
        return this;
    }
    public boolean IS_User_WasRedirectedByClickingToViewButton(){
        try {
           wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/viewButton")));
           return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Notification Screen was not changed!");
            return  false;
        }
    }
    public boolean IS_TabSelected(AndroidElement Tab){
        try {
            wait.until(ExpectedConditions.elementToBeSelected(Tab));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Tab is not Selected!");
            return  false;
        }
    }
    public boolean IS_Notification_or_Requests_Was_Deleted(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/noItemsImageView")));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/textView"),"No Results"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Notifications was not deleted!");
            return false;
        }
    }
    public boolean IS_Notification_Settings_Screen_ISDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Notifications Settings']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/personalNotificationsTextView")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/mySurveysNotificationsTextView")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/communitiesNotificationsTextView")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/myCommunitiesNotificationsTextView")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Notification Setting Screen is not displayed!");
            return false;
        }
    }
}

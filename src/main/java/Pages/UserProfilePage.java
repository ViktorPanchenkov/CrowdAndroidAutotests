package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UserProfilePage extends CommunityPage {
    public UserProfilePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/userSurveysLayout")
    AndroidElement UserSurveys;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/communitiesLayout")
    AndroidElement UserCommunities;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/blockUserTextView")
    AndroidElement Block_Unblock_UserButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/sendMessageButton")
    AndroidElement SendPersonalMassageButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/messageEditText")
    AndroidElement InputForMessage;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/sendMessageImageView")
    AndroidElement SendMessageButton;

    public CommunityPage GotoUserSurveysTab(){
        try {
            WaitVisisbilityOfElement(UserSurveys);
            UserSurveys.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("User Surveys button is not displayed!");
        }

        return this;
    }
    public UserProfilePage GotoUserCommunitiesTab(){
        try {
            WaitVisisbilityOfElement(UserCommunities);
            UserCommunities.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("User communities button is not displayed!");
        }
        return this;
    }
    public UserProfilePage ClcikOnTheBlockUserButton() throws Exception {
        try {
            WaitVisisbilityOfElement(Block_Unblock_UserButton);
            if (Block_Unblock_UserButton.getText().equals("Block User")){
                Block_Unblock_UserButton.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/blockTextView"))).click();
            } else {
                throw new Exception("The user already banned!");
            }

        } catch (TimeoutException TimeOut){
            Assert.fail("Block User button is not displayed!");
        }
        return this;
    }
    public UserProfilePage ClcikOnTheUnblockUserButton() throws Exception{
        try {
            WaitVisisbilityOfElement(Block_Unblock_UserButton);
            if (Block_Unblock_UserButton.getText().equals("Unblock User")){
                Block_Unblock_UserButton.click();
            } else {
                throw new Exception("The user was not banned!");
            }
        } catch (TimeoutException TimeOut){
            Assert.fail("Block User button is not displayed!");
        }
        return this;
    }

    public UserProfilePage GotoPersonalMassageWithUser(){
       WaitVisisbilityOfElement(SendPersonalMassageButton);
       SendPersonalMassageButton.click();
       return this;
    }
    public UserProfilePage EnterTextOfMessege(String Messege){
        WaitVisisbilityOfElement(InputForMessage);
        InputForMessage.sendKeys(Messege);
        return this;
    }
    public UserProfilePage ClcikOnSendMessageButton(){
        WaitVisisbilityOfElement(SendMessageButton);
        SendMessageButton.click();
        return this;
    }

    public boolean IS_User_Profile_Displayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/blockUserLayout")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/sendMessageButton")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User Profile is not display!");
            return false;
        }
    }

    public boolean IS_User_Surveys_Displayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='User Surveys']")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User Survey Tab is not displayed!");
            return false;
        }
    }
    public boolean IS_User_Communityes_Displayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='User communities']")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User Communities Tab is not opened!");
            return false;
        }
    }
    public boolean IS_User_Was_Blocked(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/blockUserTextView"),"Unblock User"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User was not Blocked!");
            return false;
        }
    }
    public boolean IS_User_was_Unbloked(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(Block_Unblock_UserButton,"Block User"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User was not unbloked!");
            return false;
        }
    }
    public boolean IS_Massage_Was_Sent(String Massage){
      try {
          String SentMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+  Massage +"']"))).getText();
          System.out.println(SentMessage);
          return true;
      } catch (TimeoutException TimeOut){
          Assert.fail("Massage was not displsyed in chat!");
          return false;
      }
    }




}

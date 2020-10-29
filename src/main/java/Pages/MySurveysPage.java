package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.Time;
import java.util.List;

public class MySurveysPage extends BasePage {

    public MySurveysPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='My Surveys']")
    AndroidElement MySurveysTab;
   public  @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"My Own\"]")
    AndroidElement MyOwnSurveyTab;
   public  @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Passed\"]")
    AndroidElement PassedTab;
   public  @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Drafts\"]")
    AndroidElement DraftsTab;
   @AndroidFindBy (xpath = "//android.widget.TextView[@text='Passed']")
   AndroidElement PassedSurveyInPassedTab;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/completeSurveyButton")
   AndroidElement CompleteSurveyButton;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/headerViewGroup")
   AndroidElement Survey;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/deleteDraftButton")
   AndroidElement DeleteDraftButton;

    public void WaitVisabilityOfElement(AndroidElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public MySurveysPage GotoMySurveysPage() {
        WaitVisabilityOfElement(MySurveysTab);
        MySurveysTab.click();
        return this;
    }

    public MySurveysPage GotoMyOwnTab() {
        WaitVisabilityOfElement(MyOwnSurveyTab);
        MyOwnSurveyTab.click();
        return this;
    }

    public MySurveysPage GotoPassedTab() {
        WaitVisabilityOfElement(PassedTab);
        PassedTab.click();
        return this;
    }

    public MySurveysPage GoToDraftsTab() {
        WaitVisabilityOfElement(DraftsTab);
        DraftsTab.click();
        return this;
    }
    public MySurveysPage GotoPassedSurveyFromList(){
        WaitVisabilityOfElement(PassedSurveyInPassedTab);
        try {

            List<AndroidElement> ListOfLiveSurveys = androidDriver.findElements(By.xpath("//android.widget.TextView[@text='Passed']"));
            ListOfLiveSurveys.get(1).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Passed Survey!");
        }

        return this;
    }
    public MySurveysPage ClcikOnCompleteCommunityButton(){
        WaitVisabilityOfElement(CompleteSurveyButton);
        CompleteSurveyButton.click();
        return this;
    }
    public MySurveysPage GotoSurveyFromList(){
        try {
            WaitVisabilityOfElement(Survey);
            Survey.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any survey!");
        }

        return this;
    }
    public MySurveysPage ClickOnTheDeleteDraftButton(){
        WaitVisabilityOfElement(DeleteDraftButton);
        DeleteDraftButton.click();
        return this;
    }



    public boolean IS_TabSelected(AndroidElement Tab) {

        try {
            wait.until(ExpectedConditions.elementToBeSelected(Tab));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Tab is not Selected!");
            return false;
        }
    }
    public boolean IS_Survey_Was_Completed(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/earnedPointsTextView"),"Completed"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Status of survey is not Completed!");
            return false;
        }
    }
    public boolean IS_Draft_Was_Published(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/startSurveyButton")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/discussLayout")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("The Survey was not published!");
            return false;
        }
    }

}

package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class BookmarksPage extends BasePage {
    public BookmarksPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='Bookmarks']")
    AndroidElement BookmarksTab;
   public  @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Communities\"]")
    AndroidElement CommunitiesTab;
   public  @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Survey\"]")
    AndroidElement SurveysTab;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/titleTextView")
   AndroidElement Community;
   @AndroidFindBy (id = "com.jelvix.crowdthinc:id/title")
   AndroidElement Survey;


    public void WaitVisabilityOFElement(AndroidElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public BookmarksPage GotoBookmarkPage(){
        WaitVisabilityOFElement(BookmarksTab);
        BookmarksTab.click();
        return new BookmarksPage(androidDriver);
    }
    public BookmarksPage GotoSurveysTab(){
        WaitVisabilityOFElement(SurveysTab);
        SurveysTab.click();
        return this;
    }
    public BookmarksPage GotoCommunitiesTab(){
        WaitVisabilityOFElement(CommunitiesTab);
        CommunitiesTab.click();
        return this;
    }
    public BookmarksPage GotoCommunity(){
        try {
            WaitVisabilityOFElement(Community);
            List<AndroidElement> ListOfCommunities = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/titleTextView"));
            ListOfCommunities.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There id no any Bockmarked community!");
        }

        return this;
    }
    public BookmarksPage GotoBookmarckedSurvey(){
        try {
            WaitVisabilityOFElement(Survey);
            List<AndroidElement> ListOfSurveys = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/title"));
            ListOfSurveys.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any bockmarked survey! ");
        }
        return this;
    }


    public boolean IS_Tab_Selected(AndroidElement Tab){
        try {
            wait.until(ExpectedConditions.elementToBeSelected(Tab));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Tab is not Selected!");
            return false;
        }
    }
    public boolean IS_Community_Open(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/unbookmarkMenuItem")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/moderatorsLayout")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/followersLayout")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not opened!");
            return false;
        }
    }
    public boolean IS_Survey_Opened(){
        try {
            AndroidElement DisscusButton = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/discussLayout")));
            AndroidElement SurveyTitle = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
            AndroidElement SurveyDescription = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/fullDescriptionTextView")));
            AndroidElement StatisticButton = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/viewStatisticButton")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey was not opened!");
            return false;
        }
    }

}

package Tests;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySurveysPageTests extends TestBase {

    @BeforeMethod
    public void GotoMySurveysPage() {
        // String Phone = "1113333333";
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        mySurveysPage.GotoMySurveysPage();

    }

    @Test
    public void GotoMyOwnTab(){
       mySurveysPage.GotoMyOwnTab();
        Assert.assertTrue(mySurveysPage.IS_TabSelected(mySurveysPage.MyOwnSurveyTab));
    }
    @Test
    public void GotoPassedTab(){
        mySurveysPage.GotoPassedTab();
        Assert.assertTrue(mySurveysPage.IS_TabSelected(mySurveysPage.PassedTab));
    }
    @Test
    public void GotoDraftTab(){
        mySurveysPage.GoToDraftsTab();
        Assert.assertTrue(mySurveysPage.IS_TabSelected(mySurveysPage.DraftsTab));
    }
    @Test
    public void CompletePassedSurvey(){
        mySurveysPage.GotoPassedTab().
                GotoPassedSurveyFromList().
               ClcikOnCompleteCommunityButton().
                IS_Survey_Was_Completed();
    }
    @Test
    public void PublishDraft(){
        String Title = "It was a Draft";
        String Description = "Description of Draft";
        mySurveysPage.GoToDraftsTab().
                GotoSurveyFromList();
        communityPage.Enter_Title(Title).
                Enter_Description(Description).
                ClcikOnTheCreateSurveyButton().
                ClcikOnTheCreateSurveyPointsButton();
        communityPage.ClcikOnTheOkButtonOnConfirmationPopUP();
        Assert.assertTrue(mySurveysPage.IS_Draft_Was_Published());
    }
    @Test
    public void DeleteDraft(){
        mySurveysPage.GoToDraftsTab();
        List<AndroidElement> ListOfDraftSurveys = new ArrayList<>();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/headerViewGroup")));
             ListOfDraftSurveys = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/headerViewGroup"));
            ListOfDraftSurveys.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("Threre is no any Draft Survey!");
        }
        mySurveysPage.ClickOnTheDeleteDraftButton();
        communityPage.ClcikOnTheOkButtonOnConfirmationPopUP();
        try {
            wait.until(ExpectedConditions.invisibilityOf(ListOfDraftSurveys.get(0)));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Draft was not deleted!");
        }

    }

}

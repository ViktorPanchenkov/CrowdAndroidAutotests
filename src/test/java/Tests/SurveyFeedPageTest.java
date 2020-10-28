package Tests;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SurveyFeedPageTest extends TestBase {

    @BeforeMethod
    public void GotoSurveyPage(){
        String Phone ="1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
    }
    @Test
    public void GotoAllTab(){
     surveyFeedPage.GotoAllTab();
        Assert.assertTrue(surveyFeedPage.IsTabSelected(surveyFeedPage.AllTab));
    }
    @Test
    public void GotoFollowingTab(){
        surveyFeedPage.GoToFollowingTab();
        Assert.assertTrue(surveyFeedPage.IsTabSelected(surveyFeedPage.FollowingTab));
    }
    @Test
    public void PassSurveyInFollowingCommunity(){
        String NameOfSurvey = "Yes no survey";
        surveyFeedPage.GoToFollowingTab().
                ClcikOnSearchButton().
                EnterTextInSearchInput(NameOfSurvey).
                GotoRandomSurveyFromList().
                ClickOnStartSurveyButton();
        surveyFeedPage.SelectAnswer();
        surveyFeedPage.ClcickOnNext_FinishButton().
               SelectInpotantQuestionAnswer();
        surveyFeedPage.ClcickOnNext_FinishButton();
        Assert.assertTrue(surveyFeedPage.ISThankYouPopUPDisplayed());
    }
    @Test
    public void PassThePulseSurvey(){
       surveyFeedPage.GotoPulse().
               ClcikOnAnswerPulseButton().
               SelectAnswerForPulse();
       surveyFeedPage.ClickOnSubmitAnswerButton();

       Assert.assertTrue(surveyFeedPage.ISubmitAnswerButtonIsNotDisplayed());

    }
    @Test
    public void GoToThePulseTodayStatistic(){
        surveyFeedPage.GotoPulse().
                SelectTodayPulseStatistic().
                GotoPulseStatistic();
        Assert.assertTrue(surveyFeedPage.ISPulsetatisticDisplayed());
    }
    @Test
    public void GotoPulseAllPeriodStatistic(){
        surveyFeedPage.GotoPulse().
                SelectAllPeridPulseStatistic().
                GotoPulseStatistic();
        Assert.assertTrue(surveyFeedPage.ISPulsetatisticDisplayed());
    }
    @Test
    public void GotoSurveyStatistic(){
        surveyFeedPage.GoToFollowingTab().
                GotoRandomSurveyFromList().
                ClcikOnTheViewStatisticButton();
        Assert.assertTrue(surveyFeedPage.ISSurveyStastisticScreenDisplayed());
    }
    @Test
    public void GotoSurveyDisscussion(){
        surveyFeedPage.GoToFollowingTab().
                GotoRandomSurveyFromList().
                ClcikOnTheDisscusButton();
        Assert.assertTrue(surveyFeedPage.ISDisscussonWasOpen());
    }
    @Test
    public void SendMassageToDisscussion(){
        String TextOfMassage = "Text by autotest";
        surveyFeedPage.GoToFollowingTab().
                GotoRandomSurveyFromList().
                ClcikOnTheDisscusButton().
                TypeTextForDisscussin(TextOfMassage).
                ClcikOnTheSendMassagetoDisscussionButton();
        Assert.assertTrue(surveyFeedPage.ISSent_Massage_Displayed(TextOfMassage));
    }


}

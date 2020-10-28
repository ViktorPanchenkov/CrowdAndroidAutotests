package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SurveyFeedPage  extends BasePage {

    public SurveyFeedPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"All\"]")
    AndroidElement AllTab;
    public @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Following\"]\n")
    AndroidElement FollowingTab;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/headerViewGroup")
    AndroidElement SurveyFromList;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/startSurveyButton")
    AndroidElement StartSurveyButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/discussLayout")
    AndroidElement DiscussButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/viewStatisticButton")
    AndroidElement ViewStaticticButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/okButton")
    AndroidElement OkButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/searchMenuItem")
    AndroidElement SearchButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/searchEditText")
    AndroidElement SearchInput;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/nextButton")
    AndroidElement Next_FinishButton;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='YES! :)']")
    AndroidElement ImpotantquestionAnswer;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/doneTextView")
    AndroidElement DoneButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/pulseQuestion")
    AndroidElement PulseSurvey;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/changeTypeOfPulsePreviewButton")
    AndroidElement PulseAnswerButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/submitAnswerButton")
    AndroidElement SubmitAnswerButton;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/pulseStatisticsViewGroup")
    AndroidElement PulseStatistic;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/todayTextView")
    AndroidElement TodayPulseStatistic;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/allPeriodTextView")
    AndroidElement AllPeriodPulseStatistic;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/discussLayout")
    AndroidElement DisscussButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/inboxMenuItem")
    AndroidElement AddDisscusionToInboxButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/sendMessageImageView")
    AndroidElement Send_Massage_To_Disscussin_Button;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/messageEditText")
    AndroidElement TextInput_On_Disscuss_Screen;



    public void WaitVisabilityOfElement(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public SurveyFeedPage GotoAllTab() {
        WaitVisabilityOfElement(AllTab);
        AllTab.click();
        return this;
    }

    public SurveyFeedPage GoToFollowingTab() {
        WaitVisabilityOfElement(FollowingTab);
        FollowingTab.click();
        return this;
    }

    public SurveyFeedPage ClcikOnSearchButton() {
        WaitVisabilityOfElement(SearchButton);
        SearchButton.click();
        return this;
    }

    public SurveyFeedPage EnterTextInSearchInput(String NameOfSurvey) {
        WaitVisabilityOfElement(SearchInput);
        SearchInput.sendKeys(NameOfSurvey);
        return this;
    }

    public SurveyFeedPage GotoRandomSurveyFromList() {
        WaitVisabilityOfElement(SurveyFromList);
        List<AndroidElement> ListOfSurveys;
        ListOfSurveys = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/headerViewGroup"));
        ListOfSurveys.get(0).click();
        return this;
    }

    public SurveyFeedPage GotoPulse() {
        WaitVisabilityOfElement(PulseSurvey);
        List<AndroidElement> ListOfPulses;
        ListOfPulses = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/pulseQuestion"));
        ListOfPulses.get(0).click();
        return this;
    }

    public SurveyFeedPage ClcickOnNext_FinishButton() {
        WaitVisabilityOfElement(Next_FinishButton);
        Next_FinishButton.click();
        return this;
    }

    public SurveyFeedPage ClickOnStartSurveyButton() {
        WaitVisabilityOfElement(StartSurveyButton);
        StartSurveyButton.click();

        return this;

    }

    public void SelectAnswer() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 6);
        WebElement Answer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[1]")));

        Answer1.click();
    }

    public void SelectAnswerForPulse() {
        int Random = (int) (Math.random() * 10);
        AndroidElement Answer1 = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/firstOptionRadioButton")));
        AndroidElement Answer2 = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/secondOptionRadioButton")));
        if (Random <= 5) {
            Answer1.click();
        } else if (Random >= 5) {
            Answer2.click();
        }

    }

    public SurveyFeedPage SelectInpotantQuestionAnswer() {
        WaitVisabilityOfElement(ImpotantquestionAnswer);
        ImpotantquestionAnswer.click();
        return this;
    }
    public SurveyFeedPage ClcikOnTheViewStatisticButton(){
        WaitVisabilityOfElement(ViewStaticticButton);
        ViewStaticticButton.click();
        return this;
    }

    public SurveyFeedPage ClcikOnAnswerPulseButton() {
        WaitVisabilityOfElement(PulseAnswerButton);
        PulseAnswerButton.click();
        return this;
    }

    public SurveyFeedPage ClickOnSubmitAnswerButton() {
        WaitVisabilityOfElement(SubmitAnswerButton);
        SubmitAnswerButton.click();
        return this;
    }
    public SurveyFeedPage GotoPulseStatistic(){
        WaitVisabilityOfElement(PulseStatistic);
        PulseStatistic.click();
        return this;
    }
    public SurveyFeedPage SelectTodayPulseStatistic(){
        WaitVisabilityOfElement(TodayPulseStatistic);
        TodayPulseStatistic.click();
        return this;
    }
    public SurveyFeedPage SelectAllPeridPulseStatistic(){
        WaitVisabilityOfElement(AllPeriodPulseStatistic);
        AllPeriodPulseStatistic.click();
        return this;
    }
    public SurveyFeedPage ClcikOnTheDisscusButton(){

        WaitVisabilityOfElement(DisscussButton);
        DisscussButton.click();
        return this;
    }
    public SurveyFeedPage TypeTextForDisscussin(String Text){
        WaitVisabilityOfElement(TextInput_On_Disscuss_Screen);
        TextInput_On_Disscuss_Screen.sendKeys(Text);
        return this;
    }
    public SurveyFeedPage ClcikOnTheSendMassagetoDisscussionButton(){
        WaitVisabilityOfElement(Send_Massage_To_Disscussin_Button);
        Send_Massage_To_Disscussin_Button.click();
        return  this;
    }


    public boolean IsTabSelected(AndroidElement Tab) {
        try {
            wait.until(ExpectedConditions.elementToBeSelected(Tab));
            return true;
        } catch (TimeoutException TimeOut) {
            Assert.fail("Tab is not Selected!");
            return false;
        }
    }

    public boolean ISThankYouPopUPDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(DoneButton));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Thank you!']")));
            DoneButton.click();
            return true;
        } catch (TimeoutException TimeOut) {
            Assert.fail("PopUp After Passing Survey was not displayed!");
            return false;
        }
    }

    public boolean ISubmitAnswerButtonIsNotDisplayed() {
        try {
           wait.until(ExpectedConditions.visibilityOf(PulseStatistic));
            return true;

        } catch (TimeoutException TimeOut) {
            Assert.fail("Statistics is not displayed!");
            return false;
        }
    }
    public boolean ISPulsetatisticDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/lineChart")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/totalViewGroup")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/highestActivityViewGrop")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Today Statistic is not displayed!");
            return false;
        }
    }
    public boolean ISSurveyStastisticScreenDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/yesTextView")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/nextButton"))).click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey Statistic Screen is not displayed!");
            return false;
        }
    }
    public boolean ISDisscussonWasOpen(){
        try {
            wait.until(ExpectedConditions.visibilityOf(AddDisscusionToInboxButton));
            wait.until(ExpectedConditions.visibilityOf(Send_Massage_To_Disscussin_Button));
            wait.until(ExpectedConditions.visibilityOf(TextInput_On_Disscuss_Screen));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Disscussion was not opened!");
            return false;
        }
    }
    public boolean ISSent_Massage_Displayed(String MassageText){
        try {
            Boolean SendMassage = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/messageTextView"),MassageText));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Massage is not displayed!");
            return false;
        }
    }
}

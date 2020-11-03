package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.Time;
import java.util.List;


public class CommunityPage extends BasePage {

    public CommunityPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='Community Feed']")
    AndroidElement CommunityTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/searchMenuItem")
    AndroidElement SearchButton;
    @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"All\"]\n")
    AndroidElement AllTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/searchEditText")
    AndroidElement SearchInput;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/fab")
    AndroidElement AddCommunityButton;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/pointCostTextView")
    AndroidElement CostButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/titleEditText")
    AndroidElement Title_Text_Input;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/descriptionEditText")
    AndroidElement Description_Text_Fieled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/categoryTextView")
    AndroidElement CategorySelection;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/locationTextView")
    AndroidElement LocationSelection;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/avatarImageView")
    AndroidElement ImageLelection;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/createCommunityButton")
    AndroidElement CreateCommunityButton;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/createSurveyButton")
    AndroidElement PostSurveyButton;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/okButton")
    AndroidElement OKButton_On_Sucsuss_PopUP;
    @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"My Own\"]")
    AndroidElement MyOwnTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/titleTextView")
    AndroidElement Community;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/questionsViewGroup")
    AndroidElement GotoQuestionButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/fab")
    AndroidElement AddQuestionButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/questionTypeTextView")
    AndroidElement AnswerTypeButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/doneImageView")
    AndroidElement DoneButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/saveMenuItem")
    AndroidElement SaveButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/createButton")
    AndroidElement CreateSurveyButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/unfollowMenuItem")
    AndroidElement UnfollowCommunityButton;
    @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Following\"]")
    AndroidElement FollowingTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/followMenuItem")
    AndroidElement FollowCommunityButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/editMenuItem")
    AndroidElement EditCommunityButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text='ADD NEWS']")
    AndroidElement AddCommunityNewsButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/newsImageView")
    AndroidElement NewsImageButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/confirmMenuItem")
    AndroidElement SaveNewsButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/deleteNewsButton")
    AndroidElement DeleteNewsButton;
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/chatButton")
    AndroidElement GroupChatButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/messageEditText")
    AndroidElement InputForMassage;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/sendMessageImageView")
    AndroidElement SendMassageButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/conversationButton")
    AndroidElement DisscussionsTabButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/addMenuItem")
    AndroidElement AddDisscusionButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/createDiscussionButton")
    AndroidElement CreateDisscusionButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/surveysInDetailButton")
    AndroidElement SurveyInDetailButton;
    @AndroidFindBy (xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Moderation\"]")
    AndroidElement ModerationTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/approveButton")
    AndroidElement AprroveSurveyButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/rejectButton")
    AndroidElement RejectSurveyButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/moderatorsLayout")
    AndroidElement ModeratorsTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/followersLayout")
    AndroidElement FollowersTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/userNameTextView")
    AndroidElement UserWithName;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/flaggedCommentsLayout")
    AndroidElement FlaggedTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/deleteTextView")
    AndroidElement DeleteFlaggedItemButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/approveTextView")
    AndroidElement ItIsOKFlaggedItemButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/publicSwitch")
    AndroidElement Public_Privet_Switcher;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/qualifiedQuestionSwitch")
    AndroidElement QualifierSwither;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/userSurveysLayout")
    AndroidElement UserSurveys;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/communitiesLayout")
    AndroidElement UserCommunities;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/blockUserTextView")
    AndroidElement BlockUserButton;





    public void WaitVisisbilityOfElement(AndroidElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public CommunityPage GotoCommunityTab(){
        WaitVisisbilityOfElement(CommunityTab);
        CommunityTab.click();
        return this;
    }
    public CommunityPage ClcikOnSearchButton(){
        WaitVisisbilityOfElement(SearchButton);
        SearchButton.click();
        return this;
    }
    public CommunityPage GotoAllTab(){
        WaitVisisbilityOfElement(AllTab);
        AllTab.click();
        return this;
    }
    public CommunityPage EnterNameOfCommunity(String NameOfCommunity){
        WaitVisisbilityOfElement(SearchInput);
        SearchInput.sendKeys(NameOfCommunity);
        return this;
    }
    public CommunityPage ClickOnAddCommunityButton(){
        WaitVisisbilityOfElement(AddCommunityButton);
        AddCommunityButton.click();
        return this;
    }
    public CommunityPage ClickOnTheCostButton(){
        WaitVisisbilityOfElement(CostButton);
        CostButton.click();
        return this;
    }
    public CommunityPage Enter_Title(String Title){
        WaitVisisbilityOfElement(Title_Text_Input);
        Title_Text_Input.clear();
        Title_Text_Input.sendKeys(Title);
        return this;
    }
    public CommunityPage GotoFollowersTab(){
        WaitVisisbilityOfElement(FollowersTab);
        FollowersTab.click();
        return this;
    }
    public CommunityPage GotoModeratorsTab(){
        WaitVisisbilityOfElement(ModeratorsTab);
        ModeratorsTab.click();
        return this;
    }
    public void ScrollDown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
        TouchAction action = new TouchAction(androidDriver);
        action.press(new PointOption().withCoordinates(984,2610)).waitAction().moveTo(new PointOption().withCoordinates(984,2352)).release().perform();

    }
    public void ScrollUP(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
        TouchAction action = new TouchAction(androidDriver);
        action.press(new PointOption().withCoordinates(984,2352)).waitAction().moveTo(new PointOption().withCoordinates(984,2610)).release().perform();

    }
    public CommunityPage Enter_Description(String Description){
        WaitVisisbilityOfElement(Description_Text_Fieled);
        Description_Text_Fieled.clear();
        Description_Text_Fieled.sendKeys(Description);
        return this;
    }
    public CommunityPage SelectCategory(){
        WaitVisisbilityOfElement(CategorySelection);
        CategorySelection.click();
        ScrollDown();
       // ScrollUP();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/doneImageView"))).click();

        return this;
    }
    public CommunityPage SelectLocation(){
        WaitVisisbilityOfElement(LocationSelection);
        LocationSelection.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/doneImageView"))).click();
        return this;

    }
    public CommunityPage ClcikOnAddNewsButton(){
        WaitVisisbilityOfElement(AddCommunityNewsButton);
        AddCommunityNewsButton.click();
        return this;
    }
    public CommunityPage AddImageForNews(){
        WaitVisisbilityOfElement(NewsImageButton);
        NewsImageButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/cameraTextView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/progress_overlay"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/shutter_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/done_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/crop_image_menu_crop"))).click();
        return this;

    }
    public CommunityPage Select_Community_Image(){
        WaitVisisbilityOfElement(ImageLelection);
        ImageLelection.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/cameraTextView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/progress_overlay"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/shutter_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.camera2:id/done_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/crop_image_menu_crop"))).click();
        return this;
    }
    public CommunityPage ClcikOnCreateCommunityButton(){
        WaitVisisbilityOfElement(CreateCommunityButton);
        CreateCommunityButton.click();
        return this;
    }
    public CommunityPage GotoMyOwnTab(){
        WaitVisisbilityOfElement(MyOwnTab);
        MyOwnTab.click();
        return this;
    }
    public CommunityPage GotoFollowingTab(){
        try {
            WaitVisisbilityOfElement(FollowingTab);
            FollowingTab.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("User is not a follower of this community!");
        }

        return this;
    }
    public CommunityPage GotoCommunityFromList(int numberOFCommunityFromList){
        WaitVisisbilityOfElement(Community);
        try {
            List<AndroidElement> ListOfCommunities = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/titleTextView"));
            ListOfCommunities.get(numberOFCommunityFromList).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Community");
        }

        return this;
    }
    public CommunityPage GotoCommunityFromList(String NameOfCommunity){
        WaitVisisbilityOfElement(Community);
        ClcikOnSearchButton();
        EnterNameOfCommunity(NameOfCommunity);

        try {
            Community.click();
        } catch (TimeoutException TimeOut){;
            Assert.fail("There is no any Community");
        }

        return this;
    }

    public CommunityPage ClcikOnThePostSurveyButton(){
        try {
            WaitVisisbilityOfElement(PostSurveyButton);
            PostSurveyButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("Post Survey Button is not displayed!");
        }

        return this;
    }
    public CommunityPage ClcikOnEditCommunityButton(){
        try {
            WaitVisisbilityOfElement(EditCommunityButton);
            EditCommunityButton.click();
        } catch (TimeoutException Timeout){
            Assert.fail("Edit Community Button is not displayed!");
        }
        return this;
    }
    public CommunityPage GotoAddQuestionScreen(){
        WaitVisisbilityOfElement(GotoQuestionButton);
        GotoQuestionButton.click();
        return this;
    }
    public CommunityPage ClcikOnAddQuestionButton(){
        try {
            WaitVisisbilityOfElement(AddQuestionButton);
            AddQuestionButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("Add Question button is not displayed!");
        }
        return this;
    }
    public CommunityPage ClcikOnTheAnswerButton(){
        WaitVisisbilityOfElement(AnswerTypeButton);
        AnswerTypeButton.click();
        return this;
    }
    public CommunityPage ClcikOnDoneButton(){
        WaitVisisbilityOfElement(DoneButton);
        DoneButton.click();
        return this;
    }
    public CommunityPage GotoDisscusionsTab(){
        WaitVisisbilityOfElement(DisscussionsTabButton);
        DisscussionsTabButton.click();
        return this;

    }
    public CommunityPage ClcikOnTheSaveNewsButton(){
        WaitVisisbilityOfElement(SaveNewsButton);
        SaveNewsButton.click();
        return this;
    }
    public CommunityPage ClcikonTheSaveButton(){
        WaitVisisbilityOfElement(SaveButton);
        SaveButton.click();
        return this;
    }
    public CommunityPage ClcikOnTheCreateSurveyButton(){
        WaitVisisbilityOfElement(CreateSurveyButton);
        CreateSurveyButton.click();
        return this;
    }
    public CommunityPage GotoFirstNewsFromList(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
            List<AndroidElement> ListOfCommunityNews = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/titleTextView"));
            ListOfCommunityNews.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("In This Community no any news!");
        }

        return this;
    }
    public void ClcikOnTheCreateSurveyPointsButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/createSurveyLayout"))).click();
    }
    public CommunityPage ClickOnTheUnfolowCommunityButton(){
        WaitVisisbilityOfElement(UnfollowCommunityButton);
        UnfollowCommunityButton.click();
        return this;
    }
    public CommunityPage ClickOnTheDeleteNewsButton(){
        WaitVisisbilityOfElement(DeleteNewsButton);
        DeleteNewsButton.click();
        return this;
    }
    public CommunityPage ClcikOnFollowCommuntyButton(){
        try {
            WaitVisisbilityOfElement(FollowCommunityButton);
            FollowCommunityButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("Community Already followed!");
        }

        return this;
    }

    public CommunityPage ClcikOnQualifiedSwither(){
        WaitVisisbilityOfElement(QualifierSwither);
        QualifierSwither.click();
        return this;
    }
    public CommunityPage GotoGroupChat(){
        WaitVisisbilityOfElement(GroupChatButton);
        GroupChatButton.click();
        return this;
    }
    public CommunityPage ClcikOnTheOkButtonOnConfirmationPopUP(){
        WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
        OKButton_On_Sucsuss_PopUP.click();
        return this;
    }
    public CommunityPage EnterTextOfMassageInGroupChat(String Massege){
        WaitVisisbilityOfElement(InputForMassage);
        InputForMassage.sendKeys(Massege);
        return this;
    }
    public CommunityPage ClcikOnSendMassageButton(){
        WaitVisisbilityOfElement(SendMassageButton);
        SendMassageButton.click();
        return this;
    }
    public CommunityPage ClcikOnAddDisscusionButton(){
        WaitVisisbilityOfElement(AddDisscusionButton);
        AddDisscusionButton.click();
        return this;
    }
    public CommunityPage ClcikOnTheCreateDisscusionButton(){
        WaitVisisbilityOfElement(CreateDisscusionButton);
        CreateDisscusionButton.click();
        return this;
    }
    public CommunityPage ClcikOnTheSurveyInDetailButton(){
        WaitVisisbilityOfElement(SurveyInDetailButton);
        SurveyInDetailButton.click();
        return this;
    }
    public CommunityPage GotoModerationTab(){
        WaitVisisbilityOfElement(ModerationTab);
        ModerationTab.click();
        return this;
    }
    public CommunityPage GotoSurveyInModeration(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='in Moderation']")));

        } catch (TimeoutException TimeOut){
            Assert.fail("In this Community no any Survey In Moderation!");
        }
        List<AndroidElement> ListOfSurveyInModeration = androidDriver.findElements(By.xpath("//android.widget.TextView[@text='in Moderation']"));
        ListOfSurveyInModeration.get(0).click();
        return this;

    }
    public CommunityPage ClickOnApproveSurveyButton(){
        WaitVisisbilityOfElement(AprroveSurveyButton);
        AprroveSurveyButton.click();
        return this;
    }
    public CommunityPage ClcikOnRejectSurveyButton(){
        WaitVisisbilityOfElement(RejectSurveyButton);
        RejectSurveyButton.click();
        return this;
    }
    public CommunityPage EnterReasonOfRejection(String ReasonOfRejection){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/commentEditText"))).sendKeys(ReasonOfRejection);
        return this;
    }
    public CommunityPage GotoFlaggedTab(){
        WaitVisisbilityOfElement(FlaggedTab);
        FlaggedTab.click();
        return this;
    }
    public CommunityPage GotoUserSurveysTab(){
        try {
            WaitVisisbilityOfElement(UserSurveys);
            UserSurveys.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("User Surveys button is not displayed!");
        }

        return this;
    }
    public CommunityPage GotoUserCommunitiesTab(){
        try {
            WaitVisisbilityOfElement(UserCommunities);
            UserCommunities.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("User communities button is not displayed!");
        }
        return this;
    }
    public CommunityPage ClcikOnTheBlock_Unblock_UserButton() throws Exception {
        try {
            WaitVisisbilityOfElement(BlockUserButton);
            if (BlockUserButton.getText().equals("Block User")){
                BlockUserButton.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/blockTextView"))).click();
            } else {
               throw new Exception("The user already banned!");
            }

        } catch (TimeoutException TimeOut){
            Assert.fail("Block User button is not displayed!");
        }
        return this;
    }

    public boolean ClcikOnDeleteFlaggedItem(){
        try {
            WaitVisisbilityOfElement(DeleteFlaggedItemButton);
            List<AndroidElement> ListOfDeleteButtons = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/deleteTextView"));
            ListOfDeleteButtons.get(0).click();
            ClcikOnTheOkButtonOnConfirmationPopUP();

            try {
                wait.until(ExpectedConditions.invisibilityOf(ListOfDeleteButtons.get(0)));
                return true;
            } catch (TimeoutException TimeOut){
                Assert.fail("Item was not deleted!");
                return false;
            }
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Flagged items");
            return false;
        }
    }
    public boolean Its_OKFlaggedItem(){
        try {
            WaitVisisbilityOfElement(ItIsOKFlaggedItemButton);
            List<AndroidElement> ListOfItsOkButtons = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/approveTextView"));
            ListOfItsOkButtons.get(0).click();

            try {
                wait.until(ExpectedConditions.invisibilityOf(ListOfItsOkButtons.get(0)));
                return true;
            } catch (TimeoutException TimeOut){
                Assert.fail("The flagged item was not approved!");
                return false;
            }
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Flagged Item!");
            return false;
        }
    }
    public CommunityPage ClcikOnthePublick_PrivetSwitcher(){
        WaitVisisbilityOfElement(Public_Privet_Switcher);
        Public_Privet_Switcher.click();
        return this;
    }
    public CommunityPage SelectQualifierAnswer(){
        int Random = (int) (Math.random() *10);
        System.out.println(Random);
        if (Random <=5){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RadioButton"))).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RadioButton"))).click();
        }
        return this;
    }
    public CommunityPage GotoUserScreen(){
        try {
            WaitVisisbilityOfElement(UserWithName);
            UserWithName.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any ");
        }

        return this;
    }




    public boolean IS_Community_Was_Found(String NameOfCommunity){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView"),NameOfCommunity));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community not found!");
            return false;
        }
    }
    public boolean IS_CommunityHavePublic_Status(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/publicTextView"),"Public"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community Is not Public");
            return false;
        }
    }
      public boolean IS_CommunityHavePrivet_Status(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/publicTextView"),"Private"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community is not privet!");
            return false;
        }

      }
    public boolean IS_Community_Created(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"Your community was successfully created!"));
            WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
            OKButton_On_Sucsuss_PopUP.click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not created!");
            return false;
        }
    }
    public boolean IS_Survey_Created(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"Your survey was successfully created!"));
            WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
            OKButton_On_Sucsuss_PopUP.click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("The Survey was not created!");
            return false;
        }
    }
    public boolean IS_Community_Updated(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"Your community was successfully updated!"));
            WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
            OKButton_On_Sucsuss_PopUP.click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not Updated!");
            return false;
        }
    }
    public boolean IS_Community_News_Created(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"This news item was successfully created!"));
            WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
            OKButton_On_Sucsuss_PopUP.click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community News was not Created!");
            return false;
        }
    }

    public boolean IS_Community_Unfollowed(){
        try {
            WaitVisisbilityOfElement(FollowCommunityButton);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not Unffolowed!");
            return false;
        }
    }
    public boolean IS_Community_Followed(){
        try {
            WaitVisisbilityOfElement(UnfollowCommunityButton);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not Followed!");
            return false;
        }
    }
    public boolean IS_Disscusion_Created(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"The discussion has been successfully created"));
            WaitVisisbilityOfElement(OKButton_On_Sucsuss_PopUP);
            OKButton_On_Sucsuss_PopUP.click();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Disscusion was not Created!");
            return false;
        }
    }
    public boolean IS_SurveyID_Detail_Opened(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Completed\"]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Live\"]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Moderation\"]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey in detail screen was not opened!");
            return false;
        }
    }
    public boolean IS_Survey_Was_Approved(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/startSurveyButton")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/completeSurveyButton")));
            return  true;
        } catch (TimeoutException TimeOut){
            Assert.fail("The survey was not approved!");
            return false;
        }
    }
    public boolean IS_SurveyRejected(String ModeratorsComment){
        try {
           wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/earnedPointsTextView"),"Rejected"));
           wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/moderatorCommentTextView"),ModeratorsComment));
           return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Moderators comment or Rejected Status is not displayed!");
            return false;
        }
    }
    public boolean IS_ListOfModerators_Displayed(){
        try {
            WaitVisisbilityOfElement(UserWithName);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Moderators are not dispalyed!");
            return false;
        }
    }
    public boolean IS_listOfFollowers_Displayed(){
        try {
            WaitVisisbilityOfElement(UserWithName);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Followers are not displayed!");
            return false;
        }
    }
    public boolean IS_Question_MarkedAs_Qualifier(){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/qualifiedQuestionSwitch"),"Qualifier ON"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/qualifiedTextView")));
            return true;
        } catch (TimeoutException Timeout){
            Assert.fail("The Question was not marked as qualifier!");
            return false;
        }
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






}

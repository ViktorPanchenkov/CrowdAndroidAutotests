package Tests;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommunityPageTests extends TestBase {

    @BeforeMethod
    public void GotoCommunityPage() {
       // String Phone = "1113333333";
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        communityPage.GotoCommunityTab();

    }
    @Test
    public void SearchCommunity(){
        String NameOfCommunity = "14 Soviet army";
        communityPage.GotoAllTab().
                ClcikOnSearchButton().
                EnterNameOfCommunity(NameOfCommunity);
        Assert.assertTrue(communityPage.IS_Community_Was_Found(NameOfCommunity));
    }
    @Test
    public void AddCommunity(){
        int Random = (int) (Math.random() *10);
        String Title = "Created By Appium" + Random;
        String CommunityDescription = "Description";
        communityPage.ClickOnAddCommunityButton().
                ClickOnTheCostButton().
                Enter_Title(Title).
                Enter_Description(CommunityDescription).
                SelectCategory().
                SelectLocation().
                Select_Community_Image().
                ClcikOnCreateCommunityButton();
        Assert.assertTrue(communityPage.IS_Community_Created());
    }
    @Test
    public void Post_Survey_With_One_Yes_No_Questin_in_OWnCommunity(){
        String SurveyTitle = "Yes No Survey";
        String Description = "Description";
        String QuestionTitle = "Title by Selenium";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnThePostSurveyButton().
                Enter_Title(SurveyTitle).
                Enter_Description(Description).
                SelectCategory().
                GotoAddQuestionScreen().
                ClcikOnAddQuestionButton().
                Enter_Title(QuestionTitle).
                ClcikOnTheAnswerButton().
                ScrollUP();
        communityPage.ClcikOnDoneButton().
                ClcikonTheSaveButton().
                ClcikonTheSaveButton().
                ClcikOnTheCreateSurveyButton().
                ClcikOnTheCreateSurveyPointsButton();
        Assert.assertTrue(communityPage.IS_Survey_Created());

    }
    @Test
    public void PostSurvey_With_QuerifedQuestionInOwnCommunity(){
        String SurveyTitle = "Qurefied Survey";
        String Description = "Survey with querifed question";
        String QuestionTitle = "Title by Selenium";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnThePostSurveyButton().
                Enter_Title(SurveyTitle).
                Enter_Description(Description).
                SelectCategory().
                GotoAddQuestionScreen().
                ClcikOnAddQuestionButton().
                Enter_Title(QuestionTitle).
                ClcikOnQualifiedSwither();
        Assert.assertTrue(communityPage.IS_Question_MarkedAs_Qualifier());
           communityPage.SelectQualifierAnswer().
                   ClcikonTheSaveButton().
                   ClcikonTheSaveButton().
                ClcikOnTheCreateSurveyButton().
                ClcikOnTheCreateSurveyPointsButton();
        Assert.assertTrue(communityPage.IS_Survey_Created());


    }
    @Test
    public void SuggestSurveyInFollowingCommunity(){
        String SurveyTitle = "BlaBlaSurvey";
        String Description = "Survey  Description";
        String QuestionTitle = "Title by Selenium";
        communityPage.GotoFollowingTab().
                GotoCommunityFromList(0).
                ClcikOnThePostSurveyButton().
                Enter_Title(SurveyTitle).
                Enter_Description(Description).
                SelectCategory().
                GotoAddQuestionScreen().
                ClcikOnAddQuestionButton().
                Enter_Title(QuestionTitle).
                ClcikOnTheAnswerButton().
                ScrollUP();
        communityPage.ClcikOnDoneButton().
                ClcikonTheSaveButton().
                ClcikonTheSaveButton().
                ClcikOnTheCreateSurveyButton().
                ClcikOnTheCreateSurveyPointsButton();
        Assert.assertTrue(communityPage.IS_Survey_Created());
    }
    @Test
    public void UnfollowCommunity(){
       communityPage.GotoFollowingTab().
               GotoCommunityFromList(2).
               ClickOnTheUnfolowCommunityButton().
               ClcikOnTheOkButtonOnConfirmationPopUP();
       Assert.assertTrue(communityPage.IS_Community_Unfollowed());
    }
    @Test
    public void FollowCommunity(){
        communityPage.ScrollDown();
        communityPage.ScrollDown();
        communityPage.ScrollDown();
        communityPage.ScrollDown();
        communityPage.ScrollDown();
        communityPage.ScrollDown();
        communityPage.GotoCommunityFromList(3).
                ClcikOnFollowCommuntyButton();
        Assert.assertTrue(communityPage.IS_Community_Followed());
    }
    @Test
    public void GotoModeratorsTabOfCommunity(){
        communityPage.GotoFollowingTab().
                GotoCommunityFromList(1).
                GotoModeratorsTab();
        Assert.assertTrue(communityPage.IS_ListOfModerators_Displayed());
    }
    @Test
    public void GotoFollowersTab(){
        communityPage.GotoFollowingTab().
                GotoCommunityFromList(1).
                GotoFollowersTab();
        Assert.assertTrue(communityPage.IS_listOfFollowers_Displayed());
    }
    @Test
    public void EditOwnCommunity(){
        int Random = (int) (Math.random() *10);
        String NewTitle = "Updated Community" + Random;
        String NewDescription = "New community description" + Random;
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(2).
                ClcikOnEditCommunityButton().
                Enter_Title(NewTitle).
                Enter_Description(NewDescription).
                ClcikOnEditCommunityButton();
        Assert.assertTrue(communityPage.IS_Community_Updated());
    }
    @Test
    public void AddCommunityNews(){
        String NewsTitle = "Title by Selenium";
        String NewsDescriptin = "Description by Selenium";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnEditCommunityButton().
                ClcikOnAddNewsButton().
                AddImageForNews().
                Enter_Title(NewsTitle).
                Enter_Description(NewsDescriptin).
                ClcikOnTheSaveNewsButton();
        Assert.assertTrue(communityPage.IS_Community_News_Created());
    }
    @Test
    public void DeleteCommunityNews(){
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnEditCommunityButton().
                GotoFirstNewsFromList().
                ClickOnTheDeleteNewsButton().
                ClcikOnTheOkButtonOnConfirmationPopUP();
    }
    @Test
    public void SendMassageInGroupChat(){
        int Random = (int) (Math.random() * 10);
        String Massege = "Sent by automated test number";
        communityPage.GotoFollowingTab().
                GotoCommunityFromList(0).
                GotoGroupChat().
                EnterTextOfMassageInGroupChat(Massege).
                ClcikOnSendMassageButton();

    }
    @Test
    public void CreateDisscussions(){
        int Random = (int) (Math.random() *10);
        String TitleOFDisscusion = "Created by Autotest" + Random;
        String DescriptionOfDisscusion = "Description by autotest";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(3).
                GotoDisscusionsTab().
                ClcikOnAddDisscusionButton().
                Enter_Title(TitleOFDisscusion).
                Enter_Description(DescriptionOfDisscusion).
                ClcikOnTheCreateDisscusionButton();
        Assert.assertTrue(communityPage.IS_Disscusion_Created());
    }
    @Test
    public void GotoSurveyInDetail(){
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(1).
                ClcikOnTheSurveyInDetailButton();
        Assert.assertTrue(communityPage.IS_SurveyID_Detail_Opened());
    }
    @Test
    public void ApproveSurveyInOwnCommunity(){
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnTheSurveyInDetailButton().
                GotoModerationTab().
                GotoSurveyInModeration().
                ClickOnApproveSurveyButton();
        Assert.assertTrue(communityPage.IS_Survey_Was_Approved());
    }
    @Test
    public void RejectSurveyInOwnCommunity(){
        String ReasonOfRejection = "This survey was rejected because";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(0).
                ClcikOnTheSurveyInDetailButton().
                GotoModerationTab().
                GotoSurveyInModeration().
                ClcikOnRejectSurveyButton().
                EnterReasonOfRejection(ReasonOfRejection).
                ClcikOnRejectSurveyButton();
               Assert.assertTrue(communityPage.IS_SurveyRejected(ReasonOfRejection));
    }
    @Test
    public void DeleteFlaggedItem(){
        String NameOfCommunity = "14 Soviet Army";
        communityPage.GotoMyOwnTab().
        GotoCommunityFromList(NameOfCommunity).
                GotoFlaggedTab();
        Assert.assertTrue(communityPage.ClcikOnDeleteFlaggedItem());

    }
    @Test
    public void Its_Ok_FlaggedItem(){
        String NameOfCommunity = "14 Soviet Army";
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(NameOfCommunity).
                GotoFlaggedTab();
        Assert.assertTrue(communityPage.Its_OKFlaggedItem());
    }
    @Test
    public void ChangeStatusOfCommunityToPrivet(){
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(2).
                ClcikOnEditCommunityButton();
             Assert.assertTrue(communityPage.IS_CommunityHavePublic_Status());
             communityPage.ClcikOnthePublick_PrivetSwitcher();
             Assert.assertTrue(communityPage.IS_CommunityHavePrivet_Status());
             communityPage.ClcikOnEditCommunityButton().
                     ClcikOnTheOkButtonOnConfirmationPopUP();
    }

    @Test
    public void ChangeStatusOfComunityToPublic(){
        communityPage.GotoMyOwnTab().
                GotoCommunityFromList(2).
                ClcikOnEditCommunityButton();
        Assert.assertTrue(communityPage.IS_CommunityHavePrivet_Status());
        communityPage.ClcikOnthePublick_PrivetSwitcher();
        Assert.assertTrue(communityPage.IS_CommunityHavePublic_Status());
        communityPage.ClcikOnEditCommunityButton().
                ClcikOnTheOkButtonOnConfirmationPopUP();
    }
    @Test
    public void GotoUserScreen(){
        GotoFollowersTab();
        communityPage.GotoUserScreen();
        Assert.assertTrue(communityPage.IS_User_Profile_Displayed());
    }
    @Test
    public void OpenUsersSurveys(){
        GotoUserScreen();
        communityPage.GotoUserSurveysTab();
        Assert.assertTrue(communityPage.IS_User_Surveys_Displayed());
    }
    @Test
    public void GotoUserCommunities(){
        GotoUserScreen();
        communityPage.GotoUserCommunitiesTab();
        Assert.assertTrue(communityPage.IS_User_Communityes_Displayed());
    }
    @Test
    public void BlockUser() throws Exception {
        GotoUserScreen();
        communityPage.ClcikOnTheBlock_Unblock_UserButton();
        Assert.assertTrue(communityPage.IS_User_Was_Blocked());
    }
    @Test
    public void UnblockUser(){

    }




}

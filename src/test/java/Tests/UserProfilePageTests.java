package Tests;

import Pages.CommunityPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProfilePageTests extends CommunityPageTests {

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
    public void GotoUserScreen(){
        GotoFollowersTab();
        communityPage.GotoUserScreen();
        Assert.assertTrue(userProfilePage.IS_User_Profile_Displayed());
    }
    @Test
    public void OpenUsersSurveys(){
        GotoUserScreen();
        userProfilePage.GotoUserSurveysTab();
        Assert.assertTrue(userProfilePage.IS_User_Surveys_Displayed());
    }
    @Test
    public void GotoUserCommunities(){
        GotoUserScreen();
        userProfilePage.GotoUserCommunitiesTab();
        Assert.assertTrue(userProfilePage.IS_User_Communityes_Displayed());
    }
    @Test
    public void BlockUser() throws Exception {
        GotoUserScreen();
        userProfilePage.ClcikOnTheBlockUserButton();
        Assert.assertTrue(userProfilePage.IS_User_Was_Blocked());
    }
    @Test
    public void UnblockUser() throws Exception {
        GotoUserScreen();
        userProfilePage.ClcikOnTheUnblockUserButton();
        Assert.assertTrue(userProfilePage.IS_User_was_Unbloked());
    }
    @Test
    public void SendMassageToUser(){
        String Message = "nkvd";
        GotoUserScreen();
        userProfilePage.GotoPersonalMassageWithUser().
                EnterTextOfMessege(Message).
                ClcikOnSendMessageButton();
        Assert.assertTrue(userProfilePage.IS_Massage_Was_Sent(Message));
    }
}

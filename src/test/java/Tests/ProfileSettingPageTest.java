package Tests;

import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ProfileSettingPageTest extends TestBase{
    int Random = (int) (Math.random() *10);

    @BeforeMethod
    public void GotoCommunityPage() {

         String Phone2 = "1113333333";
        String Phone1 = "1112222222";
        String Phone3 ="11111111111";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton();
        if(Random <= 4){
            loginPage.EnterPhone(Phone1);
        } else if(Random > 4){
            loginPage.EnterPhone(Phone2);
        }

                loginPage.EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        profileSettingPage.GoToProfileSettingsPage();

    }

    @Test
    public void ChangeUserName(){
        String UserName2 = "33"+Random+"User";
        String UserName1 = "1"+ Random +" Soviet Army";
        if (Random <= 4){
            profileSettingPage.EnterUserName(UserName1);
            Assert.assertTrue(profileSettingPage.IS_UserName_Was_Changed(UserName1));
        } else {
            profileSettingPage.EnterUserName(UserName2);
            Assert.assertTrue(profileSettingPage.IS_UserName_Was_Changed(UserName2));
        }
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();



    }
    @Test
    public void ChangeZIPCode(){
        String ZIPCode = "5555" + Random;
       profileSettingPage.EnterZIPCode(ZIPCode);
        Assert.assertTrue(profileSettingPage.IS_ZIP_Code_Was_Entered(ZIPCode));
               profileSettingPage.ClcikOnTheSaveButton().
               ClcionOnTheOkButtonOnSuccsesPopUP();
    }
    @Test
    public void ChangeGender(){
        profileSettingPage.SelectGender();
        Assert.assertTrue(profileSettingPage.IS_GenderSelected());
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();

    }
    @Test
    public void SelectBirthday(){
        profileSettingPage.SelectBirthday();
        Assert.assertTrue(profileSettingPage.IS_Birthday_Selected());
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();
    }

    @Test
    public void EnterBio(){
        String Bio = "Bla Bla Boi" + Random;
        profileSettingPage.EnterBio(Bio);
        Assert.assertTrue(profileSettingPage.IS_Bio_Was_Entered(Bio));
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();

    }
    @Test
    public void SetInterests(){
        int NumberofInterestFromList = 5;
        profileSettingPage.GotoListOfInterests().
                TurnOffAllInterests().
                SelectInterest(NumberofInterestFromList).
                SelectInterest(4).
                ClcikOnBackButton();
        Assert.assertTrue(profileSettingPage.IS_InterestsWas_Set());
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();

    }
    @Test
    public void ChangeStatusOfAccountToPrivate(){
      profileSettingPage.ChangeAccauntStatusToPrivate();
      Assert.assertTrue(profileSettingPage.IS_Account_have_Private_Status());
      profileSettingPage.ClcikOnTheSaveButton().
              ClcionOnTheOkButtonOnSuccsesPopUP();
    }
    @Test
    public void ChangeStatusOfAccountToPublic(){
       profileSettingPage.ChangeAccountStatusToPublic();
       Assert.assertTrue(profileSettingPage.IS_Account_HavePublic_Staus());
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();

    }
    @Test
    public void ChangeUserEmail(){
        String UserEmail = "TestEmail"+Random+"@gmail.com";
        profileSettingPage.ScrollDown();
        profileSettingPage.EnterUserEmail(UserEmail);
        Assert.assertTrue(profileSettingPage.IS_User_Email_Was_Changed(UserEmail));
        profileSettingPage.ClcikOnTheSaveButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();
    }
    @Test
    public void ChangePassword(){
        String OldPass= "qwerty";
        String NewPass = "qwerty";
     profileSettingPage.ClcikOnChangePasswordButton().
             EnterOldPassword(OldPass).
             EnternewPassword(NewPass).
             EnterConfirmPassword(NewPass).
             SavePassword();
     Assert.assertTrue(profileSettingPage.IS_Password_Was_Changed());

    }
    @Test
    public void OpenTrmOFUse(){
       profileSettingPage.ScrollDown();
       profileSettingPage.OpenTermOfUse();
       Assert.assertTrue(profileSettingPage.IS_TermOfUse_Opened());
    }
    @Test
    public void OpenPrivicyPolisy(){
        profileSettingPage.ScrollDown();
        profileSettingPage.OpenPrivacyPolicy();
        Assert.assertTrue(profileSettingPage.IS_PrivacyPosisly_wasOpened());
    }
    @Test
    public void SendContactUsForm(){
        String Email = "testemail.@gmail.com";
        String Massage = "Bla Bla Bla";
        profileSettingPage.ScrollDown();
        profileSettingPage.OpenContactUsForm().
                EnterEmailInComtactAsForm(Email).
                TypeMessageForContactUsForm(Massage).
                ClickOnTheSendContactUSformButton();
        Assert.assertTrue(profileSettingPage.IS_ContactUsRequestWasSent());
        profileSettingPage.ClcionOnTheOkButtonOnSuccsesPopUP();
    }
    @Test
    public void LogOut(){
        profileSettingPage.ScrollDown();
        profileSettingPage.ClcikonLogoutButton().
                ClcionOnTheOkButtonOnSuccsesPopUP();
        Assert.assertTrue(profileSettingPage.IS_LoginScreenDisplayed());
    }
}

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
        // String Phone = "1113333333";
        String Phone = "1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        profileSettingPage.GoToProfileSettingsPage();

    }

    @Ignore
    public void ChangeUserName(){

        String UserName = "1"+ 4 +" Soviet Army";
      profileSettingPage.EnterUserName(UserName);
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
}

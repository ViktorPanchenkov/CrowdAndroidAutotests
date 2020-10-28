package Tests;

import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {


    @Test
    public void LoginAs14SovietArmyUser(){
        String Phone ="1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();

        Assert.assertTrue(loginPage.IsUserLoggenIn());
    }
   @Test
    public void GotoForgotPasswordScreen(){
        loginPage.ClcikOnTheOkButton().
                ClickOnTheForgotPasswordButton();
        Assert.assertTrue(loginPage.SendResetLinkISDisplayed());
   }
   @Test
    public void GotoSingUpScreen(){
      loginPage.ClcikOnTheOkButton().
              ClickOnTheGotoSingUpPageButton();

      Assert.assertTrue(loginPage.SingUPScreenIsDisplayed());
   }

}

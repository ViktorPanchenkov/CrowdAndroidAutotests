package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingUpPageTest extends TestBase {


    @BeforeMethod
    public void GotoSingUpPage(){
        loginPage.ClcikOnTheOkButton();
        loginPage.ClickOnTheGotoSingUpPageButton();
    }
    @Test
    public void SingUpUser(){
        int Random = (int) (Math.random() *10);
        String Phone ="123445566" + Random;
        String Password ="qwerty";
        String Username = "TestUser" + Random;
        singUPPage.EnterPhone(Phone).
                EnterUserName(Username).
                EnterPassword(Password).
                Chex16EarsOldChexbox().
                ClcikOntheSingUpButton();
        Assert.assertTrue(singUPPage.NotitificationPopUpIsDispalyed());
}


}

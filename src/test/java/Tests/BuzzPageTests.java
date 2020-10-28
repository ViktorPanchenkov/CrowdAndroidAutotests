package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class BuzzPageTests extends TestBase{

    @BeforeMethod
    public void GotoBuzzPage(){
        String Phone ="1112222222";
        String Password = "qwerty";
        loginPage.ClcikOnTheOkButton().
                EnterPhone(Phone).
                EnterPassword(Password).
                ClcikOnTheLoginButton();
        basePage.OpenBurgerMenu();
        buzzPage.GotoBuzzPage();

    }
    @Test
    public void ViewLink(){
       buzzPage.Clcik_On_View_Link_Button();
        Assert.assertTrue(buzzPage.ISLink_Was_Opened());

    }
    @Test
    public void OpenPDF(){
        buzzPage.Clcik_On_View_PDFButton();
        Assert.assertTrue(buzzPage.ISPDF_Was_Opened());
    }

}

package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import javax.swing.text.StyledEditorKit;

public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    //By OKbutton = By.id("android:id/button1");
  //  By PhoneField = By.id("com.jelvix.crowdthinc:id/phoneNumberEditText");
  //  By PasswordField = By.id("com.jelvix.crowdthinc:id/passwordEditText");
  //  By LoginButton = By.id("com.jelvix.crowdthinc:id/loginButton");
  //  By PhoneInputError = By.id("com.jelvix.crowdthinc:id/textinput_error");
  //  By ForgotPasswordButton = By.id("com.jelvix.crowdthinc:id/forgotPassButton");

    @AndroidFindBy (id = "android:id/button1")
    AndroidElement OkButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/phoneNumberEditText")
    AndroidElement PhoneField;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/passwordEditText")
    AndroidElement PasswordField;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/loginButton")
    AndroidElement LoginButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/forgotPassButton")
    AndroidElement ForgotPasswordButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/resetLinkButton")
    AndroidElement SendResetLinkButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/signUpButton")
    AndroidElement SingScreenButton;

    public void WaitVisabilityOfElement( AndroidElement element){
       wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void WaitVisabilityOfElement( By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public LoginPage ClcikOnTheOkButton(){
       WaitVisabilityOfElement(OkButton);
       OkButton.click();
       return this;
    }
    public LoginPage EnterPhone(String Phone){
        WaitVisabilityOfElement(PhoneField);
        PhoneField.sendKeys(Phone);
        return this;
    }
    public LoginPage EnterPassword(String Password){
        WaitVisabilityOfElement(PasswordField);
        PasswordField.sendKeys(Password);
        return this;

    }
    public void ClcikOnTheLoginButton(){
        WaitVisabilityOfElement(LoginButton);
        LoginButton.click();
    }
    public LoginPage ClickOnTheForgotPasswordButton(){
        WaitVisabilityOfElement(ForgotPasswordButton);
        ForgotPasswordButton.click();
        return this;
    }
    public SingUPPage ClickOnTheGotoSingUpPageButton(){
        WaitVisabilityOfElement(SingScreenButton);
        SingScreenButton.click();
        return new SingUPPage(androidDriver);
    }
    public Boolean IsUserLoggenIn(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")));
            MobileElement Burger = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton");
            Burger.click();
            return true;
        } catch (Exception Exp){
            return false;
        }
    }
    public Boolean SendResetLinkISDisplayed(){
        try {
           wait.until(ExpectedConditions.visibilityOf(SendResetLinkButton));
           return true;
        } catch (TimeoutException TimeOut){
            return false;
        }
    }
    public boolean SingUPScreenIsDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/usernameEditText")));
            return true;
        } catch (TimeoutException TimeOut){
            return false;
        }
    }


}



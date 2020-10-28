package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingUPPage extends BasePage{
    LoginPage loginPage;

    public SingUPPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }
    @AndroidFindBy (id ="com.jelvix.crowdthinc:id/phoneNumberEditText")
    AndroidElement PhoneFieled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/usernameEditText")
    AndroidElement UsernameField;
    @AndroidFindBy (id= "com.jelvix.crowdthinc:id/passwordEditText")
    AndroidElement PasswordFieled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/termsCheckBox")
    AndroidElement Chxbox16EarsOld;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/signUpButton")
    AndroidElement SingUpButton;


    public SingUPPage EnterPhone(String Phone){
    wait.until(ExpectedConditions.visibilityOf(PhoneFieled));
    PhoneFieled.sendKeys(Phone);
    return this;
    }
    public SingUPPage EnterUserName(String Username){
        wait.until(ExpectedConditions.visibilityOf(UsernameField));
        UsernameField.sendKeys(Username);
        return this;
    }
    public SingUPPage EnterPassword(String Password){
        wait.until(ExpectedConditions.visibilityOf(PasswordFieled));
        PasswordFieled.sendKeys(Password);
        return this;
    }
    public SingUPPage Chex16EarsOldChexbox(){
        wait.until(ExpectedConditions.visibilityOf(Chxbox16EarsOld));
        Chxbox16EarsOld.click();
        return this;
    }
    public void ClcikOntheSingUpButton(){
        wait.until(ExpectedConditions.visibilityOf(SingUpButton));
        SingUpButton.click();
    }
    public Boolean NotitificationPopUpIsDispalyed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/okButton")));
            return true;
        } catch (TimeoutException TimeOut){
            return false;
        }
    }

    }



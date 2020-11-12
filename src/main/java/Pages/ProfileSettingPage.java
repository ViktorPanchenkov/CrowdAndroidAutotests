package Pages;

import com.google.gson.internal.$Gson$Preconditions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.jws.soap.SOAPBinding;
import java.sql.Time;
import java.util.List;
import java.util.Random;

public class ProfileSettingPage extends BasePage {
    public ProfileSettingPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    AndroidElement ProfileSettingsTab;
    By UserNameFiled = By.id("com.jelvix.crowdthinc:id/usernameEditText");
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/saveTextView")
    AndroidElement SaveButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/zipCodeEditText")
    AndroidElement ZIPCodeFiled;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/okButton")
    AndroidElement OKButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/gendersTextView")
    AndroidElement GenderSelection;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/doneImageView")
    AndroidElement DoneButton;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/birthdayTextView")
    AndroidElement BirthdaySelection;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/bioEditText")
    AndroidElement BioFiled;
    @AndroidFindBy(id = "com.jelvix.crowdthinc:id/interestsLayout")
    AndroidElement InterestsSelection;
    List<AndroidElement> ListOfSwithers;
    @AndroidFindBy (xpath = "//android.widget.ImageButton")
    AndroidElement BackButton;
    @AndroidFindBy (xpath = "//android.widget.CheckedTextView")
    AndroidElement SelectedInterest;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/publicSwitch")
    AndroidElement Public_PrivetSwither;
    By UserEmailFiled = By.id("com.jelvix.crowdthinc:id/emailEditText");
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/changePasswordTextView")
    AndroidElement ChangePasswordButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/oldPasswordEditText")
    AndroidElement OldPasswordFiled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/newPasswordEditText")
    AndroidElement NewPassowordFiled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/confirmPasswordEditText")
    AndroidElement ConfirmPasswordFiled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/termOfUseTextView")
    AndroidElement TermOfUseButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/privacyPolicyTextView")
    AndroidElement PrivicyPosicyButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/contactUsTextView")
    AndroidElement ContactUsButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/emailEditText")
    AndroidElement EmailFiled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/textMessageEditText")
    AndroidElement ContactUsMassageFiled;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/sendButton")
    AndroidElement SendContactUsFormButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/logoutButton")
    AndroidElement LogoutButton;

    public void WaitVisabilityofElement(AndroidElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public void WaitVisabilityofElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    @Override
    public void ScrollDown(){
        WaitVisabilityofElement(ZIPCodeFiled);
        TouchAction action = new TouchAction(androidDriver);
        action.press(new PointOption().withCoordinates(984,2610)).waitAction().moveTo(new PointOption().withCoordinates(984,1100)).release().perform();

    }


    public ProfileSettingPage GoToProfileSettingsPage() {
        WaitVisabilityofElement(ProfileSettingsTab);
        ProfileSettingsTab.click();
        return new ProfileSettingPage(androidDriver);
    }

    public ProfileSettingPage EnterUserName(String UserName) {
     WaitVisabilityofElement(UserNameFiled);
     androidDriver.findElement(UserNameFiled).clear();
     androidDriver.findElement(UserNameFiled).sendKeys(UserName);
     return this;
    }
    public ProfileSettingPage ClcikOnBackButton(){
        WaitVisabilityofElement(BackButton);
        BackButton.click();
        return this;
    }

    public ProfileSettingPage EnterZIPCode(String ZIPCode) {
        WaitVisabilityofElement(ZIPCodeFiled);
        ZIPCodeFiled.clear();
        ZIPCodeFiled.sendKeys(ZIPCode);
        return this;
    }

    public ProfileSettingPage ClcikOnTheSaveButton() {
        WaitVisabilityofElement(SaveButton);
        SaveButton.click();
        return this;
    }

    public ProfileSettingPage ClcionOnTheOkButtonOnSuccsesPopUP() {
        WaitVisabilityofElement(OKButton);
        OKButton.click();
        return this;
    }

    public ProfileSettingPage SelectGender() {
        WaitVisabilityofElement(GenderSelection);
        GenderSelection.click();
        ScrollUP();
        ScrollDown();
        DoneButton.click();
        return this;
    }

    public ProfileSettingPage SelectBirthday() {
        int Random = (int) (Math.random() * 10);
        WaitVisabilityofElement(BirthdaySelection);
        BirthdaySelection.click();
        if (Random <= 5) {
            ScrollDown();
        } else {
            ScrollUP();
        }
        DoneButton.click();
        return this;

    }

    public ProfileSettingPage EnterBio(String Bio) {
        WaitVisabilityofElement(BioFiled);
        BioFiled.clear();
        BioFiled.sendKeys(Bio);
        return this;
    }

    public ProfileSettingPage GotoListOfInterests() {
        WaitVisabilityofElement(InterestsSelection);
        InterestsSelection.click();
        return this;
    }

    public ProfileSettingPage TurnOffAllInterests() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/switchView")));
         ListOfSwithers = androidDriver.findElements(By.id("com.jelvix.crowdthinc:id/switchView"));
        for (int i = 0; i < ListOfSwithers.size(); i++) {
            if (ListOfSwithers.get(i).getText().equals("ON")) {
                ListOfSwithers.get(i).click();
            }
        }

        return this;
    }
    public ProfileSettingPage SelectInterest(int NumberOfInterest){
        try {
            ListOfSwithers.get(NumberOfInterest).click();
        } catch (IndexOutOfBoundsException NoIndex){
            Assert.fail("In the list of interests no one with such number!");
        }

        return this;
    }
    public ProfileSettingPage ChangeAccauntStatusToPrivate(){
        WaitVisabilityofElement(Public_PrivetSwither);
        if (Public_PrivetSwither.getText().equals("ON")){
            Public_PrivetSwither.click();
        } else {
            Assert.fail("Account Already Private!");
        }

        return this;
    }

    public ProfileSettingPage EnterUserEmail(String Email){
       WaitVisabilityofElement(UserEmailFiled);
       androidDriver.findElement(UserEmailFiled).clear();
       androidDriver.findElement(UserEmailFiled).sendKeys(Email);
       return this;
    }
    public ProfileSettingPage ChangeAccountStatusToPublic(){
        WaitVisabilityofElement(Public_PrivetSwither);
        if (Public_PrivetSwither.getText().equals("OFF")){
            Public_PrivetSwither.click();
        } else {
            Assert.fail("Account is Already Public!");
        }
        return this;
    }
    public ProfileSettingPage ClcikOnChangePasswordButton(){
        ScrollDown();
        WaitVisabilityofElement(ChangePasswordButton);
        ChangePasswordButton.click();
        return this;
    }

    public ProfileSettingPage EnterOldPassword(String OldPassword){
        WaitVisabilityofElement(OldPasswordFiled);
        OldPasswordFiled.sendKeys(OldPassword);
        return this;
    }
    public ProfileSettingPage EnternewPassword(String NewPassword){
        WaitVisabilityofElement(NewPassowordFiled);
        NewPassowordFiled.sendKeys(NewPassword);
        return this;
    }
    public ProfileSettingPage EnterConfirmPassword(String ConfirmPassword){
        WaitVisabilityofElement(ConfirmPasswordFiled);
        ConfirmPasswordFiled.sendKeys(ConfirmPassword);
        return this;
    }
    public ProfileSettingPage SavePassword(){
        AndroidElement SavePasswordButton = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/saveMenuItem")));
        SavePasswordButton.click();
        return this;
    }
    public ProfileSettingPage OpenTermOfUse(){
        WaitVisabilityofElement(TermOfUseButton);
        TermOfUseButton.click();
        return this;
    }
    public ProfileSettingPage OpenPrivacyPolicy(){
        WaitVisabilityofElement(PrivicyPosicyButton);
        PrivicyPosicyButton.click();
        return this;
    }
    public ProfileSettingPage OpenContactUsForm(){
        WaitVisabilityofElement(ContactUsButton);
        ContactUsButton.click();
        return this;
    }
    public ProfileSettingPage EnterEmailInComtactAsForm(String Email){
        WaitVisabilityofElement(EmailFiled);
        if (EmailFiled.isEnabled()){
            EmailFiled.sendKeys(Email);
        }
        return this;
    }
    public ProfileSettingPage TypeMessageForContactUsForm(String Massage){
        WaitVisabilityofElement(ContactUsMassageFiled);
        ContactUsMassageFiled.sendKeys(Massage);
        return this;
    }
    public ProfileSettingPage ClickOnTheSendContactUSformButton(){
        WaitVisabilityofElement(SendContactUsFormButton);
        SendContactUsFormButton.click();
        return this;
    }
    public ProfileSettingPage ClcikonLogoutButton(){
        WaitVisabilityofElement(LogoutButton);
        LogoutButton.click();
        return this;
    }




    public boolean IS_ZIP_Code_Was_Entered(String ZIPCODE){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/zipCodeEditText"),ZIPCODE));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Zip Code was not changed!");
            return false;
        }
    }
    public boolean IS_GenderSelected(){
        try {
            wait.until(ExpectedConditions.visibilityOf(GenderSelection));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Gender was not Selected!");
            return false;
        }
    }
    public boolean IS_Birthday_Selected(){
        try {
            wait.until(ExpectedConditions.visibilityOf(BirthdaySelection));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Birthday was not selected!");
            return false;
        }
    }
    public boolean IS_Bio_Was_Entered(String Bio){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/bioEditText"),Bio));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Bio was not changed!");
            return false;
        }
    }
    public boolean IS_InterestsWas_Set(){
        try {
            WaitVisabilityofElement(SelectedInterest);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Interest was not Selected");
            return false;
        }
    }
    public boolean IS_Account_HavePublic_Staus(){
        try {
            Boolean AccountStatus = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/publicTextView"),"Public"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Account does not have Public status!");
            return false;
        }
    }
    public boolean IS_Account_have_Private_Status(){
        try {
            Boolean AccountStatus = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/publicTextView"),"Private"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Account Does not have Private status!");
            return false;
        }
    }
    public boolean IS_UserName_Was_Changed(String UserName){
        try {
            Boolean UserNameFiledValue = wait.until(ExpectedConditions.textToBePresentInElementLocated((UserNameFiled),UserName));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User Name was not changed!");
            return false;
        }
    }
    public boolean IS_User_Email_Was_Changed(String UserEmail){
        try {
            Boolean EmailFiledValue = wait.until(ExpectedConditions.textToBePresentInElementLocated((UserEmailFiled),UserEmail));
            return true;
        }catch (TimeoutException TimeOut){
            Assert.fail("Email was not changed!");
            return false;
        }
    }
    public boolean IS_Password_Was_Changed(){
        try {
            Boolean SuccessPopUP = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"Password changed successfully!"));
            ClcionOnTheOkButtonOnSuccsesPopUP();
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Password Was not changed!");
            return false;
        }
    }
    public boolean IS_TermOfUse_Opened(){
        try {
            AndroidElement TermOfUse = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.webkit.WebView")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Term Of Use Was not Opened!");
            return false;
        }
    }
    public boolean IS_PrivacyPosisly_wasOpened(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.chromium.webview_shell:id/url_field")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Privacy Polisy was not opened!");
            return false;
        }
    }

    public boolean IS_ContactUsRequestWasSent(){
        try {
            Boolean MasswgeWasSentText = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.jelvix.crowdthinc:id/descriptionTextView"),"The message was sent."));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Request was not sent");
            return false;
        }
    }
    public boolean IS_LoginScreenDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
            AndroidElement LoginButton = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/loginButton")));
            AndroidElement PasswordFiled = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/passwordEditText")));


            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Login Screen is not displayed!");
            return false;
        }
    }





}

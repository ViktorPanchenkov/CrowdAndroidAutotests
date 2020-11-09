package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.Time;
import java.util.List;
import java.util.Random;

public class ProfileSettingPage extends BasePage {
    public ProfileSettingPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
    AndroidElement ProfileSettingsTab;
    @AndroidFindBy(xpath = "com.jelvix.crowdthinc:id/usernameEditText")
    AndroidElement UserNameFiled;
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

    public void WaitVisabilityofElement(AndroidElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public ProfileSettingPage GoToProfileSettingsPage() {
        WaitVisabilityofElement(ProfileSettingsTab);
        ProfileSettingsTab.click();
        return new ProfileSettingPage(androidDriver);
    }

    public ProfileSettingPage EnterUserName(String UserName) {
        wait.until(ExpectedConditions.visibilityOf(UserNameFiled));
        UserNameFiled.clear();
        UserNameFiled.sendKeys(UserName);
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



}

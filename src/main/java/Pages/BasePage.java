package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected AndroidDriver androidDriver;
    protected static WebDriverWait wait;


    public BasePage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        wait = new WebDriverWait(androidDriver,6);
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);

    }
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
    AndroidElement BurgerMenu;
    @AndroidFindBy (xpath = "//android.widget.CheckedTextView[@text='The Buzz!']")
    AndroidElement BuzzTab;

    public void OpenBurgerMenu(){
        wait.until(ExpectedConditions.visibilityOf(BurgerMenu));
        BurgerMenu.click();
    }
    public void ScrollDown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
        TouchAction action = new TouchAction(androidDriver);
        action.press(new PointOption().withCoordinates(984,2610)).waitAction().moveTo(new PointOption().withCoordinates(984,2352)).release().perform();

    }
    public void ScrollUP(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.jelvix.crowdthinc:id/titleTextView")));
        TouchAction action = new TouchAction(androidDriver);
        action.press(new PointOption().withCoordinates(984,2352)).waitAction().moveTo(new PointOption().withCoordinates(984,2610)).release().perform();

    }


}

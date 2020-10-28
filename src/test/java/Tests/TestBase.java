package Tests;

import Pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class TestBase {

    AndroidDriver androidDriver;
    LoginPage loginPage;
    SingUPPage singUPPage;
    SurveyFeedPage surveyFeedPage;
    CommunityPage communityPage;
    BuzzPage buzzPage;
    BasePage basePage;
   public static WebDriverWait wait;

    @BeforeMethod
    public void SetUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.jelvix.crowdthinc");
        // capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity", ".presentation.ui.activity.splash.SplashActivity");
        //  capabilities.setCapability("appActivity",".main.MainActivity");
        // capabilities.setCapability("app","/home/user/IdeaProjects/AutotestsAndroid/apkes/org.wikipedia.apk");
        // capabilities.setCapability("app", "/home/user/IdeaProjects/CrowdThinkMobileAutomation/apkes/TestBuild.apk");
        capabilities.setCapability("app", "/home/user/IdeaProjects/CrowdThinkMobileAutomation/apkes/TestBuildnewServ.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(androidDriver,4);

        loginPage = new LoginPage(androidDriver);
        singUPPage = new SingUPPage(androidDriver);
        surveyFeedPage = new SurveyFeedPage(androidDriver);
        communityPage = new CommunityPage(androidDriver);
        buzzPage = new BuzzPage(androidDriver);
        basePage = new BasePage(androidDriver);

    }

  //  @AfterMethod
    public void Close(){
        androidDriver.closeApp();
    }
}

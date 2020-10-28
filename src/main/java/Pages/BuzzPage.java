package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.Time;

public class BuzzPage extends BasePage {
    public BuzzPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }


    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='The Buzz!']")
    AndroidElement BuzzTab;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/viewButton")
    AndroidElement ViewLinkButton;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/viewPdfButton")
    AndroidElement ViewPDFButton;
    @AndroidFindBy (id= "org.chromium.webview_shell:id/url_field")
    AndroidElement URL;
    @AndroidFindBy (id = "com.jelvix.crowdthinc:id/pdfView")
    AndroidElement PDFDocument;




    public void WaitVisisbilityOfElement(AndroidElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public BuzzPage GotoBuzzPage(){
        WaitVisisbilityOfElement(BuzzTab);
        BuzzTab.click();
        return this;
    }
    public BuzzPage Clcik_On_View_Link_Button(){
        try {
            WaitVisisbilityOfElement(ViewLinkButton);
            ViewLinkButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Buzz With Link");
        }

        return this;
    }
    public BuzzPage Clcik_On_View_PDFButton(){
        try {
            WaitVisisbilityOfElement(ViewPDFButton);
            ViewPDFButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There ia no any Buzz With PDF");
        }

        return this;
    }


    public boolean ISLink_Was_Opened(){
        WaitVisisbilityOfElement(URL);

        if (URL.getText().startsWith("http")){
            return true;
        }else {
            Assert.fail("Link Was not opened!");
            return false;
        }

    }
    public boolean ISPDF_Was_Opened(){
        try {
            WaitVisisbilityOfElement(PDFDocument);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("PDF Was not Opened!");
            return  false;
        }


    }

}

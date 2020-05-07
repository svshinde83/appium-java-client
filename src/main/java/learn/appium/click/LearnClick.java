package learn.appium.click;

import io.appium.java_client.android.AndroidDriver;
import learn.appium.common.android.natvie.ApiDemoApp;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Slf4j
public class LearnClick {

    private AndroidDriver driver;

    @Test
    public void testClick() {
        driver = ApiDemoApp.invokeApiDemos();
        driver.findElementByAccessibilityId("Preference").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        ((WebElement) driver.findElementsByClassName("android.widget.Button").get(1)).click();
    }

    @AfterClass
    public void closeApp() {
        driver.closeApp();
    }
}

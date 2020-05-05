package learn.appium.ui.automator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learn.appium.common.ApiDemoApp;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class LearnAndroidUIAutomator {

    private AndroidDriver<AndroidElement> driver;

    @Test
    public void testAndroidUIAutomator() {
        driver = ApiDemoApp.invokeApiDemos();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
    }

    @AfterClass
    public void closeApp(){
        driver.closeApp();
    }
}

package learn.appium.gestures;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learn.appium.common.android.natvie.ApiDemoApp;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertTrue;

@Slf4j
public class LearnGesture {
    private AndroidDriver<AndroidElement> driver;

    @Test
    public void testGestures() {
        driver = ApiDemoApp.invokeApiDemos();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //Tap
        final TouchAction t = new TouchAction(driver);
        final WebElement expandList = driver.
                findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();
        driver.
                findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        final WebElement people = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        t.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(5))).release().perform();
        log.info(" :" + driver.findElementById("android:id/title").isDisplayed());
        assertTrue(driver.findElementById("android:id/title").isDisplayed());
    }

    @AfterClass
    public void closeApp() {
        driver.closeApp();
    }

}

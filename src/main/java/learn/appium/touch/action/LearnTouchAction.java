package learn.appium.touch.action;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import learn.appium.common.android.natvie.ApiDemoApp;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Slf4j
public class LearnTouchAction {

    private AndroidDriver driver;

    @Test
    public void testTouchAction() {
        driver = ApiDemoApp.invokeApiDemos();
        log.info("Device locked: " + driver.isDeviceLocked());
        log.info("context: " + driver.getContext());
        final List<AndroidElement> elements = driver.findElements(By.className("android.widget.TextView"));

        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withDuration(Duration.ofSeconds(10)).withElement(ElementOption.element(elements.get(2)));

        final TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(longPressOptions).perform();

    }

    @AfterClass
    public void closeApp() {
        driver.closeApp();
    }

}

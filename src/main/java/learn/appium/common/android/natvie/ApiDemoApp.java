package learn.appium.common.android.natvie;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static java.util.Objects.requireNonNull;

/**
 * Base class to test the driver connection
 * Invoke the application
 * Can be extended
 */
@Slf4j
public class ApiDemoApp {
    private static AndroidDriver<AndroidElement> driver = null;

    public static AndroidDriver invokeApiDemos() {

        try {
            final File appDir = new File("src/app");
            final File app = new File(appDir, "ApiDemos-debug.apk");

            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(DEVICE_NAME, "android-emulator-10");
            capabilities.setCapability(APP, app.getAbsolutePath());
            capabilities.setCapability(AUTOMATION_NAME, "uiautomator2");

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException m) {
            log.error("Exception occurred : \n :");
            m.printStackTrace();
        }

        log.info("Api Demo app invoked : " + requireNonNull(driver).toString());
        return driver;
    }

    @AfterClass
    public void closeApp() {
        driver.closeApp();
    }
}

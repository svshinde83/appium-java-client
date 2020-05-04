import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;

/**
 * Base class to test the driver connection
 * Invoke the application
 * Can be extended
 */
@Slf4j
public class ApiDemoApp {

    public static void main(String[] args) {
        final AndroidDriver<AndroidElement> androidElementAndroidDriver = invokeApiDemos();
        log.info("Android Element Driver : " + androidElementAndroidDriver.toString());
    }

    public static AndroidDriver<AndroidElement> invokeApiDemos() {
        AndroidDriver<AndroidElement> driver = null;
        try {
            final File appDir = new File("src/app");
            final File app = new File(appDir, "ApiDemos-debug.apk");

            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(DEVICE_NAME, "android-emulator-10");
            capabilities.setCapability(APP, app.getAbsolutePath());
            capabilities.setCapability(AUTOMATION_NAME, "uiautomator2");

            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException m) {
            log.error("Exception occurred : \n :");
            m.printStackTrace();
        }
        return driver;
    }
}

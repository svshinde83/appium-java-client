package learn.appium.common.web;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static java.util.Objects.requireNonNull;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.testng.Assert.assertTrue;
//import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

@Slf4j
public class WebBrowserSetUp {

    private AndroidDriver driver;

    @Test
    public void invokeDeviceBrowser() throws MalformedURLException {
        final DesiredCapabilities capabilities = getDesiredCapabilities();
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        requireNonNull(driver);
        log.info("Driver initialized !");
        driver.get("https://www.google.com.au/");
        assertTrue(driver.getCurrentUrl().contains("google.com.au"));
    }

    private DesiredCapabilities getDesiredCapabilities() {

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME, "Android Device");
        capabilities.setCapability(BROWSER_NAME, "Chrome");
        final File webBrowserDir = new File("src/mobile.drivers");
        final File webBrowser = new File(webBrowserDir, "chromedriver_win32-83.exe");
        capabilities.setCapability("chromedriverExecutable", webBrowser.getAbsolutePath());

        return capabilities;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            log.info("Quitting driver!");
            driver.quit();
        }
    }

}

package learn.appium.gestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import learn.appium.common.ApiDemoApp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LearnGesture{
    private AndroidDriver<AndroidElement> driver;

    @Test
    public  void testGestures(){
        driver = ApiDemoApp.invokeApiDemos();
    }

    @AfterClass
    public void closeApp(){
        driver.closeApp();
    }

}

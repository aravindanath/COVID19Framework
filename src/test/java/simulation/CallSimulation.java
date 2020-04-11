package simulation;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class CallSimulation {

    private AndroidDriver driver;
  
	
    private String APP = System.getProperty("user.dir")+File.separator+"apks"+File.separator+"VodQA.apk";
    private String PHONE_NUMBER = "5551237890";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("avd", "API_27");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", APP);
        capabilities.setCapability("adbExecTimeout", 80000);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", 80000);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPhoneCall() throws InterruptedException {
        // do something in our app
     //   driver.findElementByAccessibilityId("Login Screen").click();

        // receive and accept a call
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CALL);
        Thread.sleep(2000); // pause just for effect
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.ACCEPT);

        // continue to do something in our app
//        driver.findElementByAccessibilityId("username").sendKeys("hi");
        Thread.sleep(2000); // pause just for effect

        // end the call
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CANCEL);
        Thread.sleep(2000); // pause just for effect
    }
}
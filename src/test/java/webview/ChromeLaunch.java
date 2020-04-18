package webview;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeLaunch {


    public static void main(String[] args) {




        WebDriver driver = null;


        try {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

            caps.setCapability("deviceName", "motorola one power");

            caps.setCapability("udid", "ZF62245RHC"); // Give Device ID of your mobile phone

            caps.setCapability("platformName", "Android");

            caps.setCapability("platformVersion", "10");

            caps.setCapability("browserName", "Chrome");

            caps.setCapability("newCommandTimeout", 0);

            caps.setCapability("chromedriverExecutable",

                    "/usr/local/lib/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac/chromedriver");

            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);


        } catch (MalformedURLException e) {

            System.out.println(e.getMessage());

        }

        // Open URL in Chrome Browser

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Appium jobs in bangalore", Keys.ENTER);



    }
}

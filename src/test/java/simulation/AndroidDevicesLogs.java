package simulation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

public class AndroidDevicesLogs {

    public AppiumDriver driver;
    WebDriverWait wait;

    // appium port 3333 --relaxed-security

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//		 capabilities.setCapability("networkSpeed", "hsdpa");
//		 capabilities.setCapability("avd", "API_29");
//		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
//		 "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF62245RHC");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator+"apks"+File.separator+"VodQA.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


        @Test
        public void rec(){
//            screenRecord1(driver);
            turnOffWifi();
            turnOnWifi();
//            screenRecord(driver);
            driver.closeApp();
        }





    public void androidScreenRecordTest() throws IOException {
        ((AndroidDriver) driver).startRecordingScreen();
        String s = ((AndroidDriver) driver).stopRecordingScreen();
        byte[] decode = Base64.getDecoder().decode(s);
        FileUtils.writeByteArrayToFile(new File(System.getProperty("user.dir")+"/sample.mp4"), decode);
    }


    public void iOSScreenRecordTest() throws IOException {
        ((IOSDriver) driver).startRecordingScreen();
        String s = ((IOSDriver) driver).stopRecordingScreen();
        byte[] decode = Base64.getDecoder().decode(s);
        FileUtils.writeByteArrayToFile(new File(System.getProperty("user.dir")+"/sample.mp4"), decode);
    }


    public void battery(WebDriver driver) {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "dumpsys");
        args.put("args", "battery");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }




    public void wifi(WebDriver driver) {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "dumpsys");
        args.put("args", "wifi");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }

    public void screenRecord(WebDriver driver) {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "adb screenrecord");
        args.put("args", "/mnt/sdcard/Download/test.mp4");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }
    public void screenRecord1(WebDriver driver) {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "adb shell screenrecord /mnt/sdcard/Download/test.mp4");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile:", args);
        System.out.println(o);
    }




    public void turnOffWifi() {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "svc wifi disable");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }

    public void turnOnWifi() {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "svc wifi enable");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }

}

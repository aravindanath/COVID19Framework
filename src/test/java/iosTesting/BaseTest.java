package iosTesting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	public String udid = "E6A60320-C921-4C55-B500-96279C968D4B";// "emulator-5554";
	public String PlatformVersion = "13.4.1";
	public String DeviceName = "iPhone 8";
	public String platformName ="iOS";
	public String bundleID = "com.example.apple-samplecode.UICatalog";
	public String path = System.getProperty("user.dir")+File.separator+"apks"+File.separator+"WebViewTest.apk";
//	public IOSDriver driver;
	protected WebDriver driver = null;
	//protected AndroidDriver<AndroidElement> driver = null;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	@BeforeClass
	public void launchApp() throws MalformedURLException {

		String url ="http://0.0.0.0:4723/wd/hub";
		if (udid.length() > 20) {
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("platformVersion", PlatformVersion);
			capabilities.setCapability("deviceName", DeviceName);
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleID);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);;
			capabilities.setCapability(MobileCapabilityType.UDID ,udid);
			driver = new IOSDriver<IOSElement>(new URL(url), capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else {

			capabilities.setCapability("autoGrantPermission", true);
			capabilities.setCapability("testName", "Simulating Slow Internet Connections on Android Demo");
			capabilities.setCapability("deviceName", DeviceName);
			capabilities.setCapability("platformVersion",PlatformVersion);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("automationName", "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, " ");
			capabilities.setCapability("intentAction", "android.intent.action.VIEW");
			driver = new AndroidDriver<>(new URL(url), capabilities);
		}
	}
	
//	@BeforeClass
//	public void launchApp() throws MalformedURLException {
//
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//		dc.setCapability(MobileCapabilityType.NO_RESET, false);
////		dc.setCapability(MobileCapabilityType.APP, path);
//		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleId);
//		dc.setCapability(MobileCapabilityType.VERSION, PlatformVersion);
//		dc.setCapability("deviceName", DeviceName);
//		dc.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, "iOS");
//		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//	}
//
	
	

}

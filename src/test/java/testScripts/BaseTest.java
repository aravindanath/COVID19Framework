package testScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public String udid = "J9AAGF003855NTH";// "emulator-5554";
	public String PlatformVersion = "9";
	public String DeviceName = "ASUS_X00TD";//"motorola one power";
	public String packageName = "in.amazon.mShop.android.shopping";// "in.swiggy.android"; //com.actimind.actitime
	public String appActivity = "com.amazon.mShop.home.HomeActivity";// com.actimind.actitime.ui.startup.StartActivity
	public String path = System.getProperty("user.dir")+File.separator+"apks"+File.separator+"WebViewTest.apk";
	public AppiumDriver driver;
	
	
	@BeforeClass
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.NO_RESET, false);
		dc.setCapability(MobileCapabilityType.APP, path);
//		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packageName);
//		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		dc.setCapability(MobileCapabilityType.VERSION, PlatformVersion);
		dc.setCapability("deviceName", DeviceName);
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", false);
		driver = new AppiumDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	
	

}

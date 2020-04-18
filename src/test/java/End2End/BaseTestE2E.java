package End2End;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestE2E {
	public String udid = "ZF62245RHC";// "emulator-5554";
	public String PlatformVersion = "10";
	public String DeviceName = "motorola one power";
	public String path = System.getProperty("user.dir")+File.separator+"apks"+File.separator+"GeneralStore.apk";


	public AndroidDriver driver;
	
	@BeforeClass
	public void launchApp() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.NO_RESET, false);
		dc.setCapability(MobileCapabilityType.APP, path);
		dc.setCapability(MobileCapabilityType.VERSION, PlatformVersion);
		dc.setCapability("deviceName", DeviceName);
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", false);

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	
	
	

}
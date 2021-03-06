package simulation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

 
public class LockPattern {
	public AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("networkSpeed", "hsdpa");
		capabilities.setCapability("avd", "API_27");
		capabilities.setCapability("unlockType", "pattern");
		capabilities.setCapability("unlockKey", "1234");
		capabilities.setCapability("uiautomator2ServerLaunchTimeout", 200000);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800000);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/VodQA.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void sample() throws InterruptedException {
		doubleTap();
		battery(driver);
		turnOffWifi();
		Thread.sleep(3000);
		turnOnWifi();
		Thread.sleep(3000);
		wifi(driver);
	}

	public void doubleTap() throws InterruptedException {
		// screenRecord(driver);
		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("login"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("doubleTap"))).click();
		Thread.sleep(1000);
		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("doubleTapMe");
		Thread.sleep(1000);
		// for button center
		Point source = element.getCenter();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		// Move
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.getX(),
				source.getY()));
		// Down
		tap.addAction((finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())));
		// Pause
		tap.addAction(new Pause(finger, Duration.ofMillis(40)));
		// Up
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		// pause
		tap.addAction(new Pause(finger, Duration.ofMillis(40)));
		// down
		tap.addAction((finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())));
		// pause
		tap.addAction(new Pause(finger, Duration.ofMillis(40)));
		// up
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		driver.perform(Arrays.asList(tap));

		Thread.sleep(1000);

		battery(driver);

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
		args.put("command", "screenrecord");
		args.put("args", "../demo.mp4");
		Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
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

	// adb shell 'svc wifi disable'
	//
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

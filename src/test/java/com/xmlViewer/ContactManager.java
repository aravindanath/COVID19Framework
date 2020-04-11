package com.xmlViewer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactManager {
	public static AndroidDriver<MobileElement> driver;
	private static final String FILENAME = System.getProperty("user.dir")+"/contactManager.xml";
	
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		File app = new File("./apks/ContactManager.apk");
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "motorola one power");
		caps.setCapability("udid", "ZF62245RHC"); // Give Device ID of your
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("uiautomator2ServerLaunchTimeout", 80000);
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		// Instantiate Appium Driver
		
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://0.0.0.0:4723/wd/hub"), caps);
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
		Thread.sleep(3000);
	    String src=driver.getPageSource();
	    System.out.println("src is::"+src);
	    saveFile(src);
	    driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
		
		Thread.sleep(6000);
		
	}
	
	public void saveFile(String src) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
		
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(src);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		WebDriverManager.chromedriver().setup();
 		WebDriver d2=new ChromeDriver();
 		d2.get("file:///"+FILENAME);

	}
	

	@AfterTest
	public void quit() {
		driver.quit();
	}

}

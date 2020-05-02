package iosTesting;

import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.Dimension;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

public class IOSTest extends BaseTest{

    @Test
    public void iosTextCase() throws InterruptedException {


//        driver.findElement(MobileBy.AccessibilityId("Alert Views")).click();
//        driver.findElement(MobileBy.xpath("//*[@value='Text Entry']")).click();
//        driver.findElement(MobileBy.className("XCUIElementTypeTextField")).sendKeys("hello");
//        driver.findElement(MobileBy.name("OK")).click();
//        driver.navigate().back();
//



        driver.findElement(MobileBy.iOSNsPredicateString("value='Date Picker'")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[2]")).sendKeys("7");
        Thread.sleep(2000);
        driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[3]")).sendKeys("50");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(MobileBy.AccessibilityId("Picker View")).click();
        driver.findElement(MobileBy.name("Green color component value")).sendKeys("220");
        driver.findElements(MobileBy.className("XCUIElementTypePickerWheel")).get(0).sendKeys("55");
        driver.findElement(MobileBy.xpath("//*[@name='Blue color component value']")).sendKeys("130");
    }}
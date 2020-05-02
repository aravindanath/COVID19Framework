package iosTesting;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test002 extends BaseTest{



    @Test
    public void text002() throws Exception{
        driver.findElement(MobileBy.AccessibilityId("Search")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.AccessibilityId("Default")).click();
        driver.findElement(MobileBy.AccessibilityId("Scope Two")).click();
        for(int i=0;i<2;i++)
        driver.navigate().back();
        driver.findElement(MobileBy.AccessibilityId("Steppers")).click();
        driver.findElement(MobileBy.AccessibilityId("Increment")).click();
        driver.findElement(MobileBy.AccessibilityId("Increment")).click();
        System.out.println( driver.findElements(MobileBy.className("XCUIElementTypeStaticText")).get(1).getText());
        System.out.println( driver.findElements(MobileBy.className("XCUIElementTypeStaticText")).get(2).getText());
        driver.findElement(MobileBy.AccessibilityId("Decrement")).click();
        System.out.println(driver.findElements(MobileBy.className("XCUIElementTypeStaticText")).get(1).getText());
        driver.navigate().back();

    }
}

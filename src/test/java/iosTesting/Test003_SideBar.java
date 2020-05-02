package iosTesting;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

public class Test003_SideBar extends BaseTest{



    @Test
    public void text003() throws Exception{
        driver.findElement(MobileBy.AccessibilityId("Sliders")).click();
        Thread.sleep(2000);

        WebElement slidebar = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSlider[1]"));



        driver.navigate().back();

    }
}

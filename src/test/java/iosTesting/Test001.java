package iosTesting;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

public class Test001  extends BaseTest{



    @Test
    public void text001() throws Exception{

//

        driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeCell[2]")).click();

        driver.findElement(MobileBy.AccessibilityId("Simple")).click();

        driver.findElement(MobileBy.iOSNsPredicateString("type ='XCUIElementTypeButton' and name='OK' or label ='OK'")).click();


        Thread.sleep(2000);

        driver.findElement(MobileBy.iOSNsPredicateString("type='XCUIElementTypeButton' and name='UIKitCatalog'")).click();

        Thread.sleep(2000);
        driver.findElement(MobileBy.iOSNsPredicateString("value='Date Picker'")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[1]")).sendKeys("Sun May 3");
        Thread.sleep(2000);
        driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[4]")).sendKeys("AM");

        Thread.sleep(2000);

        driver.findElement(MobileBy.iOSNsPredicateString("type='XCUIElementTypeButton' and name='UIKitCatalog'"))
                .click();

    }
}

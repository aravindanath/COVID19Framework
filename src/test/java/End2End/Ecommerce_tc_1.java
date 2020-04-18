
package End2End;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;



import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pages.BasePage;


public class Ecommerce_tc_1  extends BaseTestE2E {


    @Test
    public void test001() throws MalformedURLException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        driver.findElement(By.id("android:id/text1")).click();
        BasePage.scroll(driver, "Argentina");


        //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

        driver.findElement(By.xpath("//*[@text='Argentina']")).click();



        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arvind");

        Thread.sleep(3000);
        driver.hideKeyboard(); //or  click on backbutton

        driver.findElement(By.xpath("//*[@text='Female']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }
}
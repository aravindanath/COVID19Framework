
package End2End;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Ecommerce_tc_2 extends BaseTestE2E {


    @Test
    public void ecommerce_tc_2() throws MalformedURLException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

        // driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@text='Female']")).click();

        driver.findElement(By.id("android:id/text1")).click();


//Jordan 6 Rings
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Algeria\").instance(0))"));

        //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

        driver.findElement(By.xpath("//*[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");



        System.out.println(toastMessage);

        Assert.assertEquals("Please enter your name", toastMessage);//Actual validation

//name attribute for toast messages will have content












    }
}
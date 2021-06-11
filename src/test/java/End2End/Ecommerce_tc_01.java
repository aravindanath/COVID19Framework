
package End2End;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Ecommerce_tc_01 extends BaseTestE2E {

    /**
     * Ecommerce_tc_01: Verify toast message
     * @throws MalformedURLException
     * @throws InterruptedException
     */


    @Test
    public void test001() throws MalformedURLException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("spinnerCountry")).click();
        String city = "Bhutan";
        BasePage.scroll(driver, city);
        driver.findElement(By.xpath("//*[@text='"+city+"']")).click();

        driver.findElement(By.xpath("//*[contains(@text,'Shop')]")).click();

        String tost = driver.findElement(By.xpath("//*[@text='Please enter your name']")).getText();
        System.out.println(tost);
        Assert.assertTrue(tost.contains("Please enter your name"),"Toast msg mis match!");


    }
}
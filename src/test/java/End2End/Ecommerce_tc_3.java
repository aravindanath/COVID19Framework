
package End2End;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Ecommerce_tc_3 extends BaseTestE2E {


    @Test
    public void ecommerce_tc_3() throws MalformedURLException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@text='Female']")).click();

        driver.findElement(By.id("android:id/text1")).click();

        BasePage.scroll(driver,"Argentina");

        driver.findElement(By.xpath("//*[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        BasePage.scroll(driver,"Jordan 6 Rings");

        List<WebElement> count = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        System.out.println("Total no of product: "+count.size());


        for(int i=0;i<count.size();i++) {
            List<WebElement> title = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
            String text = title.get(i).getText();
            if (text.equalsIgnoreCase("Jordan 6 Rings")) {
                List<WebElement> add = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
                add.get(i).click();
                break;
            }

            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

            String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

            Assert.assertEquals("Jordan 6 Rings", lastpageText);

        }


    }
}
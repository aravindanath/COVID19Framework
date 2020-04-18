
package End2End;

import io.appium.java_client.MobileBy;
import java.net.MalformedURLException;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.By.ByClassName;

import org.openqa.selenium.WebElement;



import io.appium.java_client.MobileBy;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;


public class Ecommerce_tc_4 extends BaseTestE2E {


    @Test
    public void ecommerce_tc_4() throws MalformedURLException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arvind");

        driver.hideKeyboard();

        driver.findElement(By.xpath("//*[@text='Female']")).click();

        driver.findElement(By.id("android:id/text1")).click();

        BasePage.scroll(driver,"Argentina");


        driver.findElement(By.xpath("//*[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        List<WebElement> ele = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
        ele.get(0).click();



        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(4000);

        int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

        double sum=0;

        for(int i=0;i<count;i++)

        {

            List<WebElement> amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
            String value = amount1.get(i).getText();

            double amount=getAmount(value);

            sum=sum+amount;//280.97+116.97

        }

        System.out.println(sum+"sum of products");



        String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();



        total= total.substring(1);

        double totalValue=Double.parseDouble(total);

        System.out.println(totalValue+"Total value of products");

        Assert.assertEquals(sum, totalValue);



//Mobile Gestures

        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

        TouchAction t=new TouchAction(driver);

        t.tap(tapOptions().withElement(element(checkbox))).perform();



        WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

        t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

        String msg =driver.findElement(By.id("android:id/message")).getText();
        System.out.println(msg);
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


        Set<String> contextNames = driver.getContextHandles();

        for(String contextName : contextNames ){
            System.out.println(contextName);
        }

    }

    public static double getAmount(String value)

    {

        value= value.substring(1);

        double amount2value=Double.parseDouble(value);

        return amount2value;


    }
}
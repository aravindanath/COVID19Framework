
package End2End;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Ecommerce_tc_5 extends BaseTestE2E {
    /**
     * 'a' - 'z' --> 29 - 54
     * '0' - '9'--> 7 - 16
     * SPACE --> 62
     * ENTER ---> 66
     * BACKSPACE --> 67
     * BACK --> 4
     * CALL --> 5
     * ENDCALL --> 6
     * @throws MalformedURLException
     * @throws InterruptedException
     */

    @Test
    public void ecommerce_tc_3() throws IOException, InterruptedException {


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement textbox  =driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        textbox.click();
        for(int i =29; i<37;i++)
        BasePage.useKeyboard(driver,i);

        BasePage.useKeyboard(driver,67);
        BasePage.useKeyboard(driver,40);

        driver.hideKeyboard();

        BasePage.clickBasedOnExplicitWait(driver,20,  By.id("com.androidsample.generalstore:id/btnLetsShop"));

        BasePage.useKeyboard(driver,187);
        BasePage.captureScreen(driver);
        Thread.sleep(2000);
        driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc='Staging PayZapp']/android.view.View")).click();

    }
}
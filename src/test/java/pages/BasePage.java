package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class BasePage {


    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }



    public static void verifyTitle(WebElement element , String excepted){

        String actual = element.getText();

        Assert.assertEquals(actual,excepted,"Actual vs Excepted is mismatch!");


    }



    public static void verifyElementisDisplayed(WebElement element){

        System.out.println("==== Verify the button ====");
        Assert.assertTrue(element.isDisplayed(),"Element is not present on the screen");

    }

    /**
     * https://github.com/DiUS/java-faker
     * @return
     */


    public static String mobileNumber(){

        Faker fake = new Faker(new Locale("in-ID"));
        PhoneNumber mob = fake.phoneNumber();
        String cel = mob.cellPhone().replace("-","").replace(".","");
        return cel;

    }


    public static String fullName(){

        Faker fake = new Faker(new Locale("in-ID"));
        String name = fake.name().fullName();
        return name;

    }

    /**
     * @Author arvind
     * @param driver
     * @param text
     * @return
     */

    public static WebElement scroll(WebDriver driver, String text) {

        // === Android === //
        String automatorString = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\""
                + text + "\"));";
        return ((AndroidDriver) driver).findElementByAndroidUIAutomator(automatorString);
    }



    public static void turnOffWifi() {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "svc wifi disable");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }

    public static void turnOnWifi() {
        HashMap<String, String> args = new HashMap<String, String>();
        args.put("command", "svc wifi enable");
        Object o = ((JavascriptExecutor) driver).executeScript("mobile: shell", args);
        System.out.println(o);
    }

    public static void switchAndroidApp(String packageName, String appActivity) {
        Activity appActivitys = new Activity(packageName, appActivity);
        ((AndroidDriver) driver).startActivity(appActivitys);
    }



    public static void navigateBackBtn(WebDriver driver) {
        ((AndroidDriver) driver).pressKeyCode(4);
    }


    public static void pressButton(WebDriver driver, int keycode) {
        ((AndroidDriver) driver).pressKeyCode(keycode);
    }



    public static boolean checkNativeApp(WebDriver driver) {
        if (!checkAndroid(driver))
            return false;

        AndroidDriver adriver = (AndroidDriver) driver;

        System.out.println("Checking Native App context : " + adriver.getContext());

        return adriver.getContextHandles().contains("NATIVE") && adriver.getContextHandles().size() == 1;
    }


    public static boolean checkAndroid(WebDriver driver) {
        if (driver == null)
            return false;

        System.out.println("driver type : " + driver.toString());
        return containsIgnoreCase(driver.toString(), "Android");
    }


    public static boolean containsIgnoreCase(String containerString, String containedString) {
        return containerString.toLowerCase().contains(containedString.toLowerCase());
    }


    public static void hideKeyboard(WebDriver driver) {
        ((AndroidDriver) driver).hideKeyboard();
    }



    public static String getMsgContentFromNotification(AndroidDriver aDriver, String notifictionTitle,
                                                       String smsContent) {

        (aDriver).openNotifications();

        String notificationXp = "//*[contains(@text,'notifictionTitle')]".replace("notifictionTitle", notifictionTitle);

        aDriver.findElement(By.xpath(notificationXp)).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        aDriver.findElement(By.xpath(notificationXp)).click();
        String contentXp = "(//*[contains(@text,'smsContent')])[last()]".replace("smsContent", smsContent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        return aDriver.findElement(By.xpath(contentXp)).getText();

    }

    public static String getOtpFromNotificationAdv(AndroidDriver aDriver, String notifictionTitle, String smsContent) {

        String smsText = getMsgContentFromNotification(aDriver, notifictionTitle, smsContent);

        System.out.println("====================Sms Text: " + smsText + "====================");

        for (String str : smsText.split(" ")) {
            if (str.matches("\\d{6}")) {
                return str;
            }

        }
        return "123456";

    }


    public static boolean isAndroid(WebDriver driver) {
        return driver != null && driver.toString().toLowerCase().contains("android");
    }


    public void singleTap(WebElement element) {
        TouchActions tc = new TouchActions(driver);
        tc.singleTap(element).build().perform();
    }

    public void longPress(WebElement element) {
        TouchActions tc = new TouchActions(driver);
        tc.longPress(element).build().perform();
        // tc.release().build().perform();
    }

    public static void tap(WebDriver driver, WebElement element) {

        if (isAndroid(driver)) {

            AndroidDriver<AndroidElement> aDriver = (AndroidDriver<AndroidElement>) driver;
            TouchAction touchAction = new TouchAction(aDriver);

            AndroidElement aElement = (AndroidElement) element;
            int x = aElement.getCenter().x, y = aElement.getCenter().y;

            System.out.println("Executing tap on " + x + ',' + y);

            touchAction.press(PointOption.point(x, y)).release().perform();

        } else {
            IOSDriver<IOSElement> iDriver = (IOSDriver<IOSElement>) driver;
            TouchAction touchAction = new TouchAction(iDriver);

            IOSElement iElement = (IOSElement) element;
            int x = iElement.getCenter().x, y = iElement.getCenter().y;

            System.out.println("Executing tap on " + x + ',' + y);
            touchAction.press(PointOption.point(x, y)).release().perform(); // May Upgrade , if 'visible' attribute is
            // true then syso and print "Clicking
            // directly" under log
        }
    }


    public static void horizantalSwipe(WebDriver driver) {
        System.out.println("=Performing New Swipe =");

        AppiumDriver adriver = (AppiumDriver) driver;
        TouchAction touchAction = new TouchAction(adriver);
        Dimension size = adriver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.15);
        int starty = size.height / 3;

        try {
                touchAction.press(PointOption.point(startx, starty))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(10, starty)).release().perform(); // Absolute final Co-ordinates
        } catch (Exception e) {
            System.err.println("Scroll error ");
            e.printStackTrace();
        }

    }


    public static void swipeOnSeekbar(AppiumDriver driver, WebElement element, int percentage) {

        Point point = element.getLocation();
        Dimension eleSize = element.getSize();

        int startX = point.getX();
        int startY = point.getY() + (eleSize.getHeight() / 2);
        int moveToX = point.getX() + (eleSize.getWidth() * percentage / 100);
        int moveToY = point.getY() + (eleSize.getHeight() / 2);

        new TouchAction<>(driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(moveToX, moveToY)).release().perform();
    }

//https://elementalx.org/button-mapper/android-key-codes/

    public static void useKeyboard(WebDriver driver,int val) {
        ((AndroidDriver) driver).pressKeyCode(val);
    }


    public static void clickBasedOnExplicitWait(WebDriver driver, int maxTime, By element) {
        WebDriverWait wait = new WebDriverWait(driver, maxTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(element)).click();
    }




    public static String captureScreen(WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/screenShot.png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return dest;
    }

}

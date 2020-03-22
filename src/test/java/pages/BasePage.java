package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Locale;


public class BasePage {


    protected  WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }




    public static void verifyTitle(WebElement element , String excepted){

        String actual = element.getText();

        Assert.assertEquals(actual,excepted,"Actual vs Excepted is mismatch!");


    }



    public static void verifyElementisDisplayed(WebElement element){

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






}

package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage  {


    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }


    @AndroidFindBy(id=("skip_sign_in_button"))
    private WebElement skipButton;

    @AndroidFindBy(id="sso_splash_logo")
    private MobileElement logo;

    @AndroidFindBy(id="signin_to_yourAccount")
    private MobileElement title;

    @AndroidFindBy(xpath = "//*[@text='हिंदी में देखें']")
    private MobileElement changeToHindi;

    @AndroidFindBy(id="new_user")
    private MobileElement newUser;

    @AndroidFindBy(xpath = "//*[@text='Switch to English']")
    private WebElement changeToenglish;


    /**
     * Business logic starts
     */


    public void verifySignScreenAndSkip() throws InterruptedException {

        BasePage.verifyElementisDisplayed(title);
        BasePage.verifyTitle(title,"Sign in to your account");
        changeToHindi.click();
        Thread.sleep(2000);
        changeToenglish.click();
        Thread.sleep(2000);
        skipButton.click();

    }







}

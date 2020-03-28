package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class SettingsPage  extends BasePage{

    public SettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

    }


    @AndroidFindBy(id=("in.amazon.mShop.android.shopping:id/action_bar_burger_icon"))
    private WebElement hamBurger;

    @AndroidFindBy(xpath=("//*[contains(@text,'Language')]"))
    private WebElement lang;



    @AndroidFindBy(xpath=("//*[contains(@text,'information now in Hindi')]"))
    private WebElement hindi;



    @AndroidFindBy(xpath=("//*[contains(@text,'भाषा का विकल्प किसी भी समय')]"))
    private WebElement disclaimer;


    @AndroidFindBy(xpath=("//*[@text='Settings']"))
    private WebElement settingButton;


    @AndroidFindBy(xpath=("//*[@text='Change Country']"))
    private WebElement changeCountry;


    @AndroidFindBy(xpath=("//*[@text='United States (English)']"))
    private WebElement usaEnglish;


    @AndroidFindBy(id=("in.amazon.mShop.android.shopping:id/switch_country_dialog_continue_button"))
    private WebElement continueButton;

    @AndroidFindBy(xpath=("//*[contains(@text,'later')]"))
    private WebElement remindLater;




    public void changeLanguage(){

        try{
            remindLater.click();
        }catch (Exception e){

        }

        hamBurger.click();
        BasePage.verifyElementisDisplayed(lang);
        lang.click();
        hindi.click();
        BasePage.verifyTitle(disclaimer,"भाषा का विकल्प किसी भी समय बदला जा सकता है. हम ब्राउज़ और खरीदारी करने में आपकी सहायता करने के लिए जानकारियों का अनुवाद करेंगे. हम Amazon.in पर हिंदी भाषा से जुड़े अनुभव को लगातार बेहतर बना रहे हैं. अगर आपके पास इन अनुवादों से जुड़ा कोई फ़ीडबैक है, तो कृपया ग्राहक सहायता में संपर्क करें. अनुवाद सिर्फ़ आपकी सुविधा के लिए किये गए हैं और Amazon.in का अंग्रेज़ी संस्करण, उपयोग की शर्तों सहित, ही अंतिम और निर्णायक है.");



    }


    public void changeCountry(String country){

        try{
            remindLater.click();
        }catch (Exception e){

        }

        hamBurger.click();
        BasePage.verifyElementisDisplayed(settingButton);
        settingButton.click();
        changeCountry.click();
        BasePage.scroll(driver,country);
        usaEnglish.click();
        continueButton.click();



    }





}


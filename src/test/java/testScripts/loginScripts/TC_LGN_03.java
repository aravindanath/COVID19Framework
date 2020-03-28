package testScripts.loginScripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;
import testScripts.BaseTest;

public class TC_LGN_03 extends BaseTest {

    /**
     * TC_LGN_01 : Verfiy the sign in screen and skip the login
     *
     * @throws InterruptedException
     */
	@Test
	public void open() throws InterruptedException {


		LoginPage lp = new LoginPage(driver);
		lp.verifySignScreenAndSkip();

		SettingsPage sp = new SettingsPage(driver);
		sp.changeLanguage();


	}

}

/**
 *
 */

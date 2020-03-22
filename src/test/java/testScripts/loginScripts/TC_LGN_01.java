package testScripts.loginScripts;

import io.appium.java_client.MobileBy;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import testScripts.BaseTest;

public class TC_LGN_01 extends BaseTest {

    /**
     * TC_LGN_01 : Verfiy the sign in screen and skip the login
     *
     * @throws InterruptedException
     */
	@Test
	public void open() throws InterruptedException {


		LoginPage lp = new LoginPage(driver);
		lp.verifySignScreenAndSkip();



	}

}

/**
 *
 */

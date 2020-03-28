package testScripts.trueKey;

import org.testng.annotations.Test;
import pages.LoginPage;
import testScripts.BaseTest;

public class TC_SIGNUP_01 extends BaseTest {

    /**
     * TC_SIGNUP_01 : Create a new user
     *
     * @throws InterruptedException
     */
	@Test
	public void signUP() throws InterruptedException {


		LoginPage lp = new LoginPage(driver);
		lp.verifySignScreenAndSkip();



	}

}

/**
 *
 */

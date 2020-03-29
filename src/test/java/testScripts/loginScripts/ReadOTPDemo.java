package testScripts.loginScripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;
import testScripts.BaseTest;

public class ReadOTPDemo  {

	@Test
	public void open(){


		String otp = "Hi Kavita, Device verification code for your device 6534544 xxxx6666 ";


		for (String str : otp.split(" ")) {
			if (str.matches("\\d{7}")) {

				System.out.println("OTP : "+str);
			}

		}









	}

}


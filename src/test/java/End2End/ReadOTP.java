package End2End;

import org.testng.annotations.Test;

public class ReadOTP {


    @Test
    public void readOTP(){

        String smsText = "Hi Kavita, for your HDFC txn ac xxxxxx844433 OTP is 5455".replace(".","").replace(",","").trim();

        for (String str : smsText.split(" ")) {
            if (str.matches("\\d{6}")) {
                 System.out.println(str);
            }else if(str.matches("\\d{4}")){
                System.out.println(str);
            }
    }

}}

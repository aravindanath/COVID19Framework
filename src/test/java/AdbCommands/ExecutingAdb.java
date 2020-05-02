package AdbCommands;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testScripts.BaseTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ExecutingAdb  {
    public AndroidDriver driver;
    @Test
   public void test() throws IOException, InterruptedException {
//        String adbCommand = "adb -s ZF62245RHC shell am broadcast -a io.appium.settings.wifi --es setstatus disable";
        String adbCommand = "adb  -s ZF62245RHC shell am broadcast -a io.appium.settings.data_connection --es setstatus disable";

        System.out.println(runCommand(adbCommand));


    }

    public void turnOFFWifi() throws IOException {
        String cmd = "adb shell am broadcast -a io.appium.settings.data_connection --es setstatus disable";
        Process process = Runtime.getRuntime().exec(cmd);
     //    Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.data_connection --es setstatus disable");
    }

    public void getSms() throws IOException {
        Process process = Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.sms.read --es max 10");

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }


    public static String execCmd(String cmd) // throws java.io.IOException
    {
        try {
            java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream())
                    .useDelimiter("\\A");

            String cmdOutput = s.hasNext() ? s.next() : "";
            s.close();
            return cmdOutput; // Implement close logic by storing in separate string before returning
        } catch (Exception e) {
            System.err.println("-- Unable to execute command " + cmd + " --" + e.getMessage());
            return "";
        }

    }

    public static String execProcess(String processCmd) {
        String output = "noRes";

        try {
            ProcessBuilder pb = new ProcessBuilder(processCmd.split(" "));
            output = IOUtils.toString(pb.start().getInputStream());
        } catch (Exception e) {
        }
        return output;
    }




    public String runCommand(String command) throws InterruptedException, IOException {
        Process p = Runtime.getRuntime().exec(command);
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        String allLine = "";
        int i = 1;
        while ((line = r.readLine()) != null) {
            allLine = allLine + "" + line + "\n";
            if(line.contains("Console LogLevel: debug") && line.contains("Complete")) {
                break;
            }
            i++;
        }
        return allLine;
    }


    public void runCommands(String command) throws InterruptedException, IOException {
        Process p = Runtime.getRuntime().exec(command);
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line = "";
//        String allLine = "";
//        int i = 1;
//        while ((line = r.readLine()) != null) {
//            allLine = allLine + "" + line + "\n";
//            if(line.contains("Console LogLevel: debug") && line.contains("Complete")) {
//                break;
//            }
//            i++;
//        }
//        return allLine;
    }

    public void turnOffWifi() throws InterruptedException, IOException {
        String cmd = "adb shell am broadcast -a io.appium.settings.data_connection --es setstatus disable";
        Runtime.getRuntime().exec(cmd);
    }

    public void turnOnWifi() throws InterruptedException, IOException {
        String cmd = "adb shell am broadcast -a io.appium.settings.data_connection --es setstatus enable";
        Runtime.getRuntime().exec(cmd);
    }


}

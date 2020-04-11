package webview;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testScripts.BaseTest;

public class AndroidWebView extends BaseTest {
 
	/*
	 *  Developers has to enable webview debugging  in the app. setWebContentsDebuggingEnabled
	 */
	
	


    @Test
    public void webView() throws InterruptedException {


        driver.findElement(By.xpath("//*[@content-desc='Open navigation drawer']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='WebView']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@text='GO']")).click();
        Thread.sleep(2000);
        
        Set<String> contextNames = driver.getContextHandles();

        for(String contextName : contextNames ){
            System.out.println(contextName);
        }
        //  driver.context("WEBVIEW_com.snc.test.webview2");
          driver.context(contextNames.toArray()[1].toString());
          System.out.println("Page Title: "+driver.getTitle());
          driver.context("NATIVE_APP");

    }





}

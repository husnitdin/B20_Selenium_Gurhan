package com.cybertek.tests.Day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {

        /* Google	Title	Verification
        	1.Open	Chrome	browser
        	2.Go	to	https://www.google.com
        	3.Verify	title:
        	  Expected:	Google */

        WebDriverManager.chromedriver().setup();

        // if using browser driver locally
        // you use System.set.Property every time we use WebDriverManager

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        String expected = "Google";
        String actual = driver.getTitle();

        if(expected.equalsIgnoreCase(actual)){
            System.out.println("Title verification PASSED "+expected+" "+actual);
        } else {
            System.out.println("Title verification FAILED "+expected+" "+actual);
        }

    }
}

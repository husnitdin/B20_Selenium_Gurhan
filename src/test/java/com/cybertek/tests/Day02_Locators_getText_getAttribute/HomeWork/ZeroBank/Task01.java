package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.ZeroBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Zero Bank title verification
            1. Open Chrome browser
            2. Go to http://zero.webappsecurity.com/login.html
            3. Verify title
Expected: “Zero - Log in”
 */
public class Task01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actual = driver.getTitle();
        String expected = "Zero - Log in";

        if ( actual.equals(expected) ){
            System.out.println("Title Verification PASSED");
        } else {
            System.out.println("Title Verification FAILED");
        }

    }
}



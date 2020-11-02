package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Facebook title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify title:
Expected: “Facebook - Log In or Sign Up”

 */
public class Task01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expected = "Facebook - Log In or Sign Up";
        String actual = driver.getTitle();

        if (actual.equalsIgnoreCase(expected)){
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }
    }
}

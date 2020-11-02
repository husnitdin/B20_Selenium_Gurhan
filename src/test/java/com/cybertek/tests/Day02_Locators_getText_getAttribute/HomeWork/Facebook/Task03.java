package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Facebook header verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify header text is as expected:
Expected: “Connect with friends and the world around you on Facebook.”
 */
public class Task03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String actual = driver.findElement(By.className("_8eso")).getText();
        String expected = "Connect with friends and the world around you on Facebook.";

        if (actual.equalsIgnoreCase(expected)){
            System.out.println("Header verification passed");
        } else {
            System.out.println("Header verification failed");
        }

    }
}

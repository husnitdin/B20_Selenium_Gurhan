package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Facebook incorrect login title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Enter incorrect username
        4. Enter incorrect password
        5. Verify title changed to:
Expected: “Log into Facebook | Facebook”
 */
public class Task02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("marcus@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("2837492"+ Keys.ENTER);
        Thread.sleep(5000);

        String expected = "Log into Facebook | Facebook";
        String actual = driver.getTitle();

        if (actual.equals(expected)){
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }

    }
}

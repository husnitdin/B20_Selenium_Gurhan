package com.cybertek.tests.Day02_Locators_getText_getAttribute;

/* #3: Back and forth navigation
        1-Open a chrome browser
        2-Go to: https://google.com
        3-Click to Gmail from top right.
        4-Verify title contains:Expected: Gmail
        5-Go back to Google by using the .back();
        6-Verify title equals: Expected: Google
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationsAndTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://google.com");
        driver.findElement(By.linkText("Gmail")).click();

        if (driver.getTitle().contains("Gmail")){
            System.out.println("Gmail title verification Passed!");
            Thread.sleep(3000);
            driver.navigate().back();

            if (driver.getTitle().equals("Google")){
                System.out.println("Google title verification Passed!");
            } else {
                driver.close();
            }
        } else {
            System.out.println("Gmail not found");
        }
    }
}

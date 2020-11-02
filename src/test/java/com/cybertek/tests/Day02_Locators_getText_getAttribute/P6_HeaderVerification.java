package com.cybertek.tests.Day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #6: Zero Bank header verification

1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify header textExpected: “Log in to ZeroBank”
 */
public class P6_HeaderVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        //WebElement header = driver.findElement(By.tagName("h3"));
        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Log in to ZeroBank";

        if (actualText.equalsIgnoreCase(expectedText)){
            System.out.println("Header veriffication PASSED");
        } else {
            System.out.println("Header veriffication FAILED");
        }
    }

}

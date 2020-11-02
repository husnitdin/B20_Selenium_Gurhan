package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.ZeroBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Zero Bank link text verification
            1. Open Chrome browser
            2. Go to http://zero.webappsecurity.com/login.html
            3. Verify link text from top left:
            Expected: “Zero Bank”
            4. Verify link href attribute value contains:
            Expected: “index.html”
 */
public class Task02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement zeroBankLinkTopLeft =  driver.findElement(By.className("brand"));

        String actualLinkText   = zeroBankLinkTopLeft.getText();
        String expectedLinkText = "Zero Bank";

        if ( actualLinkText.equals(expectedLinkText) ){
            System.out.println("Link Text Verification PASSED");
        } else {
            System.out.println("Link Text Verification FAILED");
        }

        String actualLinkHref = driver.findElement(By.className("brand")).getAttribute("href");
        String expectedLinkHref = "index.html";

        if ( actualLinkHref.contains(expectedLinkHref) ){
            System.out.println("Href value verification PASSED");
        } else {
            System.out.println("Href value verification FAILED");
        }

    }
}

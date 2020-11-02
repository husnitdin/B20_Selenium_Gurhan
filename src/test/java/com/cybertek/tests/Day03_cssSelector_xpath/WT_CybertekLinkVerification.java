package com.cybertek.tests.Day03_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {
    public static void main(String[] args) throws InterruptedException {
        /*TC #3: PracticeCybertek/ForgotPassword URL verification
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/forgot_password
        3.Enter any email into input box
        4.Click on Retrieve password
        5.Verify URL contains: Expected: “email_sent”
        6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!” */

        WebDriver driver  = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("marcus@yahoo.com");

        driver.findElement(By.id("form_submit")).click();

        String expectedURL = "email_sent";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("1st verification passed");
        } else {
            System.out.println("1st verification failed");
        }

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();

        if (actual.equals(expected)){
            System.out.println("2nd verification passed");
        } else {
            System.out.println("2nd verification failed");
        }
    }
}

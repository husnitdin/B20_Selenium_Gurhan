package com.cybertek.tests.Day04;
/*
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.

 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HM_P1 {
    public static void main(String[] args) {
        WebDriver driver  = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //boolean boolHome = driver.findElement(By.xpath("//a[@class='nav-link']")).isDisplayed();
        WebElement boolHome = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement boolFP = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement boolemail = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement boolemailIn = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement boolPassButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement boolPowerBY = driver.findElement(By.xpath("//a[.='Cybertek School']/.."));

        if (boolHome.isDisplayed() && boolFP.isDisplayed() && boolemail.isDisplayed()
         && boolemailIn.isDisplayed() && boolPassButton.isDisplayed() && boolPowerBY.isDisplayed()){
            System.out.println("All buttons are displayed. PASS!");
        } else {
            System.out.println("One or more buttons are not displayed. FAIL!");
        }

    }
}

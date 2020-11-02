package com.cybertek.tests.Day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class P2_GoogleTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        /* #2:	Cybertek	verifications
            1.Open	Chrome	browser
            2.Go	to	https://practice.cybertekschool.com
            3.Verify	URL	containsExpected:	cybertekschool
         */

        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cybertekschool.com");
        String expected = driver.getCurrentUrl();
        String str = "cybertekschool";

        if (expected.contains(str)){
            System.out.println("Passed "+ "\nLink: "+expected+"\nValue: "+str);
        } else{
            System.out.println("Failed "+ "\nLink: "+expected+"\nValue: "+str);
        }

        // 4.Verify	title:	Expected:	Practice

        if(driver.getTitle().equalsIgnoreCase("Practice")){
            System.out.println("Title verification passed ");
        } else {
            System.out.println("Title verification failed ");
        }

    }
}

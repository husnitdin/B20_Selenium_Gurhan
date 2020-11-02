package com.cybertek.tests.Day02_Locators_getText_getAttribute.HomeWork.Facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4: Facebook header verification
1. Open Chrome browser
2. Go to https://www.facebook.com
3. Verify “Create a page” link href value contains text:
Expected: “registration_form”
 */
public class Task04 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String actrualhref = driver.findElement(By.linkText("Create a Page")).getAttribute("href");
        String expectedhref="registration_form";

        if(actrualhref.contains(expectedhref)){
            System.out.println("Attribute value verification PASSED!");
        }else {
            System.out.println("Attribute value verification FAILED!!!");
        }

        System.out.println("expectedhref = " + expectedhref);

    }
}

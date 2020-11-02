package com.cybertek.tests.Day04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

/*
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/forgot_password
    3.Print out the texts of all links
    4.Print out how many total link
 */
public class P0_FindElements_ForgotPassword {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int count = 1;
        for (WebElement eachLink: listOfLinks){
            System.out.println(count +" - "+eachLink.getText());
            count++;
        }
           System.out.println("Number of links = "+listOfLinks.size());
    }
}

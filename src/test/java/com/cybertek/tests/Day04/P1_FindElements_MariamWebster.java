package com.cybertek.tests.Day04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
    1.Open Chrome browser
    2.Go to https://www.merriam-webster.com/
    3.Print out the texts of all links
    4.Print out how many link is missing text
    5.Print out how many link has text
    6.Print out how many total link
 */
public class P1_FindElements_MariamWebster {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWithText = 0;
        for (WebElement eachlink: listOfLinks){

            System.out.println(eachlink.getText());
            if(eachlink.getText().isEmpty()){
                linksWithoutText++;
            } else {
                linksWithText++;
            }
        }

        System.out.println("========================");

        System.out.println("Number of links without text "+linksWithoutText);
        System.out.println("Number of links with text "+linksWithText);
        System.out.println("Total number of links "+listOfLinks.size());

    }
}

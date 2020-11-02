package com.cybertek.tests.Day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        // write apple in search box
        // click google search button
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        //verify title
        //Expected : title should start with "apple word"
        String expectedTitle = "apple - Google Search";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Search title verification passed");
        } else {
            System.out.println("Search title verification failed");
        }
    }
}

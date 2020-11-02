package com.cybertek.tests.Day01_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        // 1 set up web driver
        WebDriverManager.chromedriver().setup();

        // 2 create instance of Chrome drdiver
        WebDriver driver = new ChromeDriver();

        // 3 test if driver working
        driver.get("https://www.facebook.com");

    }
}

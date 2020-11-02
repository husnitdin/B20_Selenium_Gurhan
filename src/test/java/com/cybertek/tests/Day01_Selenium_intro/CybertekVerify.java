package com.cybertek.tests.Day01_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekVerify {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://cybertekschool.okta.com");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("okta-signin-username"));
        WebElement password = driver.findElement(By.id("okta-signin-password"));

        email.sendKeys("husnitdin@gmail.com");
        password.sendKeys("Axmatboy123");

        WebElement login = driver.findElement(By.id("okta-signin-submit"));
        login.click();

        login.click();


    }
}

package com.cybertek.tests.Day09_Windows_Tabs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class P06_handleMore2Windows {

    //1.	Create new test and make set ups
    //2.	Go to : https://www.amazon.com
    //3.	Copy paste the lines from below into your class
    //4.	Create a logic to switch to the tab where Etsy.com is open
    //5.	Assert: Title contains “Etsy”
    //
    //Lines to be pasted:
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    //
    //These lines will simple open new tabs using something called JavaScriptExecut and get those pages.
    // We will learn JavaScriptExecutor later as well.

    WebDriver driver;

    @BeforeMethod
    public void setUps(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void windowHandleP06(){

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current page => "+ driver.getTitle());

            if (driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }
    }
}

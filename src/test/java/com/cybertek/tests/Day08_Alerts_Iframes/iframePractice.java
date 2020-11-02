package com.cybertek.tests.Day08_Alerts_Iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframePractice {

   /* TC #4 :
        1. Create new test and make set ups
        2. Go to: http://practice.cybertekschool.com/iframe
        3. Assert: “Your content goes here.” Text is displayed.
        4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
    */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void P04_iframe_practice(){
    /*
       WebElement content = driver.findElement(By.xpath("//body//p[.='Your content goes here.']"));
        String str = content.getText();
        System.out.println(str);

        // throws NoSuchElementException
    */

        // 3 ways of iframe locating
        // 1. byIndex
           driver.switchTo().frame(0);

        // 2. by Id or Name; passing id attribute value
           driver.switchTo().frame("mce_0_ifr");

        // 3. locate as a web element, then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement content = driver.findElement(By.xpath("//body//p[.='Your content goes here.']"));

        //  3. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(content.isDisplayed(),"Text is not displayed. Verification Failed!");

        // 4. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed(),"Text is not displayed. Verification Failed!");

    }
}

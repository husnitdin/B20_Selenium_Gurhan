package com.cybertek.tests.Day08_Alerts_Iframes;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class AlertPractices {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void P01_information_Alert(){
        /*TC #1:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Alert” button
            4. Click to OK button from the alert
            5. Verify “You successfully clicked an alert” text is displayed.
        */

        WebElement warningAlertButton = driver.findElement(By.xpath("//body//button[@onclick=\"jsAlert()\"]"));
                                    //        driver.findElement(By.xpath("//button[.='Click for JS Alert']"));     // getting from text
        warningAlertButton.click();

        BrowserUtils.wait(2);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultTest = driver.findElement(By.xpath("//body//p[@id='result']"));

        Assert.assertTrue(resultTest.isDisplayed(), "Success message is not displayed. Verification FAILED");
    }

    @Test
    public void P02_confirmation_Alert(){

        /* TC #2:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Confirm” button
            4. Click to OK button from the alert
            5. Verify “You clicked: Ok” text is displayed.
         */
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        warningAlertButton.click();

        BrowserUtils.wait(2);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement resultTest = driver.findElement(By.xpath("//body//p[@id='result']"));

        Assert.assertTrue(resultTest.isDisplayed(), "Success message is not displayed. Verification FAILED");
    }

    @Test
    public void P03_prompt_Alert(){

        /* TC #3:
            2. Go to website: http://practice.cybertekschool.com/javascript_alerts
            3. Click to “Click for JS Prompt” button
            4. Send “hello” text to alert
            5. Click to OK button from the alert
            6. Verify “You entered: hello” text is displayed.
         */

        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        warningAlertButton.click();

        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();

        WebElement resultTest = driver.findElement(By.xpath("//body//p[@id='result']"));

        Assert.assertTrue(resultTest.isDisplayed(), "Success message is not displayed. Verification FAILED");
    }
}



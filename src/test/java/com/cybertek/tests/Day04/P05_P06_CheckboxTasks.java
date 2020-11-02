package com.cybertek.tests.Day04;

import com.cybertek.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import com.sun.tools.javac.comp.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P05_P06_CheckboxTasks {

    //TC #3: SeleniumEasy Checkbox Verification – Section 2
    //1. Open Chrome browser
    //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    //3. Verify “Check All” button text is “Check All”
    //4. Click to “Check All” button
    //5. Verify all check boxes are checked
    //6. Verify button text changed to “Uncheck All”

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void checkBoxVerify2Test1(){
        //  Verify “Check All” button text is “Check All”
            String expectedcheckAll = "Check All";
            String actualCheckAll = driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value");
            Assert.assertEquals(actualCheckAll, expectedcheckAll,"Check all not matched");
            System.out.println("Check all matched");

        // Click to “Check All” button
        driver.findElement(By.xpath("//input[@value='Check All']")).click();
        System.out.println("Check all hit");

        // Verify all check boxes are checked
        List<WebElement> listOfCheckboxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement eachCheckBox: listOfCheckboxes){
            Assert.assertTrue(eachCheckBox.isSelected(), "one of the checkboxes is not checked");
        }
        System.out.println("All checkboxes checked");

        // Verify button text changed to “Uncheck All”
        String expectedUncheckAll = "Uncheck All";
        String actualUnCheckAll = driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value");
        Assert.assertEquals(expectedUncheckAll, actualUnCheckAll,"Uncheck all not matched");
        System.out.println("Uncheck all matched");
    }
}

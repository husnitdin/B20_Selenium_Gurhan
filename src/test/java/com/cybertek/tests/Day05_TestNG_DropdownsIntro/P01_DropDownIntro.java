package com.cybertek.tests.Day05_TestNG_DropdownsIntro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P01_DropDownIntro {

    // TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        // 3.Verify “Simple dropdown” default selected value is correct
        //   Expected: “Please select an option”
        //   locate dropdown and pass it to the select Constructor

        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));

        String actualSelectedOption = simpleDropDown.getFirstSelectedOption().getText();    // returns web element
        String expectedSelectedOption = "Please select an option";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption, "default value is not matching");

        Thread.sleep(3000);
        simpleDropDown.selectByVisibleText("Option 2");

        // 4.Verify “State selection” default selected value is correct
        //   Expected: “Select a State”
        Select stateSelected = new Select(driver.findElement(By.id("state")));
        String actualStateSelected = stateSelected.getFirstSelectedOption().getText();
        String expectedStateSelected = "Select a State";
        Assert.assertEquals(actualStateSelected, expectedStateSelected, "default state value is not matching");
    }
}
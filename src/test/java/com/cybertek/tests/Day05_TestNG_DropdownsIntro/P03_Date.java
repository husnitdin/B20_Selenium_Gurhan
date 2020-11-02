package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P03_Date {
    //TC #3: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select “December 1st , 1921” and verify it is selected.
    //   Select year using      : visible text
    //   Select month using     : value attribute
    //   Select day using       : index number

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void verifyDate(){

        Select selectYear = new Select(driver.findElement(By.xpath("//body//select[@id='year']")));
        Select selectMonth = new Select(driver.findElement(By.xpath("//body//select[@id='month']")));
        Select selectDate = new Select(driver.findElement(By.xpath("//body//select[@id='day']")));

        selectYear.selectByVisibleText("1921");
        selectMonth.selectByValue("11");
        selectDate.selectByIndex(0);

        String expYear = "1921";
        String expMonth = "December";
        String expDate = "1";

        String actYear = selectYear.getFirstSelectedOption().getText();
        String actMonth = selectMonth.getFirstSelectedOption().getText();
        String actDate = selectDate.getFirstSelectedOption().getText();

        Assert.assertEquals(actYear, expYear, "expected year not matched");
        Assert.assertEquals(actMonth, expMonth, "expected month not matched");
        Assert.assertTrue(actDate.equals( expDate ), "expected day not matched");
    }
}

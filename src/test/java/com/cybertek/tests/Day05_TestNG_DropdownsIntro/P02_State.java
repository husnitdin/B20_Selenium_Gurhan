package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P02_State {

    //    TC #2: Selecting state from State dropdown and verifying result
    //    1. Open Chrome browser
    //    2. Go to http://practice.cybertekschool.com/dropdown
    //    3. Select Illinois
    //    4. Select Virginia
    //    5. Select California
    //    6. Verify final selected option is California.
    //    Use all Select options. (visible text, value, index)

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void testStateDropdown() throws InterruptedException{
        Select selectStates = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(1000);
        selectStates.selectByVisibleText("Illinois");

        Thread.sleep(1000);
        selectStates.selectByValue("VA");

        Thread.sleep(1000);
        selectStates.selectByValue("CA");

        String actFinSelState = selectStates.getFirstSelectedOption().getText();
        String expFinSelState = "California";
        Assert.assertEquals(actFinSelState, expFinSelState, "expected state name not found");

    }
}

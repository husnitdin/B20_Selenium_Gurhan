package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P05_Non_SelectDropDown {
    // TC #5: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void nonSelect() {

        WebElement linkDropDown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        linkDropDown.click();

        driver.findElement(By.xpath("//a[.='Facebook']")).click();

        String expTitle = "Facebook - Log In or Sign Up";
        String actTitle = driver.getTitle();

        Assert.assertEquals(actTitle, expTitle, "titles not matched");
    }
}

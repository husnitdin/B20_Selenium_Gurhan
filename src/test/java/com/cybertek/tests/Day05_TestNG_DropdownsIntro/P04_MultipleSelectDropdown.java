package com.cybertek.tests.Day05_TestNG_DropdownsIntro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class P04_MultipleSelectDropdown {

    // TC #4: Selecting value from multiple select dropdown
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/dropdown
    // 3. Select all the options from multiple select dropdown.
    // 4. Print out all selected values.
    // 5. Deselect all values.

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyMultiSelect() throws InterruptedException {

       Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

       List<WebElement> allOptions  = multipleSelectDropdown.getOptions();

       for (WebElement eachOption: allOptions){
           Thread.sleep(500);
            eachOption.click();
           System.out.println("Selected "+ eachOption.getText());
           Assert.assertTrue(eachOption.isSelected(), "The option "+eachOption+" is not selected");
        }

        multipleSelectDropdown.deselectAll();
    }

}

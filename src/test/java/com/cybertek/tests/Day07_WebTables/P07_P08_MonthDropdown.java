package com.cybertek.tests.Day07_WebTables;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class P07_P08_MonthDropdown {
    // 1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/dropdown/
    //3. Verify default value is always showing the current month
    //o Expected: If currently in June, should show June selected.
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void monthDropDown(){

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String currentDate  = date.format(formatter);

        Select month =  new Select (driver.findElement(By.xpath("//body//select[@id='month']")));

       /*if ( currentDate.contains( month.getFirstSelectedOption().getText()) ){
           System.out.println("default value matched with current month");
        } else {
           System.out.println("default value NOT matched with current month");
       }*/

       // Expected
       String expectedValue = LocalDateTime.now().getMonth().name();

       // Actual
       String actualValue = month.getFirstSelectedOption().getText();

        // Assert
        // just to be safe making them lower case
        Assert.assertEquals(actualValue.toLowerCase(), expectedValue.toLowerCase());

        // second way of comparing actual and expected
        Assert.assertTrue(actualValue.equalsIgnoreCase( expectedValue) );

        // 1. Do both verifications in the same test
        // 2. Verify list of months are correct as expected.
        // 3. Expected: Options should contain all 12 months of the year

        // get all options and store them in a list
        List<WebElement> actualMonthOptions = month.getOptions();
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                                                          "August", "September", "October", "November", "December");

        // create a new list of strings and store the texts of web elements into it
            /*List<String> actualMonthTexts = new ArrayList<>();

            for (WebElement each : actualMonthOptions) {
                    actualMonthTexts.add(each.getText());
            }*/

        // passing lists to Assertions, first check size then the content
        Assert.assertEquals( BrowserUtils.getElementsText(actualMonthOptions), expectedMonthOptions);
    }
}

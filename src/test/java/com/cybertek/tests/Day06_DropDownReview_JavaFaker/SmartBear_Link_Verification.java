package com.cybertek.tests.Day06_DropDownReview_JavaFaker;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear_Link_Verification {
//    TC #1: Smartbear software link verification
//    1. Open browser
//    2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//    3. Enter username: “Tester”
//    4. Enter password: “test”
//    5. Click to Login button
//    6. Print out count of all the links on landing page
//    7. Print out each link text on this page

    WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void linkVerification(){

        SmartBearUtilities.loginToSmartBear(driver);

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of links "+listOfLinks.size());

        for (WebElement eachLink: listOfLinks) {

            if(!eachLink.getText().isEmpty()) {
                System.out.println(eachLink.getText());
            }
        }
    }
}

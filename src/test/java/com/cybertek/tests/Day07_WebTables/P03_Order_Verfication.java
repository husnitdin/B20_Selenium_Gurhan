package com.cybertek.tests.Day07_WebTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P03_Order_Verfication {
    //TC#3: Smartbear software order verification
    //1. Open browser and login to Smartbear software
    //2. Click on View all orders
    //3. Verify Susan McLaren has order on date “01/05/2010”

    WebDriver driver;

       @BeforeMethod
        public void setUpBrowser(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        }

        @Test
        public void orderVerification(){
            SmartBearUtilities.loginToSmartBear(driver);
            driver.findElement(By.xpath("//tbody//a[.='View all orders']")).click();
            WebElement susanDate = driver.findElement(By.xpath("//tbody//td[.='Susan McLaren']/following-sibling::td[3]"));

            String actDate = susanDate.getText();
            String expDate = "01/05/2010";

            /*if (actDate.equals(expDate)){
                System.out.println("pass");
            } else {
                System.out.println("fail");
            }*/

            Assert.assertEquals(actDate, expDate,"dates not matchhed");

        }
        

    }


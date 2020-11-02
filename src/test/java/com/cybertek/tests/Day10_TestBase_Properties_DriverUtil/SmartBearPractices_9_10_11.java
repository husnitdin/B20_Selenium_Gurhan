package com.cybertek.tests.Day10_TestBase_Properties_DriverUtil;
import com.cybertek.tests.Base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase {

    @Test
    public void p9_delete_order_task() throws IOException {

            // TC #9: SmartBear delete order
            //1. Open browser and login to SmartBear 2. Delete “Mark Smith” from the list
            //3. Assert it is deleted from the list

            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            String url = properties.getProperty("smartBearURL"); //--> returns url from configuration

            driver.get(url);
            SmartBearUtilities.loginToSmartBear(driver);

            BrowserUtils.wait(2);

            WebElement MarkSmithCheckBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
            MarkSmithCheckBox.click();

            WebElement deleteButton = driver.findElement(By.xpath("//body//input[@id='ctl00_MainContent_btnDelete']"));
            deleteButton.click();

            List <WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

            for (WebElement each : nameList) {
                Assert.assertFalse(each.getText().equals("Mark Smith"));
            }
        }

    @Test
    public void p10_delete_order_task(){

        // 1. Open browser and login to SmartBear
        // 2. Click to edit button from the right for “Steve Johns”
        // 3. Change name to “Michael Jordan”
        // 4. Click Update
        // 5. Assert “Michael Jordan” is in the list

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

        BrowserUtils.wait(2);

        WebElement editButton = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[13]"));
        editButton.click();

        WebElement editName = driver.findElement(By.xpath("//body//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        for (int i = 0; i < 20; i++) {
            editName.sendKeys(Keys.BACK_SPACE);
        }

        editName.sendKeys("Michael Jordan");


        WebElement updateButton = driver.findElement(By.xpath("//a[@id = 'ctl00_MainContent_fmwOrder_UpdateButton']"));
        updateButton.click();

        List <WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList) {
            if (each.getText().equalsIgnoreCase("Michael Jordan")){
                System.out.println("Matched name found: "+each.getText()+" - "+"Michael Jordan");
            }
        }
    }

    @Test
    public void  deleteMethodCall(){
        String nameEmp = "Samuel Clemens";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        SmartBearUtilities.deleteName_Method( driver, nameEmp);
    }
}

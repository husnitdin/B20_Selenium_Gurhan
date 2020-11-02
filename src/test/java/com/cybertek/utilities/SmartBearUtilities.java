package com.cybertek.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class SmartBearUtilities {

    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter

    public static void loginToSmartBear( WebDriver driver){

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }

    public static void verifyOrder(WebDriver driver, String name){

        /*for (int i = 2; i < 8; i++) {

            String expName = name;
            String actName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]//td[2]")).getText();

            if (expName.equals(actName)){
                System.out.println(actName+" found");
            }
        }*/

        List <WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList) {
            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail("Name "+name+" doesn't exist in the list! Verification FAILED!");
    }

    public static void printNamesAndCities (WebDriver driver){

        List <WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        List <WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for (int i = 0; i < namesList.size(); i++) {
            System.out.println("Name"+(i+1)+": "+namesList.get(i).getText()+", City"+(i+1)+": "+citiesList.get(i).getText());
        }
    }

    public static void deleteName_Method(WebDriver driver, String name){

        // 1. Accepts two parameters: WebDriver, String name
        // 2. Method will remove the given name from the list of Smartbear
        // 3. Create a new TestNG test, and call your method.
        // 4. Assert that your method removed the given name

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

        BrowserUtils.wait(2);

        WebElement nameSearch = driver.findElement(By.xpath("//td[.='"+name+"']/../td[1]"));
        nameSearch.click();


        WebElement deleteButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']"));
        deleteButton.click();

        List <WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList) {
            if (each.getText().equalsIgnoreCase(name)){
                System.out.println("Matched name found: "+each.getText()+" - "+"Michael Jordan");
            }

        }
    }
}


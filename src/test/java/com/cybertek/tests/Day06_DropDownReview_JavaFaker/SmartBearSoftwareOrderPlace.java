package com.cybertek.tests.Day06_DropDownReview_JavaFaker;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearSoftwareOrderPlace {

    //9. Fill address Info with JavaFaker
    //• Generate: name, street, city, state, zip code
    //10. Click on “visa” radio button
    //11. Generate card number using JavaFaker
    //12. Click on “Process”
    //13.Verify success message “New order has been successfully added.”

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

       //6. Click on Order
       driver.findElement(By.xpath("//body//a[.='Order']")).click();

        //7. Select familyAlbum from product, set quantity to 2
        Select orderDropDown = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        orderDropDown.selectByVisibleText("FamilyAlbum");

        WebElement orderQuan = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        orderQuan.sendKeys(Keys.BACK_SPACE + "2");

        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        WebElement zip = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));

        Faker faker = new Faker();

        customerName.sendKeys(faker.name().firstName());
        street.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());

        zip.sendKeys(faker.address().zipCode().replaceAll("-", ""));

        //10. Click on “visa” radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();

        //11. Generate card number using JavaFaker

        WebElement ccNum = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        ccNum.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement expDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expDate.sendKeys("12/25");

        //12. Click on “Process”
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
        //13.Verify success message “New order has been successfully added.”

        String expresult = "New order has been successfully added.";
        String actResult = driver.findElement(By.xpath("//strong")).getText();

        Assert.assertEquals(actResult, expresult, "New account not created");
    }
}

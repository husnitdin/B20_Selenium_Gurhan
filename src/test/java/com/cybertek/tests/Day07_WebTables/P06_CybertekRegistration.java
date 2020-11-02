package com.cybertek.tests.Day07_WebTables;
import com.cybertek.utilities.BirthdayFormat;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class P06_CybertekRegistration {
    // TC#6: Cybertek registration form confirmation Note: Use JavaFaker when possible.
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/registration_form
    //3. Enter first name
    //4. Enter last name
    //5. Enter username
    //6. Enter email address
    //7. Enter password
    //8. Enter phone number
    //9. Select a gender from radio buttons
    //10. Enter date of birth
    //11. Select Department/Office
    //12. Select Job Title
    //13. Select programming language from checkboxes
    //14. Click to sign up button
    //15.Verify success message “You’ve successfully completed registration.” is
    //displayed.
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");
    }

    @Test
    public void cybertekRegistForm() throws InterruptedException {
        Faker faker =  new Faker();

        WebElement fname = driver.findElement(By.xpath("//body//input[@name='firstname']"));
        String firstname = faker.name().firstName();
        fname.sendKeys( firstname );

        WebElement lname = driver.findElement(By.xpath("//body//input[@name='lastname']"));
        String lastname = faker.name().lastName();
        lname.sendKeys( lastname );

        WebElement password = driver.findElement(By.xpath("//body//input[@name='password']"));
        password.sendKeys( faker.internet().password());

        WebElement username = driver.findElement(By.xpath("//body//input[@name='username']"));
        username.sendKeys( firstname+""+lastname.toLowerCase() );

        WebElement email = driver.findElement(By.xpath("//body//input[@name='email']"));
        email.sendKeys( faker.internet().emailAddress() );

        WebElement phnum = driver.findElement(By.xpath("//body//input[@name='phone']"));
        phnum.sendKeys( "500-400-1020" );

        if(firstname.endsWith("a") || firstname.endsWith("e")){
            driver.findElement(By.xpath("//body//input[@value='female']")).click();
        } else {
            driver.findElement(By.xpath("//body//input[@value='male']")).click();
        }

        WebElement dob = driver.findElement(By.xpath("//body//input[@name='birthday']"));
        dob.sendKeys(BirthdayFormat.bDay() );

        Select dept = new Select(driver.findElement(By.xpath("//body//select[@name='department']")));
        dept.selectByValue("DE");

        Select jobType = new Select(driver.findElement(By.xpath("//body//select[@name='job_title']")));
        jobType.selectByVisibleText("SDET");

        WebElement lang = driver.findElement(By.xpath("//body//input[@id='inlineCheckbox2']"));
        lang.click();

        WebElement signUp = driver.findElement(By.xpath("//body//button[@id='wooden_spoon']"));
        signUp.click();

        Thread.sleep(3000);

        WebElement completed  = driver.findElement( By.xpath("//body//div[@class='alert alert-success']/p") );

        Assert.assertTrue(completed.isDisplayed(),"not registered");

        /*if(completed.isDisplayed()) {
            System.out.println("Registration was successful");
        } else {
            System.out.println("Registration was NOT successful");
        }*/
    }
}



















package com.cybertek.tests.Day04;

    //TC #02: FINDELEMENTS_APPLE

    //1. Open Chrome browser
    //2. Go to https://www.apple.com
    //3. Click to iPhone
    //4. Print out the texts of all links
    //5. Print out how many link is missing text
    //6. Print out how many link has text
    //7. Print out how many total link

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_APPLE_FIndElement {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.get("https://www.apple.com");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void findElementApple(){

        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWithText = 0;

        for (WebElement eachLink: listOfLinks){
            //4. Print out the texts of all links
            System.out.println(eachLink.getText());

            if (eachLink.getText().isEmpty()){
                linksWithoutText++;
            } else {
                linksWithText++;
            }
        }

        //5. Print out how many link is missing text
        System.out.println("Links without text "+ linksWithoutText);

        //6. Print out how many link has text
        System.out.println("Links with text "+ linksWithText);

        //7. Print out how many total link
        System.out.println("Total number of links "+ listOfLinks.size());
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }
}

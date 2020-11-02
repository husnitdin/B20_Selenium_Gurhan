package com.cybertek.tests.Day04;

    //TC #03: FINDELEMENTS_APPLE

    //1. Open Chrome browser
    //2. Go to https://www.apple.com
    //3. Click to all of the headers one by one
    //a. Mac, iPad, iPhone, Watch, TV, Music, Support
    //4. Print out how many links on each page with the titles of the pages
    //5. Loop through all
    //6. Print out how many link is missing text TOTAL
    //7. Print out how many link has text TOTAL
    //8. Print out how many total link TOTAL

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_APPLE_FIndElements {

        WebDriver driver;


        @BeforeMethod
        public void setUpMethod(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("https://www.apple.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

            @Test
            public void findElement() throws InterruptedException {

            driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']")).click();
            List<WebElement> MacLinks = driver.findElements(By.xpath("//body//a"));

            int linksWithoutTextMac = 0;
            int linksWithTextMac = 0;
            for (WebElement eachLink: MacLinks){
                if (eachLink.getText().isEmpty()){
                    linksWithoutTextMac++;
                } else {
                    linksWithTextMac++;
                }
            }
                Thread.sleep(3000);
                driver.navigate().back();

            driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']")).click();
            List<WebElement> iPadLinks = driver.findElements(By.xpath("//body//a"));

            int linksWithoutTextiPad = 0;
            int linksWithTextiPad = 0;
            for (WebElement eachLink: iPadLinks){
                if (eachLink.getText().isEmpty()){
                    linksWithoutTextiPad++;
                } else {
                    linksWithTextiPad++;
                }
            }
                Thread.sleep(3000);
                driver.navigate().back();

            driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
            List<WebElement> iPhoneLinks = driver.findElements(By.xpath("//body//a"));

            int linksWithoutTextiphone = 0;
            int linksWithTextiphone = 0;
            for (WebElement eachLink: iPhoneLinks){
                if (eachLink.getText().isEmpty()){
                    linksWithoutTextiphone++;
                } else {
                    linksWithTextiphone++;
                }
            }
                Thread.sleep(3000);
                driver.navigate().back();

            driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']")).click();
            List<WebElement> WatchLinks = driver.findElements(By.xpath("//body//a"));

            int linksWithoutTextWatch = 0;
            int linksWithTextWatch = 0;

            for (WebElement eachLink: WatchLinks){
                if (eachLink.getText().isEmpty()){
                    linksWithoutTextWatch++;
                } else {
                    linksWithTextWatch++;
                }
            }
                Thread.sleep(3000);
                driver.navigate().back();

            driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']")).click();
            List<WebElement> TVLinks = driver.findElements(By.xpath("//body//a"));

            int linksWithoutTextTV = 0;
            int linksWithTextTV = 0;
            for (WebElement eachLink: TVLinks){
                if (eachLink.getText().isEmpty()){
                    linksWithoutTextTV++;
                } else {
                    linksWithTextTV++;
                }
            }
                Thread.sleep(3000);
                driver.navigate().back();

            int linksWithoutText = linksWithoutTextMac + linksWithoutTextiPad + linksWithoutTextiphone + linksWithoutTextWatch + linksWithoutTextTV;
            int linksWithText = linksWithTextMac + linksWithTextiPad + linksWithTextiphone + linksWithTextWatch + linksWithTextTV;

            System.out.println("Links without text "+(linksWithoutText) );
            System.out.println("Links with text "+linksWithText);
            System.out.println("Total links "+(linksWithoutText+linksWithText));
        }
    }


package com.cybertek.tests.Day04;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/add_remove_elements/
    3. Click to “Add Element” button 50 times
    4. Verify 50 “Delete” button is displayed after clicking.
    5. Click to ALL “Delete” buttons to delete them.
    6. Verify “Delete” button is NOT displayed after clicking.
 */
public class HM_P3_Delete50_FindElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("//body//div/button[1]"));

        for (int i = 0; i < 50; i++) {
            addElement.click();
        }

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//body//button[.='Delete']"));

        if (deleteButtons.size() == 50){
            System.out.println("Verification passed "+deleteButtons.size()+ " delete buttons are displayed");
        } else {
            System.out.println("Verification failed "+deleteButtons.size() + " delete buttons are displayed");
        }

        for (WebElement eachDelete: deleteButtons){
            eachDelete.click();
        }

        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        try {if (!deleteButton.isDisplayed()) {
            System.out.println("Delete button is NOT displayed after clicking. PASS!");
        }else{
            System.out.println("Delete button is displayed after clicking. FAILED!");
        }

        }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");       }

    }
}

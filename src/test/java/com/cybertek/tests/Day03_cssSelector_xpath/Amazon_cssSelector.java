package com.cybertek.tests.Day03_cssSelector_xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    TC #3: Amazon link number verification
    1. Open Chrome browser
    2. Go to https://www.amazon.com
    3. Enter search term (use cssSelectorto locate search box)
    4. Verify title contains search term
 */

public class Amazon_cssSelector {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        // WebElement searchbox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchbox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchbox.sendKeys("apple watch"+ Keys.ENTER);

        String expected = "apple watch";
        String actual = driver.getTitle();

        if (actual.contains(expected)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }
    }
}

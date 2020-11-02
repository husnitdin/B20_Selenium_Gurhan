package com.cybertek.tests.Day12_JavScrExecuter_POM;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class JSExecutpor_Practices {

    @Test
    public void scroll_using_JSEx1(){
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        // create instance of JSExecutor and cast our driver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        // just scrolling the page
        js.executeScript("window.scrollBy(0, 500)");
                // here 0   -> moves vertically   (arrow X)
                // here 500 -> moves horizontally (arrow Y)

        // if want to scroll more than once use loop
            /*for (int i = 1; i < 5; i++) {
                BrowserUtils.wait(1);
                js.executeScript("window.scrollBy(0, 2000)");
            }*/
    }

    @Test
    public void scroll_using_JSEx2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        // locate CyberTek School Link
        WebElement link = Driver.getDriver().findElement( By.linkText("Cybertek School") );

        // use JSExecutor to scroll Cybertek School link intoView
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // use scrollIntoView function from Javascript scroll to a specific web element
        // arguments[0].scrollIntoView(true) -> JavaScript Code
        js.executeScript("arguments[0].scrollIntoView(true)", link);

    }
}

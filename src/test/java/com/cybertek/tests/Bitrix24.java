package com.cybertek.tests;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Bitrix24 {
    @Test
    public void visual_editor(){

        Driver.getDriver().get("https://login2.nextbasecrm.com/");
        Driver.getDriver().manage().window().maximize();

        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement submit = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));

        login.sendKeys("marketing27@cybertekschool.com");
        password.sendKeys("UserUser");
        submit.click();

        WebElement message = Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']/span"));
        message.click();

        BrowserUtils.wait(3);

        WebElement visEdit = Driver.getDriver().findElement(By.xpath("//span[@title='Visual editor']"));
        visEdit.click();

        BrowserUtils.wait(2);
        WebElement editor_text_bar = Driver.getDriver().findElement(By.xpath("//div[@id='bx-html-editor-tlbr-idPostFormLHE_blogPostForm']"));

        Assert.assertTrue(editor_text_bar.isDisplayed(), "Editor Text Bar is not displayed");

    }
}

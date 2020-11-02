package com.cybertek.pages;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DynamicLoadPage {

    public DynamicLoadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//strong[.='Done!']")
    public WebElement doneMessage;

    @FindBy (xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy (xpath = "//div[.='Loading... ']")
    public WebElement loading;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='pwd']")
    public WebElement password;

    @FindBy (xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//div[@class='flash error']")
    public WebElement wrongUsername;
}


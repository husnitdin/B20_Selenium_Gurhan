package com.cybertek.pages;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class VyTrackLoginPage {
    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="prependedInput")
    public WebElement username;

    @FindBy (id="prependedInput2")
    public WebElement password;

    @FindBy (id="_submit")
    public WebElement loginButton;

    @FindBy (xpath="//div[.='Invalid user name or password.']")
    public WebElement errorMessage;

    @FindBy (xpath="//a[@class='app-logo']")
    public WebElement loginLogo;


    @FindBy (xpath="//button[@class='btn extra-submit btn-uppercase btn-primary']")
    public WebElement requestButton;

    @FindBy (xpath="//div[@class='alert alert-error']")
    public WebElement FPErrorMessage;

    @FindBy (xpath="//a[.='Forgot your password?']")
    public WebElement forgotPassword;

}

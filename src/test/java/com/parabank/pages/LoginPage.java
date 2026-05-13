package com.parabank.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement btnLogin;

    @FindBy(linkText = "Register")
    WebElement linkRegister;

    public void goTo() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public void login(String user, String pass) {
        // Using the wrappers from BasePage
        sendKeys(txtUsername, user);
        sendKeys(txtPassword, pass);
        click(btnLogin);
    }


}

package com.parabank.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
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
        txtUsername.sendKeys(user);
        txtPassword.sendKeys(pass);
        btnLogin.click();
    }

    public void clickRegister() {
        linkRegister.click();
    }

    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }


    public void clickLogin() {
        btnLogin.click();
    }
}

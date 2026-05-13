package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "customer.firstName")
    WebElement txtFirstName;

    @FindBy(name = "customer.lastName")
    WebElement txtLastName;

    @FindBy(name = "customer.address.street")
    WebElement txtAddress;

    @FindBy(name = "customer.address.city")
    WebElement txtCity;

    @FindBy(name = "customer.address.state")
    WebElement txtState;

    @FindBy(name = "customer.address.zipCode")
    WebElement txtZipCode;

    @FindBy(name = "customer.phoneNumber")
    WebElement txtPhone;

    @FindBy(name = "customer.ssn")
    WebElement txtSSN;

    @FindBy(name = "customer.username")
    WebElement txtUsername;

    @FindBy(name = "customer.password")
    WebElement txtPassword;

    @FindBy(name = "repeatedPassword")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement btnRegister;

    public void register(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtAddress.sendKeys(address);
        txtCity.sendKeys(city);
        txtState.sendKeys(state);
        txtZipCode.sendKeys(zipCode);
        txtPhone.sendKeys(phone);
        txtSSN.sendKeys(ssn);
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(confirmPassword);
        btnRegister.click();
    }
}

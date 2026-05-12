package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
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

    public void enterFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void enterCity(String city) {
        txtCity.sendKeys(city);
    }

    public void enterState(String state) {
        txtState.sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        txtZipCode.sendKeys(zipCode);
    }

    public void enterPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void enterSSN(String ssn) {
        txtSSN.sendKeys(ssn);
    }

    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickRegister() {
        btnRegister.click();
    }

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

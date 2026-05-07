package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {
    WebDriver driver;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='payee.name']")
    WebElement txtPayeeName;

    @FindBy(css = "input[name='payee.address.street']")
    WebElement txtPayeeAddress;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    WebElement txtPayeeCity;

    @FindBy(css = "input[name='payee.address.state']")
    WebElement txtPayeeState;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    WebElement txtPayeeZipCode;

    @FindBy(css = "input[name='payee.phoneNumber']")
    WebElement txtPayeePhone;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    WebElement txtPayeeAccount;

    @FindBy(css = "input[name='verifyAccount']")
    WebElement txtVerifyAccount;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement txtAmount;

    @FindBy(css = "select[name='fromAccountId']")
    WebElement selectFromAccount;

    @FindBy(xpath = "//input[@value='Send Payment']")
    WebElement btnSendPayment;

    public void billPay(String payeeName, String address, String city, String state, String zipCode, String phone, String account, String verifyAccount, String amount, String fromAccount) {
        txtPayeeName.sendKeys(payeeName);
        txtPayeeAddress.sendKeys(address);
        txtPayeeCity.sendKeys(city);
        txtPayeeState.sendKeys(state);
        txtPayeeZipCode.sendKeys(zipCode);
        txtPayeePhone.sendKeys(phone);
        txtPayeeAccount.sendKeys(account);
        txtVerifyAccount.sendKeys(verifyAccount);
        txtAmount.sendKeys(amount);
        selectFromAccount.sendKeys(fromAccount);
        btnSendPayment.click();
    }
}

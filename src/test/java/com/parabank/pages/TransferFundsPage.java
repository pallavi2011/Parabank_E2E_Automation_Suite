package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {
    private WebDriver driver;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(id = "toAccountId")
    private WebElement toAccountDropdown;

    @FindBy(xpath = "//input[@value='Transfer']")
    private WebElement transferButton;

    @FindBy(xpath = "//h1[text()='Transfer Complete!']")
    private WebElement transferCompleteMessage;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void selectFromAccount(String accountId) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(accountId);
    }

    public void selectToAccount(String accountId) {
        Select select = new Select(toAccountDropdown);
        select.selectByVisibleText(accountId);
    }

    public void clickTransfer() {
        transferButton.click();
    }

    public boolean isTransferCompleteDisplayed() {
        return transferCompleteMessage.isDisplayed();
    }
}

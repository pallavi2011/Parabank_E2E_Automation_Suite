package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BasePage {
    private WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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


    public TransferFundsPage transferAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
        return this;
    }

    public TransferFundsPage selectFromAccount(String accountId) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(accountId);
        return this;
    }

    public TransferFundsPage selectToAccount(String accountId) {
        Select select = new Select(toAccountDropdown);
        select.selectByVisibleText(accountId);
        return this;
    }

    public TransferFundsPage clickTransfer() {
        transferButton.click();
        return this;
    }

    public boolean isTransferCompleteDisplayed() {

        return waitForCondition(ExpectedConditions.visibilityOf(transferCompleteMessage)).isDisplayed();

    }
}

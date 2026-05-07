package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsPage {
     WebDriver driver;

    @FindBy(id = "criteria.amount")
    private WebElement amountInput;

    @FindBy(id = "criteria.onDate")
    private WebElement onDateInput;

    @FindBy(id = "criteria.fromDate")
    private WebElement fromDateInput;

    @FindBy(id = "criteria.toDate")
    private WebElement toDateInput;

    @FindBy(xpath = "//button[@value='Find Transactions'] | //input[@value='Find Transactions']")
    private WebElement findTransactionsButton;

    @FindBy(xpath = "//table[@id='transactionTable']")
    private WebElement transactionTable;

    public FindTransactionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void enterOnDate(String date) {
        onDateInput.clear();
        onDateInput.sendKeys(date);
    }

    public void enterFromDate(String date) {
        fromDateInput.clear();
        fromDateInput.sendKeys(date);
    }

    public void enterToDate(String date) {
        toDateInput.clear();
        toDateInput.sendKeys(date);
    }

    public void clickFindTransactions() {
        findTransactionsButton.click();
    }

    public boolean isTransactionTableDisplayed() {
        return transactionTable.isDisplayed();
    }
}

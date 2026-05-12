package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage {
    private WebDriver driver;

    @FindBy(id = "amount")
    private WebElement loanAmountInput;

    @FindBy(id = "downPayment")
    private WebElement downPaymentInput;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Apply Now']")
    private WebElement applyNowButton;

    @FindBy(xpath = "//h1[text()='Loan Request Processed']")
    private WebElement loanRequestProcessedHeader;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLoanAmount(String amount) {
        loanAmountInput.clear();
        loanAmountInput.sendKeys(amount);
    }

    public void enterDownPayment(String downPayment) {
        downPaymentInput.clear();
        downPaymentInput.sendKeys(downPayment);
    }

    public void selectFromAccount(String accountId) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(accountId);
    }

    public void clickApplyNow() {
        applyNowButton.click();
    }

    public boolean isLoanRequestProcessedDisplayed() {
        return loanRequestProcessedHeader.isDisplayed();
    }
}

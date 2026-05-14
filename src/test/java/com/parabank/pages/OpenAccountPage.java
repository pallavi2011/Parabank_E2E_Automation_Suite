package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BasePage {
     WebDriver driver;

    @FindBy(id = "type")
    private WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountButton;

    @FindBy(id = "newAccountId")
    private WebElement newAccountIdLink;

    public OpenAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public OpenAccountPage selectAccountType(String accountType) {
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
        return this;
    }


    public OpenAccountPage selectFromAccount(String accountId) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(accountId);
        return this;
    }

    public OpenAccountPage clickOpenNewAccount() {
        openNewAccountButton.click();
        return this;
    }

    public String getNewAccountId() {
        return waitForCondition(ExpectedConditions.visibilityOf(newAccountIdLink)).getText();
    }
}

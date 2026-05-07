package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[text()='Accounts Overview']")
    private WebElement accountsOverviewHeader;

    @FindBy(xpath = "//table[@id='accountTable']")
    private WebElement accountTable;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountsOverviewHeaderDisplayed() {
        return accountsOverviewHeader.isDisplayed();
    }

    public boolean isAccountTableDisplayed() {
        return accountTable.isDisplayed();
    }
}

package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectAccountType(String accountType) {
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
    }


    public void selectFromAccount(String accountId) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(accountId);
    }

    public void clickOpenNewAccount() {
        openNewAccountButton.click();
    }

    public String getNewAccountId() {
        return newAccountIdLink.getText();
    }
}

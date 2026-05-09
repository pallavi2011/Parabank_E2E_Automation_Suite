package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.AccountsOverviewPage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountsOverviewTest extends BaseTest {
    LoginPage loginPage;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        accountsOverviewPage = new AccountsOverviewPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");
    }

    @Test
    public void testAccountsOverviewDisplayed() {
        Assert.assertTrue(accountsOverviewPage.isAccountsOverviewHeaderDisplayed());
        Assert.assertTrue(accountsOverviewPage.isAccountTableDisplayed());
    }
}

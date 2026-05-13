package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.AccountsOverviewPage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountsOverviewTest extends BaseTest {
    LoginPage loginPage;
    AccountsOverviewPage accountsOverviewPage;



    @Test
    public void testAccountsOverviewDisplayed() {
        Assert.assertTrue(accountsOverviewPage.isAccountsOverviewHeaderDisplayed());
        Assert.assertTrue(accountsOverviewPage.isAccountTableDisplayed());
    }
}

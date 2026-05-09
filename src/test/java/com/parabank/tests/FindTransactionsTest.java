package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.FindTransactionsPage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class FindTransactionsTest extends BaseTest {
    LoginPage loginPage;
    FindTransactionsPage findTransactionsPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        findTransactionsPage = new FindTransactionsPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/findtrans.htm");
    }

    @Test
    public void testFindTransactionsByAmount() {
        findTransactionsPage.enterAmount("100");
        findTransactionsPage.clickFindTransactions();
        Assert.assertTrue(findTransactionsPage.isTransactionTableDisplayed());
    }
}

package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.FindTransactionsPage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class FindTransactionsTest extends BaseTest {
    LoginPage loginPage;
    FindTransactionsPage findTransactionsPage;



    @Test
    public void testFindTransactionsByAmount() {
        findTransactionsPage.enterAmount("100");
        findTransactionsPage.clickFindTransactions();
        Assert.assertTrue(findTransactionsPage.isTransactionTableDisplayed());
    }
}

package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TransferFundsTest extends BaseTest {
    LoginPage loginPage;
    TransferFundsPage transferFundsPage;



    @Test
    public void testTransferFunds() {
        transferFundsPage.enterAmount("100");
        transferFundsPage.selectFromAccount("12345678");
        transferFundsPage.selectToAccount("23456789");
        transferFundsPage.clickTransfer();
        Assert.assertTrue(transferFundsPage.isTransferCompleteDisplayed());
    }
}

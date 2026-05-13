package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RequestLoanPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class RequestLoanTest extends BaseTest {
    LoginPage loginPage;
    RequestLoanPage requestLoanPage;



    @Test
    public void testRequestLoan() {
        requestLoanPage.enterLoanAmount("5000");
        requestLoanPage.enterDownPayment("500");
        requestLoanPage.selectFromAccount("12345678");
        requestLoanPage.clickApplyNow();
        Assert.assertTrue(requestLoanPage.isLoanRequestProcessedDisplayed());
    }
}

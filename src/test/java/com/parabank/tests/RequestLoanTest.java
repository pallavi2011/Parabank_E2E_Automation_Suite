package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RequestLoanPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class RequestLoanTest extends BaseTest {
    LoginPage loginPage;
    RequestLoanPage requestLoanPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        requestLoanPage = new RequestLoanPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/requestloan.htm");
    }

    @Test
    public void testRequestLoan() {
        requestLoanPage.enterLoanAmount("5000");
        requestLoanPage.enterDownPayment("500");
        requestLoanPage.selectFromAccount("12345678");
        requestLoanPage.clickApplyNow();
        Assert.assertTrue(requestLoanPage.isLoanRequestProcessedDisplayed());
    }
}

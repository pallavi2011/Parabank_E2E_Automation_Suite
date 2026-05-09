package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.BillPayPage;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class BillPayTest extends BaseTest {
    LoginPage loginPage;
    BillPayPage billPayPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        billPayPage = new BillPayPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/billpay.htm");
    }

    @Test
    public void testBillPayment() {
        billPayPage.billPay("ElectricCo", "456 Elm St", "Los Angeles", "CA", "90001", "9876543210", "987654321", "987654321", "150", "12345678");
        Assert.assertTrue(driver.getPageSource().contains("Bill Payment Complete"));
    }
}

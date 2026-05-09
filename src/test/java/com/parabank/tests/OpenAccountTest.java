package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.OpenAccountPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpenAccountTest extends BaseTest {
    LoginPage loginPage;
    OpenAccountPage openAccountPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        openAccountPage = new OpenAccountPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");
    }

    @Test
    public void testOpenNewAccount() {
        openAccountPage.selectAccountType("SAVINGS");
        openAccountPage.selectFromAccount("12345678");
        openAccountPage.clickOpenNewAccount();
        Assert.assertFalse(openAccountPage.getNewAccountId().isEmpty());
    }
}

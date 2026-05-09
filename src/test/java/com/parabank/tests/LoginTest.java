package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getPageSource().contains("Accounts Overview"));
    }
}

package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
        registrationPage.enterAddress("123 Main St");
        registrationPage.enterCity("New York");
        registrationPage.enterState("NY");
        registrationPage.enterZipCode("10001");
        registrationPage.enterPhone("1234567890");
        registrationPage.enterSSN("123-45-6789");
        registrationPage.enterUsername("johndoe123");
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password123");
        registrationPage.clickRegister();
        Assert.assertTrue(driver.getPageSource().contains("Your account was created successfully"));
    }
}

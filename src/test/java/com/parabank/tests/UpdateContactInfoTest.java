package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.UpdateContactInfoPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class UpdateContactInfoTest extends BaseTest {
    LoginPage loginPage;
    UpdateContactInfoPage updateContactInfoPage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);
        updateContactInfoPage = new UpdateContactInfoPage(driver);
        loginPage.enterUsername("johndoe123");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        driver.get("https://parabank.parasoft.com/parabank/updateprofile.htm");
    }

    @Test
    public void testUpdateContactInfo() {
        updateContactInfoPage.setFirstName("John");
        updateContactInfoPage.setLastName("Doe");
        updateContactInfoPage.setAddress("123 Main St");
        updateContactInfoPage.setCity("New York");
        updateContactInfoPage.setState("NY");
        updateContactInfoPage.setZipCode("10001");
        updateContactInfoPage.setPhone("1234567890");
        updateContactInfoPage.clickUpdateProfile();
        Assert.assertTrue(updateContactInfoPage.isProfileUpdatedMessageDisplayed());
    }
}

package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.UpdateContactInfoPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class UpdateContactInfoTest extends BaseTest {
    LoginPage loginPage;
    UpdateContactInfoPage updateContactInfoPage;


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

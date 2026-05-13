package com.parabank.tests;

import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegistrationPage;
import com.parabank.utils.JsonFileReader;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage;



    @DataProvider(name = "RegisterDataProvider")
    public Object[][] getData() throws IOException {
        return JsonFileReader.getJsonData("registrationTests");
    }


    @Test(dataProvider = "RegisterDataProvider")
    public void testRegistration(String scenario, String firstName, String lastName, String address, String city,
                                 String state, String zip, String phone, String ssn, String user, String pass,
                                 String confirm, String expected) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.goToRegisterPage();


        registrationPage.register(firstName, lastName, address, city, state, zip, phone, ssn, user, pass, confirm);

        if (expected.equalsIgnoreCase("Success")) {
            // 1. Success Message Assertion
            boolean isSuccess = registrationPage.isTextPresent("Your account was created successfully.");
            Assert.assertTrue(isSuccess, "FAILED: Registration failed for positive scenario: " + scenario);

            // 2. URL Assertion (Best practice)
            Assert.assertTrue(driver.getCurrentUrl().contains("register.htm"), "FAILED: Did not stay on/reach register confirmation for: " + scenario);
        }
        else {
            // 3. Error Message Assertion (For Negative/Boundary cases)
            // ParaBank usually shows error messages in a red span or specific classes
            boolean hasError = registrationPage.isTextPresent("is required")
                    || registrationPage.isTextPresent("did not match")
                    || registrationPage.isTextPresent("already exists");

            Assert.assertTrue(hasError, "FAILED: Expected an error message but none appeared for: " + scenario);
        }
    }
}

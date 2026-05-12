package com.parabank.tests;

import com.google.gson.stream.JsonReader;
import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.utils.JsonFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData() throws IOException {
        return JsonFileReader.getJsonData("loginTests");
    }

    @Test(dataProvider = "LoginDataProvider")
    public void testLogin(String scenario, String user, String pass, String expected) {
        System.out.println("Executing: " + scenario);
        loginPage = new LoginPage(driver);
        // 1. Actions
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();

        // 2. Logic to handle both Positive and Negative scenarios
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (expected.equalsIgnoreCase("Success")) {
            // Wait specifically for the title to change to the Overview page
            boolean isSuccess = wait.until(ExpectedConditions.titleContains("Accounts Overview"));
            Assert.assertTrue(isSuccess, "FAILED: Login was expected to succeed but didn't for: " + scenario);
        } else if (scenario.contains("SQL Injection")) {
            // Check if we are on the 'Security' page OR see an error message
            boolean blocked = driver.getCurrentUrl().contains("security")
                    || driver.getPageSource().contains("Access Denied")
                    || driver.getPageSource().contains("error");

            Assert.assertTrue(blocked, "SQL Injection was NOT blocked by the security gateway!");
        }else {
            // Wait specifically for the error message element to appear
            // ParaBank error messages usually appear in a specific 'p' or 'span' tag
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
            System.out.println("Passed: Error message caught for negative case.");
        }

    }
}

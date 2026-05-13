package com.parabank.tests;

import com.google.gson.stream.JsonReader;
import com.parabank.base.BaseTest;
import com.parabank.pages.LoginPage;
import com.parabank.utils.JsonFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        loginPage.login(user, pass);

        // 2. Logic to handle both Positive and Negative scenarios
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (expected.equalsIgnoreCase("Success")) {
            // 1. Replaced wait.until with generic waitForCondition
            boolean isSuccess = loginPage.waitForCondition(ExpectedConditions.titleContains("Accounts Overview"));
            Assert.assertTrue(isSuccess, "FAILED: Success expected but 'Accounts Overview' not found for: " + scenario);

        } else if (scenario.contains("SQL Injection")) {
            // We added a 4th condition for the Cloudflare verification message
            boolean blocked = loginPage.waitForCondition(ExpectedConditions.or(
                    ExpectedConditions.urlContains("security"),
                    ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Access Denied"),
                    ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "security verification"),
                    ExpectedConditions.presenceOfElementLocated(By.className("error"))
            ));

            Assert.assertTrue(blocked, "SQL Injection was NOT blocked! No security gate or error detected.");
        } else {
            // 3. Replaced wait.until for standard negative cases
            WebElement errorElement = loginPage.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.className("error")));
            Assert.assertNotNull(errorElement, "Passed: Error message caught for negative case: " + scenario);
        }
    }
}


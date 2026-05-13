package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

/**
 * BasePage serves as the parent for all Page Objects.
 * It centralizes WebDriver initialization, explicit waits, and common UI actions.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize the explicit wait (set to 10 seconds)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize PageFactory for all child classes
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    public void goToRegisterPage(){
        registerLink.click();
    }

    /**
     * The Functional Interface Wait utility from Java 8
     * Allows passing specific ExpectedConditions (e.g., visibilityOf, elementToBeClickable).
     */
    public <V> V waitForCondition(Function<WebDriver, V> condition) {
        return wait.until(condition);
    }

    /**
     * A generic wrapper for typing text.
     * Handles waiting, clearing the field, and sending keys in one go.
     */
    public void sendKeys(WebElement element, String text) {
        // Ensure text is not null to avoid errors; if null, send empty string
        String textToType = (text != null) ? text : "";
        waitForCondition(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(textToType);
    }

    /**
     * A generic wrapper for clicking elements.
     * Ensures the element is clickable before attempting the action.
     */
    public void click(WebElement element) {
        waitForCondition(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Utility to get the page title (useful for assertions)
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Utility to check if specific text is present on the page
     */
    public boolean isTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }
}

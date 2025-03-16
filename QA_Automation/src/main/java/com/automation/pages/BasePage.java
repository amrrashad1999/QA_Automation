package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    private Actions actions;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        this.jsExecutor = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    // Wait for an element to be visible
    protected WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    protected WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click method with wait
    public void click(WebElement element) {
        waitForClickability(element).click();
    }

    // Send text to a field with wait
    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element).sendKeys(text);
    }

    // Scroll to an element
    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Move to an element using Actions class
    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Get text from an element
    public String getText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    // Check if element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

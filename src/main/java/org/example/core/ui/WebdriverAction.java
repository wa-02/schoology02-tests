package org.example.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverAction {

    private WebDriver driver;

    private WebDriverWait wait;

    public WebdriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public String getText(final By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void setValue(final By locator, final String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(value);
    }

    public void setValue(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(value);
    }

    public void clearAndSetValue(final By locator, final String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void clearAndSetValue(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    public boolean isElementDisplayedOnScreen(final By element) {
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


}

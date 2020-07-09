package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#s-update-create-form")
    private WebElement updateCreateForm;
    static final int TIMEOUTINSECONDS = 30;

    public GroupPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUTINSECONDS);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(updateCreateForm));
    }
}


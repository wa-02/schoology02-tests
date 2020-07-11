package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Updates extends AbstractPage {

    @FindBy(css = "#edit-submit")
    private WebElement postButton;

    @FindBy(css = "#edit-body_ifr")
    private WebElement frame;

    @FindBy(css = "#tinymce")
    private WebElement frameTextField;

    public static final String XPATH_UPDATE_TEXT = "//p[text()='%s']";

    public void postUpdate(final String text) {
        driver.switchTo().frame(frame);
        frameTextField.sendKeys(text);
        driver.switchTo().defaultContent();
        postButton.click();
    }

    public String getUpdate(final String updateName) {
        WebElement updatedText = driver.findElement(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
        return updatedText.getText();
    }
}

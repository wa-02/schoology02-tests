package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Updates extends AbstractPage {

    @FindBy(css = "#edit-submit")
    private WebElement postButton;

    @FindBy(css = "#edit-body_ifr")
    private WebElement frame;

    @FindBy(css = "#tinymce")
    private WebElement frameTextField;

    public void postUpdate(final String text){
        driver.switchTo().frame(frame);
        frameTextField.sendKeys(text);
        driver.switchTo().defaultContent();
        postButton.click();
    }
}

package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUpdatePopup extends AbstractPage {

    @FindBy(css = "#edit-update-body_ifr")
    private WebElement frame;

    @FindBy(css = "#tinymce")
    private WebElement frameTextField;

    @FindBy(css = "input#edit-submit[class = \"form-submit\"]")
    private WebElement saveChanges;

    public Updates newUpdate(final String newUpdate) {
        driver.switchTo().frame(frame);
        frameTextField.clear();
        frameTextField.sendKeys(newUpdate);
        driver.switchTo().defaultContent();
        saveChanges.click();
        return new Updates();
    }
}

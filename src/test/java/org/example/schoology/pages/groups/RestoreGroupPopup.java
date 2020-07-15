package org.example.schoology.pages.groups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestoreGroupPopup extends AbstractGroupPopup {

    @FindBy(css = "#confirmation_confirm")
    private WebElement submitButton;

    public void clickRestoreButton() {
        action.click(submitButton);
    }
}

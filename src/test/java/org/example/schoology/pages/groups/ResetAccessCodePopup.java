package org.example.schoology.pages.groups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResetAccessCodePopup extends AbstractGroupPopup{

    @FindBy(css = "input[id='edit-submit'][value='Confirm']")
    protected WebElement confirmButton;

    public void resetAccessCode() {

        action.click(confirmButton);

    }
}

package org.example.schoology.pages.groups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchiveGroupPopup extends AbstractGroupPopup {


    @FindBy(css = "#confirmation_confirm")
    private WebElement confirmButton;

    public void clickArchiveButton() {
        action.click(confirmButton);
    }

}

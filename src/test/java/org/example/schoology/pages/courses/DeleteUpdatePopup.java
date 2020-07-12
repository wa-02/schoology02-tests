package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteUpdatePopup extends AbstractPage {

    @FindBy(css = "#confirmation_confirm")
    private WebElement deleteButton;

    public Updates deleteUpdate() {
        action.click(deleteButton);

        return new Updates();
    }
}

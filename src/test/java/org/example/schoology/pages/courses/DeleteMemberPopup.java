package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteMemberPopup extends AbstractPage {

    @FindBy(css = "#popup_submit")
    private WebElement confirmButton;

    public Members clickConfirmButton() {
        action.click(confirmButton);

        return new Members();
    }
}

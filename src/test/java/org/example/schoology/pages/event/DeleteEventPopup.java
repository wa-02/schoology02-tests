package org.example.schoology.pages.event;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * <h1>Delete Event Popup</h1>
 * This class represents a Delete Event Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public class DeleteEventPopup extends AbstractPage {

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    public void clickDeleteButton() {
        action.click(deleteButton);
    }
}

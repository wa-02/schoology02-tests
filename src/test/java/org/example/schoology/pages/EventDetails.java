package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.event.DeleteEventPopup;
import org.openqa.selenium.By;

/**
 * <h1>Event Details</h1>
 * This class represents an Event Details.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public class EventDetails extends AbstractPage {

    public static final String EVENT_ACTIONS_BUTTON = "//div[@class='info-text']/descendant::div[@role='button']";
    public static final String EVENT_ACTIONS_DELETE_OPTION = "//li[@class='action-delete']/descendant::a[text()"
            + "='Delete']";

    private void clickEventActionButton() {
        action.click(By.xpath(EVENT_ACTIONS_BUTTON));
    }

    public DeleteEventPopup clickDeleteOption() {
        clickEventActionButton();
        action.click(By.xpath(EVENT_ACTIONS_DELETE_OPTION));
        return new DeleteEventPopup();
    }



}

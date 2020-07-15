package org.example.schoology.pages.event;

import org.example.schoology.pages.Calendar;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * <h1>Create Event Popup</h1>
 * This class represents a Create Event Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public class CreateEventPopup extends AbstractEventPopup {

    public CreateEventPopup() {
        super();
    }

    public Calendar addEvent(final Map<String, String> eventMap) {
        action.click(By.xpath(CREATE_EVENT_ENABLE_END_TIME));
        action.click(createEventPopupTitle);
        fillCreateEventForm(eventMap);
        action.click(createEventCreateButton);
        return new Calendar();
    }

}

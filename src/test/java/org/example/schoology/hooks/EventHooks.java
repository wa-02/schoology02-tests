package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.EventDetails;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.event.DeleteEventPopup;

/**
 * <h1>Event Hooks</h1>
 * This class contains all the methods to be executed before and also after of each scenario.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public class EventHooks {

    private ScenarioContext context;

    public EventHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios

    }

    @After(value = "@deleteEvent")
    public void deleteEvent() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        EventDetails eventDetails = new Home().clickOnEventDetails(context.getValue("EventNameKey"));
        DeleteEventPopup deleteEventPopup = eventDetails.clickDeleteOption();
        deleteEventPopup.clickDeleteButton();
    }

}

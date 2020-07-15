package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Calendar;
import org.example.schoology.pages.event.CreateEventPopup;
import org.testng.asserts.Assertion;

import java.util.Map;


public class CalendarStepsDefs {

    private final ScenarioContext context;
    private Home home;
    private final Assertion assertion;
    private Calendar calendar;

    public CalendarStepsDefs(final AssertionGroup assertionGroup, final ScenarioContext context,
                            final Calendar calendar, final Home home) {
        assertion = assertionGroup.getAssertion();
        this.home = home;
        this.calendar = calendar;
        this.context = context;
    }

    @And("I create a calendar event with:")
    public void iCreateACalendarEventWith(final Map<String, String> datatable) {
        calendar = home.clickCalendarMenuOption();
        calendar.clickInACalendarDate(datatable);
        CreateEventPopup createEventPopup = calendar.clickInACalendarHour(datatable);
        createEventPopup.addEvent(datatable);
        context.setContext("EventNameKey", datatable.get("title"));
    }

    @Then("I comeback to home page")
    public void iComebackToHomePage() {
        calendar.goHomeScreen();
    }


    @And("I should see an event with name {string}")
    public void iShouldSeeAnEventWithName(final String eventName) {
        assertion.assertTrue(home.resourceItemExist(eventName));

    }
}

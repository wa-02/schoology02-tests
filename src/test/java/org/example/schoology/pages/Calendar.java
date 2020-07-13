package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.event.CreateEventPopup;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * <h1>Calendar</h1>
 * This class represents a Calendara Page.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public class Calendar extends AbstractPage {

    public static final String CALENDAR_DATE = "//table[@class='fc-border-separate']/descendant::div[text()='%s']";
    public static final String CALENDAR_HOUR = "//table[@class='fc-agenda-slots']/descendant::th[text()"
            + "='%s']/parent::tr/descendant::div";

    public void clickInACalendarDate(final Map<String, String> eventMap) {
        String day = eventMap.get("startDate");
        action.click(By.xpath(String.format(CALENDAR_DATE, day)));
    }

    public CreateEventPopup clickInACalendarHour(final Map<String, String> eventMap) {
        String hour = eventMap.get("startHour");
        action.click(By.xpath(String.format(CALENDAR_HOUR, hour)));
        return new CreateEventPopup();
    }

    public Home goHomeScreen() {
        driver.navigate().to("https://app.schoology.com/home/");
        return new Home();
    }

}

package org.example.schoology.pages.event;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Abstract Event Popup</h1>
 * This class represents an abstract Event Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-13
 */
public abstract class AbstractEventPopup extends AbstractPage {

    public static final String CREATE_EVENT_END_DATE = "//input[@name='end[date]']";
    public static final String CREATE_EVENT_END_HOUR = "//input[@name='end[time]']";
    public static final String CREATE_EVENT_ENABLE_END_TIME = "//div[text()='Add End Time']";

    @FindBy(css = "#edit-title")
    private WebElement createEventTitleTextField;

    @FindBy(css = ".mceContentBody")
    private WebElement createEventDescriptionTextField;

    @FindBy(css = "#edit-submit")
    protected  WebElement createEventCreateButton;

    @FindBy(css = "div[class='title']")
    protected  WebElement createEventPopupTitle;


    public void fillCreateEventForm(final Map<String, String> eventMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("title", () -> setTitleAddCreateEventForm(eventMap.get("title")));
        stepsMap.put("description", () -> setDescriptionCreateEventForm(eventMap.get("description")));
        stepsMap.put("endDate", () -> setEndDateCreateEventForm(eventMap.get("endDate")));
        stepsMap.put("endHour", () -> setEndHourCreateEventForm(eventMap.get("endHour")));

        for (String keyField : stepsMap.keySet()) {
            action.click(createEventPopupTitle);
            stepsMap.get(keyField).execute();
            action.click(createEventPopupTitle);
        }
    }

    public void setEndDateCreateEventForm(final String endDate) {
        WebElement createEventEndDate = driver.findElement(By.xpath(CREATE_EVENT_END_DATE));
        action.click(createEventEndDate);
        action.clearAndSetValue(createEventEndDate, endDate);
    }

    public void setEndHourCreateEventForm(final String endHour) {
        WebElement createEventStartHour = driver.findElement(By.xpath(CREATE_EVENT_END_HOUR));
        action.click(createEventStartHour);
        action.clearAndSetValue(createEventStartHour, endHour);
    }

    public void setTitleAddCreateEventForm(final String title) {
        action.clearAndSetValue(createEventTitleTextField, title);
    }

    private void setDescriptionCreateEventForm(final String description) {
        driver.switchTo().frame("edit-description_ifr");
        action.click(createEventDescriptionTextField);
        action.clearAndSetValue(createEventDescriptionTextField, description);
        driver.switchTo().defaultContent();
    }

}

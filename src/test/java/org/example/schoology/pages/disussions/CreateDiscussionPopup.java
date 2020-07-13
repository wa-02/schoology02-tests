package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class CreateDiscussionPopup extends AbstractPage {

    @FindBy(css = "popups-2")
    private WebElement createPopup;

    @FindBy(css = "input#edit-title")
    private WebElement discussionTitle;

    @FindBy(css = ".mceContentBody")
    private WebElement discussionDescription;

    @FindBy(css = "input.form-submit")
    private WebElement createButton;

    public void fill(final Map<String, String> discussionMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("title", () -> setName(discussionMap.get("title")));
        stepMap.put("description", () -> setDescription(discussionMap.get("description")));

        for (final String keyField : discussionMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setName(final String name) {
        discussionTitle.clear();
        discussionTitle.sendKeys(name);
    }

    private void setDescription(final String description) {
        driver.switchTo().frame("edit-post_ifr");
        action.click(discussionDescription);
        action.clearAndSetValue(discussionDescription, description);
        driver.switchTo().defaultContent();
    }

    public void createDiscussionButton(){
        createButton.click();
    }

}

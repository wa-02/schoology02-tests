package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Discussions extends AbstractPage {

    public static final String XPATH_UPDATE_TEXT = "//a[text()='%s']";

    @FindBy(css = "span.create-new")
    private WebElement createDiscussionButton;

    @FindBy(css = "a.discussion-title")
    private WebElement discussionName;

    public CreateDiscussionPopup createDiscussion() {
        return new CreateDiscussionPopup();
    }

    public CreateDiscussionPopup clickAddDiscussionButton() {
        createDiscussionButton.click();
        return new CreateDiscussionPopup();
    }

    public String getDiscussionName(final String updateName) {
        WebElement updatedText = driver.findElement(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
        return updatedText.getText();
    }

    public boolean resourceItemExist(final String resourceName) {
        return action.isElementDisplayedOnScreen(By.cssSelector("a.discussion-title"));
    }

    public Discussion joinDiscussion() {

        discussionName.click();
        return new Discussion();
    }
}

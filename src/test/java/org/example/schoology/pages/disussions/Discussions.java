package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussions extends AbstractPage {

    public static final String XPATH_UPDATE_TEXT = "//a[text()='%s']";
    public static final String XPATH_DELETE_DISCUSSION = "//div[@class=\"submit-buttons\"]/child::span/child::input";

    @FindBy(css = "span.create-new")
    private WebElement createDiscussionButton;

    @FindBy(css = "a.discussion-title")
    private WebElement discussionName;

    @FindBy(css = "a.delete-discussion")
    private WebElement deleteDiscussionButton;

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

    public void deleteDiscussionClick() {
        deleteDiscussionButton.click();
    }

    public void clickDeleteDiscussionButton() {
        WebElement deleteButton = driver.findElement(By.xpath(XPATH_DELETE_DISCUSSION));
        deleteButton.click();
    }

    public boolean discussionDeleted() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popups-3")));
        return true;
    }
}

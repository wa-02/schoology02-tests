package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussion extends AbstractPage {

    public static final String DISCUSSION_ACTIONS_BUTTON = "//div[@class='submit-buttons']/child::span/child::input";
    public static final String XPATH_EDIT_DELETE = "//p[text()='%s']/parent::div/parent::div/parent::div/parent::div"
            + "/parent::div/child::div[@class='s-js-comment-action-links']";

    @FindBy(css = ".mceContentBody")
    private WebElement discussionComment;

    @FindBy(css = "#comment-placeholder")
    private WebElement commentArea;

    @FindBy(css = "#edit-submit")
    private WebElement postComment;

    @FindBy(css = "span.comment-author")
    private WebElement commentAuthor;

    @FindBy(css = ".comment-body-wrapper")
    private WebElement commentText;

    @FindBy(css = ".action-links-wrapper-junior")
    private WebElement editDeleteWraper;

    @FindBy(css = ".edit-comment")
    private WebElement editOption;

    public void setComment(final String comment) {

        commentArea.click();
        driver.switchTo().frame("edit-comment_ifr");
        action.click(discussionComment);
        action.clearAndSetValue(discussionComment, comment);
        driver.switchTo().defaultContent();
        postComment.click();
    }

    public String getCommentAuthor() {
        return commentAuthor.getText();
    }

    public String getCommentText() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popups-3")));
        return commentText.getText();
    }

    public void clickEditDeleteWraper(final String comment) {

        WebElement editWrapper = driver.findElement(By.xpath(String.format(XPATH_EDIT_DELETE, comment)));
        editWrapper.click();
        editOption.click();
    }

    public void updateComment(final String comment) {
        WebElement groupActionsButton = driver.findElement(By.xpath(DISCUSSION_ACTIONS_BUTTON));
        driver.switchTo().frame("edit-comment-body_ifr");
        action.click(discussionComment);
        action.clearAndSetValue(discussionComment, comment);
        driver.switchTo().defaultContent();
        groupActionsButton.click();
    }

}


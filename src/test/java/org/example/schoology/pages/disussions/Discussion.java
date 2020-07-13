package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussion extends AbstractPage {

    public static final String DISCUSSION_ACTIONS_BUTTON = "//div[@class='submit-buttons']/child::span/child::input";

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
//        String comment = commentText.getText();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popups-3")));
//        action.getText(commentText);
        return commentText.getText();
    }

    public void clickEditDeleteWraper(){
        editDeleteWraper.click();
        editOption.click();
    }

    public void updateComment(final String comment) {
//        commentArea.click();
        WebElement groupActionsButton = driver.findElement(By.xpath(DISCUSSION_ACTIONS_BUTTON));
        driver.switchTo().frame("edit-comment-body_ifr");
        action.click(discussionComment);
        action.clearAndSetValue(discussionComment, comment);
        driver.switchTo().defaultContent();
        groupActionsButton.click();
    }

}


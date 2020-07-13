package org.example.schoology.pages.disussions;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussion extends AbstractPage {

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

    public void setDescription(final String comment) {
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
        return commentText.getText();
    }

}


package org.example.schoology.pages.groups;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Groups extends ViewList {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@href='#']";
    public static final String SELECT_ACTIONS = "//a[text()='%s']/ancestor::li//ul//li[@class='action-edit']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";
    public static final String POST_UPDATE = "//p[text()='%s']";
    public static final String UPDATE_BODY = "//body/p";

    @FindBy(css = "a.create-group")
    private WebElement createGroupButton;

    @FindBy(css = "ul[style=\"display: block;\"] .action-delete")
    private WebElement deleteGroup;

    @FindBy(css = "input[id='edit-submit']")
    private WebElement postButton;


    public CreateGroupPopup clickCreateGroupButton() {
        createGroupButton.click();
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        wait.until(ExpectedConditions.visibilityOf(groupActionsButton));
        groupActionsButton.click();
        driver.findElement(By.xpath(String.format(SELECT_ACTIONS, groupName))).click();
        return new EditGroupPopup();
    }

    public String getGroupByName(final String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

    public DeleteGroupPopup clickDeleteGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON,
                groupName)));

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        deleteGroup.click();
        return new DeleteGroupPopup();
    }

    public void clickGroupName(final String groupName) {
        driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).click();
    }

    public String setPost(final String postText) {
        driver.switchTo().frame("edit-body_ifr");
        driver.findElement(By.xpath(UPDATE_BODY)).sendKeys(postText);
        driver.switchTo().defaultContent();
        postButton.click();
        return driver.findElement(By.xpath(String.format(POST_UPDATE, postText))).getText();
    }
}

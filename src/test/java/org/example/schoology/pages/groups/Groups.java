package org.example.schoology.pages.groups;

import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.disussions.CreateDiscussionPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Groups extends ViewList {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li/descendant::div[@role='button']";
    public static final String SELECT_ACTIONS = "//a[text()='%s']/ancestor::li//ul//li[@class='action-edit']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";
    public static final String POST_UPDATE = "//p[text()='%s']";
    public static final String UPDATE_BODY = "//body/p";
    public static final String RESET_LINK = "//a[@class='action-regenerate-code popups-processed sExtlink-processed']";
    public static final String MENU_ITEM = "//a[@role='menuitem' and contains(text(),'%s')]";
    public static final String ADD_RESOURCE = "//span[contains(text(),'Add Resources')]";


    @FindBy(css = "a.create-group")
    private WebElement createGroupButton;

    @FindBy(css = "a.group-discussion-left-menu")
    private WebElement discussionMenu;

    @FindBy(css = "ul[style=\"display: block;\"] .action-delete")
    private WebElement deleteGroup;

    @FindBy(css = "input[id='edit-submit']")
    private WebElement postButton;

    @FindBy(css = "span[class='enrollment-code']")
    private WebElement accessCode;

    @FindBy(css = "ul[style=\"display: block;\"] .action-archive")
    private WebElement archiveGroup;

    @FindBy(css = "ul[style=\"display: block;\"] .action-restore")
    private WebElement restoreGroup;

    public CreateGroupPopup clickCreateGroupButton() {

        createGroupButton.click();
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        action.click(groupActionsButton);

        driver.findElement(By.xpath(String.format(SELECT_ACTIONS, groupName))).click();
        return new EditGroupPopup();
    }

    public String getGroupByName(final String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

    public CreateDiscussionPopup clickDiscussionsList() {
        action.click(discussionMenu);
        return new CreateDiscussionPopup();
    }

    public DeleteGroupPopup clickDeleteGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON,
                groupName)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        action.click(groupActionsButton);

        action.click(deleteGroup);

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

    public String saveAccessCode() {
        return accessCode.getText();
    }

    public String resetAccessCode() {
        driver.findElement(By.xpath(RESET_LINK)).click();
        new ResetAccessCodePopup().resetAccessCode();
        driver.navigate().refresh();
        return accessCode.getText();
    }

    public void clickInMenuItem(final String menuItem) {
        driver.findElement(By.xpath(String.format(MENU_ITEM, menuItem))).click();
    }

    public CreateFolderPopup clickAddResource() {

        WebElement groupActionsButton = driver.findElement(By.xpath(ADD_RESOURCE));
        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        wait.until(ExpectedConditions.visibilityOf(groupActionsButton));
        groupActionsButton.click();
        driver.findElement(By.xpath(String.format(GROUP_BY_NAME, "Add Folder"))).click();
        return new CreateFolderPopup();

    }

    public String getResourcesByName(final String folderName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, folderName))).getText();
    }

    public void clickLeaveGroup() {
        driver.findElement(By.xpath(String.format(GROUP_BY_NAME, "Leave this group"))).click();
    }

    public ArchiveGroupPopup clickArchiveGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON,
                groupName)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        archiveGroup.click();
        return new ArchiveGroupPopup();
    }

    public void clickArchivedTab() {
        driver.findElement(By.xpath(String.format(GROUP_BY_NAME, "Archived"))).click();
    }

    public void clickCurrentTab() {
        driver.findElement(By.xpath(String.format(GROUP_BY_NAME, "Current"))).click();
    }

    public RestoreGroupPopup clickRestoreGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON,
                groupName)));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        groupActionsButton.click();
        restoreGroup.click();
        return new RestoreGroupPopup();
    }
}

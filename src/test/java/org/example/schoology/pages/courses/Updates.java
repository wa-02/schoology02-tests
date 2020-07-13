package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Updates extends AbstractPage {

    @FindBy(css = "#edit-submit")
    private WebElement postButton;

    @FindBy(css = "#edit-body_ifr")
    private WebElement frame;

    @FindBy(css = "#tinymce")
    private WebElement frameTextField;

    @FindBy(css = ".update-post-action-links.sActionLinksVisible")
    private WebElement updateAction;

    @FindBy(css = "li.action-edit")
    private WebElement editUpdate;

    @FindBy(css = "li.action-delete")
    private WebElement deleteUpdate;

    public static final String XPATH_UPDATE_TEXT = "//p[text()='%s']";

    public static final String XPATH_DELETE_MESSAGE = "//div[text()='%s']";

    public void postUpdate(final String text) {
        driver.switchTo().frame(frame);
        frameTextField.sendKeys(text);
        driver.switchTo().defaultContent();
        postButton.click();
    }

    public String getUpdate(final String updateName) {
        return action.getText(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
    }

    public void moveToUpdate(final String updateName) {
        Actions actionElement = new Actions(driver);
        WebElement updateElement = driver.findElement(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
        actionElement.moveToElement(updateElement).perform();
    }

    public EditUpdatePopup editUpdate(final String updateToEdit) {
        moveToUpdate(updateToEdit);
        action.click(updateAction);
        action.click(editUpdate);

        return new EditUpdatePopup();
    }

    public DeleteUpdatePopup deleteUpdate(final String updateToDelete) {
        moveToUpdate(updateToDelete);
        action.click(updateAction);
        action.click(deleteUpdate);

        return new DeleteUpdatePopup();
    }

    public String getMessageDelete(final String deletedText) {
        return action.getText(By.xpath(String.format(XPATH_DELETE_MESSAGE, deletedText)));
    }

    public boolean updateItemExist(final String updateName) {
        return action.isElementDisplayedOnScreen(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
    }
}

package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * <h1>Resources</h1>
 * This class represents a resource web page.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class Resources extends AbstractPage {
    public static final String ADD_RESOURCE_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@class='action"
            + "-links-unfold ']";
    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/parent::td/following-sibling::td"
            + "/descendant::div[@class='action-links-unfold ']";
    public static final String RESOURCE_ACTIONS_DELETE_OPTION = "//a[text()='%s']/following::a[@class='action-delete "
            + " sExtlink-processed popups-processed']";
    public static final String RESOURCE_ITEM = "//a[text()='%s']";

    public static final String EDIT_QUESTION_QUIZ = "//ul[@style='display: block;"
            + "']/descendant::li/a[@class='action-edit-template-assessment-questions sExtlink-processed']";

    @FindBy(css = "#collection-add-question-bank")
    private WebElement addQuestionBankOption;

    @FindBy(css = "#collection-add-assessment")
    private WebElement addTestQuizOption;

    @FindBy(css = "a[class='action-edit-template-assessment-questions sExtlink-processed']")
    private WebElement editQuestionQuizResource;

    @FindBy(css = "a[class='action-delete  sExtlink-processed popups-processed']")
    private WebElement deleteQuizResource;

    @FindBy(css = ".messages .message-text")
    private WebElement messages;

    @FindBy(css = "#library-wrapper div.messages-container")
    private WebElement messageContainer;

    @FindBy(css = "a[href*='/add_folder?']")
    private WebElement addFolderOption;



    public void clickAddResourcesButton() {
        action.click(By.xpath(ADD_RESOURCE_ACTIONS_BUTTON));
    }

    public AddQuestionBankResourcePopup clickAddQuestionBankResource() {
        clickAddResourcesButton();
        action.click(addQuestionBankOption);
        return new AddQuestionBankResourcePopup();
    }

    public AddTestQuizResourcePopup clickAddTestQuizResource() {
        clickAddResourcesButton();
        action.click(addTestQuizOption);
        return new AddTestQuizResourcePopup();
    }

    public DeleteResourcePopup clickRemoveResource(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));
        action.click(By.xpath(String.format(RESOURCE_ACTIONS_DELETE_OPTION, resourceName)));
        return new DeleteResourcePopup();

    }

    public boolean resourceItemExist(final String resourceName) {
        return action.isElementDisplayedOnScreen(By.xpath(String.format(RESOURCE_ITEM, resourceName)));
    }

    public String getMessage() {
        return action.getText(messages);
    }

    public void waitForMessageContainerDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#library-wrapper div"
                + ".messages-container")));
    }

    private void clickResourceActionsButton(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, resourceName)));
    }

    public EditAssessmentQuestions clickEditQuestionsQuizResource(final String resourceName) {
        clickResourceActionsButton(resourceName);
        action.click(By.xpath(EDIT_QUESTION_QUIZ));
        return new EditAssessmentQuestions();
    }

    public DeleteResourcePopup clickDeleteQuiz(final String resourceName) {
        clickResourceActionsButton(resourceName);
        action.click(deleteQuizResource);
        return new DeleteResourcePopup();

    }

    public TestQuizTemplatePopup clickResourceItem(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_ITEM, resourceName)));
        return new TestQuizTemplatePopup();
    }
    public AddFolderPopup clickAddFolderOption(){
        action.click(addFolderOption);
        return new AddFolderPopup();

    }


}

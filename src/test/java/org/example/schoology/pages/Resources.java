package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.example.schoology.pages.resources.DeleteResourcePopup;
import org.example.schoology.pages.resources.TestQuizTemplatePopup;
import org.example.schoology.pages.resources.AddFolderPopup;
import org.example.schoology.pages.resources.EditFolderPopup;
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

    public static final String ADD_RESOURCE_ACTIONS_BUTTON = "//div[@id='toolbar-add']/child::div[@role='button']";
    public static final String RESOURCE_ACTIONS_BUTTON = "//a[text()='%s']/parent::td/following-sibling::td"
            + "/descendant::div[@role='button']";
    public static final String RESOURCE_ACTIONS_DELETE_OPTION = "//ul[@style='display: block;"
            + "']/descendant::a[@class='action-delete  sExtlink-processed popups-processed']";
    public static final String RESOURCE_ITEM = "//a[text()='%s']";

    public static final String EDIT_QUESTION_QUIZ = "//ul[@style='display: block;"
            + "']/descendant::li/a[@class='action-edit-template-assessment-questions sExtlink-processed']";

    public static final String RESOURCE_ACTIONS_EDIT = "//a[text()='%s']/following::a[@class='action-edit-template "
            + "edit-popup folder sExtlink-processed popups-processed']";
    public static final String ADD_FOLDER_OPTION = "//li[@id='collection-add-folder']/child::a[@class='sExtlink"
            + "-processed popups-processed']";

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
    public AddFolderPopup clickAddFolderOption() {
        clickAddResourcesButton();
        action.click(By.xpath(ADD_FOLDER_OPTION));
        return new AddFolderPopup();

    }
    public EditFolderPopup clickEditFolderOption(final String folderName) {
        action.click(By.xpath(String.format(RESOURCE_ACTIONS_BUTTON, folderName)));
        action.click(By.xpath(String.format(RESOURCE_ACTIONS_EDIT, folderName)));
        return new EditFolderPopup();
    }


}

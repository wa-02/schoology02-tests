package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Abstract Resource Popup</h1>
 * This class represents an Abstract Resource Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public abstract class AbstractResourcePopup extends AbstractPage {

    public static final String ADD_FOLDER_COLOUR = "div[class='clickable s-js-color-select s-js-color-%s']";

    @FindBy(css = "#edit-title")
    private WebElement addQuestionBankNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement addQuestionBankDescriptionTextField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement addQuestionBankEnableTrackingCheckBox;

    @FindBy(css = "input[value='Create']")
    protected  WebElement addQuestionBankSubmitButton;

    @FindBy(css = "#edit-template-fields-title")
    protected WebElement addTestQuizNameTextField;

    @FindBy(css = "#edit-template-fields-max-points")
    protected WebElement addTestQuizMaxPointsTextField;

    @FindBy(css = "form#s-library-collection-template-form input#edit-submit")
    protected WebElement addTestQuizSubmitButton;

    @FindBy(css = "input[value='Create']")
    private WebElement addFolderCreateButton;

    @FindBy(css = "#edit-title")
    private WebElement addFolderNameField;

    @FindBy(css = ".mceContentBody")
    private WebElement addFolderDescriptionTextField;

    @FindBy(css = "input[class='form-text required edit-title']")
    private WebElement editFolderNameField;

    public void setNameAddQuestionBank(final String name) {
        addQuestionBankNameTextField.sendKeys(name);
    }

    public void setDescriptionAddQuestionBank(final String description) {
        addQuestionBankDescriptionTextField.sendKeys(description);
    }

    public void fillAddQuestionBankForm(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameAddQuestionBank(resourceMap.get("name")));
        stepsMap.put("description", () -> setDescriptionAddQuestionBank(resourceMap.get("description")));
        stepsMap.put("enableQuestionTracking", () -> setEnableQuestionTrackingAddQuestionBank(resourceMap.get(
                "enableQuestionTracking")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setEnableQuestionTrackingAddQuestionBank(final String enableQuestionTracking) {
        switch (enableQuestionTracking) {
            case "True":
                addQuestionBankEnableTrackingCheckBox.click();
                break;
            default:
                //nothing to do
        }
    }

    public void fillAddTestQuizForm(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameAddTestQuiz(resourceMap.get("name")));
        stepsMap.put("maxPoints", () -> setMaxPointsAddTestQuiz(resourceMap.get("maxPoints")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setNameAddTestQuiz(final String name) {
        addTestQuizNameTextField.sendKeys(name);
    }

    private void setMaxPointsAddTestQuiz(final String maxPoints) {
        action.clearAndSetValue(addTestQuizMaxPointsTextField, maxPoints);
    }

    public void fillAddFolderForm(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameAddFolder(resourceMap.get("name")));
        stepsMap.put("colour", () -> setColourToFolder(resourceMap.get("colour")));
        stepsMap.put("description", () -> setDescriptionFolder(resourceMap.get("description")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setNameAddFolder(final String name) {
        action.clearAndSetValue(addFolderNameField, name);
    }

    private void setDescriptionFolder(final String description) {
        driver.switchTo().frame("edit-description_ifr");
        action.click(addFolderDescriptionTextField);
        action.clearAndSetValue(addFolderDescriptionTextField, description);
        driver.switchTo().defaultContent();
    }
    private void setColourToFolder(final String colour) {
        action.click(By.cssSelector(String.format(ADD_FOLDER_COLOUR, colour)));
    }

    public void fillEditFolderForm(final Map<String, String> resourceMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setNameEditFolder(resourceMap.get("name")));
        stepsMap.put("colour", () -> setColourToFolder(resourceMap.get("colour")));

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }

    private void setNameEditFolder(final String name) {
        action.clearAndSetValue(editFolderNameField, name);
    }

}

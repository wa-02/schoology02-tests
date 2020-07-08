package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * <h1>Edit Assessment Questions</h1>
 * This class represents an Assessment Question web page.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class EditAssessmentQuestions extends AbstractPage {

    @FindBy(css = "div[class='action-links-unfold ']")
    private WebElement assessmentAddQuestionButton;

    @FindBy(css = "a[class='schoology-back-to-resources-link sExtlink-processed']")
    private WebElement backToResourcesLink;

    public static final String ADD_QUESTION_MULTIPLE_CHOICE = "//ul[@class='action-links "
            + "component-list']/descendant::a[contains(@href,'multiple_choice')]";
    public static final String QUESTION_BY_NAME = "//p[text()='%s']";

    public void clickAddQuestionButton() {
        action.click(assessmentAddQuestionButton);
    }

    public MultipleChoiceQuestion clickAddQuestionMultipleChoice() {
        clickAddQuestionButton();
        action.click(By.xpath(String.format(ADD_QUESTION_MULTIPLE_CHOICE)));
        return new MultipleChoiceQuestion();
    }

    public Resources goToBackResources() {
        action.click(backToResourcesLink);
        return new Resources();
    }

    public boolean questionItemExist(final String questionItem) {
        return action.isElementDisplayedOnScreen(By.xpath(String.format(QUESTION_BY_NAME, questionItem)));
    }

}

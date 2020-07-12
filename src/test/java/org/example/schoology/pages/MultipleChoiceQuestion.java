package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Multiple Choice Question</h1>
 * This class represents a Multiple Choice Question web page.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class MultipleChoiceQuestion extends AbstractPage {

    @FindBy(css = ".mceContentBody")
    private WebElement questionTextField;

    @FindBy(css = "#edit-add-choice")
    private WebElement addButton;

    @FindBy(css = "#edit-remove-blanks")
    private WebElement removeBlanksButton;

    @FindBy(css = "#edit-submit")
    private WebElement createQuestionButton;

    @FindBy(css = "a[class='schoology-back-to-resources-link sExtlink-processed']")
    private WebElement backToResourcesLink;


    public static final String MULTIPLE_CHOICE = "#edit-multiple-choice-choice-%s-text";
    public static final String MULTIPLE_CHOICE_IS_ANSWER = "#edit-multiple-choice-choice-%s-is-answer";


    private void setMultipleChoiceQuestion(final String question) {
        driver.switchTo().frame("edit-title_ifr");
        action.click(questionTextField);
        action.setValue(questionTextField, question);
        driver.switchTo().defaultContent();
    }

    private void setChoiceAnswerText(final String answer, final String index) {
        WebElement choiceAnswerTextField = driver.findElement(By.cssSelector(
                String.format(MULTIPLE_CHOICE, index)));
        action.click(choiceAnswerTextField);
        action.setValue(choiceAnswerTextField, answer);
    }

    private void selectCorrectChoiceAnswer(final String index) {
        Integer indexAnswer = Integer.parseInt(index) - 1;
        action.click(By.cssSelector(String.format(MULTIPLE_CHOICE_IS_ANSWER, indexAnswer)));
    }

    private void removeBlankQuestions() {
        action.click(removeBlanksButton);
    }

    private void fillMultipleChoiceQuestion(final Map<String, String> questionMap) {
        Integer numberOfQuestions = Integer.parseInt(questionMap.get("number_of_options"));

        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("question", () -> setMultipleChoiceQuestion(questionMap.get("question")));

        for (int i = 0; i < numberOfQuestions; i++) {
            String choice = "choice_" + i;
            String index = String.valueOf(i);
            stepMap.put(choice, () -> setChoiceAnswerText(questionMap.get(choice), index));
        }

        stepMap.put("is_answer", () -> selectCorrectChoiceAnswer(questionMap.get("is_answer")));

        for (String keyField : stepMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void addMultipleChoiceQuestion(final Map<String, String> questionMap) {
        fillMultipleChoiceQuestion(questionMap);
        removeBlankQuestions();
        action.click(createQuestionButton);
    }

    public void backToResourcesPage() {
        action.click(backToResourcesLink);
    }

}

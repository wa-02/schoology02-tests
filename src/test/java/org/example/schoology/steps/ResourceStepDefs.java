package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.EditAssessmentQuestions;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.MultipleChoiceQuestion;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.example.schoology.pages.resources.DeleteResourcePopup;
import org.testng.asserts.Assertion;

import java.util.Map;

public class ResourceStepDefs {

    private final ScenarioContext context;
    private Home home;
    private SubMenu subMenu;
    private Resources resources;
    private EditAssessmentQuestions editAssessmentQuestions;
    private MultipleChoiceQuestion multipleChoiceQuestion;
    private final Assertion assertion;

    public ResourceStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                            final ScenarioContext context, final Resources resources, final Home home) {
        assertion = assertionGroup.getAssertion();
        this.home = home;
        this.resources = resources;
        this.context = context;
    }

   @And("I create an Add Question Bank resource with:")
    public void iCreateAResourceWith(final Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddQuestionBankResourcePopup addQuestionBankResourcePopup = resources.clickAddQuestionBankResource();
        resources = addQuestionBankResourcePopup.addResource(datatable);
    }

    @And("I should not see a resource with name {string}")
    public void iShouldNotSeeAResourceWithName(final String name) {
        assertion.assertFalse(resources.resourceItemExist(name));
    }

    @When("I remove a resource with name {string}")
    public void iRemoveAResourceWithName(final String name) {
        DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(name);
        resources = deleteResourcePopup.clickDeleteButton();
    }

    @And("I wait for message disappear")
    public void iWaitForMessageDisappear() {
        resources.waitForMessageContainerDisappear();
    }

    @Then("I should see message {string}")
    public void iShouldSeeMessage(final String message) {
        assertion.assertEquals(message, resources.getMessage());
    }

    @And("I create an Add Test Quiz resource with:")
    public void iCreateAnAddTestQuizResourceWith(final Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddTestQuizResourcePopup addTestQuizResourcePopup = resources.clickAddTestQuizResource();
        editAssessmentQuestions = addTestQuizResourcePopup.addResource(datatable);
        context.setContext("ResourceNameKey", datatable.get("name"));
    }

    @And("I added a multiple choice question with:")
    public void iAddedAMultipleChoiceQuestionWith(final Map<String, String> datatable) {
        multipleChoiceQuestion = editAssessmentQuestions.clickAddQuestionMultipleChoice();
        multipleChoiceQuestion.addMultipleChoiceQuestion(datatable);
    }


    @Then("I should see a resource with name {string}")
    public void iShouldSeeAResourceWithName(final String resourceName) {
        assertion.assertTrue(resources.resourceItemExist(resourceName));
    }

    @Then("I comeback to resources page")
    public void iComebackToResourcesPage() {
        multipleChoiceQuestion.backToResourcesPage();
    }

    @And("resource {string} has the question {string}")
    public void resourceHasTheQuestion(final String resourceName, final String questionName) {
        resources.clickEditQuestionsQuizResource(resourceName);
        assertion.assertTrue(editAssessmentQuestions.questionItemExist(questionName));

    }
}


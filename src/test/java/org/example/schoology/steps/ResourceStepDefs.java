package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.schoology.pages.EditAssessmentQuestions;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.MultipleChoiceQuestion;
import org.example.schoology.pages.resources.EditFolderPopup;
import org.example.schoology.pages.resources.AddFolderPopup;
import org.example.schoology.pages.resources.AddQuestionBankResourcePopup;
import org.example.schoology.pages.resources.DeleteResourcePopup;
import org.example.schoology.pages.resources.TestQuizTemplatePopup;
import org.example.schoology.pages.resources.AddTestQuizResourcePopup;
import org.testng.asserts.Assertion;

import java.util.Map;

public class ResourceStepDefs {

    private final ScenarioContext context;
    private Home home;
    private SubMenu subMenu;
    private Resources resources;
    private EditAssessmentQuestions editAssessmentQuestions;
    private MultipleChoiceQuestion multipleChoiceQuestion;
    private TestQuizTemplatePopup testQuizTemplatePopup;
    private final Assertion assertion;

    public ResourceStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context,
                            final Resources resources, final Home home,
                            final TestQuizTemplatePopup testQuizTemplatePopup) {
        assertion = assertionGroup.getAssertion();
        this.home = home;
        this.resources = resources;
        this.testQuizTemplatePopup = testQuizTemplatePopup;
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
        editAssessmentQuestions.goToBackResources();
    }

    @And("resource {string} Assessment has the question {string}")
    public void resourceAssessmentHasTheQuestion(final String resourceName, final String questionName) {
        resources.clickEditQuestionsQuizResource(resourceName);
        assertion.assertTrue(editAssessmentQuestions.questionItemExist(questionName));

    }

    @And("resource {string} Template popup has the question {string}")
    public void resourceTemplatePopupHasTheQuestion(final String resourceName, final String questionName) {
      testQuizTemplatePopup  = resources.clickResourceItem(resourceName);
      assertion.assertTrue(testQuizTemplatePopup.questionItemExist(questionName));
      testQuizTemplatePopup.closeTestQuizTemplatePopup();
    }

    @When("I create an Folder resource with:")
    public void iCreateAnFolderResourceWith(final Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        AddFolderPopup addFolderPopup = resources.clickAddFolderOption();
        addFolderPopup.addResource(datatable);
        context.setContext("ResourceNameKey", datatable.get("name"));
    }

    @When("I edit the {string} resource with:")
    public void iEditTheResourceWith(final String resourceName, final Map<String, String> datatable) {
        resources = home.clickResourcesMenuOption();
        EditFolderPopup editFolderPopup = resources.clickEditFolderOption(resourceName);
        editFolderPopup.editResource(datatable);
        context.setContext("ResourceNameKey", datatable.get("name"));

    }

    @And("I should see a resource with description {string}")
    public void iShouldSeeAResourceWithDescription(final String resourceDescription) {
        assertion.assertTrue(resources.resourceItemExist(resourceDescription));
    }
}


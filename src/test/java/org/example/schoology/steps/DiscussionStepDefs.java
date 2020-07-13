package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.core.AssertionGroup;
import org.example.schoology.pages.disussions.CreateDiscussionPopup;
import org.example.schoology.pages.disussions.Discussion;
import org.example.schoology.pages.disussions.Discussions;
import org.testng.asserts.Assertion;

import java.util.Map;

public class DiscussionStepDefs {

    private final Discussions discussions;
    private Discussion discussion;
    private Assertion assertion;

    public DiscussionStepDefs(final AssertionGroup assertionGroup, final Discussions discussions,
                              final Discussion discussion) {
        assertion = assertionGroup.getAssertion();
        this.discussions = discussions;
        this.discussion = discussion;
    }

    @And("I click on Add Discussion")
    public void iClickAddDiscussionButton() {
        discussions.clickAddDiscussionButton();
    }

    @And("I create a discussion with:")
    public void iCreateADiscussionWith(final Map<String, String> datatable) {
        CreateDiscussionPopup createDiscussionPopup  = discussions.createDiscussion();
        createDiscussionPopup.fill(datatable);
        createDiscussionPopup.createDiscussionButton();
    }

    @Then("I should see the {string} discussion created")
    public void iShouldSeeNewDiscussionInDiscussionList(final String discussionName) {

        assertion.assertEquals(discussionName, discussions.getDiscussionName(discussionName));

    }

    @And("I join to the created discussion")
    public void iJoinTheCreatedDiscussion() {
        discussion = discussions.joinDiscussion();

    }

    @And("I write {string}")
    public void iWriteAComment(final String comment) {
        discussion.setComment(comment);
    }

    @Then("A new comment from Trainer {string} is displayed")
    public void aNewCommentFromTrainerIsDisplayed(final String comment) {
        assertion.assertEquals(comment, discussion.getCommentAuthor());
    }

    @And("the comment displayed is {string}")
    public void commentDisplayedIs(final String comment) {
        assertion.assertEquals(comment, discussion.getCommentText());
    }

    @And("I click on edit the comment")
    public void iClickOnEditTheComment() {
        discussion.clickEditDeleteWraper();
    }

    @And("I update a comment with {string}")
    public void iUpdateAComment(final String comment) {
        discussion.updateComment(comment);
    }
    @Then("the new comment displayed should be {string}")
    public void theNewCommentShouldBe(final String comment) {
        assertion.assertEquals(comment, discussion.getCommentText());
    }

}

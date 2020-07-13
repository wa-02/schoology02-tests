package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.core.AssertionGroup;
import org.example.schoology.pages.disussions.CreateDiscussionPopup;
import org.example.schoology.pages.disussions.Discussions;
import org.testng.asserts.Assertion;

import java.util.Map;

public class DiscussionStepDefs {

    private final Discussions discussions;
    private Assertion assertion;

    public DiscussionStepDefs(final AssertionGroup assertionGroup, final Discussions discussions) {
        assertion = assertionGroup.getAssertion();
        this.discussions = discussions;
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
//        assert(discussionName == discussions.getDiscussionName());
    }

}

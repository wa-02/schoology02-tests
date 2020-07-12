package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.EditGroupPopup;
import org.example.schoology.pages.groups.CreateFolderPopup;
import org.example.schoology.pages.groups.Group;
import org.example.schoology.pages.groups.Groups;
import org.testng.asserts.Assertion;

public class GroupStepDefs {

    private final ScenarioContext context;

    private final Groups groups;

    private Assertion assertion;

    public GroupStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                         final Groups groups, final ScenarioContext context) {
        assertion = assertionGroup.getAssertion();
        this.groups = groups;
        this.context = context;
    }

    @And("I create a group with:")
    public void iCreateAGroupWith(final Map<String, String> datatable) {
        String menu = "Groups";
        SubMenu subMenu = new Home().clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateGroupPopup createGroupPopup = this.groups.clickCreateGroupButton();
        Group group = createGroupPopup.create(datatable);
        context.setContext("GroupKey", datatable.get("name"));
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(final String name, final Map<String, String> datatable) {
        EditGroupPopup editGroupPopup = groups.clickEditGroup(name);
        editGroupPopup.edit(datatable);
    }

    @And("I should see a group with {string} as a name")
    public void iShouldSeeAGroupWithAsName(final String groupName) {
        assertion.assertEquals(groupName, groups.getGroupByName(groupName));
    }

    @And("I enter to {string} group")
    public void iEnterTo(final String groupName) {
        groups.clickGroupName(groupName);
    }

    @And("I post and update:")
    public void iPostAndUpdate(final String postText) {
        assertion.assertEquals(postText, groups.setPost(postText));
    }

    @And("I save the access code")
    public void iSaveTheAccessCode() {
        context.setContext("AccessCode", groups.saveAccessCode());
    }

    @Then("I reset the access code")
    public void iResetTheAccessCode() {
        assertion.assertNotEquals(context.getValue("AccessCode"),
                groups.resetAccessCode());
    }

    @And("I select {string} menuItem")
    public void iSelectMenuItem(final String menuItem) {
        groups.clickInMenuItem(menuItem);
    }

    @And("I add a folder resource to group")
    public void iAddAFolderResourceToGroup(final Map<String, String> datatable) {
        CreateFolderPopup createFolderPopup = groups.clickAddResource();
        createFolderPopup.create(datatable);
    }

    @And("I verified that {string} folder was create")
    public void iVerifiedThatFolderWasCreate(final String folderName) {
        assertion.assertEquals(folderName, groups.getResourcesByName(folderName));
    }

    @Then("I select Leave This Group option")
    public void iSelectLeaveThisGroupOption() {
        groups.clickLeaveGroup();
    }

    @And("I should see the a message:")
    public void iShouldSeeTheAMessage(final String message) {
        assertion.assertEquals(message, new ViewList().getErrorMessage(), "Message banner");
    }
}

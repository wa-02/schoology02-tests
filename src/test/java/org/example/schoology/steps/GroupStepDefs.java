package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.EditGroupPopup;
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
}

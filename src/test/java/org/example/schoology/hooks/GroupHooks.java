package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.ScenarioContext;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.groups.DeleteGroupPopup;
import org.example.schoology.pages.groups.Groups;
import org.example.core.ui.DriverFactory;

public class GroupHooks {

    private ScenarioContext context;

    public GroupHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios
    }


    @After(value = "@deleteGroup")
    public void deleteCourse() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        SubMenu subMenu = new Home().clickMenu("Groups");
        subMenu.clickViewListLink("Groups");
        DeleteGroupPopup deleteGroupPopup = new Groups().clickDeleteGroup(context.getValue("GroupKey"));
        deleteGroupPopup.clickDeleteButton();
    }

}

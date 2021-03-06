package org.example.schoology.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.testng.asserts.Assertion;

public class CommonStepDefs {

    private final Assertion assertion;

    private Home home;

    public CommonStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup) {
        assertion = assertionGroup.getAssertion();
    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(final String account) {
        Login login = new Login();
        home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
                Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
    }

    @And("I log out of user")
    public void iLogOutOfUser() {
        home.clickLogout();
    }

    @When("I navigate to {string}")
    public void iNavigateToCourses(final String menu) {
        SubMenu subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(final String message) {
        assertion.assertEquals(message, new ViewList().getMessage(), "Message banner");
    }

}

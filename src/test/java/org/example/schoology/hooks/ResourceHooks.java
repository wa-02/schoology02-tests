package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Resources;
import org.example.schoology.pages.resources.DeleteResourcePopup;

/**
 * <h1>Resource Hooks</h1>
 * This class contains all the methods to be executed before and also after of each scenario.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class ResourceHooks {

    private ScenarioContext context;

    public ResourceHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios

    }

    @After(value = "@deleteResource")
    public void deleteResource() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        Resources resources = new Home().clickResourcesMenuOption();
        DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(context.getValue("ResourceNameKey"));
        deleteResourcePopup.clickDeleteButton();
    }
}

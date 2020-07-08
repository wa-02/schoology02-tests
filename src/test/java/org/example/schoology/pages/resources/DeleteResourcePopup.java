package org.example.schoology.pages.resources;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * <h1>Delete Resource Popup</h1>
 * This class represents a Delete Resource Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class DeleteResourcePopup extends AbstractPage {

    private WebDriver driver;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    public Resources clickDeleteButton() {
        action.click(deleteButton);
        return new Resources();
    }
}

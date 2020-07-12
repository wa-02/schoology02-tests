package org.example.schoology.pages.resources;

import org.example.schoology.pages.Resources;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * <h1>Edit folder Popup</h1>
 * This class represents an Edit Folder Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-11
 */
public class EditFolderPopup extends AbstractResourcePopup {

    @FindBy(css = "input[value='Save Changes']")
    private WebElement editFolderSaveChangesButton;

    public EditFolderPopup() {
        super();
    }

    public Resources editResource(final Map<String, String> resourceMap) {
        fillEditFolderForm(resourceMap);
        action.click(editFolderSaveChangesButton);
        return new Resources();
    }
}

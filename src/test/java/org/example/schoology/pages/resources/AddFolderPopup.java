package org.example.schoology.pages.resources;

import org.example.schoology.pages.Resources;

import java.util.Map;

/**
 * <h1>Add Folder Popup</h1>
 * This class represents an Add Folder Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-11
 */
public class AddFolderPopup extends AbstractResourcePopup {
    public AddFolderPopup() {
        super();
    }

    public Resources addResource(final Map<String, String> resourceMap) {
        fillAddFolderForm(resourceMap);
        action.click(addQuestionBankSubmitButton);
        return new Resources();
    }
}

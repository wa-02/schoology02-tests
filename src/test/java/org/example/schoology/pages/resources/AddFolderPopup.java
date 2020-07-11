package org.example.schoology.pages.resources;

import org.example.schoology.pages.Resources;

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

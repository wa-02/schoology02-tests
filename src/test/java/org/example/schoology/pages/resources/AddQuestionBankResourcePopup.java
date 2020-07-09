package org.example.schoology.pages.resources;

import org.example.schoology.pages.Resources;

import java.util.Map;

/**
 * <h1>Add Question Bank Resource Popup</h1>
 * This class represents an Add Question Bank Resource Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class AddQuestionBankResourcePopup extends AbstractResourcePopup {

    public AddQuestionBankResourcePopup() {
        super();
    }

    public Resources addResource(final Map<String, String> resourceMap) {
        fillAddQuestionBankForm(resourceMap);
        action.click(addQuestionBankSubmitButton);
        return new Resources();
    }

}

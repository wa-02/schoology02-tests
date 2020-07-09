package org.example.schoology.pages.resources;

import org.example.schoology.pages.EditAssessmentQuestions;

import java.util.Map;

/**
 * <h1>Add Test/Quiz Resource Popup</h1>
 * This class represents an Add Test/Quiz Resource Popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class AddTestQuizResourcePopup extends AbstractResourcePopup {

    public AddTestQuizResourcePopup() {
        super();
    }

    public EditAssessmentQuestions addResource(final Map<String, String> resourceMap) {
        fillAddTestQuizForm(resourceMap);
        action.click(addTestQuizSubmitButton);
        return new EditAssessmentQuestions();
    }
}


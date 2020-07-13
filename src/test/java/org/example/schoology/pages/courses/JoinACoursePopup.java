package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinACoursePopup extends AbstractPage {
    @FindBy(css = "#edit-invite-code")
    private WebElement accessCodeTextField;

    @FindBy(css = "#edit-submit")
    protected WebElement joinButton;

    private void setAccessCode(final String code) {
        action.setValue(accessCodeTextField, code);
    }

    public Courses joinCourse(final String code) {
        setAccessCode(code);
        action.click(joinButton);
        return new Courses();
    }
}

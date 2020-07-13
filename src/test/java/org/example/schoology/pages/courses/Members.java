package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Members extends AbstractPage {

    public static final String XPATH_MEMBER_OPTION =
            "//tr[contains(.,'%s')]//following::div[@class=\"action-links-unfold \"]";

    public static final String XPATH_MEMBER_NAME = "//tr[contains(.,'%s')]//td[@class=\"user-picture\"]";

    @FindBy(css = "ul[style=\"display: block;\"] li.enrollment-unenroll")
    private WebElement removeButton;

    public DeleteMemberPopup removeMember(final String memberName) {
        action.click(By.xpath(String.format(XPATH_MEMBER_OPTION, memberName)));
        action.click(removeButton);

        return new DeleteMemberPopup();
    }

    public boolean memberExists(final String memberName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath(String.format(XPATH_MEMBER_NAME, memberName))));
        return action.isElementDisplayedOnScreen(By.xpath(String.format(XPATH_MEMBER_NAME, memberName)));
    }
}

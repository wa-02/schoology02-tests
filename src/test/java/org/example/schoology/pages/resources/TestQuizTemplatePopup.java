package org.example.schoology.pages.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * <h1>Test Quiz Template Popup</h1>
 * This class represents a Test Quiz Delete popup.
 * This class contains all the related object elements and actions for the mentioned page.
 *
 * @author  Miguel Tancara
 * @version 1.0
 * @since   2020-07-08
 */
public class TestQuizTemplatePopup extends AbstractResourcePopup {

    public static final String RESOURCE_ITEM_QUESTION = "//p[text()='%s']";

    @FindBy(css = "a[href='javascript://']")
    private WebElement closePopup;


    public TestQuizTemplatePopup() {
            super();
        }

    public boolean questionItemExist(final String questionName) {
         return action.isElementDisplayedOnScreen(By.xpath(String.format(RESOURCE_ITEM_QUESTION, questionName)));

    }

    public void closeTestQuizTemplatePopup() {
        action.click(closePopup);
    }

}

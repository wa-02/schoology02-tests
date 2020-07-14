package org.example.schoology.pages.groups;

import java.util.HashMap;
import java.util.Map;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public abstract class AbstractGroupPopup extends AbstractPage {

    public static final String COLOR_BUTTON =  "//div[@data-color='%s' and @role='button']";

    @FindBy(css = "#edit-name")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-group-code")
    private WebElement groupCodeField;

    @FindBy(css = "#edit-privacy-level")
    private WebElement privacyField;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessField;

    @FindBy(css = "#edit-category")
    private WebElement categoryField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    @FindBy(css = "#edit-title")
    private WebElement titleField;


    public void fill(final Map<String, String> groupMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setName(groupMap.get("name")));
        stepMap.put("description", () -> setDescription(groupMap.get("description")));
        stepMap.put("groupCode", () -> setGroupCode(groupMap.get("groupCode")));
        stepMap.put("privacy", () -> selectPrivacy(groupMap.get("privacy")));
        stepMap.put("access", () -> selectAccess(groupMap.get("access")));
        stepMap.put("category", () -> selectCategory(groupMap.get("category")));

        for (final String keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setName(final String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setDescription(final String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void setGroupCode(final String code) {
        groupCodeField.clear();
        groupCodeField.sendKeys(code);
    }

    public void selectPrivacy(final String privacy) {
        Select selectPrivacy = new Select(privacyField);
        selectPrivacy.selectByVisibleText(privacy);
    }

    public void selectAccess(final String access) {
        Select selectAccess = new Select(accessField);
        selectAccess.selectByVisibleText(access);
    }

    public void selectCategory(final String category) {
        Select selectCategory = new Select(categoryField);
        selectCategory.selectByVisibleText(category);
    }

    public void fillFolderData(final Map<String, String> groupMap) {
        Map<String, Step> stepMap = new HashMap<>();
        stepMap.put("name", () -> setTittle(groupMap.get("name")));
        stepMap.put("description", () -> setDescriptionFrame(groupMap.get("description")));
        stepMap.put("folderColor", () -> selecColor(groupMap.get("folderColor")));

        for (final String keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setTittle(final String code) {
        titleField.clear();
        titleField.sendKeys(code);
    }

    public void selecColor(final String code) {
        driver.findElement(By.xpath(String.format(COLOR_BUTTON, code))).click();
    }

    public void setDescriptionFrame(final String code) {
        driver.switchTo().frame("edit-description_ifr");
        driver.findElement(By.xpath("//body/p")).sendKeys(code);
        driver.switchTo().defaultContent();
    }

}

package org.example.schoology.pages.courses;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class Course extends AbstractPage {

    private final By cssCourseProfile = By.cssSelector("#course-profile-materials");

    public static final String XPATH_COURSE_OPTION = "//a[contains(text(),'%s')]";

    @FindAll({
            @FindBy(css = "#course-profile-materials"),
            @FindBy(css = "#cursos-profile-materials")
    })
    private WebElement courseProfileMaterials;

    @FindBy(css = "span.enrollment-code")
    private WebElement accessCode;

    public Course() {
        wait.until(ExpectedConditions.visibilityOf(courseProfileMaterials));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssCourseProfile));
    }

    public String getAccessCode() {
        return accessCode.getText();
    }

    public Map<String, Object> allOptions() {
        Map<String, Object> resources = new HashMap<>();
        resources.put("Updates", new Updates());
        resources.put("Members", new Members());

        return resources;
    }

    public Object selectCourseOption(final String nameOption) {
        action.click(driver.findElement(By.xpath(String.format(XPATH_COURSE_OPTION, nameOption))));
        return allOptions().get(nameOption);
    }
}

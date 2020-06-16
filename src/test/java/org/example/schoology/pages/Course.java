package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Course extends AbstractPage {

	private final By cssCourseProfile = By.cssSelector("#course-profile-materials");

	@FindBy(css = "#course-profile-materials")
	private WebElement courseProfileMaterials;

	public Course() {
		wait.until(ExpectedConditions.visibilityOf(courseProfileMaterials));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cssCourseProfile));
	}
}

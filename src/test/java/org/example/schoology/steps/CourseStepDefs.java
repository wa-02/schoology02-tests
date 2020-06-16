package org.example.schoology.steps;

import io.cucumber.java.en.And;

import org.example.schoology.SharedDriver;
import org.example.schoology.pages.*;
import org.junit.Assert;

import java.util.Map;

public class CourseStepDefs {

	private SubMenu subMenu;

	private Courses courses;


	private Home home;

	public CourseStepDefs(SharedDriver sharedDriver, Home home, Courses courses) {
		this.home = home;
		this.courses = courses;
	}

	@And("I create a course with:")
	public void iCreateACourseWith(Map<String, String> datatable) {
		String menu = "Courses";
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
		CreateCoursePopup createCoursePopup = this.courses.clickCreateCourseButton();
		Course course = createCoursePopup.create(datatable);
	}

	@And("I edit the {string} course with:")
	public void iEditTheCourseWith(String Name, Map<String, String> datatable) {
		EditCoursePopup editCoursePopup = courses.clickEditCourse(Name);
		courses = editCoursePopup.edit(datatable);
	}

	@And("I should see the {string} section on {string} course item")
	public void iShouldSeeTheSectionOnCourseItem(String expectedSection, String courseName) {
		Assert.assertEquals(expectedSection, courses.getSectionByName(courseName));
	}

}

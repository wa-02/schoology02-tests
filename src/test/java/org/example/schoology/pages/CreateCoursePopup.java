package org.example.schoology.pages;

import java.util.Map;

public class CreateCoursePopup extends AbstractCoursePopup {

	public Course create(Map<String, String> courseMap) {
		fill(courseMap);
		submitButton.click();
		return new Course();
	}

}

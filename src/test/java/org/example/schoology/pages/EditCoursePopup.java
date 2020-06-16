package org.example.schoology.pages;

import java.util.Map;

public class EditCoursePopup extends AbstractCoursePopup {

	public Courses edit(Map<String, String> courseMap) {
		fill(courseMap);
		submitButton.click();
		return new Courses();
	}

}

package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

	/**
	 * This only works for Courses and Groups
	 * Resources and More menu has another behavior.
	 * @param menuName
	 * @return
	 */
	public SubMenu clickMenu(String menuName) {
		driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))).click();
		return new SubMenu();
	}

}

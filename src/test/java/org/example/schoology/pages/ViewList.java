package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewList extends AbstractPage {

	@FindBy(css = ".messages .message-text")
	private WebElement messages;

	public String getMessage() {
		return messages.getText();
	}

}

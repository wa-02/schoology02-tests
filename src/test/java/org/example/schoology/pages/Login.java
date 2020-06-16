package org.example.schoology.pages;

import org.example.schoology.AbstractPage;
import org.example.schoology.account.Account;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Login extends AbstractPage {

	// This info should come from config file.
	public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
	public static final int MIN_IMPLICIT_TIMEOUT = 3;
	private static final Account ACCOUNT = Account.getInstance();

	@FindBy(css = "#edit-mail")
	private WebElement usernameTextField;

	@FindBy(css = "#edit-pass")
	private WebElement passwordTextField;

	@FindBy(css = "#edit-submit")
	private WebElement loginButton;

	@FindBy(css = "#confirmation_cancel")
	private WebElement cancelVerifyYourAccountButton;

	public Login() {
		driver.get("https://app.schoology.com/login");
		PageFactory.initElements(driver, this);
	}

	public Home loginAs(String account) {
		String username = ACCOUNT.getValue(String.format("%s.credentials.username", account));
		String password = ACCOUNT.getValue(String.format("%s.credentials.password", account));
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		verifyYourAccount();
		return new Home();
	}

	private void verifyYourAccount() {
		try {
//			// Changing timeout
			driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			cancelVerifyYourAccountButton.click();
		} catch (NoSuchElementException e) {
			// nothing.
		} finally {
//			// Restore timeout
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		}
	}

}

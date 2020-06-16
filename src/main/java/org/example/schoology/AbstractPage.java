package org.example.schoology;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

	public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;

	protected WebDriver driver;

	protected WebDriverWait wait;

	public AbstractPage() {
		this.driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
}

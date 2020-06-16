package org.example.schoology;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserFactory {

	private static final Map<String, Supplier<AbstractBrowser>> BROWSERS = new HashMap<>();
	static {
		BROWSERS.put("chrome", Chrome::new);
		BROWSERS.put("firefox", Firefox::new);
		BROWSERS.put("headless", Headless::new);
	}

	public static WebDriver getBrowser(String browser) {
		return BROWSERS.getOrDefault(browser, Chrome::new).get().init();
	}

}

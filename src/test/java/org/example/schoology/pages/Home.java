package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */

    public static final String XPATH_LOGOUT_USER = "//div[text()='%s']";
    public static final String XPATH_OPTION_USER = "//a[text()='%s']";


    public SubMenu clickMenu(final String menuName) {
        action.click(By.xpath(String.format("//span[text()='%s']/parent::button", menuName)));
        return new SubMenu();
    }

    public Resources clickResourcesMenuOption() {
        action.click(By.xpath("//header[@class='_1SIMq _3v0y7 _349XD']/descendant::a[@href='/resources']"));
        return new Resources();
    }

    public void displayAccountOptions(final String account){
        WebElement accountOptionsDropdown = driver.findElement(By.xpath(String.format(XPATH_LOGOUT_USER,
                account)));
        accountOptionsDropdown.click();
    }

    public void selectAccountOption(final String option){
        WebElement accountOption= driver.findElement(By.xpath(String.format(XPATH_OPTION_USER,
                option)));
        accountOption.click();
    }

    public Login clickLogout(final String account){
        displayAccountOptions(account);
        selectAccountOption("Logout");
        return new Login();
    }
}

package org.example.schoology.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */

    public SubMenu clickMenu(final String menuName) {
        action.click(By.xpath(String.format("//span[text()='%s']/parent::button", menuName)));
        return new SubMenu();
    }

    public Resources clickResourcesMenuOption() {
        action.click(By.xpath("//header[@class='_1SIMq _3v0y7 _349XD']/descendant::a[@href='/resources']"));
        return new Resources();
    }

    public void displayAccountOptions() {
        action.click(By.cssSelector("[data-sgy-sitenav=\"header-my-account-menu\"]"));
    }

    public void selectAccountOption(final String option) {
        action.click(By.xpath(String.format("//a[text()='%s']", option)));
    }

    public Login clickLogout() {
        displayAccountOptions();
        selectAccountOption("Logout");
        return new Login();
    }
}

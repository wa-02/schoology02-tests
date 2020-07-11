package org.example.schoology.pages.groups;

import org.openqa.selenium.By;

import java.util.Map;

public class CreateFolderPopup extends AbstractGroupPopup {

    public static final String CREATE_BUTTON =  "//input[@id='edit-submit' and @value='Create']";

    public Groups create(Map<String, String> datatable) {
        fillFolderData(datatable);
        driver.findElement(By.xpath(CREATE_BUTTON)).click();
        return new Groups();
    }
}

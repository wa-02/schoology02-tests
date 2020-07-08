/*package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class  ResourcesTest {

    public static final String PREFIX_AT = "AT_";

    @Test
    public void removeResource() {

        // Given
        Login login = new Login();
        Home home = login.loginAs("mixmeil@gmail.com", "Control123");
        Resources resources =  home.clickResourcesMenuOption();
        AddResourcePopup addResourcePopup = resources.clickAddResource("Add Question Bank");

        String questionBankName = PREFIX_AT + "Test Question Bank" + System.currentTimeMillis();
        Map<String, String> resourceMap = new HashMap<>();
        resourceMap.put("name", questionBankName);
        resourceMap.put("description", "MT - This is a description text, only for testing purposes");
        String enableQuestionTracking = "True";

        resources = addResourcePopup.AddResource(resourceMap, enableQuestionTracking);
        resources.waitForMessageContainerDisappear();

        // When
        DeleteResourcePopup deleteResourcePopup = resources.clickRemoveResource(questionBankName);
        resources = deleteResourcePopup.clickDeleteButton();

        // Then
        Assert.assertEquals("Your item has been removed.", resources.getMessage());
        resources.waitForMessageContainerDisappear();
        Assert.assertFalse(resources.resourceItemExist(questionBankName));



    }

}*/

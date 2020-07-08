/*
package org.example.schoology.tests;


import org.example.schoology.pages.Groups;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.CreateGroupPopup;
import org.example.schoology.pages.EditGroupPopup;
import org.example.schoology.pages.GroupPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GroupsTest {
    public static final String PREFIX_AT = "AT_";

    @Test
    public void editGroup() {

        // Given
        Login login = new Login();
        Home home = login.loginAs("mixmeil@gmail.com", "Control123");
        SubMenu subMenu = home.clickMenu("Groups");
        Groups groups = subMenu.clickMyGroupsLink();
        CreateGroupPopup createGroupPopup = groups.clickCreateGroupButton();
        String groupName = PREFIX_AT + "Test Group" + System.currentTimeMillis();

        Map<String, String> groupMap = new HashMap<>();

        */
/*Attempt 01*//*

        groupMap.put("name", groupName);
        groupMap.put("description", "MT - This is a Description Text, only for testing purposes");
        groupMap.put("privacy", "School");
        groupMap.put("access", "Allow Requests");
        groupMap.put("category", "General");


        */
/*Attempt 02*//*

        */
/*groupMap.put("name","MT - Test Group");
        groupMap.put("description", "MT - This is a Description Text, only for testing purposes");
        groupMap.put("privacy", "No One");
        groupMap.put("access", "Open");*//*


        */
/*Attempt 03*//*

        */
/*groupMap.put("name","MT - Test Group");
        groupMap.put("description", "Nothing to see here");*//*

        GroupPage groupPage = createGroupPopup.create(groupMap);

        //When
        subMenu = home.clickMenu("Groups");
        groups = subMenu.clickMyGroupsLink();
        EditGroupPopup editGroupPopup = groups.clickEditGroup(groupName);
        groupMap = new HashMap<>();
        groupMap.put("description", "MT - This is an updated description");
        groupMap.put("category", "Sports Groups");
        groups = editGroupPopup.edit(groupMap);

        //Then
        Assert.assertEquals(groupName + " has been saved.", groups.getMessage());








    }

}
*/

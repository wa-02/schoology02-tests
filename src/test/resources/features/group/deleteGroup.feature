Feature: Group

  Scenario: delete group
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | groupTest         |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I navigate to "Groups"
    Then I delete the "SeleniumWebDriver" group

  @deleteGroup
  Scenario: Failed message to leave the group
    Given I log in as "GroupInstructor02" user
    When I create a group with:
      | name        | SeleniumWebDriver_deleteGroup |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    Then I select Leave This Group option
    And I should see the a message:
      """
      Since you are a group admin, you cannot leave until you make at least one other member an admin.
      """

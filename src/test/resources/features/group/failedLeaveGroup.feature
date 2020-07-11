Feature: Group

  @deleteGroup
  Scenario: Failed message to leave the group
    Given I log in as "GroupInstructor01" user
    When I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    Then I select Leave This Group option
    And I should see the a message:
      """
      Since you are a group admin, you cannot leave until you make at least one other member an admin.
      """
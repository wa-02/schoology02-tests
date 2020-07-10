Feature: Group

  @deleteGroup
  Scenario: Post update
    Given I log in as "GroupInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    #When I navigate to "Groups"
    #And I enter to "groupTest" group
    And I post and update:
      """
      test post update in groups
      """

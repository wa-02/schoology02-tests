Feature: Group

  @deleteGroup
  Scenario: Post update
    Given I log in as "GroupInstructor01" user
    When I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    Then I post and update:
      """
      test post update in groups
      """
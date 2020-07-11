Feature: Group

  @deleteGroup
  Scenario: Reset access code
    Given I log in as "GroupInstructor01" user
    When I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    And I save the access code
    Then I reset the access code
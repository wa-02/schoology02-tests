Feature: Group

  @deleteGroup
  Scenario: delete group
    Given I log in as "GroupInstructor01" user
    When I create a group with:
      | name        | groupTest         |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    Then I navigate to "Groups"


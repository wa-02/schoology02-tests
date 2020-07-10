Feature: Group

  @deleteGroup
  Scenario: delete group
    Given I log in as "GroupInstructor01" user
    And I create a group with:
      | name        | groupTest         |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I navigate to "Groups"


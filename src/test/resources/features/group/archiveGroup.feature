Feature: Groups

  Scenario: Archive a group
    Given I log in as "GroupInstructor02" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I navigate to "Groups"
    And I archive the "SeleniumWebDriver" group
    Then I navigate to Archive tab
    And I should see a group with "SeleniumWebDriver" as a name
    And I delete the "SeleniumWebDriver" group


  @deleteGroup
  Scenario: Restore a group
    Given I log in as "GroupInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    And I navigate to "Groups"
    And I archive the "SeleniumWebDriver" group
    And I navigate to Archive tab
    And I should see a group with "SeleniumWebDriver" as a name
    When I restore the "SeleniumWebDriver" group
    Then I navigate to Current tab
    And I should see a group with "SeleniumWebDriver" as a name

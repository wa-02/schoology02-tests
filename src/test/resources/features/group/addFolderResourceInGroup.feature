Feature: Group

  @deleteGroup
  Scenario: Add Folder Resource in a group
    Given I log in as "GroupInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I select "Resources" menuItem
    And I add a folder resource to group:
      | name        | testFolder       |
      | description | Description      |
      | folderColor | green            |
    Then I verified that "testFolder" folder was create
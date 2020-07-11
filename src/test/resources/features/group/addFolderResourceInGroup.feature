Feature: Group

  @deleteGroup
  Scenario: Add Folder Resource in a group
    Given I log in as "GroupInstructor01" user
    When I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    And I select "Resources" menuItem
    And I add a folder resource to group
      | name        | testFolder       |
      | description | Description      |
      | folderColor | green            |
    And I verified that "testFolder" folder was create
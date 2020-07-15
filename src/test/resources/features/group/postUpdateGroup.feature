Feature: Group

  @deleteGroup
  Scenario: Post update
    Given I log in as "GroupInstructor02" user
    And I create a group with:
      | name        | SeleniumWebDriver_update  |
      | description | Description               |
      | privacy     | School                    |
      | access      | Invite Only               |
      | category    | Musical Groups            |
    When I select "Updates" menuItem
    Then I post and update:
      """
      test post update in groups
      """
# new feature
# Tags: optional

Feature: Group Discussion feature

  @deleteGroup
  Scenario: delete a group discussion as a trainer
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver_delete_discussion|
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I click to Discussions menu
    And I click on Add Discussion
    And I create a discussion with:
      | title        | testDiscussion_to_delete  |
      | description  | test discussion  |
    And I see the "testDiscussion_to_delete" discussion listed
    And I click on delete Discussion icon
    And I click on delete button
    Then discussion is removed from discussion list


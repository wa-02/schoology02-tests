# new feature
# Tags: optional

Feature: Group Discussion feature

  @softAssert @deleteGroup
  Scenario: create a group discussion as a trainer
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver_add_discussion |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I click to Discussions menu
    And I click on Add Discussion
    And I create a discussion with:
      | title        | testDiscussion_add   |
      | description  | test discussion  |
    Then I should see the "testDiscussion_add" discussion created

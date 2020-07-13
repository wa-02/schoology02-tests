# new feature
# Tags: optional

Feature: Create a Group Discussion

  @softAssert @deleteGroup
  Scenario: create a group discussion as a trainer
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I click to Discussions menu
    And I click on Add Discussion
    And I create a discussion with:
      | title        | testDiscussion   |
      | description  | test discussion  |
    And I join to the created discussion
    And I write "a Comment"
    Then A new comment from Trainer "Course Instructor01" is displayed
    And the comment displayed is "a Comment"
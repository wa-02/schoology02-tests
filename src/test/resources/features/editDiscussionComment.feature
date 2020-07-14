# Tags: optional

Feature: Group Discussion feature

  @deleteGroup
  Scenario: create a group discussion as a trainer
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | MZ_SeleniumWebDriver |
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I click to Discussions menu
    And I click on Add Discussion
    And I create a discussion with:
      | title        | testDiscussion to update  |
      | description  | test discussion  |
    And I join to the created discussion
    And I write "a Comment"
    And I click on edit the comment
    And I update a comment with "a comment updated"
    Then the new comment displayed should be "a comment updated"
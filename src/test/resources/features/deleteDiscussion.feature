# new feature
# Tags: optional

Feature: Group Discussion feature

  @softAssert @deleteGroup
  Scenario: delete a group discussion as a trainer
    Given I log in as "CourseInstructor01" user
    And I create a group with:
      | name        | SeleniumWebDriver MZ2|
      | description | Description       |
      | privacy     | School            |
      | access      | Invite Only       |
      | category    | Musical Groups    |
    When I click to Discussions menu
    And I click on Add Discussion
    And I create a discussion with:
      | title        | testDiscussion   |
      | description  | test discussion  |
    And I see the "SeleniumWebDriver" discussion listed
    And I click on delete Discussion icon

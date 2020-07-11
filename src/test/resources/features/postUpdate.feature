# new feature
# Tags: optional

Feature: Post an update

  @deleteCourse
  Scenario: post an update as student in a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | Mat01             |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I get the access code of course
    And I log out of user
    And I log in as "CourseStudent01" user
    When I navigate to "Courses"
    And I join a course with access code
    And In "Mat01" course I post "TestUpdate" as "Updates"
    Then I should see the "TestUpdate" in updates section
    And I log out of user
    And I log in as "CourseInstructor01" user

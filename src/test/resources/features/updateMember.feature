# new feature
# Tags: optional

Feature: Update a member

  @deleteCourse
  Scenario: remove a student of a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | DGMat05             |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I get the access code of course
    And I log out of user
    And I log in as "CourseStudent01" user
    And I navigate to "Courses"
    And I join a course with access code
    And I log out of user
    When I log in as "CourseInstructor01" user
    And I navigate to "Courses"
    And I remove "Course Student01" member from "Members" of a "DGMat05" course
    Then I should not see "Course Student01" from members

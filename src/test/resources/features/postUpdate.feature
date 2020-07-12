# new feature
# Tags: optional

Feature: Post an update

  @deleteCourse
  Scenario: post an update as student in a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | DGMat01             |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I get the access code of course
    And I log out of user
    And I log in as "CourseStudent01" user
    When I navigate to "Courses"
    And I join a course with access code
    And In "DGMat01" course I post "TestUpdate" as "Updates"
    Then I should see the "TestUpdate" in updates section
    And I log out of user
    And I log in as "CourseInstructor01" user

  @deleteCourse
  Scenario: edit a student's update as teacher in a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | DGMat02            |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I get the access code of course
    And I log out of user
    And I log in as "CourseStudent01" user
    And I navigate to "Courses"
    And I join a course with access code
    And In "DGMat02" course I post "Test Update" as "Updates"
    And I log out of user
    When I log in as "CourseInstructor01" user
    And I navigate to "Courses"
    And I edit "Test Update" to "Test update edited" in "Updates" of "DGMat02" course
    Then I should see the "Test update edited" in updates section

  @deleteCourse
  Scenario: delete a update as teacher in a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | DGMat03           |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I navigate to "Courses"
    And In "DGMat03" course I post "Test Update" as "Updates"
    When I navigate to "Courses"
    And I delete "Test Update" from "Updates" of "DGMat03"
    Then I should see message "This update has been deleted" in updates
    And I should not see "Test Update" in updates

  @deleteCourse
  Scenario: delete an update as student in a course
    Given I log in as "CourseInstructor01" user
    And I create a course with:
      | name    | DGMat04            |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    And I get the access code of course
    And I log out of user
    When I log in as "CourseStudent01" user
    And I navigate to "Courses"
    And I join a course with access code
    And In "DGMat04" course I post "Test Update" as "Updates"
    And I navigate to "Courses"
    And I delete "Test Update" from "Updates" of "DGMat04"
    Then I should see message "This update has been deleted" in updates
    And I should not see "Test Update" in updates
    And I log out of user
    And I log in as "CourseInstructor01" user

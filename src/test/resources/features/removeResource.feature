Feature: Resources

  @softAssert
  Scenario: Remove a resource
    Given I log in as "ResourceInstructor01" user
    And I create an Add Question Bank resource with:
      | name | MT_TestQuestionBank |
      | description | MT-This_is_a_description_text |
      | enableQuestionTracking | True |
    And I wait for message disappear
    When I remove a resource with name "MT_TestQuestionBank"
    Then I should see message "Your item has been removed."
    And I wait for message disappear
    And I should not see a resource with name "MT_TestQuestionBank"
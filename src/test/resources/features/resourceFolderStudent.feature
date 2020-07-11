Feature: Resources


  Scenario: Create a resource of type: Add Folder.
  @softAssert
  Scenario: Create a resource of type: Add Folder
    Given I log in as "ResourceStudent01" user
    When I create an Folder resource with:
      | name | MT_TestFolder |
      | description | MT-This_is_a_description_sample |
      | colour | yellow |
    Then I should see message "folder has been successfully created."
    And I wait for message disappear
    And I should see a resource with name "MT_TestFolder"


Feature: Resources Folder

  @softAssert @deleteResource
  Scenario: Create a Folder resource
    Given I log in as "ResourceStudent01" user
    When I create an Folder resource with:
      | name | MT_TestFolder |
      | description | MT-This_is_a_description_sample |
      | colour | yellow |
    Then I should see message "MT_TestFolder has been successfully created."
    And I wait for message disappear
    And I should see a resource with name "MT_TestFolder"

  @softAssert
  Scenario: Delete a Folder resource
    Given I log in as "ResourceStudent01" user
    And I create an Folder resource with:
      | name | MT_FolderToBeRemoved |
      | description | MT-This_is_a_description_for_a_folder_to_be_removed |
      | colour | green |
    And I wait for message disappear
    When I remove a resource with name "MT_FolderToBeRemoved"
    Then I should see message "Your item has been removed."
    And I wait for message disappear
    And I should not see a resource with name "MT_FolderToBeRemoved"

  @softAssert @deleteResource
  Scenario: Update a Folder resource
    Given I log in as "ResourceStudent01" user
    And I create an Folder resource with:
      | name | MT_FolderToBeUpdated |
      | description | MT-This_is_a_description_text |
      | colour | black |
    And I wait for message disappear
    When I edit the "MT_FolderToBeUpdated" resource with:
      | name | MT_FolderUpdated |
      | colour | gray |
    Then I should see the "Your changes have been saved." message
    And I should see a resource with name "MT_FolderUpdated"
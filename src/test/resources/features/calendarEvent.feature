Feature: Calendar Event

  @softAssert @deleteEvent
  Scenario: Create a Calendar Event
    Given I log in as "ResourceStudent01" user
    When I create a calendar event with:
      | startDate | 16 |
      | startHour | 10am |
      | endDate | 12/25/20 |
      | endHour | 10:00pm |
      | title | Reminder_Christmas_Gifts |
      | description | MT-This_is_a_remainder_sample |
      | commentsEnabled | true |
    Then I comeback to home page
    And I should see an event with name "Reminder_Christmas_Gifts"

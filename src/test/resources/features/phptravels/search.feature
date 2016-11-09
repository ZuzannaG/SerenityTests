Feature: Search
  In order to test search functionality
  As a user
  I want to specify search conditions

  Background: Opening main page
    Given I am on the landing page

    Scenario: Searching for hotel
      Given I am on the "Hotels" tab
      When I insert "Dubai" into the city search field
      And I select the 1st option from the list
      And I select tomorrow as the start date
      And I select day after tomorrow as the end date
      And I select 4 adults
      And I select 2 children
      And I click Search
      Then I am on the Search Results page
      And I can see that Total Stay is "1 Nights"
      And I can see only hotels in "Dubai"

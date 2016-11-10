Feature: Search
  In order to test search functionality
  As a user
  I want to specify search conditions

  Background: Opening main page
    Given I am on the landing page

  Scenario: Searching for hotel
    Given I am on the "Hotels" tab
    When I insert "Dubai" into the city search field
    And I select the 1 option from the list
    And I select tomorrow as the check in date
    And I select day after tomorrow as the checkout date
    And I select 4 adults
    And I select 2 children
    And I click Search
    Then I am on the Search Results page
    And I can see that Total Stay is "1 Nights"
    And I can see only results from "Dubai"

  Scenario: Searching tour by city
    Given I am on the "Tours" tab
    When I insert "Dubai" into the city search field
    And I select the 2 option from the list
    And I select tomorrow as the check in date
    And I select 3 adults
    And I click Search
    Then I am on the Search Results page
    And I can see only results from "Dubai"

  Scenario: Searching tour by type
    Given I am on the "Tours" tab
    When I select tomorrow as the check in date
    And I select 3 adults
    And I select "Holidays" as the tour type
    And I click Search
    Then I am on the Search Results page
    And I can only see results with type "Holidays"

  Scenario: Searching for cars
    Given I am on the "Cars" tab
    When I insert "Manchester" into the pickup location
    Then Selected location is "Manchester"
    When I select tomorrow as the start date
    And I select "10:00" as the pickup time
    And I select day after tomorrow as the end date
    And I select "10:00" as the drop off time
    And I click Search
    Then I am on the Search Results page
    And I can see only results from "Manchester"

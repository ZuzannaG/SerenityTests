Feature: Selectable
  In order to use select functionality
  As a user
  I want to be able to select items

  Scenario: Selecting items
    Given I am on the Selectable page
    When I select 'Item 1'
    Then 'Item 1' is selected
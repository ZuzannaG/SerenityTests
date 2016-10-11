Feature: Selectable

  Scenario: Selecting items
    Given I am on the Selectable page
    When I select 'Item 1'
    Then 'Item 1' is selected
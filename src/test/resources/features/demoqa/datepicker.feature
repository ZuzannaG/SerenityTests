@ignore
Feature: Datepicker

  Scenario: Picking a date
    Given I am on the DatePicker page
    When I click on the date input
    And I select 20th day of the current month
    Then The 20th day of the current month should be in the date input
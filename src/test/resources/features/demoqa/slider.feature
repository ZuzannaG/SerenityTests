Feature: Slider

  Scenario: Sliding
    Given I open the Slider page
    When I slide the slider by 100
    Then The displayed amount is equal to 3
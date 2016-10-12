Feature: Autocomplete

  Scenario: Selecting value from autocomplete list
    Given I am on the autocomplete page
    When I insert 'ja' into the input field
    And I click the 'Java' from the autocomplete list
    Then I should see 'Java' in the input field
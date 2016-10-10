Feature: Search by keyword
  In order for buyers to find what the are looking for
  As a seller
  I want buyers to be able to search for articles by keyword

  Scenario: Search for articles by keyword
    Given I open the homepage
    When I search for 'mouse'
    Then I should see only articles related to 'mouse'
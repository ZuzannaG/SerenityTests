Feature: Login
  In order to test the login functionality
  As a registered user
  I want to specify login conditions

  Background: Flow till Login page
    Given I am on the landing page
    When I click on My Account button
    And I click on Login button
    Then I am on the Login page

    Scenario: Successful login
      When I enter "user@phptravels.com" in the username field
      And I enter "demouser" in the password field
      And I click Login button
      Then I am on My Account page
      And The header contains "John Smith"

    Scenario Outline: Login fail
      When I enter "<Username>" in the username field
      And I enter "<Password>" in the password field
      And I click Login button
      Then I see "Invalid Email or Password" error message

      Examples:
        | Username            | Password      |
        | wrongusername       | demouser      |
        | user@phptravels.com | wrongpassword |
        | wrongusername       | wrongpassword |
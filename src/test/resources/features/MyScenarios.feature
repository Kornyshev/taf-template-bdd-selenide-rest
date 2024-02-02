Feature: My Scenarios

  Scenario: Verify Sign In Page
    Given user navigates to 'Login Page'
    Then user sees Sign In page header text equals to 'Sign in to GitHub' on Login Page

  Scenario: Verify Sign In Page - Failing test
    Given user navigates to 'Login Page'
    Then user sees Sign In page header text equals to 'ERROR' on Login Page

  Scenario: Verify Main Page
    Given user navigates to 'Main Page'
    Then user sees Sign Up email input on Main Page
    And user sees Sign Up button on Main Page

  Scenario: API request
    Given print in console current User data requested via API

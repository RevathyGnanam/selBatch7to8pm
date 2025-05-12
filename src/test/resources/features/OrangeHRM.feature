
Feature: feature test to login functionality and invalid scenarios
@SmokeTesting
  Scenario: Check login is successful with valid credentials
    Given Open the browser
    When Launch the Url
    Then Enter the valid credentials
    Then Click on login button
    Then User should navigate to the home page
    And Verify title of the page
    And Close the browser


  Scenario Outline: Check login with invalid credentials
    Given Open the browser
    When Launch the Url
    Then Enter the invalid credentials<username>and<password>
    Then Click on login button
    And Verify error message of the page
    And Close the browser

    Examples: 
      | username | password     |
      | Admin1   | admin123345  |
      | Admin2   | admin1233456 |

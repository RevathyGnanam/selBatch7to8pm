Feature: feature test to login functionality and invalid scenarios
  Description: Login the functionality and checking the errors

  Background: User logged in
   Given Open the browser
    When Launch the Url

  @SmokeTesting
  Scenario: Check login with invalid credentials
    Then Enter valid credentials
      | username | password     |
      | Admin1   | admin123345  |
      | Admin2   | admin1233456 |
    Then Click on login button
    And Verify error message of the page
    And Close the browser

  @SmokeTesting @RegressionTesting
  Scenario: Check login with invalid credentials
    Then Enter valid credentials
      | username | password     |
      | Admin3   | admin123345  |
      | Admin4   | admin1233456 |
    Then Click on login button
    And Verify error message of the page
    And Close the browser

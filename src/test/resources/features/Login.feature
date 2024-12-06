Feature: Login
  @positive @login
  Scenario: Verify login with valid username and password
    Given User already on login page
    When User fill username and password
    And User click login button
    Then User redirected to Account Overview

  @negative @login
  Scenario: Verify login with invalid username and password
    Given User already on login page
    When User fill invalid username and password
    And User click login button
    Then User failed login and show message error
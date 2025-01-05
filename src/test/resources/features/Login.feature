Feature: Login
  @QaseSuite=Login-A
  @QaseFields={"description":"Login_using_valid_credentials","preconditions":"User_already_registered","severity":"major","priority":"high"}
  @login @positive
  Scenario: Verify login with valid
    Given User already on login page
    When User input username and password
    And User click login button
    Then User redirected to Account Overview

  @QaseSuite=Login-A
  @QaseFields={"description":"Login_using_invalid_credentials","preconditions":"User_already_registered","severity":"major","priority":"high"}
  @login @negative
  Scenario: Verify login with invalid
    Given User already on login page
    When User input invalid username and password
    And User click login button
    Then User failed login and show message error
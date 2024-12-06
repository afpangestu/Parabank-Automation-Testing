Feature: Register
  @positive @register
  Scenario: Verify user success register
    Given User is on parabank homepage
    When User click register link button
    Then User on register page
    When User fill first name and last name
    And User fill address detail
    And User fill valid username and password
    And User fill password confirmation
    When User click register button
    Then User register successfully

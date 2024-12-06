Feature: Register

  @register
  Scenario Outline: Verify user success register
    Given User is on parabank homepage
    When User click register link button
    Then User on register page
    When User fill first name and last name
    And User fill address detail
    And User fill <username> and <password>
    And User fill password confirmation
    When User click register button
    Then User verify register <result>
    Examples:
    | username  | password  | result  |
    | youk1     | youkYES   | passed  |
    | youk2     | youkYES   | passed  |
    | youk3     | youkYES   | passed  |
    | youk4     | youkYES   | passed  |
    | youk1     | youkYES   | failed  |

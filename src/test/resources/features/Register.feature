Feature: Register

  @register
  Scenario Outline: Verify user success register
    Given User is on parabank homepage
    When User click register link button
    Then User on register page
    When User fill name
    And User fill address detail
    And User fill <username> and <password>
    And User fill <confirm> confirmation
    When User click register button
    Then User verify register <result>
    Examples:
    | username  | password  | confirm | result  |
    |           |           |         | failed  |
    | pengguna1 | user123   | user123 | passed  |
    | pengguna1 | user123   | user123 | failed  |
    | pengguna1 | user123   | user123 | failed  |


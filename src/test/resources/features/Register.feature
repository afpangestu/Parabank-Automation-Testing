Feature: Register
  @register
  Scenario Outline: Verify user register
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
    # 1. blank -> failed register
    # 2. valid username, password, confirm password -> success register
    # 3. existing username -> failed register
    # 4. miss-match password -> failed register
    | username | password  | confirm | result          |
    |          |           |         | failed          |
    | daftar11 | user123   | user123 | passed          |
    | daftar11 | user123   | user123 | user exists     |
    | daftar11 | user123   | user    | pass missmatch  |


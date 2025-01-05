Feature: Register

  @QaseSuite=Register-A
  @QaseFields={"description":"Register_using_blank_data","preconditions":"User_already_open_register_page","postconditions":"all_fields_on_the_registration_page_are_displayed","severity":"major","priority":"high"}
  @register @negative
  Scenario Outline: User failed register with blank input
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

  @QaseSuite=Register-A
  @QaseFields={"description":"Register_using_valid_data","preconditions":"User_already_open_register_page","postconditions":"all_fields_on_the_registration_page_are_displayed","severity":"major","priority":"high"}
  @register @positive
  Scenario Outline: User successful register with valid input
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
      | daftar12 | user123   | user123 | passed          |

  @QaseSuite=Register-A
  @QaseFields={"description":"Register_using_existing_username","preconditions":"User_already_open_register_page","postconditions":"all_fields_on_the_registration_page_are_displayed","severity":"major","priority":"high"}
  @register @negative
  Scenario Outline: User failed register with existing username
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
      | daftar12 | user123   | user123 | user exists     |

  @QaseSuite=Register-A
  @QaseFields={"description":"Register_with_password_mismatch","preconditions":"User_already_open_register_page","postconditions":"all_fields_on_the_registration_page_are_displayed","severity":"major","priority":"high"}
  @register @negative
  Scenario Outline: User failed register with password mismatch
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
      | daftar12 | user123   | user    | pass missmatch  |

#  @register
#  Scenario Outline: Verify user register
#    Given User is on parabank homepage
#    When User click register link button
#    Then User on register page
#    When User fill name
#    And User fill address detail
#    And User fill <username> and <password>
#    And User fill <confirm> confirmation
#    When User click register button
#    Then User verify register <result>
#    Examples:
#    # 1. blank -> failed register
#    # 2. valid username, password, confirm password -> success register
#    # 3. existing username -> failed register
#    # 4. miss-match password -> failed register
#      | username | password  | confirm | result          |
#      |          |           |         | failed          |
#      | daftar11 | user123   | user123 | passed          |
#      | daftar11 | user123   | user123 | user exists     |
#      | daftar11 | user123   | user    | pass missmatch  |


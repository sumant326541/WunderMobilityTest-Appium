@login @test
Feature: Login scenarios

  Scenario Outline: Login with invalid user name
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I Tap on login Button
    Then login should fail with an error "<err>"
    Examples:
      | username        | password | err                                          |
      | invalidUsername | 12345678 | Invalid credentials! Please check your data. |

  Scenario Outline: Login with invalid password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I Tap on login Button
    Then login should fail with an error "<err>"
    Examples:
      | username                  | password        | err                                          |
      | qatest@wundermobility.com | invalidPassword | Invalid credentials! Please check your data. |

  Scenario Outline: Login with valid user name and password
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I Tap on login Button
    Then I should see Map page title
    Examples:
      | username                  | password | title   |
      | qatest@wundermobility.com | 12345678 | QA Test |
Feature: Login Action

  Scenario: Successfully login with valid credentials
    Given user is on home page
    When user navigate to login page
    And user enter username and password
    Then message displayed login successfully

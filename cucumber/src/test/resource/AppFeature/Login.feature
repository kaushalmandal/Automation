Feature: LoginFeature

  Scenario: Login with username and password
    Given when user is on home page
    Then user click on login button
    And user provide "kaushal.mandal000@gmail.com" and "kaushal123"
    Then user click on login link
    Then message displayed login successfully

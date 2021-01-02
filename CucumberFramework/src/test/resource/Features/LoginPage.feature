Feature: Login page feature

  Scenario: login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: login with correct credentials
    Given user is on login page
    When user enter username as "kauhsal.mandal000@gmail.com"
    And user enter password as "kaushal123"
    And user click on login button
    Then user gets the title of the page
   # And page title should be "My account - My Store"
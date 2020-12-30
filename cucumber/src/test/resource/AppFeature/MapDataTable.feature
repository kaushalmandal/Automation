Feature: map data table

  Scenario: user registration with different data with column
    Given user is on registration page
    When user enter following data with column
      | First name | Last name | Email id                    |
      | kaushal    | Mandal    | kaushal.mandal000@gmail.com |
      | Kajal      | Mandal    | kajal.mandal000@gmail.com   |
    Then user registration is successfully done

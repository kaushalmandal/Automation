Feature: Account page feature

  Background: 
    Given user is already logged into application
      | username                    | password   |
      | kaushal.mandal000@gmail.com | kaushal123 |

  Scenario: Account page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Account section count
    Given user is on Accounts page
    Then user gets accounts section
      | Order history and details |
      | My credit slips           |
      | My addresses              |
      | My personal information   |
      | My wishlists              |
    And account section count should be 5

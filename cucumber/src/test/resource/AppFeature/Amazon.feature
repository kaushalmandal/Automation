Feature: validating order details

  Background: 
    Given a rigistered user exist
    Given user is on amazon home page
    When user enter username and password
    And user click on the loglin button
    Then user navigate to order page

  Scenario: check previous order detail link
    When user click on previous order link
    Then user check the previous order detail

  Scenario: check open order details
    When user click on open order links
    Then user check the open order details

  Scenario: check cancelled order details
    When user click on cancelled order links
    Then user check the cancelled order details

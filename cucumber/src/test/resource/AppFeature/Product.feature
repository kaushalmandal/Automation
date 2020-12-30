Feature: Search product

  Scenario: search product with price range
    Given user is on product home page
    When user search "apple mac book pro" with price range 100
    Then system should display list of all products
    Then user select the product and add into the cart

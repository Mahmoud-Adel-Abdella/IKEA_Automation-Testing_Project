Feature: Add To Cart
  Scenario: Verify that a product can be added to the shopping cart
    Given User is on Home Page
    When User clicks on lighting category on home page
    And clicks on lamps subcategory
    And selects a random products and click add to cart twice
    Then the cart quantity should be 2
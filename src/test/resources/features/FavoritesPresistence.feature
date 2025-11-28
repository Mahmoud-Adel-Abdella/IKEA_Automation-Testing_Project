Feature: Favorites Persistence
  Scenario: Verify that the favorites is persist in session
    Given User is on home page
    When User adds product to cart
    And User navigates to any category or page
    And Returns to favorites page
    Then Verify that the product is displayed
    When Deletes the products
    Then Verify that the remove message is displayed
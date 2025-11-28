Feature: Category Details & Products Details
  Scenario: Verify that the product details match in category page & product page
    Given User is on home page
    When User navigates to any category
    And Selects any product from the list
    And Clicks on this products
    Then The product details in category list should matches the products details in product page

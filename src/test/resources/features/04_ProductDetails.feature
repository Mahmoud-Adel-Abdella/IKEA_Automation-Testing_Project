Feature: Product Details
  Scenario: Verify that clicking on a product displayed opens the product details page
    Given User should be on home page.
    When User clicks on a random product on the home page
    Then The product details page should be opened
    And The product details in the home page matches the details in the product page

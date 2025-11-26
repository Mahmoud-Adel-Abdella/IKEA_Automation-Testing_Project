Feature: Add to Favorite
  Scenario: Verify that the user can add products to favorite
    Given User should be on Home page
    When User add a random product to favorite
    And Clicks View to open favorite page
    Then The product should be displayed before removing
    And Removes product form favorites

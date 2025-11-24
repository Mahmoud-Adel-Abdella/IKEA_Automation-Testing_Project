Feature: Search Bar Results
  Scenario: Verify that the search ber returns relevant product results
    Given User should be on home page
    When User enters a product keyword like "chair" in search bar
    And click the search icon
    Then The product displayed should be related to the keyword "chair"
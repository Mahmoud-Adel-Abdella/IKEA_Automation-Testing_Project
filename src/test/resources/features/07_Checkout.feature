Feature: Checkout
  Scenario: Verify that the order requires payment details
    Given User should be on home page
    When User search for random product like "chair" and click add to bag
    And User navigates to bag page
    And click on Checkout button

Feature: Checkout
  Scenario: Verify that the order requires payment details
    Given User should be on home page
    When User search for random product like "chair" and click add to bag
    And User navigates to bag page
    And clicks on Checkout button
    And fills billing address with valid data
    And User continue to pay
    And User selects payment method without fill and click Pay
    Then Payment is failed and error message appears "Your Order Has Payment Failure"
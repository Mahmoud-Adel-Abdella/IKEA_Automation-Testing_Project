Feature: Footer Links Navigation
  Scenario: Verify that footer links works correctly
    Given User is on the home page
    When User scrolls to footer
    And Click on footer link (Terms and Conditions)
    Then The user should be redirected to (Terms and Conditions) Page
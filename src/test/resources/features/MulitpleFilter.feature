Feature: Multiple Filter Combination
  Scenario: Verify that the multiple filters works correctly
    Given User is on home page
    When User navigates to beds category
    And Applys material filter
    And Applys price filter
    Then The result should match both filters
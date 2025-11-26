Feature: Sorting By Price: Low to High
  Scenario: Verify that the products sorted correctly
    Given User is on the home page
    When User Search for "Living Room"
    And Apply filter Price: Low to High
    Then The results must be sorted correctly
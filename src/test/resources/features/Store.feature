Feature: Store
  Scenario: Verify that the user can change the store
    Given User is on home page
    When User clicks on Stores from top menu
    And Selects any Store from list
    Then The Store details should be displayed and matches Store details
Feature: Change Language
  Scenario: Verify that the user can switch language to Arabic
    Given User is on the home page
    When User click on language select button
    And Selects Arabic language
    Then The page content should be is in Arabic
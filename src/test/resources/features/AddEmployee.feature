Feature: Search for employee at PIM

  Scenario: Verify that the employee is displayed after search
    Given User should be logged In
    When User navigate to the PIM module
    And User fills the Employee name field with "Ruford"
    And User clicks on Search Button
    Then Row of Employee details should be displayed
    And The cell First Name content should matches the name field

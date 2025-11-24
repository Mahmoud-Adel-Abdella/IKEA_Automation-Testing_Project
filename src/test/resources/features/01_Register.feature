Feature: User Register
  Scenario: Verify that the new user can register successfully
    Given User is on Home Page
    When User navigates to create account page
    And User enters valid credentials and accepts policy
    And User enters Create Account Button
    Then User should be redirected to profile page

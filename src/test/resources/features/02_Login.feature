Feature: User Login
  Scenario: Verify that an existing user can log in
    Given The user should be registered before
    When User Click on login button
    And Enters Valid email and password
    And Click on Login button
    Then User must be redirected to profile page
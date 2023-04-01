Feature: Login to SSO

  @valid
  Scenario: Login with valid credentials
    Given User navigates to login
    When User enters username
    And User enters password
    And User clicks on login button
    Then User redirects to sso dashboard

  @ulp
  Scenario: Upload reports via ULP
    When Click on ULP tile
    And Click on hotels dropdown
    And User adds the date
    When User uploads reports
    And User clicks on upload button
    Then User gets success message
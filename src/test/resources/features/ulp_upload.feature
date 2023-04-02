Feature: ULP Automation

  @ulp
  Scenario: Upload configured reports
    Given User navigates to ULP
    And Click on hotels dropdown
    And User adds the date
    When User uploads reports
    And User clicks on upload button
    Then User gets success message
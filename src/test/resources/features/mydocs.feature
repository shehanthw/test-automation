Feature: myDocs Automation

  @mydocs
  Scenario: Validate PMS dropdown
    Given MD_Log into SSO
    When MD_Validate PMS dropdown
    Then MD_Quit browser
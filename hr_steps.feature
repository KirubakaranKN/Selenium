Feature: feature to test HR Management functionality
  Scenario: Validate HR Management is working
    Given HR Management is open
    And Login as a HR
    When create a new employee
    Then update employee details

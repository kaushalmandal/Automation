Feature: Test Tagged Hook

  @First
  Scenario: This is first scenario
    Given this is the first step
    When this is the second step
    Then this is the third step

  @Second
  Scenario: this is the second scenario
    Given this is the first step
    When this is the second step
    Then this is the third step

  @Third
  Scenario: this is the third scenario
    Given this is the first step
    When this is the second step
    Then this is the third step

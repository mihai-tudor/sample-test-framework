Feature: Sportsbook site

  Description: Scenarios for testing Sportsbook features

  Background:
    Given User navigates to Williamhill Sports

  Scenario Outline::
    Given I am logged in with username ctmihai and password mihai123
    When I navigate to a <sport> event
    And I add the first active selection to the bet slip
    And I make a bet of 0.05 in bet slip
    Then I should have To Return value on the bet receipt
    And I should have Total Stake value on the bet receipt
    And The user balance should be updated

  Examples:
  | sport |
  | Football |
  | Tennis |
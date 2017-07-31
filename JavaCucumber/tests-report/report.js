$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Sportsbook.feature");
formatter.feature({
  "line": 1,
  "name": "Sportsbook site",
  "description": "\r\nDescription: Scenarios for testing Sportsbook features",
  "id": "sportsbook-site",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": ":",
  "description": "",
  "id": "sportsbook-site;:",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am logged in with username ctmihai and password mihai123",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I navigate to a \u003csport\u003e event",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I add the first active selection to the bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I make a bet of 0.05 in bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I should have To Return value on the bet receipt",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I should have Total Stake value on the bet receipt",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "The user balance should be updated",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "sportsbook-site;:;",
  "rows": [
    {
      "cells": [
        "sport"
      ],
      "line": 18,
      "id": "sportsbook-site;:;;1"
    },
    {
      "cells": [
        "Football"
      ],
      "line": 19,
      "id": "sportsbook-site;:;;2"
    },
    {
      "cells": [
        "Tennis"
      ],
      "line": 20,
      "id": "sportsbook-site;:;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5035641997,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "User navigates to Williamhill Sports",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.User_navigates_to_Williamhill_Sports()"
});
formatter.result({
  "duration": 34287936616,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": ":",
  "description": "",
  "id": "sportsbook-site;:;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am logged in with username ctmihai and password mihai123",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I navigate to a Football event",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I add the first active selection to the bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I make a bet of 0.05 in bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I should have To Return value on the bet receipt",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I should have Total Stake value on the bet receipt",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "The user balance should be updated",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "ctmihai",
      "offset": 29
    },
    {
      "val": "mihai123",
      "offset": 50
    }
  ],
  "location": "StepsDefinition.i_am_logged_in_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 64934797358,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Football",
      "offset": 16
    }
  ],
  "location": "StepsDefinition.i_navigate_to_a_football_event(String)"
});
formatter.result({
  "duration": 1467316006,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_add_the_first_active_selection_to_the_bet_slip()"
});
formatter.result({
  "duration": 2423987648,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.05",
      "offset": 16
    }
  ],
  "location": "StepsDefinition.i_make_a_bet_of_in_bet_slip(String)"
});
formatter.result({
  "duration": 367290121,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_should_have_To_Return_value_on_the_bet_receipt()"
});
formatter.result({
  "duration": 65833241,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_should_have_Total_Stake_value_on_the_bet_receipt()"
});
formatter.result({
  "duration": 26227,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.the_user_balance_should_be_updated()"
});
formatter.result({
  "duration": 28857633,
  "status": "passed"
});
formatter.after({
  "duration": 250528826,
  "status": "passed"
});
formatter.before({
  "duration": 4715246030,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "User navigates to Williamhill Sports",
  "keyword": "Given "
});
formatter.match({
  "location": "StepsDefinition.User_navigates_to_Williamhill_Sports()"
});
formatter.result({
  "duration": 35388179733,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": ":",
  "description": "",
  "id": "sportsbook-site;:;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am logged in with username ctmihai and password mihai123",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I navigate to a Tennis event",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I add the first active selection to the bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I make a bet of 0.05 in bet slip",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I should have To Return value on the bet receipt",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "I should have Total Stake value on the bet receipt",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "The user balance should be updated",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "ctmihai",
      "offset": 29
    },
    {
      "val": "mihai123",
      "offset": 50
    }
  ],
  "location": "StepsDefinition.i_am_logged_in_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 40388005834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tennis",
      "offset": 16
    }
  ],
  "location": "StepsDefinition.i_navigate_to_a_football_event(String)"
});
formatter.result({
  "duration": 1329043621,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_add_the_first_active_selection_to_the_bet_slip()"
});
formatter.result({
  "duration": 2730566867,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.05",
      "offset": 16
    }
  ],
  "location": "StepsDefinition.i_make_a_bet_of_in_bet_slip(String)"
});
formatter.result({
  "duration": 303300215,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_should_have_To_Return_value_on_the_bet_receipt()"
});
formatter.result({
  "duration": 58177669,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.i_should_have_Total_Stake_value_on_the_bet_receipt()"
});
formatter.result({
  "duration": 34210,
  "status": "passed"
});
formatter.match({
  "location": "StepsDefinition.the_user_balance_should_be_updated()"
});
formatter.result({
  "duration": 76527209,
  "status": "passed"
});
formatter.after({
  "duration": 2129143513,
  "status": "passed"
});
});
@bol
Feature: Bol homepage footer links verification
  Agile story: As a user, I want to be able to click any footer link and end up on the right page

  Background:
    Given User is on the Bol homepage

  Scenario:  Verify that all footer links are valid and correct
    When user scroll down to where the footer links are
    Then all footer links have href attributes with valid link
@bol
Feature: Bol dropdown navigation
  Agile story: As a user, I should be able to navigate to any category I want through dropdown menu

  Background:
    Given User is on the Bol homepage

  Scenario: Verify the user is able to go to a specific product category
    When user clicks on Category dropdown
    And user clicks on "Boeken" further on "Taal" finally on "Nederlandse boeken" link
    Then user should only see the Dutch(Nederlands boeken) books
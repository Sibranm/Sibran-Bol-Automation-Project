@bol
Feature: Bol shopping cart functionality
  Agile story: As a user, I should be able to navigate to the shopping cart

  Background:
    Given User is on the Bol homepage

  Scenario: Verify user can navigate to the shopping cart from homepage
    When user clicks on the shopping cart on homepage
    Then user should be able to see "Winkelwagentje" in the title


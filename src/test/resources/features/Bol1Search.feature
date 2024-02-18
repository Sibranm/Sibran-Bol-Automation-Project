@bol
Feature: Bol search functionality
  Agile story: As a user, I should be able to search for a product using search bar

  Background:
    Given User is on the Bol homepage


  Scenario: Verify user is able to search for a product
    When user types "speelgoed" in the search bar and press enter
    Then user should be able to see "speelgoed" in the title



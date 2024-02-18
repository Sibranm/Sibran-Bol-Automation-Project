@bol
Feature: Bol add product to shopping cart
  Agile story: As a user, I should be able to add a product to the shopping cart

  Background:
    Given User is on the Bol homepage

  Scenario: Verify user can add products to shopping cart
    When user types "speelgoed" in the search bar and press enter
    Then the user selects the option to add previously founded item to the cart
    Then the item should be successfully added to the shopping cart
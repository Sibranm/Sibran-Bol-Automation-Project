@bol @wip
Feature: Bol navigate to certain category
  Agile story: As a user, I should be able to go to specific product module I want

  Background:
    Given User is on the Bol homepage

  Scenario: Verify that the user can quickly navigate to a category via the dropdown menu
    When user clicks on Category dropdown
    And user clicks on "Zwanger, Baby & Peuter" further on "Babykamer & Slapen" finally on "Babykamermeubels" link
    Then user ends up on a page that displays "Babykamermeubel" products

  ## we will have endless options to test the navigation process
  Scenario Outline: Verify that the user can quickly navigate to a category via the dropdown menu
    When user clicks on Category dropdown
    And user clicks on "<category1>" further on "<category2>" finally on "<category3>" link
    Then user ends up on a page that displays "<inTitle>" products

    Examples:
      | category1              | category2          | category3        | inTitle         |
      | Zwanger, Baby & Peuter | Babykamer & Slapen | Babykamermeubels | Babykamermeubel |
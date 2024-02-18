@bol
Feature: Bol log in with invalid credentials
  Agile story: As a user, I should get an error message when I enter wrong username or password

  Background:
    Given User is on the Bol homepage


  Scenario Outline: Verify user gets warning message and fails to login with wrong credentials
    When user clicks on login button
    And user enters "<email>" and wrong "<password>" and press enter
    Then there is an error message is displayed "De combinatie van e-mailadres en wachtwoord is niet geldig."

    Examples:
      | email                          | password |
      | sibran.m@outlook.com           | 8hjk1*]  |
      | noname123@gmail.com            | 898hjk*  |
      | emptyname903@outlook.com       | 3040(jk- |
      | anotherAbsurdname777@yahoo.com | jl1980-  |

# Bol.com Automated Testing Framework


## Overview

This project is an automated testing framework for the https://bol.com website. The framework is built using Cucumber BDD, Java, Selenium, and JUnit tools, incorporating design patterns such as Singleton and Page Object Model (POM). There are two different layers of this project. Business-layer which is represented by feature files, written it Gherkin language. Implementation layer includes the step-definitions and all other classes with code.

## Requirements

The automated tests cover the following requirements of the bol.com website:

1.Search for a Product:
* On the homepage, users can search for a product using the search bar.<br>

2.Navigate to Shopping Cart:<br>
* Users can navigate to their shopping cart from the homepage.<br>

3.Add Product to Shopping Cart:<br>
* When searching for a product, users can add the product to their shopping cart.<br>

4.Login with Wrong Credentials:<br>
* Logging in with incorrect credentials displays an appropriate error message.<br>

5.Navigate via Dropdown Menu:<br>
* Users can quickly navigate to the category "Zwanger, Baby & Peuter > Babykamer & Slapen > Babykamermeubels" through the dropdown menu.<br>

6.Apply Filter for Dutch E-books:<br>
* In the "Books" category, users can apply a filter to view only Dutch e-books.<br>

7.Footer Links Validation:<br>
* All footer links on the homepage have an 'href' attribute filled with the correct link.<br>


## Implementation

* The framework is written in Java and utilizes Cucumber for BDD, Selenium for web automation, and JUnit for test execution.<br>

* Design patterns such as Singleton and Page Object Model (POM) are employed for code organization and maintainability.<br>

* Dependencies are managed using Maven.<br>

* A cucumber report is generated to provide detailed test results.<br>


## Project Structure

<br>

![folder_structure.png](src%2Ftest%2Fresources%2Ffiles%2Ffolder_structure.png)
<br>

## Execution

Tests can be executed either from the CukesRunner class or through Maven.<br>


## How to run my framework from terminal with maven

From the top right corner second icon , `Run Anything` Option :
- `mvn clean`
- `mvn test`
- `mvn clean test`
- `mvn clean test -Dcucumber.filter.tags=@TagYouWantToRun`
- This will give us option to provide the tag without changing TestRunner

## Thanks for reading me!
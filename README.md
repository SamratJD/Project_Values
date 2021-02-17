# Project_Values
Sample project for validation of: Values &amp; Total Balance in https://www.exercise1.com/values

## Validations implemented:
1. The count of values in the web page.
2. The values are greater than 0.
3. The values are formatted as currencies.
4. The totalBalance is equal to the sum of all the individual values listed on the web page.


## Pre-requisites for this project:
Requires Java, Maven and Eclipse (or any suitable IDE) to be installed.

## Maven Dependencies:
1. Selenium-java
2. Cucumber-java
3. Cucumber-junit
4. Webdrivermanager

## Script Design:
### Path to Object repository:
`src/test/java/pageObjects`

### Path to Feature files:
`src/test/resources/features`

### Path to Step definition files:
`src/test/java/stepDefinitions`

## Script Execution:
Change the tags in the jUnit runner as per requirements and run.

### Path to Runner file:
`src/test/java/runner`

### Note: 
1. No drivers are required, since WebDriverManager will fetch the required drivers at runtime based on user input
2. Support for Chrome, Firefox and IE browsers is present.

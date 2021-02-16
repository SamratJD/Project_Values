@ValuesFeature
Feature: To perform validation on the values present in Value page

  Background: 
    Given Opened "Chrome" browser
    When Navigated to "https://www.excercise1.com/values" URL

  @ValuesCount
  Scenario: 1. To verify the right count of values appear on the screen
    Then Verify the count of Value labels and Value textboxes are equal
    And Verify the count is "5" for both labels and textboxes

  @GreaterThanZero
  Scenario: 2. To verify the values on the screen are greater than 0
    Then Verify each of the values on the screen are greater than "0"

  @SumOfValues
  Scenario: 3. To verify the total balance is a sum of all the individual values provided
    Then Verify the total balance is equal to sum of all values listed on screen

  @CurrencyFormat
  Scenario: 4. To verify the values are formatted as currencies
    Then Verify the listed values are formatted as currencies

  @TotalBalance
  Scenario: 5. To verify the sum of values listed is equal to the total balance field
    Then Verify the sum of values listed is equal to the total balance field

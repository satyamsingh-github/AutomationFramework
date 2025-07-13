#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Search functionality on Amazon

  Scenario Outline: Search for Product on Amazon
    Given User is on Amazon "<website>"
    #Given All links on the result page are valid
    When User searches for "<product>"
    Then Results for "<product>" are displayed
    And User Clicks on Add to Cart button
    Then "<product>" is added to cart 

    Examples:
      | website   | product   | 
      | fromExcel | fromExcel | 
      | fromExcel | fromExcel | 
      | fromExcel | fromExcel | 


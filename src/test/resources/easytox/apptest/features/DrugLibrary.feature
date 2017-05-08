@Specific
Feature: Drug library

  Background:
    Given the easytox url for drug library
    And I enter username as "lab_admin_username" for drug library
    And I enter password as "lab_admin_password" for drug library
    And click on 'Login' button for drug library
##Scenario 1
#  Scenario Outline: Create a Compound with Type as 'Test Screen'
#    When Go to Libraries -> Compound Library for drug library scenario 1
#    Then Compound page should be open for drug library scenario 1
#
#    When Click 'Create Compound' icon for drug library scenario 1.
#    Then Add Compound screen should be displayed for drug library scenario 1.
#
#    When Enter 'Name' as "<compound>" for drug library scenario 1,
#    And 'Type' as "Test Screen" and for drug library scenario 1
#    And enter all the other data and click Submit for drug library scenario 1.
#    Then A new Compound 'Compound1' should be created successfully  for drug library scenario 1.
#    Examples:
#      | compound  |
#      | Compound1 |
#      | Compound2 |
##Scenario 2
#  Scenario Outline: Create a Compound with Type as 'Validity Testing'
#    When Go to Libraries -> Compound Library for drug library scenario 2
#    Then Compound page should be open for drug library scenario 2
#
#    When Click 'Create Compound' icon for drug library scenario 2.
#    Then Add Compound screen should be displayed for drug library scenario 2.
#
#    When Enter 'Name' as "<compound>" for drug library scenario 2,
#    And 'Type' as "Validity Testing" and for drug library scenario 2
#    And enter all the other data and click Submit for drug library scenario 2.
#    Then A new Compound 'Compound1' should be created successfully  for drug library scenario 2.
#    Examples:
#      | compound   |
#      | VCompound1 |
#      | VCompound2 |
##Scenario 3
#  Scenario: While creating a Drug, verify that the Compounds List doesn’t contain Validity Testing Compunds
#    When Go to Libraries -> Drug Library 'for drug library scenario 3'
#    Then Drug page should be open 'for drug library scenario 3'
#
#    When Click 'Add Drug' icon 'for drug library scenario 3'.
#    Then Add Drug screen should be displayed for drug library scenario 3.
#
#    When Verify the values displayed in 'Compounds' drop down 'for drug library scenario 3'.
#    Then Following values should be displayed in 'Compounds' dropdown: "Compound1" and "Compound2" 'for drug library scenario 3'
#
#    When Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 3'.
#    When Following values should NOT be displayed in 'Compounds' dropdown: "VCompound1" and "VCompound2" 'for drug library scenario 3'
#Scenario 4 nad 5
  Scenario Outline: Create a Drug 'Drug1'
    When Go to Libraries -> Drug Library 'for drug library scenario 4'
    Then Drug' page should be open 'for drug library scenario 4'

    When Click 'Add Drug' icon 'for drug library scenario 4'.
    Then Add Drug screen should be displayed 'for drug library scenario 4'.

    When Enter 'Name' as "<drug>", Select "<compound>" from the drop down and enter all the other data and click Submit 'for drug library scenario 4'.
    Then A new Drug "<drug>" should be created successfully 'for drug library scenario 4'.
    Examples:
      | compound  | drug     |
      | Compound1 | NewDrug1 |
#      | Compound2 | NewDrug2 |

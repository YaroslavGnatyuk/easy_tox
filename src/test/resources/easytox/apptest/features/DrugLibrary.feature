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
#Scenario 2
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
##Scenario 4
#  Scenario Outline: Create a Drug 'Drug'
#    When Go to Libraries -> Drug Library 'for drug library scenario 4'
#    Then Drug' page should be open 'for drug library scenario 4'
#
#    When Click 'Add Drug' icon 'for drug library scenario 4'.
#    Then Add Drug screen should be displayed 'for drug library scenario 4'.
#
#    When Enter 'Name' as "<drug>", Select "<compound>" from the drop down and enter all the other data and click Submit 'for drug library scenario 4'.
#    Then A new Drug "<drug>" should be created successfully 'for drug library scenario 4'.
#    Examples:
#      | compound  | drug     |
#      | Compound1 | NewDrug1 |
#      | Compound2 | NewDrug2 |
#
##Scenario 5
#  Scenario: Validating Compound Test Group
#    When Go to Libraries -> Compound Test Group 'for drug library scenario 5'
#    Then Test Code' page should be open 'for drug library scenario 5'
#
#    When Click 'Add Test Code' icon 'for drug library scenario 5'.
#    Then Add Test Code screen should be displayed 'for drug library scenario 5'.
#
#    When Verify the values displayed in 'Compounds' drop down 'for drug library scenario 5'.
#    Then Following values should be displayed in 'Compounds' dropdown: "Compound1" and "Compound2" 'for drug library scenario 5'
#
#    When Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 5'.
#    Then Following values should NOT be displayed in 'Compounds' dropdown: "VCompound1" and "VCompound2" 'for drug library scenario 5'
#
##Scenario 6
#  Scenario: Create a Compound Test Group
#    When Go to Libraries -> Compound Test Group 'for drug library scenario 6'
#    Then Test Code' page should be open 'for drug library scenario 6'
#
#    When Click 'Add Test Code' icon 'for drug library scenario 6'.
#    Then Add Test Code screen should be displayed 'for drug library scenario 6'.
#
#    When Enter 'Test Code' as "NewCompTestGrp" 'for drug library scenario 6',
#    And Select "Compound1" and "Compound2" from the Compounds drop down and 'for drug library scenario 6'
#    And enter all the other data and click Submit 'for drug library scenario 6'.
#    Then A new Compound "NewCompTestGrp" should be created successfully 'for drug library scenario 6'.
#
##Scenario 7
#  Scenario: Validating ValidityTest Group
#    When Go to Libraries -> Validity Test Group 'for drug library scenario 7'
#    Then Validity Test Code page should be open 'for drug library scenario 7'
#
#    When Click 'Add Validity Test Code' icon 'for drug library scenario 7'.
#    Then Add Validity Test Code screen should be displayed 'for drug library scenario 7'.
#
#    When Verify the values displayed in 'Compounds' drop down 'for drug library scenario 7'.
#    Then Following values should be displayed in 'Compounds' dropdown: "VCompound1" and "VCompound2" 'for drug library scenario 7'
#
#    When Verify the values NOT displayed in 'Compounds' drop down 'for drug library scenario 7'.
#    Then Following values should NOT be displayed in 'Compounds' dropdown: "Compound1" and "Compound2" 'for drug library scenario 7'
#
##Scenario 8
#  Scenario: Create a Validity Test Group
#    When Go to Libraries -> Validity Test Group 'for drug library scenario 8'
#    Then Validity Test Code' page should be open 'for drug library scenario 8'
#
#    When Click 'Add Validity Test Code' icon 'for drug library scenario 8'.
#    Then Add Validity Test Code screen should be displayed 'for drug library scenario 8'.
#
#    When Enter 'ValidityTest Code' as "NewValTestGrp" 'for drug library scenario 8',
#    And Select "VCompound1" and "VCompound2" from the Compounds drop down and 'for drug library scenario 8'
#    And enter all the other data and click Submit 'for drug library scenario 8'.
#    Then A new Compound "NewValTestGrp" should be created successfully 'for drug library scenario 8'.
#
#Scenario 9
  Scenario: Validating Testing Profile
    When Go to Libraries -> Testing Profile 'for drug library scenario 9'
    Then Profile page should be open 'for drug library scenario 9'

    When Click 'Add Profile' icon 'for drug library scenario 9'.
    Then Add Profile screen should be displayed 'for drug library scenario 9'.

    When Verify the values displayed in 'TestScreen Group' drop down 'for drug library scenario 9'.
    Then Following values should be displayed in 'TestScreen Group' dropdown: "NewCompTestGrp1" 'for drug library scenario 9'

    When Verify the values NOT displayed in 'TestScreen Group' drop down 'for drug library scenario 9'.
    Then Following values should NOT be displayed in 'TestScreen Group' dropdown: "NewValTestGrp1" 'for drug library scenario 9'

    When Verify the values displayed in 'Validity Test Group' drop down 'for drug library scenario 9'.
    Then Following values should be displayed in 'Validity Test  Group' dropdown: "NewValTestGrp2" 'for drug library scenario 9'

    When Verify the values NOT displayed in 'Validity Test  Group' drop down 'for drug library scenario 9'.
    Then Following values should NOT be displayed in 'Validity TestScreen Group' dropdown: "NewCompTestGrp" 'for drug library scenario 9'
#
#Scenario 10
  Scenario: Create a Testing Profile
    When Go to Libraries -> Testing Profile for drug library scenario 10'
    Then Profile' page should be open for drug library scenario 10'

    When Click 'Add Profile' icon for drug library scenario 10'.
    Then Add Profile screen should be displayed for drug library scenario 10'.

    When Enter 'Name' as "TestProfile1" for drug library scenario 10'
    And 'Test Screen Group' as "NewCompTestGrp" for drug library scenario 10',
    And 'Validity Test Group' as "NewValTestGrp" for drug library scenario 10',
    And click Submit for drug library scenario 10'.
    Then A new Test Profile "TestProfile1" should be created successfully for drug library scenario 10'.

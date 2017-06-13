@Specific
Feature: Audit and User log

#    #Scenario 1 Create lab
#  Scenario: Create lab
#    When Login with "Username" and "Password" credentials 'for audit and user log 1'
#    Then Lab List screen should be displayed 'for audit and user log 1'.
#
#    When Select 'plus' icon next to search box 'for audit and user log 1'
#    Then Add Lab page should be open 'for audit and user log 1'
#
#    When Enter lab name as "Sujana Lab" and enter all the required details and click on 'Submit' 'for audit and user log 1'
#    Then Added Lab "Sujana Lab" should be displayed in the list 'for audit and user log 1'

    #Scenario 2 Create a Lab Admin
#  Scenario: Create a Lab Admin
#    When Login with "Username" and "Password" credentials 'for audit and user log 2'
#    Then Lab List screen should be displayed 'for audit and user log 2'.
#
#    When Select "Sujana Lab" from the lab list 'for audit and user log 2'.
#    Then Update Lab screen should be displayed 'for audit and user log 2'.
#
#    When Click 'Add User' icon 'for audit and user log 2'.
#    Then Add Lab Admin user screen should be displayed 'for audit and user log 2'.
#
#    When Enter username and password as "Snlabadmin" and "Test@123" and all the other required information 'for audit and user log 2'
#    And click 'Add User' 'for audit and user log 2'.
#    Then Lab Admin "Snlabadmin" should be created successfully and displayed in User List 'for audit and user log 2'.
#
     #Scenario 3 Create a Lab User
#  Scenario: Create a Lab User
#    When Login with "newLabAdminUsername" and "newLabAdminPassword" credentials 'for audit and user log 3'.
#    Then Case List screen should be displayed 'for audit and user log 3'.
#
#    When Select Libraries -> User 'for audit and user log 3'.
#    Then User List screen should be displayed 'for audit and user log 3'.
#
#    When Click on 'plus' icon beside Search box 'for audit and user log 3'.
#    Then Add a Lab User screen should be displayed 'for audit and user log 3'.
#
#    When Enter Username and Password as "labuserone" and "Test@123" 'for audit and user log 3',
#    And Role as "LAB_TECHNICIAN" and enter all the other required information 'for audit and user log 3'
#    And click Submit 'for audit and user log 3'.
#    Then "labuserone" should be added to the user list 'for audit and user log 3'.

#  #Scenario 4 Create a Lab User
#  Scenario: Create a Lab Client
#    When Login with "newLabAdminUsername" and "newLabAdminPassword" credentials 'for audit and user log 4'.
#    Then Case List screen should be displayed 'for audit and user log 4'.
#
#    When Select Libraries -> Lab Client 'for audit and user log 4'.
#    Then LabClient List screen should be displayed 'for audit and user log 4'.
#
#    When Click on 'plus' icon beside Search box 'for audit and user log 4'.
#    Then Add Lab Client screen should be displayed 'for audit and user log 4'.
#
#    When Enter username and password as "SLabClientOne" and "Test@123" 'for audit and user log 4'
#    And Enter all the other required information 'for audit and user log 4'
#    And Click Submit 'for audit and user log 4'.
#    Then "SLabClientOne" should be added to the LabClient list 'for audit and user log 4'.

    #Scenario 5 Create a Lab Physician
#  Scenario: Create a Lab Client
#    When Login with "newLabAdminUsername" and "newLabAdminPassword" credentials 'for audit and user log 5'.
#    Then Case List screen should be displayed 'for audit and user log 5'.
#
#    When Select Libraries -> Physician. 'for audit and user log 5'.
#    Then Physician List screen should be displayed 'for audit and user log 5'.
#
#    When Click on 'plus' icon beside Search box 'for audit and user log 5'.
#    Then Add Physician screen should be displayed 'for audit and user log 5'.
#
#    When Enter username and password as "SPhyOne" and "Test@123" 'for audit and user log 5'
#    And Enter all the other required information 'for audit and user log 5'
#    And Click Submit 'for audit and user log 5'.
#    Then "SPhyOne" should be added to the LabClient list 'for audit and user log 5'.

  #Scenario 6 Verify Audit Log
#  Scenario: Verify Audit Log
#    When Login with "newLabAdminUsername" and "newLabAdminPassword" credentials 'for audit and user log 6'.
#    Then Case List screen should be displayed 'for audit and user log 6'.
#
#    When Select Libraries -> Audit Log 'for audit and user log 6'
#    Then Audit Log Screen should be displayed 'for audit and user log 6'.
#
#    When Verify the values in "Lab Client" drop down 'for audit and user log 6'.
#    Then "SLabClientOne" and "SLabCLientTwo" values should be displayed 'for audit and user log 6'.
#
#    When Verify for other values in "lab Client" drop down 'for audit and user log 6'.
#    Then No other values should be displayed in the Lab Client drop down only "SLabClientOne" and "SLabCLientTwo" 'for audit and user log 6'.
#
#    When Verify the values in "User" drop down 'for audit and user log 6'.
#    Then "SNLabadmin", "SPhyOne", "SPhyTwo", "labuserone" values should be displayed in the User drop down 'for audit and user log 6'.
#
#    When Verify for other values in "User" drop down 'for audit and user log 6'.
#    Then No other values should be displayed in the User drop down only "SNLabadmin", "SPhyOne", "SPhyTwo", "labuserone" 'for audit and user log 6'.
#
#    When Verify the columns displayed in the Audit Log 'for audit and user log 6'.
#    Then Following columns should be displayed in Audit Log: "Modified By","Lab","Lab Client", "Date/Time","Table Name","Column Name","Old Value","New Value","Event Type" 'for audit and user log 6'
#
#    When Verify the values under "Modified By" column 'for audit and user log 6'.
#    Then Only either of the following values should be displayed under "Modified By" column: "Snlabadmin", "SPhyOne", "SPhyTwo", "labuserone".No other values other than above four should be displayed under "Modified By" column 'for audit and user log 6'.
#
#    When Verify the values under "Lab" column 'for audit and user log 6'.
#    Then Value under "Lab" column should be "Sujana Lab" always 'for audit and user log 6'.
#
#    When Verify the values under "Lab Client" column 'for audit and user log 6'.
#    Then Value under "Lab Client" column should be "SLabClientOne" or "SLabClientTwo" only. No other values should be displayed 'for audit and user log 6'.
#
#    When Verify the values under "Date/Time" column 'for audit and user log 6'.
#    Then Date and Time of the individual events in the formats "DD/MMM/YYYY" and "HH:MM:SS" respectively should be displayed 'for audit and user log 6'.

#  Scenario 7
  Scenario: Verify Audit Log filter 'for audit and user log 7'
    When Select a value from "Lab Client" drop down and clcik Search 'for audit and user log 7'.
    Then Results corresponding to selected Lab Client should be displayed 'for audit and user log 7'.

    When Select a value from "User" drop down and click Search 'for audit and user log 7'.
    Then Results corresponding to selected User should be displayed 'for audit and user log 7'.

    When Select From and To Dates in the Date Range and click Search 'for audit and user log 7'.
    Then Only records between the selected date range should be displayed 'for audit and user log 7'.

    When Enter a value in "Table Name" field and click Search 'for audit and user log 7'.
    Then All the records with entered Table Name should be displayed 'for audit and user log 7'.

    When Select an Event Type from the drop down and click Search 'for audit and user log 7'.
    Then ll the records matchin selected "Event Type" should be displayed 'for audit and user log 7'.

    When Select values from two or more filters and click Search 'for audit and user log 7'.
    Then Records as per the entered search criteria should be displayed 'for audit and user log 7'.

    When Click on down arrow icon  on each column name.
    Then Records should be displayed based on the ascending order of the selected column

    When Click on Up arrow icon on each column name.
    Then Records should be displayed based on the descending order of the selected column



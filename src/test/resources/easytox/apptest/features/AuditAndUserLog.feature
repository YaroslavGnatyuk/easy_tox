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
  Scenario: Create a Lab Client
    When Login with "newLabAdminUsername" and "newLabAdminPassword" credentials 'for audit and user log 5'.
    Then Case List screen should be displayed 'for audit and user log 5'.

    When Select Libraries -> Physician. 'for audit and user log 5'.
    Then Physician List screen should be displayed 'for audit and user log 5'.

    When Click on 'plus' icon beside Search box 'for audit and user log 5'.
    Then Add Physician screen should be displayed 'for audit and user log 5'.

    When Enter username and password as "SPhyOne" and "Test@123" 'for audit and user log 5'
    And Enter all the other required information 'for audit and user log 5'
    And Click Submit 'for audit and user log 5'.
    Then "SPhyOne" should be added to the LabClient list 'for audit and user log 5'.

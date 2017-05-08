@Specific
Feature: Verifying the Lab List
Background:
 Given the easytox url
	And I enter username as "username"
	And I enter password as "password"
	And click on "Login" button 
	

  Scenario: Verify Lab User List of particular lab under Action Column
    When Click on user icon under Action Column
    Then User List screen should be displayed.

    
	
	
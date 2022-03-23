Feature: login functionality

@sample
Scenario: User signs in with the newly created account
	Given User navigates to the home page
	And User creates a new account with login "siriabc127@gmail.com" and password "lkdsaklps" and default information
	Then User signs out
	
@sample
Scenario: Verify that the user receives an error message	
	Given User navigates to the home page
	And User signs in with login "siriabc@gmail.com" and password "bbbb" credentials
	Then user receives error message

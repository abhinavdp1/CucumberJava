Feature: This file has registrations tests


Scenario: Verify the User is able to register
Given User goes to https://demoqa.com/registration/
When user fills in the given details registrataion form
			|First Name | Abhinav     |
			| Last Name | Dharmapuri  |
			| Phone Number| 8754570782  | 
			| Username| testuser001 |
			

			

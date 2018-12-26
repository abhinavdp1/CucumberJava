Feature: Login tests

  Scenario Outline: Login with correct username and password
    Given I navigate to login page
    And I enter the <username> and <password>
    And I Click login button
    Then I should see the userform page
    
    Examples: 
    
    | username | password |
    | admin | adminpassword | 

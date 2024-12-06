Feature: Test Login User

 
  Scenario Outline: Login with invalid credential
    Given User open browser
    When User enters invalid email "<email>" and valid password "<password>"
    And User click button login 
    Then login should be failed with an error "<error>"
 
     Examples: 
      | email  | password |error |
      | test1230@yopmail.com |123456789 | Warning: No match for E-Mail Address and/or Password. |
      
      #Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. 
   
 
    Scenario Outline: Login with valid credential
    Given User open browser
    When Enter valid login "<email>" and valid password "<password>"
    And User click button login 
    Then User should connect to home page 
    
    Examples: 
      | email  | password |
      | test-123@yopmail.com |Sssafa199** |
      
      
      
Feature: Check Feature Register User
 

  Scenario Outline: Register with valid data
    Given User open browser to register page
    When User enter valid credential "<firstname>" "<lastname>" "<email>" "<telephone>" "<password>" "<confpassword>"
    And User click button policy
    And User click button register
    Then User create account
  

    Examples: 
      |firstname |lastname |email  |telephone  |password |confpassword |  
      |test |test |test120000@yopmail.com |99556633 |987654321S |987654321S | 
      
      
      
   Scenario Outline: Register with existing email
    Given User open browser to register page
    When User enter valid credential "<firstname>" "<lastname>" "<email>" "<telephone>" "<password>" "<confpassword>"
    And User click button policy
    And User click button register
    Then User have msg error displayed "<msgerror>"
  
   Examples: 
      |firstname |lastname |email  |telephone  |password |confpassword |  msgerror |
      |test |test |test123665@yopmail.com |99556633 |987654321S |987654321S | Warning: E-Mail Address is already registered! |
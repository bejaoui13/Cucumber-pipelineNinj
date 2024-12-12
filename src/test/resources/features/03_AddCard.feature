Feature: Search and Add and Delete product to the cart 
 
 
       
  Scenario Outline: Search product non existing product
      Given User go to home page
      When User enters name product "<productinvalid>" into the search bar
      And  User click on the search button  
      Then User should see message "There is no product that matches the search criteria."
    
      Examples: 
      | productinvalid  |
      | NonExistentProduct |
       
       
  Scenario Outline: Seccessuful search for an existing product 
     Given User logged "<email>" and valid password "<password>" 
      When User enters name product "<product>" into the search bar
     And  User click on the search button
     Then User should see a list of product containing "<product>"

     Examples: 
       | email  | password | product  |
       | test-123@yopmail.com |Sssafa199** | HP LP3065 |
       
  Scenario Outline: Add Product to Card with correct Qte and price
       Given User go to page product
       When User update "<quantity>" 
       And User add product to card
       And User go to shoping card 
       Then User have the price correct in the shoping card "<quantity>"
        
       
      Examples: 
       | product  | quantity | 
       | HP LP3065 | 3  |
      
      
      Scenario Outline: Update quantity page card 
       Given User in the page card shop
       When User update quantity "<updatequantity>" and click on the button 
       Then User have succes alert "<msg>"
         Examples: 
         | updatequantity | msg |
         | 20  | Success: You have modified your shopping cart! ×]|
         
       
       Scenario Outline: Delet product to page card shoping 
       Given User in the page card shop
       When User click on the button deleted 
       Then User dont have product "<nomproduct>" on the page
       Examples: 
       | nomproduct  |  
       | HP LP3065 |  
      
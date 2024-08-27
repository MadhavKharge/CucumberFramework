Feature: Register Functionality

Scenario: User creates account only with mandatory fields
Given User has navigates to Register Account Page
When User enters below details into fields 
|firstName|     Hello             |
|lastname |     world             |
#|email    |  acd@amazom.com    |
|telephone|     1234567890     |
|password |         1234       |
And User selects Privacy Policy
And User clicks on Continue button 
Then User account should get created 

Scenario: User creates account with all mandatory fields
Given User has navigates to Register Account Page
When User enters below details into fields 
|firstName|     Madhav            |
|lastname |     Kharge            |
#|email    |  mv@gamil.com |
|telephone|     1234567890        |
|password |         1234          |
And User select Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User account should get created 

Scenario: User creates duplicate a account
Given User has navigates to Register Account Page
When User enters below details into fields with duplicate email
|firstName|     Madhav            |
|lastname |     Kharge            |
|email    |  madhavkharge22@gmail.com |
|telephone|     1234567890        |
|password |         1234          |
And User select Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User should get a proper warning about duplicate email

Scenario: User should create account without filling any deatils
Given User has navigates to Register Account Page 
When User dont enter any details into fields 
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory field 

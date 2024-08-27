Feature: Search Functionality 

Scenario: User search for valid product
Given User opens the application 
When User enters valid product "HP" into search box field 
And User clicks on search button 
Then User should get valid product displayed in search result

Scenario: User search for invalid product
Given User opens the application 
When User enters invalid product "Headphone" into search box field 
And User clicks on search button 
Then User should get a massage about no product matching

Scenario: User dont enter any product into search field
Given User opens the application 
When User dont enter any product name into search box field 
And User clicks on search button 
Then User should get a massage about no product matching
 

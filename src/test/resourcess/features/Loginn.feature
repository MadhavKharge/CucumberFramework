Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigates to login Page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field 
And User clicks on login button
Then User should get successfully logged in
Examples:
|        username            |  password   |
|madhav.kharge2010@gmail.com | Madhavk@2023|
|madhavkharge22@gmail.com    |  12345      |
|madhavkharge@gmail.com      |  12345      |
Scenario: Login with invalid credentials
Given User has navigates to login Page 
When User enters invalid email address into email field
And User enters invalid password "1234" into password field 
And User clicks on login button
Then User should get a warning massage about credentials mismatch

Scenario: Login with invalid email and valid password 
Given User has navigates to login Page
When User enters valid email address "madhav123@gmail.com" into email field
And User enters invalid password "Madh123" into password field 
And User clicks on login button
Then User should get a warning massage about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigates to login Page
When User enters invalid email address into email field
And User enters valid password "Madh123" into password field 
And User clicks on login button
Then User should get a warning massage about credentials mismatch

Scenario: Login without credentials
Given User has navigates to login Page
When User  dont enters any email address into email field
And User dont enters any password into password field 
And User clicks on login button
Then User should get a warning massage about credentials mismatch



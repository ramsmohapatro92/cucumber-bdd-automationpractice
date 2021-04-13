Feature: Account page feature

Background:  
Given User has already logged into application
|username|password|
|automationtestram@gmail.com| Avaya@468 |

Scenario: Accounts page title
Given User is on Accounts page
When  User gets the title of the page
And The page title should be "My account - My Store"

Scenario: Accounts section count
Given User is on Accounts page
Then User gets account section 
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6
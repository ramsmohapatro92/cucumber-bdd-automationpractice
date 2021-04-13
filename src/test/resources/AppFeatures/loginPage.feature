Feature: Login page feature

#A login functionality test for : http://automationpractice.com/index.php

Scenario: Login page Title
Given User is on login page
When  User gets the title of the page
Then  The page title should be "Login - My Store"

Scenario: Forgot password link
Given User is on login page
When  User gets the title of the page
Then Forget your password link should be displayed
And User is able to click it

Scenario: Login with correct credentials
Given User is on login page
When  User gets the title of the page
When User enters username "automationtestram@gmail.com"
And User enters password "Avaya@469"
And User clicks on login button
When  User gets the title of the page
And The page title should be "My account - My Store"
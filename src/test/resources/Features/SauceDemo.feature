Feature: Sauce Demo Application

Scenario: Validate Login Functionality
Given Sauce user is on the login page
When user enters username as "standard_user" and password as "secret_sauce"
Then user clicks on the login button

Scenario: Validate Home Page Functionality
Given user is on the product page
Then user validates the product page URL
And user validates the product page title
And adds "<product>" to the cart by clicking on the Add to Cart button

Examples:
| product                    |
| Sauce Labs Bolt T-Shirt    |
| Sauce Labs Fleece Jacket   |
| Sauce Labs Backpack        |

Scenario: Validate Checkout Page
Given user is on product page
When  user click on cartButton
And user click on CheckOutButton
When user is on checkOutInfo page firstname "abc" lastname "paq" zip "411014"
Then click on continue button

Scenario: order details page
Given User is on Checkout Overview page
Then capture screenshot
When user click on finsh Button
Then capture screenshot 


Scenario: user logout
When user click on menu button
When sideBar is open and click on logOut

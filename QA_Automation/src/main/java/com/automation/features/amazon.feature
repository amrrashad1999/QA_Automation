Feature: Amazon Purchase Automation

  Scenario: Automate buying video games under 15K EGP
    Given I open Amazon website
    When I log in with "Amr.rashad1999@gmail.com" and "12345678aA!#"
    And I navigate to "All" > "Video Games" > "All Video Games"
    And I apply filters "Free Shipping" and "New Condition"
    And I sort by "Price: High to Low"
    And I add all products below 15K EGP to cart
    Then I verify all products are in the cart
    And I add address and select cash as payment
    Then I verify total price with shipping cost

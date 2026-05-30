@Cucumber @Cart
Feature: Cart test

  @id(Cart_checkCartIsEmpty_1) @checkCartIsEmpty
  Scenario: Check cart is empty
    When Empty current cart
    Then I will verify that games in cart is : ""

  @id(Cart_addGameToCart_1) @addGameToCart
  Scenario: Add game to cart
    When Add game to current cart by name - "The Witcher 3"
    Then I will verify that "The Witcher 3" is present in cart

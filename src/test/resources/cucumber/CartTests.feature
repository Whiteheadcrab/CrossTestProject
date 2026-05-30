@Cucumber @Cart
Feature: Cart test

  @id(Cart_checkCartIsEmpty_1) @checkCartIsEmpty
  Scenario: Check cart is empty
    When Empty current cart
    Then I will verify that games in cart is : ""

  @id(Cart_addGameToCart_1) @addGameToCart
  Scenario Outline: Add game to cart
    When Add game to current cart by name - "<gameName>"
    Then I will verify that games in cart is : "<expectedGames>"

    Examples:
      | gameName                                       | expectedGames                                  |
      | The Witcher 3                                  | The Witcher 3                                  |
      | Sky Jump Legends                               | Sky Jump Legends                               |
      | The Witcher 3, Sky Jump Legends, Space Farmers | The Witcher 3, Sky Jump Legends, Space Farmers |

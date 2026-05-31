@Cucumber @Cart
Feature: Cart test

  @id(Cart_checkCartIsEmpty_1) @checkCartIsEmpty
  Scenario: Check cart is empty
    When Empty current cart
    Then I will verify that games in cart is : ""

  @id(Cart_addGameToCart_1) @addGameToCart
  Scenario Outline: Add game to cart using Name
    When Add game to current cart by name - "<gameName>"
    Then I will verify that games in cart is : "<expectedGames>"

    Examples:
      | gameName                                       | expectedGames                                  |
      | The Witcher 3                                  | The Witcher 3                                  |
      | Sky Jump Legends                               | Sky Jump Legends                               |
      | The Witcher 3, Sky Jump Legends, Space Farmers | The Witcher 3, Sky Jump Legends, Space Farmers |

  @id(Cart_addGameToCart_2) @addGameToCart
  Scenario Outline: Add game to cart using Id
    When Add game to current cart by id - "<gameId>"
    Then I will verify that games in cart is : "<expectedGames>"

    Examples:
      | gameId  | expectedGames                                   |
      | 1       | The Witcher 3                                   |
      | 11      | Sky Jump Legends                                |
      | 1, 11, 4 | The Witcher 3, Sky Jump Legends, Space Farmers |

  @id(Cart_removeGameFromCart_1) @removeGameFromCart
  Scenario Outline: Add games to cart using Name and remove one game
    When Add game to current cart by name - "<gameName>"
    Then I will verify that games in cart is : "<expectedGamesBeforeRemove>"
    When Remove game from current cart by name - "<removedGame>"
    Then I will verify that games in cart is : "<expectedGamesAfterRemove>"

    Examples:
      | gameName                                       | expectedGamesBeforeRemove                      | removedGame        | expectedGamesAfterRemove     |
      | The Witcher 3, Sky Jump Legends                | The Witcher 3, Sky Jump Legends                | The Witcher 3      | Sky Jump Legends             |
      | Space Farmers, Ocean Puzzle Quest              | Space Farmers, Ocean Puzzle Quest              | Ocean Puzzle Quest | Space Farmers                |
      | The Witcher 3, Sky Jump Legends, Space Farmers | The Witcher 3, Sky Jump Legends, Space Farmers | Sky Jump Legends   | The Witcher 3, Space Farmers |

  @id(Cart_removeGameFromCart_2) @removeGameFromCart
  Scenario Outline: Add games to cart using Id and remove one game
    When Add game to current cart by id - "<gameId>"
    Then I will verify that games in cart is : "<expectedGamesBeforeRemove>"
    When Remove game from current cart by name - "<removedGame>"
    Then I will verify that games in cart is : "<expectedGamesAfterRemove>"

    Examples:
      | gameId   | expectedGamesBeforeRemove                      | removedGame        | expectedGamesAfterRemove |
      | 1, 11    | The Witcher 3, Sky Jump Legends                | The Witcher 3      | Sky Jump Legends         |
      | 4, 13    | Space Farmers, Ocean Puzzle Quest              | Ocean Puzzle Quest | Space Farmers            |
      | 1, 11, 4 | The Witcher 3, Sky Jump Legends, Space Farmers | Sky Jump Legends   | The Witcher 3, Space Farmers |

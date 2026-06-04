@Cucumber @Cart
Feature: Cart test

  # Test ideas supported by current cart steps:
    # 1. Verify that total price for empty cart is 0 .
  # 2. Add games by name or id, verify cart total price, then verify cart total price .
  # 3. Add games by name or id, verify cart total price, clear cart, then verify cart total price is 0.
  # 4. Add games by name, buy games in current cart, then verify cart is empty.
  # 5. Add several games, remove one game, clear remaining games, then verify all previously added games are not present.

  @id(Cart_checkCartIsEmpty_1) @checkCartIsEmpty
  Scenario: Check cart is empty
    When Empty current cart
    Then I will verify that games in cart is : ""

  @id(Cart_checkCartIsEmpty_2) @checkCartIsEmpty
  Scenario Outline: Add games to cart, clear cart and check cart is empty
    When Add game to current cart by name - "<gameName>"
    Then I will verify that games in cart is : "<expectedGames>"
    When Empty current cart
    Then I will verify that games in cart is : ""

    Examples:
      | gameName                                       | expectedGames                                  |
      | The Witcher 3                                  | The Witcher 3                                  |
      | Sky Jump Legends, Space Farmers                | Sky Jump Legends, Space Farmers                |
      | Ocean Puzzle Quest, Grand Prix Manager, Retro Arcade Pack | Ocean Puzzle Quest, Grand Prix Manager, Retro Arcade Pack |

  @id(Cart_checkCartIsEmpty_3) @checkCartIsEmpty
  Scenario Outline: Add games to cart, remove game, clear cart and check cart is empty
    When Add game to current cart by name - "<gameName>"
    Then I will verify that games in cart is : "<expectedGamesBeforeRemove>"
    When Remove game from current cart by name - "<removedGame>"
    Then I will verify that games in cart is : "<expectedGamesAfterRemove>"
    When Empty current cart
    Then I will verify that games in cart is : ""

    Examples:
      | gameName                                                                           | expectedGamesBeforeRemove                                                        | removedGame              | expectedGamesAfterRemove                                      |
      | The Witcher 3, Sky Jump Legends                                                    | The Witcher 3, Sky Jump Legends                                                  | The Witcher 3            | Sky Jump Legends                                              |
      | Space Farmers, Ocean Puzzle Quest, Grand Prix Manager                               | Space Farmers, Ocean Puzzle Quest, Grand Prix Manager                            | Ocean Puzzle Quest       | Space Farmers, Grand Prix Manager                            |
      | Evil Hospital: Run from them, Pixel Racing League, Dragon Cafe Manager, Castle Defense Heroes | Evil Hospital: Run from them, Pixel Racing League, Dragon Cafe Manager, Castle Defense Heroes | Pixel Racing League      | Evil Hospital: Run from them, Dragon Cafe Manager, Castle Defense Heroes |

  @id(Cart_checkCartIsEmpty_4) @checkCartIsEmpty
  Scenario Outline: Add games by id, verify games in cart, clear cart, then verify cart is empty
    When Add game to current cart by id - "<gameId>"
    Then I will verify that games in cart is : "<expectedGames>"
    When Empty current cart
    Then I will verify that games in cart is : ""

    Examples:
      | gameId     | expectedGames                                                        |
      | 3, 8       | Evil Hospital: Run from them, Neon Street Fighter                    |
      | 5, 17, 20  | Pixel Racing League, Galaxy Traders MMO, Ultimate Game Mix           |
      | 2, 6, 14   | How to craft everything, Dragon Cafe Manager, Wild Frontier Survival |

  @id(Cart_checkCartIsEmpty_5) @checkCartIsEmpty
  Scenario Outline: Add games by name, verify specific games are present, remove one game, then verify removed game is not present
    When Add game to current cart by name - "<gameName>"
    Then I will verify that "<presentGame>" is present in cart
    When Remove game from current cart by name - "<removedGame>"
    Then I will verify that "<removedGame>" is not present in cart

    Examples:
      | gameName                                                                | presentGame            | removedGame              |
      | Haunted Castle Mystery, Dungeon Cards Online                             | Dungeon Cards Online   | Haunted Castle Mystery   |
      | Battle Arena Prime, Tactical Sports League, Retro Arcade Pack            | Tactical Sports League | Retro Arcade Pack        |
      | Space Farmers, Ocean Puzzle Quest, Grand Prix Manager                    | Grand Prix Manager     | Ocean Puzzle Quest       |

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

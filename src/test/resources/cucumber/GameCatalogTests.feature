@Cucumber @GameCatalog
Feature: Game catalog tests

  @id(GameCatalog_searchByName_1) @searchByName
  Scenario Outline: Search game by name - found game is equal to expected game via name
    When I search game by name "<gameName>"
    Then I will verify that found game name is - "<expectedGameName>"

    Examples:
      | gameName                     | expectedGameName             |
      | Evil Hospital: Run from them | Evil Hospital: Run from them |
      | Sky Jump Legends             | Sky Jump Legends             |
      | Grand Prix Manager           | Grand Prix Manager           |

  @id(GameCatalog_searchByName_2) @searchByName
  Scenario Outline: Search game by name - found game is not equal to expected game via name
    When I search game by name "<gameName>"
    Then I will verify that found game name is not - "<unexpectedGameName>"

    Examples:
      | gameName                     | unexpectedGameName     |
      | Sky Jump Legends             | Tactical Sports League |
      | The Witcher 3                | Castle Defense Heroes  |
      | Evil Hospital: Run from them | Dungeon Cards Online   |

  @id(GameCatalog_searchByName_3) @searchByName
  Scenario Outline: Search game by name - game not found
    When I search game by name "<gameName>"
    Then I will verify that no game was found

    Examples:
      | gameName             |
      | Minecraft            |
      | City Traffic Builder |
      | Underwater Quest     |

  @id(GameCatalog_searchById_1) @searchById
  Scenario Outline: Search game by id - found game is equal to expected game via name
    When I search game by id <gameId>
    Then I will verify that found game name is - "<expectedGameName>"

    Examples:
      | gameId | expectedGameName       |
      | 7      | Castle Defense Heroes  |
      | 14     | Wild Frontier Survival |
      | 18     | Retro Arcade Pack      |

  @id(GameCatalog_searchById_2) @searchById
  Scenario Outline: Search game by id - found game is not equal to expected game via name
    When I search game by id <gameId>
    Then I will verify that found game name is not - "<unexpectedGameName>"

    Examples:
      | gameId | unexpectedGameName           |
      | 14     | Dungeon Cards Online         |
      | 3      | Sky Jump Legends             |
      | 20     | Evil Hospital: Run from them |

  @id(GameCatalog_searchById_3) @searchById
  Scenario Outline: Search game by id - game not found
    When I search game by id <gameId>
    Then I will verify that no game was found

    Examples:
      | gameId |
      | 99     |
      | 21     |
      | 100    |

  @id(GameCatalog_searchByCategory_1) @searchByCategory
  Scenario Outline: Search games by category - found list of games is equal to expected list of games
    When I search games by game's category "<category>"
    Then I will verify that found games  are - "<games>"

    Examples:
      | category | games                                                                                                     |
      | HORROR   | Evil Hospital: Run from them, Haunted Castle Mystery                                                      |
      | PUZZLE   | Dragon Cafe Manager, Moon Colony Architect, Ocean Puzzle Quest, Haunted Castle Mystery, Retro Arcade Pack |
      | MMO      | Dungeon Cards Online, Battle Arena Prime, Galaxy Traders MMO                                              |

  @id(GameCatalog_searchByCategory_2) @searchByCategory
  Scenario Outline: Search games by category - no games found
    When I search games by game's category "<category>"
    Then I will verify that no game was found

    Examples:
      | category |
      | MOBA     |
      | COZY     |
      | STEALTH  |

  @id(GameCatalog_searchByCategory_3) @searchByCategory
  Scenario Outline: Search games by category - found list of games is not equal to expected list of games
    When I search games by game's category "<category>"
    Then I will verify that found games  are not - "<unexpectedGames>"

    Examples:
      | category | unexpectedGames                            |
      | HORROR   | Ocean Puzzle Quest, Retro Arcade Pack      |
      | SPORTS   | Sky Jump Legends, Dungeon Cards Online     |
      | RACING   | Tactical Sports League, Grand Prix Manager |

  @id(GameCatalog_searchByCategories_1) @searchByCategories
  Scenario Outline: Search games by categories - found list of games is equal to expected list of games
    When I search games by game's categories "<categories>"
    Then I will verify that found games  are - "<games>"

    Examples:
      | categories       | games                                                                           |
      | HORROR,ADVENTURE | Haunted Castle Mystery                                                          |
      | RACING,SPORTS    | Pixel Racing League, Grand Prix Manager                                         |
      | ACTION,RPG       | The Witcher 3, Castle Defense Heroes, Wild Frontier Survival, Ultimate Game Mix |

  @id(GameCatalog_searchByCategories_2) @searchByCategories
  Scenario Outline: Search games by categories - no games found
    When I search games by game's categories "<categories>"
    Then I will verify that no game was found

    Examples:
      | categories     |
      | ACTION,PUZZLE  |
      | HORROR,SPORTS  |
      | MMO,RACING     |

  @id(GameCatalog_searchByCategories_3) @searchByCategories
  Scenario Outline: Search games by categories - found list of games is not equal to expected list of games
    When I search games by game's categories "<categories>"
    Then I will verify that found games  are not - "<unexpectedGames>"

    Examples:
      | categories    | unexpectedGames                                      |
      | RACING,SPORTS | Tactical Sports League, Grand Prix Manager           |
      | HORROR,PUZZLE | Evil Hospital: Run from them, Haunted Castle Mystery |
      | ACTION,RPG    | The Witcher 3, Castle Defense Heroes                 |

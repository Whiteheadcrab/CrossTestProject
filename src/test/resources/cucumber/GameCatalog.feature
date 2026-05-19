Feature: Game catalog

  Scenario: Search game by name - found game is equal to expected game via name
    When I search game by name "Evil Hospital: Run from them"
    Then I will verify that found game name is - "Evil Hospital: Run from them"

  Scenario: Search game by name - found game is not equal to expected game via name
    When I search game by name "Sky Jump Legends"
    Then I will verify that found game name is not - "Tactical Sports League"

  Scenario: Search game by name - game not found
    When I search game by name "Minecraft"
    Then I will verify that no game was found

  Scenario: Search game by id - found game is equal to expected game via name
    When I search game by id 7
    Then I will verify that found game name is - "Castle Defense Heroes"

  Scenario: Search game by id - found game is not equal to expected game via name
    When I search game by id 14
    Then I will verify that found game name is not - "Dungeon Cards Online"

  Scenario: Search game by id - game not found
    When I search game by id 99
    Then I will verify that no game was found

  Scenario Outline: Search games by category - found list of games is equal to expected list of games
    When I search games by game's category "<category>"
    Then I will verify that found games  are - "<games>"

    Examples:
      | category | games                                                                                                      |
      | HORROR   | Evil Hospital: Run from them, Haunted Castle Mystery                                                       |
      | PUZZLE   | Dragon Cafe Manager, Moon Colony Architect, Ocean Puzzle Quest, Haunted Castle Mystery, Retro Arcade Pack |

  Scenario Outline: Search games by categories - found list of games is equal to expected list of games
    When I search games by game's categories "<categories>"
    Then I will verify that found games  are - "<games>"

    Examples:
      | categories       | games                                   |
      | HORROR,ADVENTURE | Haunted Castle Mystery                  |
      | RACING,SPORTS    | Pixel Racing League, Grand Prix Manager |

  Scenario: Search games by category - no games found
    When I search games by game's category "MOBA"
    Then I will verify that no game was found

  Scenario: Search games by category - found list of games is not equal to expected list of games
    When I search games by game's category "HORROR"
    Then I will verify that found games  are not - "Ocean Puzzle Quest, Retro Arcade Pack"

  Scenario: Search games by categories - no games found
    When I search games by game's categories "ACTION,PUZZLE"
    Then I will verify that no game was found

  Scenario: Search games by categories - found list of games is not equal to expected list of games
    When I search games by game's categories "RACING,SPORTS"
    Then I will verify that found games  are not - "Tactical Sports League, Grand Prix Manager"

Feature: Game catalog

  Scenario: Search game by name - found game is equal to expected game via name
    When I search game by name "Evil Hospital: Run from them"
    Then I will verify that found game name is - "Evil Hospital: Run from them"

  Scenario: Search game by name - found game is not equal to expected game via name
    When I search game by name "Sky Jump Legends"
    Then I will verify that found game name is not - "Tactical Sports League"

  Scenario: Search game by name - found game is not equal to found game
    When I search game by name "Minecraft"
    Then I will verify that no game was found

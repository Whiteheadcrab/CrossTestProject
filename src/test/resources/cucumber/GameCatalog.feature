Feature: Game catalog

  Scenario: Search game by name - found game is not equal to found game
    When I search game by name "Evil Hospital: Run from them"
    Then I will verify that found game name is not - "Minecraft"

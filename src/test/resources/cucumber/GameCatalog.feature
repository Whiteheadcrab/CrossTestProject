Feature: Game catalog

  ## Require to rethink logic for this scenario
  Scenario: Search game by name - game not found
    When I search game by name "Minecraft"
    Then I verify not able to find game - "Game named 'Minecraft' not found"

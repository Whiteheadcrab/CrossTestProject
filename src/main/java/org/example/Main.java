package org.example;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> gameCatalog = List.of(
                new Game(1, "The Witcher 3", new BigDecimal("39.99"), List.of(Game.Category.RPG, Game.Category.ADVENTURE, Game.Category.ACTION)),
                new Game(2, "How to craft everything", new BigDecimal("14.99"), List.of(Game.Category.SURVIVAL, Game.Category.SANDBOX, Game.Category.SIMULATION)),
                new Game(3, "Evil Hospital: Run from them", new BigDecimal("29.99"), List.of(Game.Category.HORROR, Game.Category.ACTION, Game.Category.SHOOTER)),
                new Game(4, "Space Farmers", new BigDecimal("19.50"), List.of(Game.Category.STRATEGY, Game.Category.SIMULATION, Game.Category.SANDBOX)),
                new Game(5, "Pixel Racing League", new BigDecimal("25.00"), List.of(Game.Category.RACING, Game.Category.ARCADE, Game.Category.SPORTS)),
                new Game(6, "Dragon Cafe Manager", new BigDecimal("40.00"), List.of(Game.Category.SIMULATION, Game.Category.STRATEGY, Game.Category.CARD, Game.Category.PUZZLE)),
                new Game(7, "Castle Defense Heroes", new BigDecimal("9.99"), List.of(Game.Category.STRATEGY, Game.Category.TACTICAL, Game.Category.ACTION, Game.Category.RPG)),
                new Game(8, "Neon Street Fighter", new BigDecimal("34.99"), List.of(Game.Category.FIGHTING, Game.Category.ACTION)),
                new Game(9, "Moon Colony Architect", new BigDecimal("22.50"), List.of(Game.Category.SIMULATION, Game.Category.STRATEGY, Game.Category.SANDBOX, Game.Category.SURVIVAL, Game.Category.PUZZLE)),
                new Game(10, "Dungeon Cards Online", new BigDecimal("11.99"), List.of(Game.Category.CARD, Game.Category.RPG, Game.Category.MMO)),
                new Game(11, "Sky Jump Legends", new BigDecimal("16.49"), List.of(Game.Category.PLATFORMER, Game.Category.ARCADE, Game.Category.ADVENTURE)),
                new Game(12, "Battle Arena Prime", new BigDecimal("44.99"), List.of(Game.Category.SHOOTER, Game.Category.ACTION, Game.Category.TACTICAL, Game.Category.MMO)),
                new Game(13, "Ocean Puzzle Quest", new BigDecimal("7.99"), List.of(Game.Category.PUZZLE)),
                new Game(14, "Wild Frontier Survival", new BigDecimal("27.99"), List.of(Game.Category.SURVIVAL, Game.Category.SANDBOX, Game.Category.ADVENTURE, Game.Category.ACTION, Game.Category.SHOOTER, Game.Category.RPG)),
                new Game(15, "Grand Prix Manager", new BigDecimal("31.00"), List.of(Game.Category.RACING, Game.Category.SPORTS, Game.Category.SIMULATION, Game.Category.STRATEGY)),
                new Game(16, "Haunted Castle Mystery", new BigDecimal("18.75"), List.of(Game.Category.HORROR, Game.Category.ADVENTURE, Game.Category.PUZZLE)),
                new Game(17, "Galaxy Traders MMO", new BigDecimal("49.99"), List.of(Game.Category.MMO, Game.Category.STRATEGY, Game.Category.SIMULATION, Game.Category.SANDBOX, Game.Category.RPG)),
                new Game(18, "Retro Arcade Pack", new BigDecimal("12.49"), List.of(Game.Category.ARCADE, Game.Category.PLATFORMER, Game.Category.RACING, Game.Category.FIGHTING, Game.Category.SHOOTER, Game.Category.PUZZLE, Game.Category.CARD)),
                new Game(19, "Tactical Sports League", new BigDecimal("21.99"), List.of(Game.Category.SPORTS, Game.Category.TACTICAL, Game.Category.STRATEGY)),
                new Game(20, "Ultimate Game Mix", new BigDecimal("59.99"), List.of(Game.Category.ACTION, Game.Category.ADVENTURE, Game.Category.RPG, Game.Category.SHOOTER, Game.Category.RACING, Game.Category.STRATEGY, Game.Category.SIMULATION, Game.Category.ARCADE))
        );

        System.out.println("Game shop");

        // Print out all games
        for (int i = 0; i < gameCatalog.size(); i++) {
            Game game = gameCatalog.get(i);
            System.out.println(game.id() + ". " + game.name() + " - " + game.categories() + " - costs - " + game.price() + "PLN");
        }
    }
}

package org.example;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> gameCatalog = List.of(
                new Game(1, "The Witcher 3", new BigDecimal("39.99"), List.of(Game.Category.RPG)),
                new Game(2, "How to craft everything", new BigDecimal("14.99"), List.of(Game.Category.SURVIVAL)),
                new Game(3, "Evil Hospital: Run from them", new BigDecimal("29.99"), List.of(Game.Category.HORROR)),
                new Game(4, "Space Farmers", new BigDecimal("19.50"), List.of(Game.Category.STRATEGY)),
                new Game(5, "Pixel Racing League", new BigDecimal("25.00"), List.of(Game.Category.RACING)),
                new Game(6, "Dragon Cafe Manager", new BigDecimal("40.00"), List.of(Game.Category.SIMULATION)),
                new Game(7, "Castle Defense Heroes", new BigDecimal("9.99"), List.of(Game.Category.STRATEGY))
        );

        System.out.println("Game shop");

        for (int i = 0; i < gameCatalog.size(); i++) {
            Game game = gameCatalog.get(i);
            System.out.println(game.id() + ". " + game.name() + " - " + game.categories() + " - costs - " + game.price() + "PLN");
        }
    }
}

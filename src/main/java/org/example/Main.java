package org.example;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> gameCatalog = List.of(
                new Game("The Witcher 3", new BigDecimal("39.99"), Game.Category.RPG),
                new Game("How to craft everything", new BigDecimal("14.99"), Game.Category.SURVIVAL),
                new Game("Evil Hospital: Run from them", new BigDecimal("29.99"), Game.Category.HORROR),
                new Game("Space Farmers", new BigDecimal("19.50"), Game.Category.STRATEGY),
                new Game("Pixel Racing League", new BigDecimal("25.00"), Game.Category.RACING),
                new Game("Dragon Cafe Manager", new BigDecimal("40.00"), Game.Category.SIMULATION),
                new Game("Castle Defense Heroes", new BigDecimal("9.99"), Game.Category.STRATEGY)
        );

        System.out.println("Game shop");

        for (int i = 0; i < gameCatalog.size(); i++) {
            Game game = gameCatalog.get(i);
            System.out.println((i + 1) + ". " + game.name() + " - " + game.category() + " - costs - " + game.price() + "PLN");
        }
    }
}

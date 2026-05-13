package org.gameshop;

import java.math.BigDecimal;
import java.util.List;

public record Game(int id, String name, BigDecimal price, List<Category> categories) {

    public Game {
        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("Game must have at least one category");
        }

        //Copy the list inside the record , which prevents from modifying it after creating a Game
        categories = List.copyOf(categories);
    }

    public enum Category {
        ACTION,
        ADVENTURE,
        ARCADE,
        CARD,
        FIGHTING,
        HORROR,
        MMO,
        PLATFORMER,
        PUZZLE,
        RACING,
        RPG,
        SANDBOX,
        SHOOTER,
        SIMULATION,
        SPORTS,
        SURVIVAL,
        STRATEGY,
        TACTICAL;

        // Converter for list of categories
        public static Category from(String value) {
            return Category.valueOf(value.trim().toUpperCase());
        }
    }
}

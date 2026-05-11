package org.example;

import java.math.BigDecimal;
import java.util.List;

public record Game(int id, String name, BigDecimal price, List<Category> categories) {

    public Game {
        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("Game must have at least one category");
        }
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
        TACTICAL
    }
}

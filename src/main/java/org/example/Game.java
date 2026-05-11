package org.example;

import java.math.BigDecimal;

public record Game(int id, String name, BigDecimal price, Category category) {

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

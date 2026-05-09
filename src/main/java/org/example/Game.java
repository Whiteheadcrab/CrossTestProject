package org.example;

import java.math.BigDecimal;

public record Game(int id, String name, BigDecimal price, Category category) {

    public enum Category {
        RPG,
        SURVIVAL,
        RACING,
        STRATEGY,
        SIMULATION,
        HORROR
    }
}

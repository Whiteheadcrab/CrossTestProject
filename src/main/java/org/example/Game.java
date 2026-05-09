package org.example;

import java.math.BigDecimal;

public record Game(String name, BigDecimal price , Category category) {

    public enum Category {
        RPG,
        SURVIVAL,
        RACING,
        STRATEGY,
        SIMULATION,
        HORROR
    }
}

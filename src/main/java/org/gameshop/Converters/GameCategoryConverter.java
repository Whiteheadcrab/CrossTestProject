package org.gameshop.Converters;

import org.gameshop.Game;

import java.util.Arrays;
import java.util.List;

public final class GameCategoryConverter {
    private GameCategoryConverter() {
    }

    public static Game.Category fromText(String value) {
        return Game.Category.valueOf(value.trim().toUpperCase());
    }

    public static List<Game.Category> fromCommaSeparatedText(String values) {
        return Arrays.stream(values.split(","))
                .map(GameCategoryConverter::fromText)
                .toList();
    }
}

package org.gameshop.Converters;

import org.gameshop.Game;

import java.util.Arrays;
import java.util.List;

public final class GameCategoryConverter {
    private GameCategoryConverter() {
    }

    //Converter for variable with single category
    public static Game.Category fromText(String category) {
        return Game.Category.valueOf(category.trim().toUpperCase());
    }

    //Converter for variable with multiple categories
    public static List<Game.Category> fromCommaSeparatedText(String categories) {
        return Arrays.stream(categories.split(","))
                .map(GameCategoryConverter::fromText)
                .toList();
    }
}

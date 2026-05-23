package org.gameshop.Functions;

import org.gameshop.Game;
import org.gameshop.GameCatalogData;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class GameCatalogFunctions {
    //Initialize list for games
    private final List<Game> games = GameCatalogData.getGames();

    //Show list of games
    public List<Game> getAllGames() {
        return games;
    }

    //Function to find game item by its id
    public Game findById(int id) {
        //Verify if id is positive number
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive number");
        }

        //Search game by id
        return games.stream()
                .filter(game -> game.id() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Game with id " + id + " does not exist"));
    }

    //Function to find game item by its category
    public List<Game> findByCategory(Game.Category category) {
        //Verify if category is empty
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }

        //Search games by category
        List<Game> foundGames = games.stream()
                .filter(game -> game.categories().contains(category))
                .toList();

        //Verify if games were found
        if (foundGames.isEmpty()) {
            throw new NoSuchElementException("Games with category " + category + " do not exist");
        }

        return foundGames;
    }

    //Function to find game items that contain all selected categories
    public List<Game> findByCategories(List<Game.Category> categories) {
        //Verify if list of categories is empty
        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("List of Categories cannot be null or empty");
        }

        //Verify if list of categories contains empty value
        if (categories.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Categories cannot contain null values");
        }

        //Search games by categories
        List<Game> foundGames = games.stream()
                .filter(game -> game.categories().containsAll(categories))
                .toList();

        //Verify if games were found
        if (foundGames.isEmpty()) {
            throw new NoSuchElementException("Games with categories " + categories + " do not exist");
        }

        return foundGames;
    }

    //Function to find game item by its name
    public Game findByName(String name) {
        //Verify if name is empty
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        //Search game by name
        return games.stream()
                .filter(game -> game.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Game named '" + name + "' not found"));
    }
}

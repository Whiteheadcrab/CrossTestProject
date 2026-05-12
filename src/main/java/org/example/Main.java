package org.example;

import org.example.gameshop.Game;
import org.example.gameshop.GameCatalog;


public class Main {
    public static void main(String[] args) {
        //Create variable for game list
        GameCatalog gameCatalog = new GameCatalog();

        //Actions per each item in game list
        for (Game game : gameCatalog.getAllGames()) {
            System.out.println(game.id() + ". " + game.name() + " - " + game.categories() + " - costs - " + game.price() + " PLN");
        }
    }
}

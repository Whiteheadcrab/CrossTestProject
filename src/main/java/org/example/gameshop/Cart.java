package org.example.gameshop;

import org.example.Game;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    //Initialize list for games
    private final List<Game> listGames = new ArrayList<>();


    //Add game to list
    public void addGame(Game game)
    {
        listGames.add(game);
    }

    //Remove game to list
    public void removeGame(Game game)
    {
        listGames.remove(game);
    }

    //Show list of game
    public List<Game> getItems()
    {
        return Collections.unmodifiableList(listGames);
    }

    //Show total price for list
    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = BigDecimal.ZERO ;

        for (Game game : listGames)
        {
            totalPrice = totalPrice.add(game.price());
        }
        return totalPrice;
    }
}

package org.example.gameshop;

import org.example.Game;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<Game> listGames = new ArrayList<>();


    public void addGame(Game game)
    {
        listGames.add(game);
    }

    public void removeGame(Game game)
    {
        listGames.remove(game);
    }

    public List<Game> getItems()
    {
        return Collections.unmodifiableList(listGames);
    }

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

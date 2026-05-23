package org.gameshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Cart {
    //Initialize list for games
    private final List<Game> listGames = new ArrayList<>();


    //Add game to list
    public void addGame(Game game) {
        //Not found game for adding
        if (game == null) {
            throw new NoSuchElementException("Game was not found");
        }

        //Check that game is not added already to the list
        boolean gameAlreadyExists = listGames.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());
        if (gameAlreadyExists) {
            throw new IllegalArgumentException("Game with id " + game.id() + " already exists in cart");
        }

        //Add game
        listGames.add(game);
    }

    //Remove game to list
    public void removeGame(Game game) {
        //Not found game for removing
        if (game == null) {
            throw new NoSuchElementException("Game was not found in cart");
        }

        //If possible to remove - value will be true and item to be removed
        boolean gameWasRemoved = listGames.removeIf(cartGame -> cartGame.id() == game.id());

        //If boolean false - show exception
        if (!gameWasRemoved) {
            throw new NoSuchElementException("Game with id " + game.id() + " was not found in cart");
        }
    }

    //Show list of game
    public List<Game> getItems()
    {
        //Verify if cart is empty
        if (listGames == null || listGames.isEmpty()) {
            throw new NoSuchElementException("Cart is empty");
        }

        return Collections.unmodifiableList(listGames);
    }

    //Show total price for list
    public BigDecimal getTotalPrice()
    {
        //Verify if cart is empty
        if (listGames == null || listGames.isEmpty()) {
            throw new NoSuchElementException("Cart is empty");
        }

        BigDecimal totalPrice = BigDecimal.ZERO ;

        for (Game game : listGames)
        {
            totalPrice = totalPrice.add(game.price());
        }
        return totalPrice;
    }

    //Empty cart
    public void emptyCart()
    {
        listGames.clear();
    }

    //Pay for games in cart - will be implemented in future
    public void payForCart()
    {
        throw new UnsupportedOperationException("Payment for cart will be implemented in future");
    }
}

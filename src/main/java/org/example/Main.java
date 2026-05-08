package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("The Witcher 3", new BigDecimal("39.99"));

        System.out.println("Game shop");
        System.out.println(game.name() + " costs " + game.price());
    }
}

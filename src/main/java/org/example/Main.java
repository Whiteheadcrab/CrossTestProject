package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Game game_1 = new Game("The Witcher 3", new BigDecimal("39.99"));
        Game game_2 = new Game("How to craft everything", new BigDecimal("14.99"));
        Game game_3 = new Game("Evil Hospital: Run from them", new BigDecimal("29.99"));
        Game game_4 = new Game("Space Farmers", new BigDecimal("19.50"));
        Game game_5 = new Game("Pixel Racing League", new BigDecimal("25.00"));
        Game game_6 = new Game("Dragon Cafe Manager", new BigDecimal("40.00"));
        Game game_7 = new Game("Castle Defense Heroes", new BigDecimal("9.99"));

        System.out.println("Game shop");
        System.out.println("1. " + game_1.name() + " - costs - " + game_1.price() + "PLN");
        System.out.println("2. " + game_2.name() + " - costs - " + game_1.price() + "PLN");
        System.out.println("3. " + game_3.name() + " - costs - " + game_1.price() + "PLN");
        System.out.println("4. " + game_4.name() + " - costs - " + game_4.price() + "PLN");
        System.out.println("5. " + game_5.name() + " - costs - " + game_5.price() + "PLN");
        System.out.println("6. " + game_6.name() + " - costs - " + game_6.price() + "PLN");
        System.out.println("7. " + game_7.name() + " - costs - " + game_7.price() + "PLN");
    }
}

package cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.gameshop.Game;
import org.gameshop.Functions.CartFunctions;
import org.gameshop.Functions.GameCatalogFunctions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {

    private final GameCatalogFunctions gameCatalog = new GameCatalogFunctions();

    @When("Add game to current cart by name - {string}")
    public void addGameToCartViaName(String gameName, List<Game> cart) {
        Game game = gameCatalog.findByName(gameName);

        // Check that cart is exist
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Check that game is not present in cart
        boolean gameAlreadyExists = !cart.isEmpty() && cart.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());
        if (gameAlreadyExists) {
            throw new IllegalArgumentException("Game with name '" + gameName + "'"
                    + " already exists in cart. Duplication is not allowed");
        }

        //Add game to cart
        cart.add(game);
    }

    @When("Add game to current cart by id - {int}")
    public void addGameToCartViaId(int gameId, List<Game> cart) {
        Game game = gameCatalog.findById(gameId);

        // Check that cart is exist
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Check that game is not present in cart
        boolean gameAlreadyExists = !cart.isEmpty() && cart.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());
        if (gameAlreadyExists) {
            throw new IllegalArgumentException("Game with id " + gameId
                    + " already exists in cart. Duplication is not allowed");
        }

        //Add game to cart
        cart.add(game);
    }

    @When("Remove game from current cart by name - {string}")
    public void removeGameFromCart(List<Game> cart, String gameName) {
        checkPresenceOfGameInCart(cart, gameName, "is");

        Game game = gameCatalog.findByName(gameName);
        cart.removeIf(cartGame -> cartGame.id() == game.id());
    }

    @When("Empty current cart")
    public void emptyCart(List<Game> cart) {
        if (cart != null) {
            cart.clear();
        }
    }

    @Then("^I will verify that \"([^\"]*)\" (is|is not) present in cart$")
    public void checkPresenceOfGameInCart(List<Game> cart, String gameName, String equalityMode) {
        //Find game by Name
        Game game = gameCatalog.findByName(gameName);

        //Check that game is in cart
        boolean gameIsPresent = cart != null && !cart.isEmpty() && cart.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());

        switch (equalityMode) {
            case "is":
            {
                assertTrue(gameIsPresent, "Game is not present in cart");
            }
            break;
            case "is not":
            {
                assertFalse(gameIsPresent, "Game should not be present in cart");
            }
            break;
        }
    }

    @Then("^I will verify that games in cart (is|is not) : \"([^\"]*)\"$")
    public void checktGameListInCart(List<Game> cart, String equalityMode, String expectedGameNames) {
        //Variable for creating list based on expectedGameNames
        List<String> actualGameNames = new ArrayList<>();

        //If cart is not empty - transfer name of games from List<Game> into List<String>
        if (cart != null && !cart.isEmpty()) {
            actualGameNames = cart.stream()
                    .map(Game::name)
                    .sorted()
                    .toList();
        }

        //Create variable List<String> and put in it fame from expectedGameNames
        List<String> expectedGameNameList = expectedGameNames.isBlank()
                ? new ArrayList<>()
                : Arrays.stream(expectedGameNames.split(","))
                        .map(String::trim)
                        .sorted()
                        .toList();

        //Assert equality between expected and actual list of game's name in cart
        switch (equalityMode) {
            case "is":
            {
                assertEquals(expectedGameNameList, actualGameNames,
                        "Expected games in cart to be " + expectedGameNameList + ", but found " + actualGameNames);
            }
            break;
            case "is not":
            {
                assertNotEquals(expectedGameNameList, actualGameNames,
                        "Games in cart should not be " + expectedGameNameList);
            }
            break;
        }
    }

    @Then("^I will verify that cart total price (is|is not) - ([0-9]+(?:\\.[0-9]+)?)$")
    public void checkPriceOfGamesInCart(List<Game> cart, String equalityMode, BigDecimal expectedPrice) {
        //Create variable for actual price
        BigDecimal actualPrice = BigDecimal.ZERO;

        //If cart is not empty - add games into car and use get total price for games in cart
        if (cart != null && !cart.isEmpty()) {
            CartFunctions cartFunctions = new CartFunctions();

            for (Game game : cart)
            {
                cartFunctions.addGame(game);
            }
            actualPrice = cartFunctions.getTotalPrice();
        }

        //Assert equality between expected and actual total price of games in cart
        switch (equalityMode) {
            case "is":
            {
                assertEquals(expectedPrice, actualPrice,
                        "Expected cart total price to be " + expectedPrice + ", but found " + actualPrice);
            }
            break;
            case "is not":
            {
                assertNotEquals(expectedPrice, actualPrice,
                        "Cart total price should not be " + expectedPrice);
            }
            break;
        }
    }


    public void buyGamesInCart(Game game) {
        //For now, it will do the same as emptyCart , but will be different message
        // Later with developing payment and account system will need to change it
    }

    public void checkOwningGameByAccount(Game game) {
        //For now, it will do nothing
        //With developing account system
    }
}

package cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.gameshop.Game;
import org.gameshop.Functions.GameCatalogFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        checkPresenceOfGameInCart(cart, gameName);

        Game game = gameCatalog.findByName(gameName);
        cart.removeIf(cartGame -> cartGame.id() == game.id());
    }

    @Then("I will verify that {string} is present in cart")
    public void checkPresenceOfGameInCart(List<Game> cart, String gameName) {
        //Check that cart is existing
        if (cart == null || cart.isEmpty()) {
            throw new NoSuchElementException("Cart is empty or does not exist");
        }

        //Find game by Name
        Game game = gameCatalog.findByName(gameName);

        //Check that game is in cart
        boolean gameIsPresent = cart.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());
        if (!gameIsPresent) {
            throw new NoSuchElementException("Game is not present in cart");
        }
    }

    public List<Game> getGameListInCart(Game game) {
        List<Game> gameList = new ArrayList<>();
        return gameList;
    }

    public String checkPriceOfGamesInCart(Game game) {
        String checkResult = null;
        return checkResult;
    }


    public void emptyCart(Game game) {}

    public void buyGamesInCart(Game game) {
        //For now, it will do the same as emptyCart , but will be different message
        // Later with developing payment and account system will need to change it
    }

    public void checkOwningGameByAccount(Game game) {
        //For now, it will do nothing
        //With developing account system
    }
}

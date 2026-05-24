package cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.gameshop.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CartSteps {

    public void addGameToCart(Game game) {}

    public void removeGameFromCart(Game game) {}

    @Then("I will verify that {game} is present in cart")
    public void checkPresenceOfGameInCart(List<Game> cart, Game game) {
        //Check that cart is existing
        if (cart == null || cart.isEmpty()) {
            throw new NoSuchElementException("Cart is empty or does not exist");
        }

        //Check that game is in cart
        boolean gameIsPresent = game != null && cart.stream()
                .anyMatch(cartGame -> cartGame.id() == game.id());
        if (!gameIsPresent) {
            throw new NoSuchElementException("Game is not in current cart");
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

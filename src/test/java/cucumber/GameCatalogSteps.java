package cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.gameshop.Game;
import org.gameshop.Converters.GameCategoryConverter;
import org.gameshop.GameCatalog;

import java.util.*;

public class GameCatalogSteps {

    //Lit for found games
    private List<Game> foundGames = new ArrayList<>();
    //Created object for Game catalog
    private final GameCatalog gameCatalog = new GameCatalog();
    //Created object for game
    private Game foundGame;
    //Parameter for indicating absence of game via game name search
    private NoSuchElementException notFoundError;
    //Create Map for inserted parameters
    private Map<String, String> parameters;

    //Created for setting up parameters used for testing
    @Given("Set parameter")
    public void setParameter(DataTable dataTable) {
        parameters = dataTable.asMaps().get(0);
    }

    @When("I search game by id {int}")
    public Game searchGameById(int id) {
        foundGame =  gameCatalog.findById(id);
        return foundGame;
    }

    @When("I search game by name {string}")
    public Game searchGameByName(String name) {
        notFoundError = null;
        try {
            foundGame = gameCatalog.findByName(name);
        } catch (NoSuchElementException error) {
            foundGame = null;
            notFoundError = error;
        }
        return foundGame;
    }

    @When("I search games by game's category {string}")
    public List<Game> searchGameByGameCategory(String gameCategory) {
        foundGames = gameCatalog.findByCategory(Game.Category.valueOf(gameCategory));
        return foundGames;
    }

    @When("I search games by game's categories {string}")
    public List<Game> searchGameByGameCategories(String gameCategories) {
        List<Game.Category> categories = GameCategoryConverter.fromCommaSeparatedText(gameCategories);

        foundGames = gameCatalog.findByCategories(categories);
        return foundGames;
    }

    @Then("I verify found game is {string}")
    public void verifyFoundGame(String expectedGameName) {
        if (notFoundError != null) {
            throw new AssertionError(notFoundError.getMessage());
        }

        if (!foundGame.name().equals(expectedGameName)) {
            throw new AssertionError("Expected " + expectedGameName + ", but found " + foundGame.name());
        }
    }

    @Then("I verify not able to find game - {string}")
    public void verifyNotAbleToFindGame(String expectedErrorMessage) {
        if (notFoundError == null) {
            throw new AssertionError("Expected game search error, but game was found: " + foundGame);
        }

        if (!notFoundError.getMessage().equals(expectedErrorMessage)) {
            throw new AssertionError("Expected " + expectedErrorMessage + ", but found " + notFoundError.getMessage());
        }
    }

    // Requires fix: {game} is not registered as a Cucumber parameter type yet.
//    @Then("I verify found game all data similar to {game}")
//    public void verifyFoundGameData(Game expectedGame) {
//        if (!foundGame.equals(expectedGame)) {
//            throw new AssertionError("Expected and actual game data are not equal" +
//                    "\n" + "Expected data -" + expectedGame +
//                    "\n" + "Actual data -" + foundGame);
//        }
//    }
}

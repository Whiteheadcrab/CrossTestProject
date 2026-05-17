package cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.gameshop.Game;
import org.gameshop.Converters.GameCategoryConverter;
import org.gameshop.GameCatalog;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        foundGame = gameCatalog.findById(id);
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

    @Then("^I will verify that found game name (is|is not) - \"([^\"]*)\"$")
    public void verifyFoundGame(String equalityMode, String expectedGameName) {
        // if foundGame is null, then foundGame.name() will throw NullPointerException before assertEquals runs
        if (notFoundError != null) {
            throw new AssertionError(notFoundError.getMessage());
        }
        switch (equalityMode) {
            case "is":
            {
                    assertEquals(expectedGameName, foundGame.name(),
                            "Expected game name to be " + expectedGameName + ", but found " + foundGame.name());

            }
            break;
            case "is not":
            {
                    assertNotEquals(expectedGameName, foundGame.name(),
                            "Game should not be " + expectedGameName);
            }
            break;
        }
    }
}

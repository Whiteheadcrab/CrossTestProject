package cucumber;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.gameshop.Game;
import org.gameshop.Converters.GameCategoryConverter;
import org.gameshop.GameCatalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GameCatalogSteps {

    //Lit for found games
    private List<Game> foundGames = new ArrayList<>();
    //Created object for Game catalog
    private final GameCatalog gameCatalog = new GameCatalog();
    //Created object for game
    private Game foundGame;
    //Parameter for indicating absence of game via game name search
    private NoSuchElementException notFoundError;

    @When("I search game by id {int}")
    public Game searchGameById(int id) {
        notFoundError = null;
        try {
            foundGame = gameCatalog.findById(id);
        } catch (NoSuchElementException error) {
            foundGame = null;
            notFoundError = error;
        }
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
    public List<Game> searchGamesByGameCategory(String gameCategory) {
        notFoundError = null;
        try {
            foundGames = gameCatalog.findByCategory(GameCategoryConverter.fromText(gameCategory));
        } catch (NoSuchElementException error) {
            foundGames = List.of();
            notFoundError = error;
        } catch (IllegalArgumentException error) {
            foundGames = List.of();
            notFoundError = new NoSuchElementException(error.getMessage());
        }
        return foundGames;
    }

    @When("I search games by game's categories {string}")
    public List<Game> searchGamesByGameCategories(String gameCategories) {
        notFoundError = null;
        try {
            List<Game.Category> categories = GameCategoryConverter.fromCommaSeparatedText(gameCategories);
            foundGames = gameCatalog.findByCategories(categories);
        } catch (NoSuchElementException error) {
            foundGames = List.of();
            notFoundError = error;
        } catch (IllegalArgumentException error) {
            foundGames = List.of();
            notFoundError = new NoSuchElementException(error.getMessage());
        }
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

    @Then("^I will verify that found games  (are|are not) - \"([^\"]*)\"$")
    public void verifyFoundGames(String equalityMode, String expectedGameNames) {
        if (notFoundError != null) {
            throw new AssertionError(notFoundError.getMessage());
        }

        List<String> actualGameNames = foundGames.stream()
                .map(Game::name)
                .sorted()
                .toList();
        List<String> expectedGameNameList = Arrays.stream(expectedGameNames.split(","))
                .map(String::trim)
                .sorted()
                .toList();

        switch (equalityMode) {
            case "are":
            {
                assertEquals(expectedGameNameList, actualGameNames,
                        "Expected found games to be " + expectedGameNameList + ", but found " + actualGameNames);
            }
            break;
            case "are not":
            {
                assertNotEquals(expectedGameNameList, actualGameNames,
                        "Found games should not be " + expectedGameNameList);
            }
            break;
        }
    }

    @Then("I will verify that no game was found")
    public void verifyFoundGameNotExist() {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(notFoundError, "Expected no game to be found");
        assertNull(foundGame, "Expected found game to be empty");

    }
}

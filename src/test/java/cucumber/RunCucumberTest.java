package cucumber;

import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;
import org.gameshop.GameCatalog;

@Cucumber
public class RunCucumberTest {
    //Created object for Game catalog
    private final GameCatalog gameCatalog = new GameCatalog();

    @When("I search game by id {int}")
    public void searchGameById(int id) {
    }

    @When("I search game by name {string}")
    public void searchGameByName(String name) {}

    @When("I search games by game's category {string}")
    public void searchGameByGameCategory(String gameCategory) {}
}
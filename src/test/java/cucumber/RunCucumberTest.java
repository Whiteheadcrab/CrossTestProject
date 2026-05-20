package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        tags = "@Cucumber"
        // Example of tags for total , feature and test
        // "@Cucumber", "@GameCatalog" , "@id\\(GameCatalog_searchByName_1\\)"
)
public class RunCucumberTest {
}

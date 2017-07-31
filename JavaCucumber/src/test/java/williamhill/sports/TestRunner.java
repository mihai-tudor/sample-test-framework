package williamhill.sports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        format = {"pretty", "html:tests-report"}
)
public class TestRunner {
}

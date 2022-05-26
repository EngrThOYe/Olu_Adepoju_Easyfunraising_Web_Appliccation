package uk.org.easyfunraising.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/java/uk/org/easyfunraising/features"},
        glue = {"uk/org/easyfunraising/hooks", "uk/org/easyfunraising/stepDefinitions"},
        publish = true,
        tags = "@test",
        plugin = {"pretty", "html:target/cucumber"}
)

public class TestRunner {
}

package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resource\\AppFeature\\Login.feature"},
		glue={"StepDefination"},
		plugin={"pretty"}
		)
public class LoginRunner {

}

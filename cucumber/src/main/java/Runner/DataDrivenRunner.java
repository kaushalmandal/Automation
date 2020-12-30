package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resource\\AppFeature\\DataDriven.feature"},
		glue={"StepDefination"}
		)
public class DataDrivenRunner {

}

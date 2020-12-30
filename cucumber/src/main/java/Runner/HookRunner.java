package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resource\\AppFeature\\Hooks.feature"},
		glue={"StepDefination","Hook"}
		
		)
public class HookRunner {

}

package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resource\\Features\\LoginPage.feature"},
		glue={"StepDefination","Hooks"}
		)
public class MyRunner {

}

package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HookStep {
	@Given("this is the first dtep")
	public void this_is_the_first_dtep() {
		System.out.println("this is the first step");

	}

	@When("this is the second step")
	public void this_is_the_second_step() {
		System.out.println("this is the second step");

	}

	@Then("this is the third step")
	public void this_is_the_third_step() {
		System.out.println("this is the third step");

	}

}

package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HookOrder {
	@Given("this is the hookorder first step")
	public void this_is_the_hookorder_first_step() {
		System.out.println("hook order first step");

	}

	@When("this is the hookorder second step")
	public void this_is_the_hookorder_second_step() {
		System.out.println("hook order second step");

	}

	@Then("this is the hookorder third step")
	public void this_is_the_hookorder_third_step() {
		System.out.println("hook order third step");

	}

}

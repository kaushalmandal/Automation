package StepDefination;

import io.cucumber.java.en.Given;

public class TaggedHook {
	@Given("this is the first step")
	public void this_is_the_first_step() {
		System.out.println("this is the first step");

	}

}

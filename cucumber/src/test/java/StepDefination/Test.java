package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("user is on home page");
	}

	@When("user navigate to login page")
	public void user_navigate_to_login_page() {
		System.out.println("user navigate to login page");
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("user enter username and password");
	}

	@Then("message displayed login successfully")
	public void message_displayed_login_successfully() {
		System.out.println("message displayed login successfully");

	}

}

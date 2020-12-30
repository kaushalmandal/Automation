package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon {
	@Given("a rigistered user exist")
	public void a_rigistered_user_exist() {
		System.out.println("registered user exist");
	}

	@Given("user is on amazon home page")
	public void user_is_on_amazon_home_page() {
		System.out.println("user is on amazon home page");

	}

	@When("user click on the loglin button")
	public void user_click_on_the_loglin_button() {
		System.out.println("user click on the login button");

	}

	@Then("user navigate to order page")
	public void user_navigate_to_order_page() {
		System.out.println("user navigate to order page");

	}

	@When("user click on previous order link")
	public void user_click_on_previous_order_link() {
		System.out.println("user click on previous order links");

	}

	@Then("user check the previous order detail")
	public void user_check_the_previous_order_detail() {
		System.out.println("user check the previous order details");

	}

	@When("user click on open order links")
	public void user_click_on_open_order_links() {
		System.out.println("user click on open order links");

	}

	@Then("user check the open order details")
	public void user_check_the_open_order_details() {
		System.out.println("user check the open order details");

	}

	@When("user click on cancelled order links")
	public void user_click_on_cancelled_order_links() {
		System.out.println("user click on cancelled order links");

	}

	@Then("user check the cancelled order details")
	public void user_check_the_cancelled_order_details() {
		System.out.println("user check the cancelled order details");

	}

}

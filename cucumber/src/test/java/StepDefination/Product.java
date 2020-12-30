package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Product {
	@Given("user is on product home page")
	public void user_is_on_product_home_page() {
		System.out.println("user is on product page");

	}

	@When("user search {string} with price range {int}")
	public void user_search_with_price_range(String product, Integer price) {
		System.out.println("user is searching product" + product + "and price is " + price);

	}

	@Then("system should display list of all products")
	public void system_should_display_list_of_all_products() {
		System.out.println("system is displaying all products");

	}

	@Then("user select the product and add into the cart")
	public void user_select_the_product_and_add_into_the_cart() {
		System.out.println("user is selecting product and add into the cart");

	}

}

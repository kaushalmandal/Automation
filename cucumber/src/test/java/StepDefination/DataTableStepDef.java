package StepDefination;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableStepDef {
	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		System.out.println("user is on registration page");

	}

	@When("user enter following user details")
	public void user_enter_following_user_details(DataTable dataTable) {
		List<List<String>> userList = dataTable.asList(String.class);
		for (List<String> e : userList) {
			System.out.println(e);
		}
	}

	@Then("user registration is successfull")
	public void user_registration_is_successfull() {
		System.out.println("user registration is successfull");

	}

}

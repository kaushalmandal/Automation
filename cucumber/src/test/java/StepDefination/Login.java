package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login 
{
	@Given("when user is on home page")
	public void when_user_is_on_home_page() 
	{
		System.out.println("user is on home page");
	    
	}

	@Then("user click on login button")
	public void user_click_on_login_button() 
	{
		System.out.println("user click on login button");
	    
	}

	@Then("user provide {string} and {string}")
	public void user_provide_and(String username, String password) 
	{
		System.out.println("user name is "+username+"and password is"+password);
	    
	}

	@Then("user click on login link")
	public void user_click_on_login_link() 
	{
		System.out.println("user click on login link");
	    
	}


}

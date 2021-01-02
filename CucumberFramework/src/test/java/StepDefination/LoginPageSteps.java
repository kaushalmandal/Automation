package StepDefination;

import org.junit.Assert;

import Factory.DriverFactory;
import pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	public static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page1() {
		title = loginpage.getLoginPageTitle();
		System.out.println("login page title is :" + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		String title = loginpage.getLoginPageTitle();
		System.out.println("login page title is :" + title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());

	}

	@When("user enter username as {string}")
	public void user_enter_username_as(String username) {
		loginpage.enterUserName(username);

	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String pass) {
		loginpage.enterPassword(pass);

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginpage.clickLogin();

	}
	public void doLogin(String un,String pwd)
	{
		loginpage.enterUserName(un);
		loginpage.enterPassword(pwd);
		loginpage.clickLogin();
	}

}

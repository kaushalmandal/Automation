package StepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsPageStep {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountspage;

	@Given("user is already logged into application")
	public void user_is_already_logged_into_application(DataTable dataTable) {
		List<Map<String, String>> credlist = dataTable.asMaps();
		String username = credlist.get(0).get("username");
		String password = credlist.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountspage = loginpage.doLogin(username, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		accountspage.getAccountsPageTitle();
	}

	@Then("user gets accounts section")
	public List<String> user_gets_accounts_section(DataTable sectiontable) 
	{
		List<String>expAccountSectionList=sectiontable.asList();
		System.out.println("Expected count section list is :"+expAccountSectionList);
		List<String>actualAAccountSectionList=accountspage.getAccountSectionList();
		return actualAAccountSectionList;

	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedCount) 
	{
		System.out.println("Expected count value is :"+expectedCount);
	}

}

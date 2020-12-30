package StepDefination;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MapDataTableStepDef 
{
	@When("user enter following data with column")
	public void user_enter_following_data_with_column(DataTable dataTable) 
	{
		List<Map<String,String>>data=dataTable.asMaps(String.class, String.class);
		for(Map<String,String>e:data)
		{
			System.out.println(e.get("First name"));
			
		}
			
	    
		
	}

	@Then("user registration is successfully done")
	public void user_registration_is_successfully_done() 
	{
		System.out.println("user registraion successfully done");
	    
	}

}

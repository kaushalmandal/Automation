package Hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook 
{
	@Before
	public void beforeScenario()
	{
		System.out.println("this will run before scenario");
	}
	@After
	public void afterScenario()
	{
		System.out.println("this will run after scenario");
	}
	

}

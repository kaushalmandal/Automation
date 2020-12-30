package Hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookOrder {
	@Before(order = 1)
	public void beforeScenario() {
		System.out.println("this will run before scenario");
	}

	@Before(order = 0)
	public void beforeScenarioStrat() {
		System.out.println("------------Start of scenario-----------");
	}

	@Before(order = 0)
	public void afterScenarioFinish() {
		System.out.println("---------------End of scenario------------");
	}

	@After(order = 1)
	public void afterScenario() {
		System.out.println("this will run after every scenario");
	}

}

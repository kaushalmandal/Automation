package Hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TaggedHook {
	@Before
	public void beforeScenario() {
		System.out.println("this will run before each scenario");
	}

	@After
	public void afterScenario() {
		System.out.println("this will run after each scenario");
	}

	@Before("@First")
	public void beforeFirst() {
		System.out.println("this will execute before first scenario");
	}

	@Before("@Second")
	public void beforeSecond() {
		System.out.println("this will run before second scenario ");
	}

	@Before("@Third")
	public void beforeThird() {
		System.out.println("this will run before third scenario");
	}

	@After("@First")
	public void afterFirst() {
		System.out.println("this will execute after first scenario");
	}

	@After("@Second")
	public void afterSecond() {
		System.out.println("this will execute after second scenario");
	}

	@After("@Third")
	public void afterThird() {
		System.out.println("this will execute after third scenario");
	}

}

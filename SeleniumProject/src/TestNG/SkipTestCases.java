package TestNG;

import org.testng.annotations.Test;

public class SkipTestCases {
	@Test(enabled = true)
	public void m1() {
		System.out.println("this is m1 methods");
	}

	@Test(enabled = false)
	public void m2() {
		System.out.println("this is m2 methods");
	}

	@Test(enabled = true)
	public void m3() {
		System.out.println("this is m3 methods");
	}
}

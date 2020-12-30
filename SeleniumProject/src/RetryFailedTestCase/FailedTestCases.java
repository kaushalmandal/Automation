package RetryFailedTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTestCases {
	@Test
	public void test01() {
		Assert.assertEquals(true, true);
	}

	@Test
	public void test02() {
		Assert.assertEquals(true, true);
	}

	@Test
	public void test03() {
		Assert.assertEquals(false, true);
	}
}

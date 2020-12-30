package RetryFailedTestCase;

import org.testng.ITestResult;

public class RetryFailedTestCaseInSelenium {
	private int retrycount = 0;
	private int maxRetryCount = 3;

	public Boolean retry(ITestResult result) {
		if (retrycount < maxRetryCount) {
			retrycount++;
			return true;
		}
		return false;

	}

}

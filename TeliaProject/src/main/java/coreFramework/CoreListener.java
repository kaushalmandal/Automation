package coreFramework;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


/**
 * This class consists of all listners to TestNG
 * 
 * @author  Nagaraj Jayagondra
 * @version 1.0
 * @since   14-Dec-2015 
 */
public  class CoreListener implements ITestListener {
	
	public static ITestNGMethod testCaseNameListner;
	
	/**
	   * This method is used to get the test case details
	   * 
	   * @author 
	   */
/*	@Override
	public void onTestStart(ITestResult result) {

		  testCaseNameListner = result.getMethod();

		}*/
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test method " +  getTestMethodName(result) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test method " + getTestMethodName(result) + " success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("getStatus() == ITestResult.FAILURE");
//			try {
//				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
//				ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, getTestMethodName(result),"Fail" );
//				CommonWebActions.closeAlerts();
//			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("getStatus() == ITestResult.SUCCESS");
		}
		System.out.println("on test method " + getTestMethodName(result) + " failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test method " + getTestMethodName(result) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("test failed but within success % " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start of test " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish of test " + context.getName());
	}
	
	protected static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}
	/* @Override		
	    public void onTestFailure(ITestResult result) 					
	    {		
		 	System.out.println("The name of the testcase failed is :"+result.getName());					
	    }

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
*/

	/*public void Breakdown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("getStatus() == ITestResult.FAILURE");
			Assert.assertEquals(false, true,
					"Test Case Failed");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("getStatus() == ITestResult.SUCCESS");
		}
		// TODO Auto-generated method stub
		
	}*/
	


}

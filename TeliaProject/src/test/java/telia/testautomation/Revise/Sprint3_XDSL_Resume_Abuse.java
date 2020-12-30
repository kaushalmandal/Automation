package telia.testautomation.Revise;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @TestcaseName:XDSL_Resume_Abuse_an_existing_Broadband
 * @Description: 
 * @Complexity:High
 * @author :Srujana
 * @ALM :
 * 
 */ 
@Listeners({ coreFramework.CoreListener.class })
public class Sprint3_XDSL_Resume_Abuse extends ExtentManager {
	
	public static String url = "";
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	/*WebDriver driver = CommonWebActions.wd;*/

@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName", Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
@BeforeClass
public void beforetest() throws Exception {
	CommonWebActions.login();
}

@Test(priority = 1, enabled=true)
	public void XDSL_Resume_Abuse_an_existing_Broadband() throws Exception {
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			try {
				boolean Dialog = CommonWebActions.Exists(CommonWebActions.wd
						.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")));
				if (Dialog) {
					CommonWebActions.wd
							.findElement(By.xpath("(//*[@type='button']//span[contains(text(),'Cancel')])[9]")).click();
				}
			} catch (Exception e) {
				System.out.println("Cancel Element not present");
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
			System.out.println("Testcase : " + testcasename  +"Started.......");
			String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN");
			System.out.println(SSN_No);
//			CommonWebActions.login();
			 CommonWebActions.webClick("Homebtn");
			CommonWebActions.waitUntilLoaded("MyOrder_link", 20000);
			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("InstallAssets_Dropdown");
			CommonWebActions.webSet("InstallAssets_Dropdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
			CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product"));
			CommonWebActions.javaclick("Settings");
			CommonWebActions.passWithoutClear("Resume", "");
			CommonWebActions.javaclick("Continue");
			CommonWebActions.scrollup();
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			CommonWebActions.wait(2000);
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.scrollup();
			CommonWebActions.wait(2000);
			CommonWebActions.waituntilElementToBeClickable("Submit");
			CommonWebActions.javaclick("Submit");
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			String Order_id2 = App_CommonFunctions.orderNoFetch("Order_id2");
			System.out.println("Order id is:" + Order_id2);
			String due_date = App_CommonFunctions.orderNoFetch("DueDate_Input2");
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", Order_id2);
			System.out.println("Due date is:" + due_date);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date", due_date);
			extent.flush();
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Fail");
		}
	}

@AfterClass

public static void logout() throws  Exception {
    CommonWebActions.javaclick("SettingsBtn");
    CommonWebActions.waitUntil("LogoutBtn");
    CommonWebActions.webClick("LogoutBtn");
    CommonWebActions.waitUntil("UserPopup");
  } 

	  


  @AfterSuite
  public void tearDown() {
	extent.flush();
   CommonWebActions.wd.quit();
}

}

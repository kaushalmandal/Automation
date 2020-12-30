package telia.testautomation.regression;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

@Listeners({ coreFramework.CoreListener.class })

public class Disconnect_Service extends ExtentManager {
	
/*	public Disconnect_Service_1(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public static String url = "Test";
	private static String hostName;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	/*WebDriver driver = CommonWebActions.wd;*/

	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}
// --------------------------------------Test Scripts-----------------------------------//
	@Test(priority = 1)
	public void TC_001_Disconnect_Broadband_Service() throws Exception {
		
/* Getting Gestcaser Name for .xls */
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(),Packagename);
		
		String testcasename=(new Object() {
		}.getClass().getEnclosingMethod().getName());
		
/*--  Launching URL  --*/
		CommonWebActions.login();
		
/*-- page load --*/		
		waitUntilLoaded(CommonWebActions.wd,CommonWebActions.wd.findElement(By.xpath("//*[contains(text(),'My Orders')]")),20000);
//		waitForLoad1(CommonWebActions.wd);
//		waitUntilLoaded(CommonWebActions.wd,By.xpath("//span[@class='siebui-ctrl-link siebui-align-left siebui-input-align-left' and @name='s_5_1_9_0']/a"),20000);
		CommonWebActions.waitUntil("MyOrder_Link");
		
/*-- Calling Navigate Tab function --*/
		navigateTab(); //--->1
		
/*		CommonWebActions.webClick("Account_Tab");
		CommonWebActions.webClick("Account_List_Menu");
		CommonWebActions.wait(2000);*/
		
		String MenuItemInput= ExcelUtil.getDataFromExcel(testcasename, "MenuItem_Input");
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN");
		
/*-- Search By SSN and click on User Name --*/
		searchBySSNandClickOnUserName(MenuItemInput, SSN_No); //------> 2
		
		
		String ProductType = ExcelUtil.getDataFromExcel(testcasename, "Product_Type");
		String ServiceBundle = ExcelUtil.getDataFromExcel(testcasename, "ServiceBundle");
		String ExpectedAccesssType = ExcelUtil.getDataFromExcel(testcasename, "ExpectedAccesssType");
		String Product =  ExcelUtil.getDataFromExcel(testcasename, "Product");
//		CommonWebActions.waituntil("ProductType_Input"); 
		
/*-- Verify Service Bundle and Product  --*/
		verifyserviceBundelandProdcut(ProductType, ServiceBundle, ExpectedAccesssType, Product); //---> 3
	    
/*-- Enter Due Date and click on continue button  --*/		
		String DueDate =  ExcelUtil.getDataFromExcel(testcasename, "DueDate");
		enterDueDateandContinueButton(DueDate);//--->4
	    
/*-- Verify actioin Code Status  --*/	
		String ExpectedActionCodeStatus= ExcelUtil.getDataFromExcel(testcasename, "ExpectedActionCodeStatus");
	    verifyActionCodeStatus(ExpectedActionCodeStatus); //--->5

/*-- Enter Reason Code, Save, click on submit button and click on Query button and verify the Status   --*/	 
	    String ReasonCode=ExcelUtil.getDataFromExcel(testcasename, "ReasonCode");
	    enterReasonCodeandSubmit(ReasonCode); //---> 6

	}

	//-------------------------------2nd Method--------------------------------------------------------------
	
	/*@Test(priority = 2)
	public void TC_002_Disconnect_IPTV_Service() throws Exception {
		CommonMethods common = new CommonMethods(driver);
		
		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName());
		--  Launching URL  --
		CommonWebActions.login1(url);
		
		waitForLoad1(CommonWebActions.wd);
		waitUntilLoaded(CommonWebActions.wd,By.xpath("//span[@class='siebui-ctrl-link siebui-align-left siebui-input-align-left' and @name='s_5_1_9_0']/a"),20000);
		
		CommonWebActions.webClick("Account_Tab");
		CommonWebActions.webClick("Account_List_Menu");
		CommonWebActions.wait(2000);
	
		String MenuItemInput= "SSN/Org Number";  //getVariableValue("MenuItem_Input");
		CommonWebActions.webSetTab("MenuItem_Input", MenuItemInput);
		
		String testcasename=(new Object() {
		}.getClass().getEnclosingMethod().getName());	
		System.out.println("*********testcasename********* :" + testcasename);
		
		String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN"); 		
		System.out.println("*********SSN********* :" + SSN_No);
		
		//String SSN_No="199104282430";           //getVariableValue("SSN");
		CommonWebActions.webSetTab("SSN_Org_Input", SSN_No);
		
		CommonWebActions.webClick("Go_Submit_button");
		CommonWebActions.wait(3000);
		CommonWebActions.webClick("FirstName_Link");
		CommonWebActions.waitTillPageIsLoadedFully();
		CommonWebActions.wait(2000);
		
//		CommonWebActions.waituntil("ProductType_Input");
		
		CommonWebActions.fnHighlightMe(CommonWebActions.wd,CommonWebActions.wd.findElement(By.xpath("//div[@class='NotSelected' and @id='a_1']/div[2]/div[2]/input[1]")));
		CommonWebActions.webSetTab("ProductType_Input", "Product");
		
		String MyServiceBundleForBroadband= "Service Bundle-IA-1703-1"; //getVariableValue("ServiceBundleForBroadband");
		CommonWebActions.webSetTab("QuerySrchSpec_Input", MyServiceBundleForBroadband);
		
		CommonWebActions.webClick("Installed_Assets_Go_Button");
		CommonWebActions.wait(3000);
		
		// ********Access Type Verification*********
		//details about test class??
		
		//---- Access Type Status		
		String ExpectedAccesssType = "200"; // getVariableValue("AccessType");
		System.out.println("********* ExpectedAccesssType *********:- " + ExpectedAccesssType);
		String ActualAccessType = CommonWebActions.gettext1("AccessTYpeID_getText");
		System.out.println("********* AccessTYpeID_getText *********:- " + ActualAccessType);
		if (ActualAccessType.contentEquals(ExpectedAccesssType)) {
			test.log(Status.PASS, "Access Type" + test
					.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "User Details Page")));
		}
		
		//---- Enter Product Type
		String ProductType= "Product";    //getVariableValue("Product_Type");
		CommonWebActions.webSetTab("ProductType_Input", ProductType);
		
		//---- Enter Product
	    String MyProduct= "P-IA-Fiber-Broadband-1743"; // getVariableValue("Product");
	    CommonWebActions.webSetTab("QuerySrchSpec_Input", MyProduct);
	    
		//---- Click on Go Button
	    CommonWebActions.webClick("Installed_Assets_Go_Button");
	    CommonWebActions.wait(5000);
	    
		//---- Click on Disconnect Button
	    CommonWebActions.webClick("Disconnect_Button");
	    
	    
	    //In POP-UP Enter the Due Date
	    String MyDueDate= "2019-02-25 00:00:00";	//getVariableValue("DueDate");
	    CommonWebActions.webSetTab("DueDate_Input", MyDueDate);
	    
	    //Click on Continue button In POP-UP
		CommonWebActions.webClick("ChangeOrderDueDatePopupContinue_Button");
		waitForLoad1(CommonWebActions.wd);
		CommonWebActions.wait(5000);
		
		//---- Action Code "Delete" Status
		String ExpectedActionCodeStats = "Delete"; // getVariableValue("ActionCodeStatus");
		String ActualActionCodeStats = CommonWebActions.gettext1("ActionCodeStatus");
		if (ActualActionCodeStats.contentEquals(ExpectedActionCodeStats)) {
			test.log(Status.PASS, "Action Code Status" + test
					.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "User Details Page")));
		}
	    
		//---- Enter Reason Code
	    String MyReasonCode= "Deceased"; //getVariableValue("ReasonCode");
	    waitUntilLoaded(CommonWebActions.wd,By.xpath("//div[@class='NotSelected' and @id='a_1']/div/table/tbody/tr[20]/td[3]/div/input"),10000);
	    CommonWebActions.EntertextThenPressTabAndSave("ReasonCode_Input", MyReasonCode);
	    
	    //Click on Submit Button
		CommonWebActions.webClick("SalesOrderSubmit_Button");
		CommonWebActions.wait(5000);
		
		//Click on Execute Query Button
		CommonWebActions.webClick("executequeryToolbar_Button");
		CommonWebActions.wait(10000);
		CommonWebActions.webClick("executequeryToolbar_Button");
	}
*/
	@AfterTest
	public void logOut() {
		System.setProperty("jacob.dll.path", "C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\jacob-1.17-M2-x86.dll");
		try {
			updateResults();
		} catch (ALMServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		 extent.flush();
	}

	public void waitForLoad1(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 30);
		wait.until(pageLoadCondition);
	}
	public  void updateResults() throws ALMServiceException {
        try {
			ALMServiceWrapper wrapper = new ALMServiceWrapper(
			            "http://qc.teliacompany.net:8080/qcbin");
			wrapper.connect("cbo823", "Today@123", "SWE", "E2EMassMarket");
			ITestCase Demo_Test=wrapper.updateResult("E2EMM Automation","Demo", 34441, "Demo_Test", StatusAs.PASSED);
			wrapper.newAttachment("C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\report-output\\20190212\\Telia_Automation_20190212133816263.html", "TestResult",Demo_Test );
			wrapper.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  } 
	public static WebElement waitUntilLoaded(WebDriver driver, WebElement iwebelement, int seconds) {
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new WebDriverWait(driver, seconds).pollingEvery(100, TimeUnit.SECONDS);
		WebElement we = wait.until(ExpectedConditions.elementToBeClickable(iwebelement));
		return we;
	}
	
	public void navigateTab() throws Exception{
		CommonWebActions.webClick("Account_Tab");
		CommonWebActions.webClick("Account_List_Menu");
		CommonWebActions.wait(2000);
	}
	//2
	public void searchBySSNandClickOnUserName(String MenuItemInput, String SSN_No) throws Exception{
		//String MenuItemInput= "SSN/Org Number";  //getVariableValue("MenuItem_Input");
		CommonWebActions.webSetTab("MenuItem_Input", MenuItemInput);
		System.out.println("*********MenuItemInput********* :" + MenuItemInput);

		
		/*String SSN_No = ExcelUtil.getDataFromExcel(testcasename, "SSN");*/ 		
		System.out.println("*********SSN********* :" + SSN_No);
		
		//String SSN_No="199104282430";           //getVariableValue("SSN");
		CommonWebActions.webSetTab("SSN_Org_Input", SSN_No);
		
		CommonWebActions.webClick("Go_Submit_button");
		test.log(Status.PASS, "Based on SSN user has been selected"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickNotFound")));
		CommonWebActions.wait(3000);
		///---------------------------------------------
		CommonWebActions.webClick("FirstName_Link");
//		CommonWebActions.waitTillPageIsLoadedFully();
		CommonWebActions.wait(2000);
	}
	//3
	public void verifyserviceBundelandProdcut(String ProductType, String ServiceBundle, String ExpectedAccesssType, String Product) throws Exception{
		//CommonWebActions.webSetTab("ProductType_Input", ProductType);
		CommonWebActions.wait(1000);
		CommonWebActions.javaSet("ProductType_Input", ProductType);
		//CommonWebActions.webSetTab("QuerySrchSpec_Input", ServiceBundle);
		CommonWebActions.javaSet("QuerySrchSpec_Input", ServiceBundle);
		//CommonWebActions.webClick("Installed_Assets_Go_Button");
		CommonWebActions.javaclick("Installed_Assets_Go_Button");
		CommonWebActions.wait(1000);
		
		System.out.println("********* ExpectedAccesssType *********:- " + ExpectedAccesssType);
		/*String ActualAccessType = CommonWebActions.gettext1("AccessTYpeID_getText");
		System.out.println("********* AccessTYpeID_getText *********:- " + ActualAccessType);
		if (ActualAccessType.contentEquals(ExpectedAccesssType)) {
			test.log(Status.PASS, "Access Type" + test
					.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "User Details Page")));
		}*/
		//CommonWebActions.webSetTab("ProductType_Input", ProductType);
		CommonWebActions.javaSet("ProductType_Input", ProductType);
	    //CommonWebActions.webSetTab("QuerySrchSpec_Input", Product);
		CommonWebActions.javaSet("QuerySrchSpec_Input", Product);
	    
		//---- Click on Go Button
	    //CommonWebActions.webClick("Installed_Assets_Go_Button");
	    CommonWebActions.javaclick("Installed_Assets_Go_Button");
	    CommonWebActions.wait(1000);
	    	    
		//---- Click on Disconnect Button
	    //CommonWebActions.webClick("Disconnect_Button");
	    CommonWebActions.javaclick("Disconnect_Button");
	    CommonWebActions.wait(1000);
	}
	//4
		public void enterDueDateandContinueButton(String DueDate) throws Exception{
		//Enter Due Date
	    CommonWebActions.webSetTab("DueDate_Input", DueDate);
	    //Click on Continue button In POP-UP
		CommonWebActions.webClick("ChangeOrderDueDatePopupContinue_Button");
		CommonWebActions.wait(2000);
		waitForLoad1(CommonWebActions.wd);
		}
		//5
	    public void verifyActionCodeStatus(String ExpectedActionCodeStatus) throws Exception{
		/*String ActualActionCodeStats = CommonWebActions.gettext1("ActionCodeStatus");
			if (ActualActionCodeStats.contentEquals(ExpectedActionCodeStatus)) {
				test.log(Status.PASS, "Action Code Status" + test
						.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "User Details Page")));
			}*/
	    }
	    //6
	    public void enterReasonCodeandSubmit(String ReasonCode)throws Exception //->6
	    {	    	
	    waitUntilLoaded(CommonWebActions.wd,CommonWebActions.wd.findElement(By.xpath("//div[@class='NotSelected' and @id='a_1']/div/table/tbody/tr[20]/td[3]/div/input")),10000);
	    
	    CommonWebActions.EntertextThenPressTabAndSave("ReasonCode_Input", ReasonCode);
	  
	    //Click on Submit Button
		//CommonWebActions.webClick("SalesOrderSubmit_Button");
	    CommonWebActions.wait(1000);
	    CommonWebActions.javaclick("SalesOrderSubmit_Button");
		CommonWebActions.wait(10000);
		
		//Click on Execute Query Button
		//CommonWebActions.webClick("executequeryToolbar_Button");
		//CommonWebActions.clickBtn("executequeryToolbar_Button");
		CommonWebActions.wait(10000);
		//CommonWebActions.webClick("executequeryToolbar_Button");
		CommonWebActions.javaclick("executequeryToolbar_Button");
	}
	
}

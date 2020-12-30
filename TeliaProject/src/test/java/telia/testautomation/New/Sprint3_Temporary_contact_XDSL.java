/**
 * Manual Testcase Name : Possibility to use a temporary contact in XDSL orders (Part 1)
 * Description of Testcase:
 * Date of Creation: 27-02-2019
 * Reviewed By:
 * Author:QSG460
 * 
 */
package telia.testautomation.New;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;

/**
 * @author kaviag
 *
 */

public class Sprint3_Temporary_contact_XDSL extends ExtentManager {

	public static String url = "Test";
	private static String hostName;
	String Packagename = new Object() {
	}.getClass().getPackage().getName().split("[.]")[2];

	@BeforeSuite
	public void init() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			ORUtil.setValue("testDataWorkSheetName",Packagename);
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("HostName : " + hostName);
	}

	@BeforeClass
	public void beforetest() throws Exception {
		CommonWebActions.login();
	}
	
	
	
	@Test(priority = 1, enabled = true)
	public void TC_001_XDSL527_Temporary_contact_in_XDSL_orders_Part1() throws Exception {

		ExtentManager.startReporting(new Object() {
		}.getClass().getEnclosingMethod().getName(), Packagename);
		System.out.println("Package : " + Packagename);
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("Testcase : " + testcasename  +"Started.......");
		try {
			/*--  Launching URL  --*/
			String SSN = ExcelUtil.getDataFromExcel(testcasename, "SSN");
			String FirstName = ExcelUtil.getDataFromExcel(testcasename, "FristName");
			String LastName = ExcelUtil.getDataFromExcel(testcasename, "LastName");
			String Email = ExcelUtil.getDataFromExcel(testcasename, "Email");
			String MobilePhone = ExcelUtil.getDataFromExcel(testcasename, "MobileNo");
			String Product = ExcelUtil.getDataFromExcel(testcasename, "Product");
			String FbNumber = ExcelUtil.getDataFromExcel(testcasename, "Conn_Ref");
			String Speed = ExcelUtil.getDataFromExcel(testcasename, "Speed");
			String Due = ExcelUtil.getDataFromExcel(testcasename, "FieldDue");

//			CommonWebActions.login();

			// CommonWebActions.wait(20*1000);
//			CommonWebActions.waitUntilLoaded("MyOrder_link", 3000);
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.SearchServiceAccount(SSN, "Residential");
			CommonWebActions.waitForLoad1();
			CommonWebActions.retryingFindClick("FirstName_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitUntil("CustAcc_Link");
			CommonWebActions.webClick("CustAcc_Link");
			CommonWebActions.waitUntil("AddNew_Button1");
			CommonWebActions.webClick("AddNew_Button1");
			CommonWebActions.waitForLoad1();
			AddNewContact(1, "First Name", FirstName);
			AddNewContact(1, "Last Name", LastName);
			AddNewContact(1, "Email", Email);
			AddNewContact(1, "Mobile Phone #", MobilePhone);
			TempCheckBox(1, "Temporary");
			CommonWebActions.savePage();
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			CommonWebActions.webClick("AccHierarchy_Tab");
			CommonWebActions.waitForLoad1();
			CommonWebActions.retryingFindClick("BillingAcc_Link");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(1000);
			CommonWebActions.webClick("Add_Button");
			CommonWebActions.webSet("AddContacts_Dropdown", "Last Name");
			CommonWebActions.webSet("AddContacts_Input", LastName);
			CommonWebActions.webClick("AddContactsGO_Button");
			CommonWebActions.waitUntil("AddContactsOK_Button");
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("AddContactsOK_Button");
			boolean alertpresent=CommonWebActions.isAlertPresent();
		     if(alertpresent){
		          CommonWebActions.wd.switchTo().alert(); 
		          CommonWebActions.wd.switchTo().alert().accept();
		          CommonWebActions.webClick("AddContactsCancel_Button");
		          CommonWebActions.wait(2000);
		          CommonWebActions.webClick("Delete_Button");
		          CommonWebActions.wd.switchTo().alert(); 
		          CommonWebActions.wd.switchTo().alert().accept();
		          CommonWebActions.wait(1000);
		          CommonWebActions.waitUntil("Add_Button");
		          CommonWebActions.webClick("Add_Button");
		          CommonWebActions.webSet("AddContacts_Dropdown", "Last Name");
		          CommonWebActions.webSet("AddContacts_Input", LastName);
		          CommonWebActions.waitUntil("AddContactsGO_Button");
		          CommonWebActions.webClick("AddContactsGO_Button");
		          CommonWebActions.waitForLoad1();
		          CommonWebActions.waitUntil("AddContactsOK_Button");
		         CommonWebActions.webClick("AddContactsOK_Button");
		         CommonWebActions.waitForLoad1();
		     }
			CommonWebActions.waitUntil("AccHierarchy_Tab");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("AccHierarchy_Tab");
			// CommonWebActions.wait(2000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("ServiceAcc_Link");
			CommonWebActions.retryingFindClick("ServiceAcc_Link");
			CommonWebActions.webClick("Add_Button");
			CommonWebActions.webSet("AddContacts_Dropdown", "Last Name");
			CommonWebActions.webSet("AddContacts_Input", LastName);
			CommonWebActions.webClick("AddContactsGO_Button");
			CommonWebActions.waitUntil("AddContactsOK_Button");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddContactsOK_Button");
			boolean alertpresent1=CommonWebActions.isAlertPresent();
			if(alertpresent1){
			          CommonWebActions.wd.switchTo().alert(); 
			          CommonWebActions.wd.switchTo().alert().accept();
			          CommonWebActions.webClick("AddContactsCancel_Button");
			      CommonWebActions.wait(2000);
			      CommonWebActions.webClick("Delete_Button");
			      CommonWebActions.wd.switchTo().alert(); 
			      CommonWebActions.wd.switchTo().alert().accept();
			      CommonWebActions.wait(2000);
			      CommonWebActions.waitUntil("Add_Button");
			      CommonWebActions.webClick("Add_Button");
			      CommonWebActions.webSet("AddContacts_Dropdown", "Last Name");
			      CommonWebActions.webSet("AddContacts_Input", LastName);
			      CommonWebActions.webClick("AddContactsGO_Button");
			      CommonWebActions.waitUntil("AddContactsOK_Button");
			      CommonWebActions.webClick("AddContactsOK_Button");
			 }

			CommonWebActions.waitUntil("AccHierarchy_Tab");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("AccHierarchy_Tab");
			// CommonWebActions.wait(5000);
			CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("CustAcc_Link");
			CommonWebActions.retryingFindClick("CustAcc_Link");
			// CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Dropdown_Tab");
			CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Installed Assets");
			CommonWebActions.waitUntil("New_InstallAssets");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("New_InstallAssets");
			// CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Credit_Check");
			CommonWebActions.webClick("Credit_Check");
			CommonWebActions.waitUntil("NewLine_Button");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("NewLine_Button");
			// CommonWebActions.waitUntil("Product");
			CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(1, "Product", Product);
			// CommonWebActions.savePage();
			// CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			// CommonWebActions.wait(1000);
			App_CommonFunctions.NewLineITem(2, "Connectivity Reference Number", FbNumber);
			// CommonWebActions.wait(1000);
			System.out.println(FbNumber);
			CommonWebActions.webClick("Edit_Tab");
			CommonWebActions.waitUntil("Edit_option");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("Edit_option");
			CommonWebActions.waitUntil("ChangeRecord_List");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("ChangeRecord_List");
			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("EditPopup_Field");
			CommonWebActions.webSet("EditPopup_Field", "Temp Contact Last Name");
			// CommonWebActions.wait(6000);
			CommonWebActions.webSet("EditPopup_Input", LastName);
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("Value_Ok");
			CommonWebActions.waitUntil("Cutomize_Button");
			// CommonWebActions.wait(3000);
			CommonWebActions.webClick("Cutomize_Button");
			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Item_1A_speed");
			CommonWebActions.Selectvaluefromdropdown("Item_1A_speed", Speed);
			// CommonWebActions.wait(2000);
			CommonWebActions.webSet("Qty_1A_Speed", "1");
			// CommonWebActions.wait(2000);
			CommonWebActions.webClick("AddItem_1A_Speed");
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Done_1A_Speed");
			CommonWebActions.webClick("Done_1A_Speed");
			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("ServiceBundle_Expand");
			CommonWebActions.webClick("ServiceBundle_Expand");
//			CommonWebActions.webClick("Edit_option");
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webClick("ChangeRecord_List");
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webSet("EditPopup_Field", Due);
//			CommonWebActions.waitUntil("EditPopup_Input");
//			// CommonWebActions.wait(6000);
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 8);
			String newDueDate = inputFormat1.format(cal.getTime());
			System.out.println(newDueDate);
			App_CommonFunctions.NewLineITem(3, "Due", newDueDate);
//			CommonWebActions.webSet("EditPopup_Input", newDueDate);
//			// CommonWebActions.wait(3000);
//			CommonWebActions.webClick("Value_Ok");
//			// CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("Due_date");
			CommonWebActions.webSet("Due_date", newDueDate);
			CommonWebActions.webClick("SalesOrder_Submit");
			CommonWebActions.waitForLoad1();
			App_CommonFunctions.refreshComplete("StatusFld",
					ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID"));
			
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo_Input"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_Date"));
			
			extent.flush();
			String StatusID = App_CommonFunctions.orderNoFetch("Order_Status"); 
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "Pass");
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {}.getClass().getEnclosingMethod().getName()), "Not Completed");

		} catch (Exception e) {
			ExcelUtil.setDatatoExcel("Test_Output",(new Object() {
			}.getClass().getEnclosingMethod().getName()) , "TestCase_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
			}.getClass().getEnclosingMethod().getName()) + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint3", 38476, (new Object() {
			}.getClass().getEnclosingMethod().getName()), "Not Completed");

		}
	}

	public void AddNewContact(int rowno, String Columnname, String StrTexttoSend) throws Exception {
		List<WebElement> column = CommonWebActions.wd
				.findElements(By.xpath("//*[@id='gview_s_1_l']/div[2]/div/table/thead/tr/th"));
		int Line_Item_Column_Count = column.size();
		List<WebElement> LineItem_Data = CommonWebActions.wd.findElements(By.xpath("//*[@id=" + rowno + "]/td"));
		for (int i = 0; i < Line_Item_Column_Count; i++) {
			String Column_Name = column.get(i).getText();
			if ((Columnname).trim().equalsIgnoreCase(Column_Name.trim())) {
				WebElement objName = LineItem_Data.get(i);
				CommonWebActions.javaSet2(objName, StrTexttoSend);
				System.out.println(Columnname + ":" + StrTexttoSend);
				CommonWebActions.wait(1000);
			}
		}
	}

	public void TempCheckBox(int rowno, String Columnname) throws Exception {
		List<WebElement> column = CommonWebActions.wd
				.findElements(By.xpath("//*[@id='gview_s_1_l']/div[2]/div/table/thead/tr/th"));
		int Line_Item_Column_Count = column.size();
		List<WebElement> LineItem_Data = CommonWebActions.wd.findElements(By.xpath("//*[@id=" + rowno + "]/td"));

		for (int i = 0; i < Line_Item_Column_Count; i++) {
			String Column_Name = column.get(i).getText();

			if ((Columnname).trim().equalsIgnoreCase(Column_Name.trim())) {

				WebElement objName = LineItem_Data.get(i);
				objName.click();
				objName.findElement(By.xpath("(//*[@type='checkbox'])[8]")).click();
				System.out.println("check box enabled");
				CommonWebActions.wait(1000);
			}
		}
	}
	@AfterClass
	public static void teardown() throws Exception {
		CommonWebActions.logout();
		System.out.println("Testcase Completed.......");
	extent.flush();
	CommonWebActions.wd.quit();
	}
}

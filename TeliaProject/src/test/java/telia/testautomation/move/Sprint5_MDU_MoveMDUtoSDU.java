/**
 * 
 */
package telia.testautomation.move;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
public class Sprint5_MDU_MoveMDUtoSDU extends ExtentManager{
		
		String hostName;
		String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
		
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
			System.out.println("hostName: " + hostName);
		}
		
		@BeforeClass
		public void beforetest() throws Exception {
			//CommonWebActions.login();
		}
		
		/**
		 * @TestcaseName:TC_001_MDU_New_Broadband_IPTV_Bulk
		 * @Description: Move MDU BB VOIP order to SDU
		 * @Complexity:High
		 * @author :Kavia
		 * @ALM :
		 * 
		 */ 

		
		@Test(priority=1, enabled=true)
		public void MDU_Move_Upgrade_Promotion_to_SDU_Same_Aria() throws Exception {

			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("testcase:" + testcasename);
			try {
				CommonWebActions.login();
				CommonWebActions.waitUntil("MyOrder_link");
				App_CommonFunctions.SearchOrgAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
				CommonWebActions.waitForLoad1();
				CommonWebActions.waitUntil("FirstName_Link");
				CommonWebActions.wait(3000);
				CommonWebActions.retryingFindClick("FirstName_Link");
				CommonWebActions.waitUntil("AccHierarchy_Tab");
				CommonWebActions.webClick("AccHierarchy_Tab");
				CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.webClick("ServiceAcct");
				CommonWebActions.waitUntil("AddSearch_Icon");
				CommonWebActions.retryingFindClick("AddSearch_Icon");

				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cl = Calendar.getInstance();
				String CurrentDate = inputFormat.format(cl.getTime());
				System.out.println(CurrentDate);
				
				SearchAddressPopup(1, "End Date", CurrentDate);
				CommonWebActions.retryingFindClick("NewAddress_Button");
				boolean alertpresent = CommonWebActions.isAlertPresent();
				if(alertpresent){
				          CommonWebActions.wd.switchTo().alert(); 
				          CommonWebActions.wd.switchTo().alert().accept();
//				          CommonWebActions.clearValuesnSave("EndDate");
//				          SearchAddressPopup(1, "End Date", CurrentDate);
				          CommonWebActions.retryingFindClick("NewAddress_Button");
				}
				
				CommonWebActions.webSet("StreetName", ExcelUtil.getDataFromExcel(testcasename, "StreetName"));
				CommonWebActions.webSet("StreetNo", ExcelUtil.getDataFromExcel(testcasename, "StreetNo"));
				CommonWebActions.webSet("Ingang", ExcelUtil.getDataFromExcel(testcasename, "Ingång"));
				CommonWebActions.webSet("ApartmentNo", ExcelUtil.getDataFromExcel(testcasename, "ApartNO"));
				CommonWebActions.webSet("City", ExcelUtil.getDataFromExcel(testcasename, "City"));
				CommonWebActions.webClick("AddressType_Dropdown");
				CommonWebActions.webClick("AddressType_List");
				CommonWebActions.webClick("SearchAdd_Button");
				CommonWebActions.waitUntil("AddressListOk_Button");
				CommonWebActions.webClick("AddressListOk_Button");
				CommonWebActions.wait(3000);
				CommonWebActions.waitForLoad1();
				CommonWebActions.waitUntil("AddSearch_Icon");
				CommonWebActions.webClick("AddSearch_Icon");
//				SearchAddressPopup(1, "End Date", CurrentDate);
				CommonWebActions.webClick("InstallationAdd");
				App_CommonFunctions.checkBox("InstallationAdd_CheckBox");
				CommonWebActions.webClick("ShippingAddress");
				App_CommonFunctions.checkBox("ShippingAddress_CheckBox");
//				 CommonWebActions.webClick("premise");
//				 App_CommonFunctions.checkBox("premise_CheckBox");
				CommonWebActions.waitUntil("SearchAddOK_Button");
				CommonWebActions.webClick("SearchAddOK_Button");
				CommonWebActions.waitUntil("AccountHierarchyTab");
				CommonWebActions.webClick("AccountHierarchyTab");
				CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.webClick("CustomerAcct");
				CommonWebActions.waitUntil("AccountHierarchyTab");
				CommonWebActions.wait(3000);
				// CommonWebActions.webClick("AcctSummryTab");
				CommonWebActions.waitForLoad1();
				if (CommonWebActions.wd.findElements(By.xpath("//a[text()='Account Summary']")).size() != 0) {
					CommonWebActions.webClick("AcctSummryTab");
				} else {
					CommonWebActions.Selectvaluefromdropdown("Dropdown_Tab", "Account Summary");
				}

				CommonWebActions.waitUntil("InstallAssets_Dropdown");
				CommonWebActions.webSet("InstallAssets_Dropdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
				CommonWebActions.webSet("InstallAssets_Textdown", ExcelUtil.getDataFromExcel(testcasename, "Product_Broadband"));
				CommonWebActions.retryingFindClick("Installed_Assets_Go_Button");
				CommonWebActions.waitForLoad1();
				CommonWebActions.wait(5000);
				CommonWebActions.waitUntil("Settings");
				CommonWebActions.webClick("Settings");
				CommonWebActions.webClick("Select_UpgradePromo");
				CommonWebActions.wait(2000);
				CommonWebActions.webSet("Promotion_Upgrade",ExcelUtil.getDataFromExcel(testcasename,"Upgrade_Promotion"));
				CommonWebActions.webClick("PromotionUpgrades_Go");
				CommonWebActions.waitUntil("Move_Upgrade");
				CommonWebActions.webClick("Move_Upgrade");
				
				CommonWebActions.waitUntil("Cutomize_Button");
				CommonWebActions.webClick("Cutomize_Button");
				CommonWebActions.wait(3000);
				CommonWebActions.Selectvaluefromdropdown("Item_1A_speed", ExcelUtil.getDataFromExcel(testcasename, "Speed"));
				CommonWebActions.wait(2000);
				CommonWebActions.webSet("Qty_1A_Speed", "1");
				CommonWebActions.wait(2000);
				CommonWebActions.webClick("AddItem_1A_Speed");
				CommonWebActions.wait(3000);
				CommonWebActions.webClick("Done_1A_Speed");
				CommonWebActions.wait(3000);
				
				CommonWebActions.waitUntil("PortalBtn");
		        CommonWebActions.webClick("PortalBtn");
		        CommonWebActions.waitUntil("InstallAssets_Dropdown");
				CommonWebActions.webSet("InstallAssets_Dropdown",ExcelUtil.getDataFromExcel(testcasename, "Product_Type"));
				CommonWebActions.webSet("InstallAssets_Textdown",ExcelUtil.getDataFromExcel(testcasename, "Product_VoIP"));
				CommonWebActions.waitUntil("Installed_Assets_Go_Button");
		        CommonWebActions.webClick("Installed_Assets_Go_Button");
		
		        CommonWebActions.waitUntil("Modify_Button");
				CommonWebActions.webClick("Modify_Button");
				CommonWebActions.webClick("Move_CheckBox");
				CommonWebActions.wait(2000);
				
				cl.add(Calendar.MINUTE, 20);
				String newtime = inputFormat.format(cl.getTime());
				System.out.println(newtime);
				CommonWebActions.webSet("MoveDueDate",newtime);
				CommonWebActions.webClick("Continue_Button");
				CommonWebActions.javaclick("VOIPServiceBundle");
		        App_CommonFunctions.voipphoneBook();
				CommonWebActions.savePage();
				CommonWebActions.waitUntil("SalesOrder_Submit");
				CommonWebActions.webClick("SalesOrder_Submit");
				
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "SSN", App_CommonFunctions.orderNoFetch("SSN_Input"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
						App_CommonFunctions.orderNoFetch("OrderNo"));
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
						App_CommonFunctions.orderNoFetch("Due_Date"));

				extent.flush();
				String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "TestCase_Status", "Pass");
				System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921,testcasename, "Not Completed");
				CommonWebActions.logout();
			} catch (Exception e) {
				test.log(Status.FAIL, "Test Case Failed:" + (new Object() {
				}.getClass().getEnclosingMethod().getName()) + ":"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation", "Sprint5", 39921, testcasename, "Fail");
				ExcelUtil.setDatatoExcel("Test_Output", testcasename, "TestCase_Status", "Fail");
				CommonWebActions.logout();

			}
		}
		public void SearchAddressPopup(int rowno, String Columnname, String StrTexttoSend) throws Exception {
			List<WebElement> column = CommonWebActions.wd
					.findElements(By.xpath("(//table[@class='ui-jqgrid-htable'])[4]/thead/tr/th"));
			int Line_Item_Column_Count = column.size();
			List<WebElement> LineItem_Data = CommonWebActions.wd.findElements(
					By.xpath("//table[@class='ui-jqgrid-btable' and @summary ='Account Addresses']//tbody//tr[@id=" + rowno
							+ "]/td"));
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

		public void SelectAddress(String PointID) throws Exception {

			WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title=" + PointID + "]"));
			Input_Data.click();
			CommonWebActions.wait(1000);
		}
		
		@AfterTest
		public void logOut() throws Exception {
			CommonWebActions.logout();
			CommonWebActions.wd.quit();
			
		}

		@AfterSuite
		public void tearDown() {
			extent.flush();
			CommonWebActions.wd.quit();
		}
}

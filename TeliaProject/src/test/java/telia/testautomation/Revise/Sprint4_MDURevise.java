package telia.testautomation.Revise;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import applicationSpecific.App_CommonFunctions;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;
import coreFramework.ORUtil;


	@Listeners({ coreFramework.CoreListener.class })
	public class Sprint4_MDURevise extends ExtentManager {

		public static String url = "";
		private static String hostName;
		String Packagename = new Object() {
		}.getClass().getPackage().getName().split("[.]")[2];
		/* WebDriver driver = CommonWebActions.wd; */

		@BeforeSuite
		public void init() throws Exception {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				// Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
				hostName = InetAddress.getLocalHost().getHostName();
				ORUtil.setValue("testDataWorkSheetName", Packagename);
				
			} catch (UnknownHostException e) {
				throw new RuntimeException(e);
			}
			System.out.println("hostName: " + hostName);
		}
		
		@Test(priority = 1,enabled=true)
	public void Voip_New_Revise() throws Exception {
		String testcasename = (new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			/*--  Launching URL  --*/
			CommonWebActions.login();
			CommonWebActions.waitUntil("MyOrder_link");
			// CommonWebActions.wait(1000);
			CommonWebActions.webClick("Homebtn");
			// CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("MyOrder_link");

			App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
			CommonWebActions.waitForLoad1();
			CommonWebActions.wait(3000);
			CommonWebActions.waitUntil("FirstName_Link");
			CommonWebActions.retryingFindClick("FirstName_Link");
			// CommonWebActions.waitForLoad1();
			CommonWebActions.waitUntil("New_button");
			CommonWebActions.webClick("New_button");
			CommonWebActions.wait(4000);
			// ====Time Change
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			cl.add(Calendar.DATE, 5);
			String newtime = inputFormat.format(cl.getTime());
			System.out.println(newtime);
			CommonWebActions.webSet("Due_value", newtime);
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Plus_button");
			CommonWebActions.wait(2000);

			App_CommonFunctions.NewLineITem(1, "Product", ExcelUtil.getDataFromExcel(testcasename, "Product"));

			App_CommonFunctions.NewLineITem(2, "Access Type", ExcelUtil.getDataFromExcel(testcasename, "AccessType"));
			CommonWebActions.wait(1000);
			CommonWebActions.wait(1000);

			CommonWebActions.webClick("Device_typeClick");
			CommonWebActions.wait(1000);
			CommonWebActions.webSet("Device_typeClick1", ExcelUtil.getDataFromExcel(testcasename, "DeviceType"));
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Number_Lineitems");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("Number_arrow");
			CommonWebActions.wait(3000);
			/*
			 * CommonWebActions.webClick("Book_tab"); CommonWebActions.wait(3000);
			 */
			// =============Book PH Number

			List<WebElement> Phonenos = CommonWebActions.getWebElements("Phonelist");
			Biglabel: if (Phonenos.size() > 0) {
				System.out.println("Phone number LIST is DISPLAYED and hence booking one");
				label: for (int i = 0; i <= Phonenos.size() - 1;) {
					WebElement Number = Phonenos.get(i);
					System.out.println(Number);
					CommonWebActions.wait(2000);
					JavascriptExecutor executor = (JavascriptExecutor) CommonWebActions.wd;
					executor.executeScript("arguments[0].click();", Number);
					// Number.click();
					CommonWebActions.wait(2000);
					CommonWebActions.webClick("Book_tab");
					CommonWebActions.wait(2000);
					boolean alertpresent1 = CommonWebActions.isAlertPresent();
					if (alertpresent1) {
						System.out.println("Alert  present");
						CommonWebActions.wd.switchTo().alert();
						CommonWebActions.wd.switchTo().alert().accept();
						CommonWebActions.wd.switchTo().defaultContent();
						CommonWebActions.waitForLoad1();
						CommonWebActions.waitUntil("Book_tab");
						i++;
						continue label;
					} else {
						break Biglabel;
					}
				}

			} else {
				System.out.println("PHONE NUMBER LIST IS NOT DISPLAYED");
			}

			// ============
			/*
			 * CommonWebActions.webSet("Reason_Code",
			 * ExcelUtil.getDataFromExcel(testcasename, "ReasonCode"));
			 * CommonWebActions.waitUntil("Accept_Email");
			 * CommonWebActions.webClick("Accept_Email"); CommonWebActions.wait(3000);
			 */
			App_CommonFunctions.verify_UnEncryptedEmailFlag(testcasename);
			// CommonWebActions.waitUntil("TreePlusExpand_Icon");
			// CommonWebActions.webClick("TreePlusExpand_Icon");

			// CommonWebActions.waitUntil("TreePlusExpand_Icon2");
			// CommonWebActions.scrollIntoWebElement1("TreePlusExpand_Icon2");
			// CommonWebActions.javaclick("TreePlusExpand_Icon2");
			// CommonWebActions.wait(2000);
			/*
			 * CommonWebActions.waitUntil("Lineitem_Settings");
			 * CommonWebActions.webClick("Lineitem_Settings");
			 * CommonWebActions.waitUntil("LineItem_SelectAll");
			 * CommonWebActions.webClick("LineItem_SelectAll");
			 * CommonWebActions.waitUntil("Lineitem_Settings");
			 * CommonWebActions.webClick("Lineitem_Settings");
			 * CommonWebActions.waitUntil("LineItem_ChangeRecords");
			 * CommonWebActions.webClick("LineItem_ChangeRecords");
			 * CommonWebActions.waitUntil("1stField_DropDown");
			 * CommonWebActions.webSet("1stField_DropDown","Due");
			 * CommonWebActions.webClick("Due_Select");
			 * CommonWebActions.waitUntil("1stValue_Textbox");
			 * CommonWebActions.webSet("1stValue_Textbox",newtime);
			 * CommonWebActions.waitUntil("OK_Button");
			 * CommonWebActions.webClick("OK_Button");
			 */
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");
			// Fetch the status
			CommonWebActions.wait(5000);
			CommonWebActions.waitForLoad1();
			WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 120);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Sales Order:Revise']")));
			// Click on Revise
			CommonWebActions.fnHighlightMe("Revise_Button");
			element.click();

			// Adding todays date
			SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d1 = new Date();
			String date1 = inputFormat1.format(d1);
			System.out.println(date1);
			// Submit the order with today's date
			CommonWebActions.webSet("Due_date", date1);
			CommonWebActions.savePage();
			CommonWebActions.waitUntil("TreePlusExpand_Icon");
			CommonWebActions.webClick("TreePlusExpand_Icon");
			// CommonWebActions.scrollIntoWebElement1("TreePlusExpand_Icon2");
			// CommonWebActions.javaclick("TreePlusExpand_Icon2");
			CommonWebActions.wait(2000);
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_SelectAll");
			CommonWebActions.webClick("LineItem_SelectAll");
			CommonWebActions.waitUntil("Lineitem_Settings");
			CommonWebActions.webClick("Lineitem_Settings");
			CommonWebActions.waitUntil("LineItem_ChangeRecords");
			CommonWebActions.webClick("LineItem_ChangeRecords");
			CommonWebActions.waitUntil("1stField_DropDown");
			CommonWebActions.webSet("1stField_DropDown", "Due");
			CommonWebActions.webClick("Due_Select");
			CommonWebActions.waitUntil("1stValue_Textbox");
			CommonWebActions.webSet("1stValue_Textbox", date1);
			CommonWebActions.waitUntil("OK_Button");
			CommonWebActions.webClick("OK_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("SalesOrder_Submit");

			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number",
					App_CommonFunctions.orderNoFetch("OrderNo"));
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Due_Date",
					App_CommonFunctions.orderNoFetch("Due_value"));
			CommonWebActions.wait(3000);
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "PASS");
			test.log(Status.PASS, "Submit  Page is displayed"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
			System.setProperty("jacob.dll.path", System.getProperty("user.dir") + "\\jacob-1.17-M2-x86.dll");
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Not Completed");
		} catch (Exception e) {
			CommonWebActions.closeAlerts();
			ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Script_Status", "FAIL");
			test.log(Status.FAIL, "Test Case Failed:" + testcasename + ":"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Failed TC")));
			ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
			ALMTestfactory.updateResults("E2EMM Automation", "Sprint4", 39921, testcasename, "Fail");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
  
        }


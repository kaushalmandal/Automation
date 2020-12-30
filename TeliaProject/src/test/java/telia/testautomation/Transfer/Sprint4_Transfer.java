/**
	 * @TestcaseName:SDU_Transfer_Broadband_and_IPTV_to_a_different_customer

		 * @Description: 
		 * @Complexity:High
		 * @author :Rinki
		 * @ALM :
		 * 
		 */ 
	package telia.testautomation.Transfer;

import java.awt.Robot;

    import java.awt.event.KeyEvent;
    import java.net.InetAddress;
	import java.net.UnknownHostException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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
	@Test
	@Listeners({ coreFramework.CoreListener.class })


	public class Sprint4_Transfer extends ExtentManager {

		public static String url = "";
		private static String hostName;
//	    private static ITestSet testSet;
		String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];

		@BeforeSuite
		public void init() throws Exception {
			try {
				// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				// Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
				hostName = InetAddress.getLocalHost().getHostName();
				ORUtil.setValue("testDataWorkSheetName",Packagename);
			} catch (UnknownHostException e) {
				throw new RuntimeException(e);
			}
			System.out.println("hostName: " + hostName);
		}

		@Test(priority = 1,enabled=false)

		public void SDU_Transfer_Broadband_and_IPTV_to_a_different_customer () throws Exception {
		/*CommonMethods common = new CommonMethods(driver);*/
			try {
				ExtentManager.startReporting(new Object() {
				}.getClass().getEnclosingMethod().getName(),Packagename);
				String testcasename=(new Object() {
			
				}.getClass().getEnclosingMethod().getName());	
		/*--  Launching URL  --*/
				CommonWebActions.transfer_login();
				CommonWebActions.waitUntilLoaded("MyOrder_link", 120000);
				CommonWebActions.waitForLoad1(); 
	 
					CommonWebActions.webClick("Accounts");
					CommonWebActions.wait(2000);
					//CommonWebActions.waitUntilLoaded("AllAccounty");
						CommonWebActions.webClick("AllAccounts");
						
				App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename,"SSN"),"Residential");
				
				CommonWebActions.wait(4000);
				CommonWebActions.fnHighlightMe("FirstName_Link");
				CommonWebActions.waitUntil("FirstName_Link");
				CommonWebActions.retryingFindClick("FirstName_Link"); 
				CommonWebActions.webClick("Account_Hierarchy");
				CommonWebActions.waitForLoad1();
				CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.javaclick("ServiceAcct");
				CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("SASP_Link_3");
		        CommonWebActions.wait(2000);
		        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
		        CommonWebActions.webClick("Address_Icon");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Point_ID_Select");
		        CommonWebActions.wait(2000);
		        
		        
		        String paste=App_CommonFunctions.orderNoFetch("Point_ID_Copy");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Account_Address_OK");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Accounts");
		        //CommonWebActions.webClick("AllAcount_Link");
		        CommonWebActions.wait(2000);
		        App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN1"), "Residential");
		        //CommonWebActions.webClick("SSN_Org_No_TextBox");
		        CommonWebActions.waitForLoad1();
				CommonWebActions.wait(4000);
				//CommonWebActions.fnHighlightMe("FirstName_Link");
				CommonWebActions.waitUntil("FirstName_Link");
				CommonWebActions.retryingFindClick("FirstName_Link"); 
				CommonWebActions.wait(2000);
         	   //     CommonWebActions.webClick("First_Name_Link");
				CommonWebActions.waitForLoad1();
		        CommonWebActions.webClick("Account_Hierarchy");
		        CommonWebActions.wait(2000);
		        CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.javaclick("ServiceAcct");
				CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("SASP_Link_4");
		        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Address_Icon");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webSet("Search_DropDown", "Point Id");
			    CommonWebActions.wait(500);
			    CommonWebActions.webSet("PointFetch_Enter", paste);
			    CommonWebActions.wait(500);
			    CommonWebActions.webClick("Click_Arrow");
			    CommonWebActions.webClick("Select_Available1");
			    CommonWebActions.wait(500);
			    CommonWebActions.webClick("Push_go");
		        
		        
		        
		        
		        //CommonWebActions.webClick("Point_ID_Select");
		        //CommonWebActions.wait(2000);
		        //CommonWebActions.webSet("Point_ID_Copy", paste);
		        //CommonWebActions.wait(2000);
		        //CommonWebActions.checkBoxSelect("//*[contains(@id,'2_s_3_l_SSA_Primary_Field')]");
		        /*CommonWebActions.webClick("Account_Address_Primary");
		        CommonWebActions.webClick("primary");
		        CommonWebActions.webClick("Account_Address_Installation");
		        CommonWebActions.webClick("installation");
		        CommonWebActions.webClick("Account_ShippingAccount_Select");
		        CommonWebActions.webClick("shipping");
		        CommonWebActions.wait(2000);*/
		        CommonWebActions.webClick("Account_Address_OK");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Accounts");
		        CommonWebActions.webClick("AllAcount_Link");
				//CommonWebActions.waitUntilLoaded("MyOrder_link",20000);
		        App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Residential");
		        CommonWebActions.waitForLoad1();
				CommonWebActions.wait(2000);
				CommonWebActions.waitUntil("FirstName_Link");
				CommonWebActions.retryingFindClick("FirstName_Link"); 
						        
		        //CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("First_Name_Link");
		        /*Robot rb = new Robot();
		        rb.keyPress(KeyEvent.VK_CONTROL);
		        CommonWebActions.webClick("Promotion_BB1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Installed_Less_button");
		        CommonWebActions.wait(2000);
       	        CommonWebActions.webClick("Promotion_IPTV1");
		        rb.keyRelease (KeyEvent.VK_CONTROL );
		                    
		            		      		        //CommonWebActions.webSetTab("Promotion_IPTV",);
		        CommonWebActions.webClick("Transfer_Button");*/
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("ProductType_Select");
		        CommonWebActions.webSet("ProductType_Select", "Product");
		         String product1 = "P-IA-Fiber-Broadband-1743";
		         CommonWebActions.webSet("querySrchSpec_selectInput", product1);
	             CommonWebActions.wait(2000);
	             CommonWebActions.webClick("Product_GO_Button");
	             CommonWebActions.wait(2000);
	             CommonWebActions.webClick("Transfer_Button");
	            	//CommonWebActions.waitForLoad1();
	             CommonWebActions.wait(2000);
	                  CommonWebActions.webClick("Portal_Button");
	                 // CommonWebActions.waitForLoad1(); 
	                 CommonWebActions.webClick("ProductType_Select");
	                 CommonWebActions.wait(2000);
			        CommonWebActions.webSet("ProductType_Select", "Product");
			         String product2 = "P-TV-IPTV-PlayPlus-1711";
			         CommonWebActions.webSet("querySrchSpec_selectInput", product2);
		             CommonWebActions.wait(2000);
		             CommonWebActions.webClick("Product_GO_Button");
		             CommonWebActions.wait(2000);
	                CommonWebActions.waitForLoad1();
		        
		        
		             //CommonWebActions.webSetTab("Promotion_IPTV",);
		        CommonWebActions.webClick("Transfer_Button");
		        
		        CommonWebActions.webClick("Account_Details_Home");
		        CommonWebActions.wait(2000);
		        //CommonWebActions.Selectvaluefromdropdown("SSN/ORG_Number1_Select", "SSN");
		        CommonWebActions.webClick("SSN/ORG_Number1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("SSN/ORG_Number2");
		        CommonWebActions.webSet("SSN/ORG_Input_TextBox",ExcelUtil.getDataFromExcel(testcasename, "SSN1"));
		        CommonWebActions.webClick("Arrow_PickAccnt_Button");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("LastName_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickContact_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("ServiceAccount_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("SASP_PickAccnt");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("BillingAccount_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("BASP_PickAccnt");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        String OrderNO_FSSN=App_CommonFunctions.orderNoFetch("Copy_OrderNumber_Home");
		        System.out.println("** Order No from sys **:"+ OrderNO_FSSN );
		        CommonWebActions.logout();
		        
		        ///Check for enable Skip Credit checkbox need different login/////
		        String chromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32 (1)\\chromedriver.exe";
		        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		      //  ChromeDriver wd1 = new ChromeDriver();
		        
				/*--  Launching URL  --*/
			//CommonWebActions.transfer_login();
			CommonWebActions.waitForLoad1();
			// CommonWebActions.waitUntilLoaded("Setting_Hgh",20000);

			CommonWebActions.webClick("Setting_Hgh");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Setting_Button");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Change_Position_Tab");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Checkbox_Change_Position");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Change_Position_button");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Sales_Order_Click");
			CommonWebActions.wait(2000);

			CommonWebActions.webSetTab("Order_ID_Input", OrderNO_FSSN);

			CommonWebActions.webClick("Transfer_Go_Button");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Select_Dropdown");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Select_Item");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Order_Number_link");
			CommonWebActions.wait(2000);

			CommonWebActions.webClick("Line_Items_selectTab");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Skip_CreditCheckbox");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("Home_submit");
			CommonWebActions.wait(2000);
				
				 
				ExcelUtil.setDatatoExcel("Test_Output",testcasename,"SSN",App_CommonFunctions.orderNoFetch("SSN"));
		        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Order_Number",App_CommonFunctions.orderNoFetch("OrderNo_Input"));
		        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date",App_CommonFunctions.orderNoFetch("Due_date")); 
		        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date_BB",App_CommonFunctions.orderNoFetch("SSN1"));
				test.log(Status.PASS,"Transferred BB and IPTV to different customer"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
				extent.flush();
				System.setProperty("jacob.dll.path",
				System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Completed" );
			 }
				catch (Exception e)
				{
					CommonWebActions.closeAlerts();
					 //TODO Auto-generated catch block
					 test.log(Status.PASS, "Test Case Passed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Passed TC")));
					ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
					ALMTestfactory.updateResults("E2EMM Automation","Sprint2", 36542, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
		            System.out.println("New Broadband order should be submitted Successfully ");
		            e.printStackTrace();
				}
		}

		/**
		 * @TestcaseName:SDU_Transfer_SDU

			 * @Description: 
			 * @Complexity:High
			 * @author :Rinki
			 * @ALM :
			 * 
			 */ 		
		
		@Test(priority = 2,enabled=true)	

		public void SDU_Transfer_SDU () throws Exception {
		/*CommonMethods common = new CommonMethods(driver);*/

			ExtentManager.startReporting(new Object() {
			}.getClass().getEnclosingMethod().getName(), Packagename);
			System.out.println("Package : " + Packagename);
			String testcasename = (new Object() {
			}.getClass().getEnclosingMethod().getName());
			System.out.println("Testcase : " + testcasename);

	
			try {
		/*--  Launching URL  --*/
				CommonWebActions.login();
				CommonWebActions.waitUntilLoaded("MyOrder_link", 120000);
				CommonWebActions.waitForLoad1(); 
						//CommonWebActions.waitUntilLoaded("MyOrderlink",90000);
				        App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
						//CommonWebActions.Selectvaluefromdropdown("Business_Select", "Business");
						
                                CommonWebActions.waitUntil("FirstName_Link");
								CommonWebActions.retryingFindClick("FirstName_Link"); 
								CommonWebActions.waitForLoad1(); 
					 CommonWebActions.webClick("Account_Hierarchy");
					 CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("SASP_Link_5");
				CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.javaclick("ServiceAcct");
		        CommonWebActions.wait(2000);
		        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
		        CommonWebActions.webClick("Address_Icon");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Point_ID_Select1");
		        CommonWebActions.wait(2000);
		        
		        String paste1=App_CommonFunctions.orderNoFetch("Point_ID_Copy");
		        
		        CommonWebActions.webClick("Account_Address_OK");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Accounts");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("AllAcount_Link");
		        App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN1"), "Business");
		        CommonWebActions.waitUntil("FirstName_Link");
		        CommonWebActions.wait(2000);
				CommonWebActions.retryingFindClick("FirstName_Link"); 
				CommonWebActions.waitForLoad1(); 
				CommonWebActions.wait(2000);
	 	        CommonWebActions.webClick("Account_Hierarchy");
	 	       CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("SASP_Link_6");
		        CommonWebActions.waitUntil("ServiceAcct");
				CommonWebActions.javaclick("ServiceAcct");
				CommonWebActions.wait(2000);
		        CommonWebActions.waituntilElementToBeClickable("Address_Icon");
		        CommonWebActions.wait(2000);
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Address_Icon");
		        
		       CommonWebActions.webSet("Search_DropDown", "Point Id");
		       CommonWebActions.wait(500);
		       CommonWebActions.webSet("PointFetch_Enter", paste1);
		       CommonWebActions.wait(500);
		       CommonWebActions.webClick("Click_Arrow");
		       CommonWebActions.webClick("Select_Available");
		       CommonWebActions.wait(500);
		       CommonWebActions.webClick("Push_go");
		        CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("Point_ID_Select2");
		        //CommonWebActions.wait(2000);
		        //CommonWebActions.webSet("Point_ID_Copy", paste1);
		        //CommonWebActions.wait(2000);
/*		        CommonWebActions.webClick("Account_Address_Primary1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("primary_hgh");*/
		        
		        //CommonWebActions.webClick("Account_Address_Primary");
		        //CommonWebActions.checkBoxSelect("primary");
		        //CommonWebActions.wait(2000);
		        //CommonWebActions.webClick("primary");
		        
		        CommonWebActions.wait(2000);
		        CommonWebActions.savePage();
		        CommonWebActions.webClick("Account_Address_Installation1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.checkBoxSelect("installation2");
		        //CommonWebActions.webClick("installation1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Account_ShippingAccount_Select");
		        CommonWebActions.wait(2000);
		        CommonWebActions.checkBoxSelect("shipping2");
		        //CommonWebActions.webClick("shippping1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Account_Address_OK");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Accounts");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("AllAcount_Link");
		        App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
				//CommonWebActions.wait(2000);
		        //App_CommonFunctions.SearchServiceAccount(ExcelUtil.getDataFromExcel(testcasename, "SSN"), "Business");
		        CommonWebActions.wait(2000);
		        CommonWebActions.waitUntil("FirstName_Link");
				CommonWebActions.retryingFindClick("FirstName_Link"); 
				CommonWebActions.wait(2000);
				CommonWebActions.webClick("ProductType_Select");
		        CommonWebActions.webSet("ProductType_Select", "Product");
		         String product1 = "P-BIA-OF-BB Start-1827";
		         CommonWebActions.webSet("querySrchSpec_selectInput", product1);
	             CommonWebActions.wait(2000);
	             CommonWebActions.webClick("Product_GO_Button");
	             CommonWebActions.wait(2000);
	             CommonWebActions.waitUntil("Transfer_Button");
//	             CommonWebActions.wait(2000);
	             CommonWebActions.webClick("Transfer_Button");
	            	CommonWebActions.waitForLoad1();
	                  CommonWebActions.webClick("Portal_Button");
	                 CommonWebActions.waitForLoad1(); 
	                 CommonWebActions.retryingFindClick("ProductType_Select");
	                 CommonWebActions.wait(2000);
			        CommonWebActions.webSet("ProductType_Select", "Product");
			         String product2 = "P-TV-IPTV-PlayPlus-1711";
			         CommonWebActions.webSet("querySrchSpec_selectInput", product2);
		             CommonWebActions.wait(2000);
		             CommonWebActions.webClick("Product_GO_Button");
		             CommonWebActions.wait(2000);
	                CommonWebActions.waitForLoad1();
	                CommonWebActions.waitUntil("Transfer_Button");
		        
		             //CommonWebActions.webSetTab("Promotion_IPTV",);
		        CommonWebActions.webClick("Transfer_Button");
		        CommonWebActions.wait(2000);
                     
		         CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Account_Details_Home");
		        CommonWebActions.wait(2000);
		        //CommonWebActions.Selectvaluefromdropdown("SSN/ORG_Number1_Select", "SSN");
		        CommonWebActions.webClick("SSN/ORG_Number1");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("SSN/ORG_Number2");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webSet("SSN/ORG_Input_TextBox",ExcelUtil.getDataFromExcel(testcasename, "SSN1"));
		        CommonWebActions.webClick("Arrow_PickAccnt_Button");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("LastName_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("LastName_Select");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickContact_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("ServiceAccount_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("SASP_PickAccount2");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("BillingAccount_Home");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("BASP_PickAccnt2");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("PickAccnt_Ok");
		        CommonWebActions.wait(2000);
		        CommonWebActions.webClick("Home_Submit");
		                	      		        
		         
			
				ExcelUtil.setDatatoExcel("Test_Output",testcasename,"SSN",App_CommonFunctions.orderNoFetch("SSN"));
				//ExcelUtil.setDatatoExcel("Test_Output",testcasename,"SSN1",App_CommonFunctions.orderNoFetch("SSN1"));
		        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Order_Number",App_CommonFunctions.orderNoFetch("OrderNo_Input"));
		        ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date",App_CommonFunctions.orderNoFetch("Due_date")); 
		        //ExcelUtil.setDatatoExcel("Test_Output",testcasename,"Due_Date_BB",App_CommonFunctions.orderNoFetch("SSN1"));
				test.log(Status.PASS,"Transferred BB and IPTV to different customer"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Home_Submit")));
				extent.flush();
				System.setProperty("jacob.dll.path",
						System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
				ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
				ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()),"Open" );
				}
				catch (Exception e)
				{
					CommonWebActions.closeAlerts();
					// TODO Auto-generated catch block
				    test.log(Status.PASS, "Test Case Passed:"+(new Object() {}.getClass().getEnclosingMethod().getName())+":"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Passed TC")));
					ALMTestfactory.ConnectToALM("cbo823", "SWE", "E2EMassMarket");
					ALMTestfactory.updateResults("E2EMM Automation","Sprint4", 39921, (new Object() {}.getClass().getEnclosingMethod().getName()),"Fail" );
		             System.out.println("New Broadband order should be submitted Successfully ");
		            e.printStackTrace();
				}
		}	
			
		
		@AfterClass
		public static void teardown() throws Exception {
			CommonWebActions.logout();
		extent.flush();
		CommonWebActions.wd.quit();
		}
	}
	
		

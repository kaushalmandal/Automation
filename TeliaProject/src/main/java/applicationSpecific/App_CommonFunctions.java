package applicationSpecific;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

public class App_CommonFunctions extends ExtentManager {
      
	
	public static void SearchServiceAccount(String SSN_No,String AccountType) throws Exception{
		 try {
			 CommonWebActions.waitUntil("Account_Tab");
			CommonWebActions.webClick("Account_Tab"); 
			 CommonWebActions.waituntilElementToBeClickable("AllAcount_Link");
			 
			 CommonWebActions.webClick("AllAcount_Link");
			 CommonWebActions.waituntilElementToBeClickable("SearchAccount_Button");
			 CommonWebActions.webClick("SearchAccount_Button");
			 
			 CommonWebActions.webSet("SSN_Org_No_TextBox", SSN_No);
			 CommonWebActions.webSet("AccountType_SearchCustomer", AccountType);
			 CommonWebActions.wait(3000);
			 CommonWebActions.webClick("ResidentialMenuItem_Select");
			 CommonWebActions.wait(1000);
             WebDriverWait wait = new WebDriverWait (CommonWebActions.wd, 30);
             wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search Customer:Go']"))).click();
//			 CommonWebActions.waitUntil("Customer_Go_Button");
//			 CommonWebActions.webClick("Customer_Go_Button");
			 CommonWebActions.wait(5000);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void SearchOrgAccount(String SSN_No,String AccountType) throws Exception{
		 try {
			 CommonWebActions.waitUntil("Account_Tab");
			 CommonWebActions.webClick("Account_Tab"); 
			 
			 CommonWebActions.waitUntil("AllAcount_Link");
			 CommonWebActions.webClick("AllAcount_Link");
			 
			 CommonWebActions.waitUntil("SearchAccount_Button");
			 CommonWebActions.webClick("SearchAccount_Button");
			 
			 CommonWebActions.waitUntil("SSN_Org_No_TextBox");
			 CommonWebActions.webSet("SSN_Org_No_TextBox", SSN_No);
			 CommonWebActions.webSet("AccountType_SearchCustomer", AccountType);
			 CommonWebActions.wait(1000);
			 CommonWebActions.webClick("BusinessMenuItem_Select");
			 CommonWebActions.wait(5000);
			 
			 //CommonWebActions.scrollIntoWebElement1("Go_Button");
			 CommonWebActions.waitUntil("Search_Customer_Go_Button");
			 CommonWebActions.webClick("Search_Customer_Go_Button");			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void SearchServiceAccount1(String SSN_No,String AccountType) throws Exception{
        try {
              CommonWebActions.webClick("Account_Tab"); 
               CommonWebActions.waituntilElementToBeClickable("AllAcount_Link");
              CommonWebActions.webClick("AllAcount_Link");
              CommonWebActions.waituntilElementToBeClickable("SearchAccount_Button");
              CommonWebActions.webClick("SearchAccount_Button");
              CommonWebActions.waitUntil("SSN_Org_No_TextBox");
              CommonWebActions.webSet("SSN_Org_No_TextBox", SSN_No);
              CommonWebActions.webSet("AccountType_SearchCustomer", AccountType);
              CommonWebActions.wait(1000);
              //CommonWebActions.webClick("ResidentialMenuItem_Select");
              CommonWebActions.wait(1000);
//            CommonWebActions.waituntilElementToBeClickable("Go_Button");
//            CommonWebActions.webClick("Go_Button");
              CommonWebActions.scrollIntoWebElement1("Go_Button");
//            WebElement element = driver.findElement(By("element_path"));
//            Actions actions = new Actions(CommonWebActions.wd);
//            WebElement element=CommonWebActions.findElement("Go_Button");
//            actions.moveToElement(element).click().perform();
              WebDriverWait wait = new WebDriverWait (CommonWebActions.wd, 30);
              wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search Customer:Go']"))).click();
//            CommonWebActions.fnHighlightMe("Go_Button");
//            CommonWebActions.webClick("Go_Button");
              
        } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
	}
    public static boolean checknaddEmail(String xpath) throws Exception {
  	 try {
  	  By find = CommonWebActions.getWebElement1(xpath);
  	  String email=CommonWebActions.wd.findElement(find).getText();
  	  if(email.equals(null)) {
  		  CommonWebActions.javaSet(xpath, "abc@hotmail.com");
  		  System.out.println("Email value not found so passed a dummy value");
  		  return true;
  	  }
  	  else {
  		  System.out.println(email);
  		  return true;
  	  }
  	 }
  	 catch (Exception e) {
  		 System.out.println("Some Exception is thrown");
  		 return false;
  	 }
    }
    public static void verify_Primary_Checkbox()throws Exception {
        try {
      	  if(CommonWebActions.wd.findElement(By.xpath("//input[contains(@id,'SSA_Primary_Field')]")).isSelected()==false)
      	  {
      		  CommonWebActions.webClick("Primary_Field_checkbox");
      	  }
        }
                catch (Exception e) {
              test.log(Status.FAIL, "verify Service Bundle and Product failed-" + e);
              e.printStackTrace();
        }
  }
 
    public static void verify_Installation_Checkbox()throws Exception {
        try {
      	  if(CommonWebActions.wd.findElement(By.xpath("//input[contains(@id,'TS_Installation_Address_Flag')]")).isSelected()==false)
      	  {
      		  CommonWebActions.webClick("Installation_Address_checkbox");
      	  }
        }
                catch (Exception e) {
              test.log(Status.FAIL, "verify Service Bundle and Product failed-" + e);
              e.printStackTrace();
        }
  }
    public static void addressnCopperAdd() throws Exception {
    	try {
    	WebElement check = CommonWebActions.getWebElement("AccountHierarchyTab");
    	Boolean condition = check.isDisplayed();
    	if(!condition) {
    		App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
    		App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
    		App_CommonFunctions.checkBoxSelect("PremiseCheckbox");				
    		CommonWebActions.webClick("CopperMaxHD");
    		CommonWebActions.webSet("CopperMaxHDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("CopperMaxSD");
    		CommonWebActions.webSet("CopperMaxSDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("AddressOkBtn");
    		CommonWebActions.waitUntil("ContactsBtn");
    	}
    	else {
    		CommonWebActions.waitUntil("SalesAddressApplet");
    		CommonWebActions.implicitWait(CommonWebActions.wd, 5);
    		CommonWebActions.webClick("SalesAddressApplet");
    		CommonWebActions.waitUntil("SalesAddressAfterDiv");
    		App_CommonFunctions.checkBoxSelect("PrimaryCheckbox");
    		App_CommonFunctions.checkBoxSelect("InstalationCheckbox");
    		App_CommonFunctions.checkBoxSelect("PremiseCheckbox");				
    		CommonWebActions.webClick("CopperMaxHD");
    		CommonWebActions.webSet("CopperMaxHDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("CopperMaxSD");
    		CommonWebActions.webSet("CopperMaxSDIp", "2");
    		CommonWebActions.wait(500);
    		CommonWebActions.webClick("AddressOkBtn");
    		CommonWebActions.waitUntil("ContactsBtn");

    	}
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}

    } 
    public static void verify_Shipping_Checkbox()throws Exception {
        try {
      	  if(CommonWebActions.wd.findElement(By.xpath("//input[contains(@id,'TS_Shipping_Address_Flag')]")).isSelected()==false)
      	  {
      		  CommonWebActions.webClick("Shipping_Address_checkbox");
      	  }
        }
                catch (Exception e) {
              test.log(Status.FAIL, "verify Service Bundle and Product failed-" + e);
              e.printStackTrace();
        }
  }
    public static boolean checkBoxSelect(String xpath) throws Exception {
  	  try {
  		  WebElement Field=CommonWebActions.getWebElement(xpath);
  		  String Status1=Field.getAttribute("title");
  		  System.out.println(Status1);    		 
  		  if(Status1.equalsIgnoreCase("Checked")) {
  			  
  			  System.out.println(xpath+ " was already checked");
  			  test.log(Status.PASS, xpath+ "was already checked");
  			  return true;
  		  }
  		  else {
  			  CommonWebActions.javaclick(xpath);
//  			  Field.click();
  			  System.out.println(xpath+ " was not checked so Checking it");
  			  test.log(Status.PASS, xpath+ " was not already checked but checked now");
  			  return true;
  		  }
  	  }
  	  catch (Exception e) {
  		  test.log(Status.FAIL, xpath+ "has some issues"); 
  		  return false;
  	  }
    }
    
    public static boolean checkBox(String xpath) throws Exception {
  	  try {
  		  WebElement Field=CommonWebActions.getWebElement(xpath);
  		  String value=Field.getAttribute("aria-checked");
  		  System.out.println(value);    		 
  		  if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("Y")) {
  			  
  			  System.out.println(xpath+ " was already checked");
  			  test.log(Status.PASS, xpath+ "was already checked");
  			  return true;
  		  }
  		  else {
  			  Field.click();
  			  System.out.println(xpath+ " was not checked so Checking it");
  			  test.log(Status.PASS, xpath+ " was not already checked but checked now");
  			  return true;
  		  }
  	  }
  	  catch (Exception e) {
  		  test.log(Status.FAIL, xpath+ "has some issues"); 
  		  return false;
  	  }
    }
    
    public static void imageCheck(String imgxpath, String refresh) throws Exception {
  	  boolean ImagePresent = false;
  	  int attempts = 0;
  	  while(attempts < 3) {
  		  try {
  			  WebElement Image=CommonWebActions.getWebElement(imgxpath);
  			  ImagePresent = (Boolean) ((JavascriptExecutor)CommonWebActions.wd).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Image);
  			  if (ImagePresent)
  			  {
  				  ImagePresent = true;
  				  System.out.println("Image is displayed.");
  				  break;	       		         

  			  }
  			  else
  			  {
  				  System.out.println("Image is not there and hence refreshing...");
  				  WebElement RefreshBtn=CommonWebActions.getWebElement(refresh);
  				  RefreshBtn.click();
  			  }
  		  } catch(NoSuchElementException e) {
  			  System.out.println("Image is not there and hence refreshing...after 5 click on refresh button");
  		  }
  		  attempts++;
  	  }

    }
    
	public static void NewLineITem(int rowno,String Columnname,String StrTexttoSend) throws Exception{
		int Line_Item_Column_Count=CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th")).size();
		List<WebElement> Column_Header = CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th"));
		List<WebElement> LineItem_Data=CommonWebActions.wd.findElements(By.xpath("//*[@id="+rowno+"]/td"));
   		for(int i=0;i<Line_Item_Column_Count;i++){
			String Column_Name=Column_Header.get(i).getText();
			if((Columnname).trim().equalsIgnoreCase(Column_Name.trim())){
				WebElement objName=LineItem_Data.get(i);
				CommonWebActions.javaSet1(objName, StrTexttoSend);
//				CommonWebActions.Tab();
				CommonWebActions.wait(1000);
			}
		}
	}
	
	
      /**Function :1
      * This method is used to Naviagte to Account tab and search SSN Number.
      * @author: R.Suresh Babu
      * @param MenuItemInput,SSN_No      * 
       */
      public static void navigateAndSearchBySSN(String MenuItemInput, String SSN_No) throws Exception {
            try {
                  CommonWebActions.webClick("Account_Tab"); 
                  CommonWebActions.waituntilElementToBeClickable("AllAcount_Link");
                  CommonWebActions.webClick("AllAcount_Link");
                  CommonWebActions.webSetTab("SSNTypChos", MenuItemInput);         
                  CommonWebActions.webSetTab("SSN_Org_Input", SSN_No);
                  CommonWebActions.webClick("SSNAcctGoBtn");
                  
                  CommonWebActions.wait(1000);
                  /*CommonWebActions.webClick("CustmrNameLnkClk");
                  CommonWebActions.wait(1000);*/
            } catch (Exception e) {
                  test.log(Status.FAIL, "SSN Invalid/SSN Search failed-"+e);
                  e.printStackTrace();
            }
      }
    /*  public static void NewLineITem(String Columnname,String StrTexttoSend) throws Exception{
          int Line_Item_Column_Count=CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th")).size();
          List<WebElement> Column_Header = CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th"));
          List<WebElement> LineItem_Data=CommonWebActions.wd.findElements(By.xpath("//*[@id='1']/td"));
          for(int i=0;i<Line_Item_Column_Count;i++){
                String Column_Name=Column_Header.get(i).getText();
//              String ColumnHeader="Product";
                
                if((Columnname).trim().equalsIgnoreCase(Column_Name.trim())){
                      WebElement objName=LineItem_Data.get(i);
                      CommonWebActions.javaSet1(objName, StrTexttoSend);
                }
                System.out.println(Column_Name);
          }
    }*/

      
      /**Function :2 
       * This method is used to verify Service Bundle and Product
      * @author: R.Suresh Babu
      * @param ProductType,ServiceBundle_Broadband, ExpectedAccesssType, Product_Broadband
      */
      public static void verifyserviceBundleandProduct(String ProductType, String ServiceBundle_Broadband, String ExpectedAccesssType, String Product_Broadband)  throws Exception {
            try {
//                  CommonWebActions.wait(3000); 
                  //-- Enter Product Type and Service Bundle and click on Go Button --//
                  CommonWebActions.webSet("ProductType_Input", ProductType);           
                  CommonWebActions.webSet("QuerySrchSpec_Input", ServiceBundle_Broadband);
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Installed_Assets_Go_Button");
                  CommonWebActions.wait(2000);
                  CommonWebActions.waitForLoad1();
                  
                  CommonWebActions.webSet("ProductType_Input", ProductType);
                  CommonWebActions.webSet("QuerySrchSpec_Input", Product_Broadband);
                  CommonWebActions.wait(3000);
                  //-- Click on Go Button --//
                  CommonWebActions.webClick("Installed_Assets_Go_Button");
                  CommonWebActions.wait(3000);
                  CommonWebActions.waitForLoad1();
                  
                  //-- Verify the Product by using Fun webVerifyInnerText() --//
                  System.out.println("** ProductType **: " + Product_Broadband);
                  /*/////////////CommonWebActions.webVerifyInnerText("Product_Name", Product_Broadband);*/  
                  /* try {
            	  String actualText = App_CommonFunctions.orderNoFetch("Product_Name");
                  System.out.println(actualText);
                  if (actualText.equals(Product_Broadband)) {
                	  test.log(Status.PASS, "Status of actual & Expected is Same " + test
                          .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));  
                 
                  } else {
						test.log(Status.Fail, "Status of actual & Expected is Not Same " + test
                          .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));  
                 
                  }
           } catch (Exception e) {
						test.log(Status.Fail, "Status of actual & Expected is Not Same " + test
                          .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound")));  
          
           }*/
                  //-- Click on Disconnect Button --//
                  CommonWebActions.wait(2000);
                  CommonWebActions.retryingFindClick("Disconnect_Button");
//                  CommonWebActions.webClick("Disconnect_Button");
                  CommonWebActions.waitForLoad1();
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify Service Bundle and Product failed-"+e);
                  e.printStackTrace();
            }
      }
      /**Function :3 
       * This method is used to  enter DueDate And Verify Action Code Status
      * @author: R.Suresh Babu
      * @param DueDate,ExpectedActionCodeStatus      * 
       */
      public static void enterDueDateAndVerifyActionCodeStatus(String DueDate, String ExpectedActionCodeStatus, String testcasename)throws Exception {
            try {
                  // -- Enter Due Date --//
            	  CommonWebActions.wait(1000);
                  CommonWebActions.webSetTab("Disconnect_DueDate_Input", DueDate);
                  
                  // -- Click on Continue button In POP-UP --//
                  CommonWebActions.wait(1000);
                  CommonWebActions.webClick("Continue_Button");                                   
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.implicitWait(CommonWebActions.wd, 25);
                  CommonWebActions.webExplicitWait("Portal_Button", 20);
                  // --- Verify the Action Code Status by using Fun webVerifyInnerText() --//
                  System.out.println("** ExpectedActionCodeStatus ** :" + ExpectedActionCodeStatus);
                  
                  //CommonWebActions.webVerifyInnerText("ActionCodeStatus", ExpectedActionCodeStatus);
                  
                  //-- calling screenshot --//
                  /*test.log(Status.PASS, "VOIP Modify Page [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd,"ClickFound")));*/ 
                 
                  // CommonWebActions.webClick("TreePlusExpand_Icon");
                  
                  /*String ServiceID = CommonWebActions.orderNoFetch("ServiceID");
                  System.out.println("************** ServiceID (out side) *************" + ServiceID);     */                        
                  
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify enter DueDate And Verify Action Code Status failed-" + e);
                  e.printStackTrace();
            }
      }

      /**Function :3.1
       * This method is used to  enter DueDate And Verify Action Code Status
      * @author: R.Suresh Babu
      * @param DueDate,ExpectedActionCodeStatus      * 
       */
      public static void enterDueDateforVOiPAndVerifyActionCodeStatus(String DueDate, String ExpectedActionCodeStatus, String testcasename)throws Exception {
            try {

                  SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Disconnect_DueDate_Input"));
                  Calendar cl = Calendar.getInstance();
                  cl.setTime(d);
                  cl.add(Calendar.MINUTE, 60);
                  String newtime = inputFormat.format(cl.getTime());
                  System.out.println(newtime);
                      

                  // -- Enter Due Date --//
                  CommonWebActions.wait(1000);
                  CommonWebActions.webSetTab("Disconnect_DueDate_Input", newtime);
                  
                  // -- Click on Continue button In POP-UP --//
                  CommonWebActions.wait(1000);
                     CommonWebActions.waitUntil("Continue_Button");
                  CommonWebActions.webClick("Continue_Button");                                   
                  CommonWebActions.waitForLoad1();
                  
                  // --- Verify the Action Code Status by using Fun webVerifyInnerText() --//
                  System.out.println("** ExpectedActionCodeStatus ** :" + ExpectedActionCodeStatus);
                  
                  //CommonWebActions.webVerifyInnerText("ActionCodeStatus", ExpectedActionCodeStatus);
                  
                  //-- calling screenshot --//
                  test.log(Status.PASS, "VOIP Modify Page [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
                 
                  // CommonWebActions.webClick("TreePlusExpand_Icon");
                  
                  /*String ServiceID = CommonWebActions.orderNoFetch("ServiceID");
                  System.out.println("************** ServiceID (out side) *************" + ServiceID);     */                        
                  
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify enter DueDate And Verify Action Code Status failed-" + e);
                  e.printStackTrace();
            }
      }

      
      /**Function :4 
       * This method is used to enter Reason Code and Submit
      * @author: R.Suresh Babu
      * @param ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status      * 
       */
      public static void enterReasonCodeandSubmit(String ReasonCode, String Expected_Activities_Type, String Expected_Activities_Status, String testcasename )throws Exception {
            try {
                  //-- Enter the Reason Code --//
            	CommonWebActions.wait(1000);
                  CommonWebActions.waitForLoad1();
//                  CommonWebActions.
//                  CommonWebActions.waitUntil("Disconnect_ReasonCode_Input");
                  CommonWebActions.waituntilElementToBeClickable("Disconnect_ReasonCode_Input");
                  CommonWebActions.EntertextThenPressTabAndSave("Disconnect_ReasonCode_Input", ReasonCode);
                  
                  // --Click on  Accept Unencrypted Email --// New
                  verify_UnEncryptedEmailFlag(testcasename);

                  //-- Click on Submit Button --//
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.waitUntil("SalesOrderSubmit_Button");
                  CommonWebActions.webClick("SalesOrderSubmit_Button");
                  CommonWebActions.waitForLoad1();
                  
                  // --- Verify the Action Code Status by using Fun webVerifyInnerText() --//
                 
                  // -- Taking Screenshot -- //                     
                  CommonWebActions.wait(1000);
                  test.log(Status.PASS, "Disconnect [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
                  
                  String OrderNO = App_CommonFunctions.orderNoFetch("OrderNo_Input");
                  System.out.println("************** OrderNO (out side)*************" + OrderNO);
                  //-- set Data in to Excel --//
                  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", OrderNO);
                  System.out.println("Order is generated and number :"+OrderNO);
                  
                  //--Verify the status --//
                  String status = ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID").trim();                  
                  refreshComplete("Order_Status", status);   
                  
                  //--Set Order Status into Excel --//
                  String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
      			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID); 
                   
                 /* CommonWebActions.waitForLoad1();
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("Activities_Tab");
                  CommonWebActions.webClick("Activities_Tab");
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("More_InfoTab");
                  CommonWebActions.waituntilElementToBeClickable("More_InfoTab");
                  CommonWebActions.webClick("More_InfoTab");
                  CommonWebActions.waitForLoad1();*/
                  
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("Activities_Tab");
                  CommonWebActions.webClick("Activities_Tab");
                  CommonWebActions.waitForLoad1();

                  // -- Taking Screenshot -- //
                  CommonWebActions.wait(1000);
                  test.log(Status.PASS, "Status of Type & Status in Activities tab FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
               
                  //--- Verify the Activities Tab Type by using Fun webVerifyInnerText() --// New
                  //CommonWebActions.webVerifyInnerText("ActivitiesTab_Type", Expected_Activities_Type);
                  
                  //--- Verify the Activities Tab Type by using Fun webVerifyInnerText() --// New
                  //CommonWebActions.webVerifyInnerText("ActivitiesTab_Status", Expected_Activities_Status);
                  
                  /*test.log(Status.PASS, "VOIP Modify Page [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
                  */
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify enter Reason Code and Submit failed-" + e);
                  e.printStackTrace();
            }
      } 

//---------------------------
      /**Function :5
       * This method is used to Click Portal Button to Disconnect Another Product
      * @author: R.Suresh Babu
      * @param ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status      * 
       */
      public static void clickPortalButtonToDisconnectAnotherProduct()throws Exception {
            try {
            	CommonWebActions.waitForLoad1();
                  CommonWebActions.waitUntil("Portal_Button");
                  CommonWebActions.waitForLoad1();
                  //CommonWebActions.divVisibility("executequeryToolbar_Button");
                  //CommonWebActions.webClick("executequeryToolbar_Button");
                  
                  String OrderNO = orderNoFetch("OrderNo_Input"); //Need to add return type
                  CommonWebActions.wait(1000);
                  CommonWebActions.webClick("Portal_Button");
                  CommonWebActions.waitForLoad1();
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify Service Bundle and Product failed-" + e);
                  e.printStackTrace();
            }
      }

//--------------------------  

      /**Function :6 
       * This method is used To veiry the Un-Encrypted Email flag and check
      * @author: 
      * @param ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status      * 
       */
      public static void verify_UnEncryptedEmailFlag(String testcasename)throws Exception {
            try {
            	//-- get Details for Un-encrypted email -- //
                String unencryptedEmail_Flag = ExcelUtil.getDataFromExcel(testcasename,"unencryptedEmail_Flag").trim();
                System.out.println("unencryptedEmail_Flag" + unencryptedEmail_Flag);
                boolean unencypted_flag=CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).isSelected();              //
                System.out.println("unencryptedEmail_Flag boolean ** " + unencypted_flag);
          	
           //-- get Details for ordersuppression_Flag -- //                 
                String ordersuppression_Flag = ExcelUtil.getDataFromExcel(testcasename,"ordersuppression_Flag").trim();
                boolean ordersuppression_flag=CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).isSelected();
              
               if (ExcelUtil.getDataFromExcel(testcasename,"unencryptedEmail_Flag").trim().equalsIgnoreCase("Y")|| (unencypted_flag==false) )
                {
            	   CommonWebActions.waitUntil("Accept_Unencrypted_Email");
            	   CommonWebActions.javaclick("Accept_Unencrypted_Email");
            	   CommonWebActions.waitForLoad1();
                }
               if(ExcelUtil.getDataFromExcel(testcasename,"ordersuppression_Flag").trim() == "N" && (ordersuppression_flag==false))
                    {
                     CommonWebActions.javaclick("ordersuppression_flag");
                      }
                else{
                      System.out.println("ordersuppression_Flag is not check");
                }}
                    catch (Exception e) {
                  test.log(Status.FAIL, "verify unencryptedEmail & Accept_Unencrypted_Email Flag  failed-" + e);
                  e.printStackTrace();
            }
      }

//-------------New
      /**Function :7
       * This method is used to enter Reason Code and Submit and Revise and submit
      * @author: R.Suresh Babu
      * @param ReasonCode, Expected_ActiviActivitiesTab_Type,Expected_ActivitiesTab_Status      * 
       */
      public static void enterReasonCodeandSubmitAndRevise(String ReasonCode, String Expected_Activities_Type, String Expected_Activities_Status, String testcasename )throws Exception {
            try {
                  //-- Enter the Reason Code --//
              CommonWebActions.wait(1000);
              CommonWebActions.waitUntil("Disconnect_ReasonCode_Input");
                  CommonWebActions.waituntilElementToBeClickable("Disconnect_ReasonCode_Input");
                  //CommonWebActions.scrollIntoWebElement1("ReasonCode_Input");
                  CommonWebActions.EntertextThenPressTabAndSave("Disconnect_ReasonCode_Input", ReasonCode);
                  
                  // --Click on  Accept Unencrypted Email --// New
                  verify_UnEncryptedEmailFlag(testcasename);
                  
                  //-- Click on Submit Button Disconnect --//
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("SalesOrderSubmit_Button");
                  CommonWebActions.webClick("SalesOrderSubmit_Button");
                  CommonWebActions.waitForLoad1();
                  
/*                  String status = ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID").trim();                  
                  refreshComplete("Order_Status", status);                  
                  String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
                  System.out.println("** StatusID (out side) ** :" + StatusID);*/
                  //-- Click on Revise Button --//
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.wait(4000);
                  CommonWebActions.waitUntil("Revise_Button");
                  CommonWebActions.webClick("Revise_Button");
                  CommonWebActions.waitForLoad1();
                  System.out.println("** Done the Revise Action ** : ");
               
                  //-- Get Revise Date from .xls and Enter into Due Date field --//
                  String ReviseDueDate = ExcelUtil.getDataFromExcel(testcasename, "Revise_Due_Date").trim();
                  System.out.println("** Due date for Revise ** : "+ ReviseDueDate);
                  CommonWebActions.EntertextThenPressTabAndSave("Revise_Due_date", ReviseDueDate);  
                  
                  //--
                /*  SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  Date d = inputFormat.parse(App_CommonFunctions.orderNoFetch("Btnlocator"));
                  Calendar cl = Calendar.getInstance();
                  cl.setTime(d);
                  cl.add(Calendar.MINUTE, 15);
                  String newtime = inputFormat.format(cl.getTime());
                  System.out.println(newtime);
                  CommonWebActions.webClick("Expand_bund");
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Expand_bund1");
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Suresh_Service_Record");
                  CommonWebActions.wait(3000);
                  CommonWebActions.wd.findElement(By.xpath("(//*[@aria-labelledby='s_3_l_altpick'])[1]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Expand_edit");
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Click_edit");
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Change_Record");
                  CommonWebActions.wait(3000);
                  CommonWebActions.webSet("Field_Due", ExcelUtil.getDataFromExcel(testcasename, "FieldDue"));
                  CommonWebActions.wait(6000);
                  //CommonWebActions.webSet("Due_value", ReviseDueDate);
                  CommonWebActions.webSet("Due_value",ExcelUtil.getDataFromExcel(testcasename, "Revise_Due_Date").trim());
                  CommonWebActions.wait(3000);
                  CommonWebActions.webClick("Value_Ok");
                  CommonWebActions.wait(3000); */
             
                  //--
                  //-- Click on Submit Button for Revise --//
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("SalesOrderSubmit_Button");
                  CommonWebActions.webClick("SalesOrderSubmit_Button");
                  CommonWebActions.waitForLoad1();
                  CommonWebActions.wait(1000);
                  
                  String status = ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID").trim();                  
                  refreshComplete("Order_Status", status);                  
                  String StatusID = App_CommonFunctions.orderNoFetch("Order_Status");
                  System.out.println("** StatusID (out side) ** :" + StatusID);
      			  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Status", StatusID);
                  
                  // -- Taking Screenshot -- //
                  test.log(Status.PASS, "Disconnect [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
                 
                  String OrderNO = App_CommonFunctions.orderNoFetch("OrderNo_Input");
                  System.out.println("************** OrderNO (out side)*************" + OrderNO);
                  //-- set Data in to Excel --//
                  ExcelUtil.setDatatoExcel("Test_Output", testcasename, "Order_Number", OrderNO);
                  
                  
                  
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("Activities_Tab");
                  CommonWebActions.webClick("Activities_Tab");
                                    
                  CommonWebActions.waitUntil("More_InfoTab");
                  CommonWebActions.webClick("More_InfoTab");
                  
                  CommonWebActions.wait(1000);
                  CommonWebActions.waitUntil("Activities_Tab");
                  CommonWebActions.webClick("Activities_Tab");
                  
                  // -- Taking Screenshot -- //
                  CommonWebActions.wait(1000);
                  test.log(Status.PASS, "Status of Type & Status in Activities tab FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
               
                  //--- Verify the Activities Tab Type by using Fun webVerifyInnerText() --// New
                  //CommonWebActions.webVerifyInnerText("ActivitiesTab_Type", Expected_Activities_Type);
                  
                  //--- Verify the Activities Tab Type by using Fun webVerifyInnerText() --// New
                  //CommonWebActions.webVerifyInnerText("ActivitiesTab_Status", Expected_Activities_Status);
                  /*test.log(Status.PASS, "VOIP Modify Page [" + ExcelUtil.getDataFromExcel(testcasename, "ExpectedStatusID") + " ]  FOUND on UI" + test
                              .addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickFound"))); 
                  */
            } catch (Exception e) {
                  test.log(Status.FAIL, "verify enter Reason Code and Submit failed-" + e);
                  e.printStackTrace();
            }
      }

      
      public static void creditCheck(String Btn, String ScoreField)  {
    	  WebElement CreditButton = CommonWebActions.getWebElement(Btn);
    	  By CreditLocator=CommonWebActions.getWebElement1(Btn);
    	  CreditButton.click();
    	  CommonWebActions.waitForLoad1();
    	  CommonWebActions.wait(2000);
    	  CommonWebActions.explicitClick(CommonWebActions.wd, 45, CreditLocator);
    	  String ExpectedText=orderNoFetch(ScoreField);
    	  if(ExpectedText.contains("NO_SCORING_NEEDED")) {
    		  System.out.println("Credit check has PASSED continue to submit the order");
    	  }
    	  else {
//    		  System.out.println("Credit check FAILED pls check");
    	  }
    	  
      }
      public static void DueDate_LineItem(int rowno,String StrTexttoSend) throws Exception{
  		int Line_Item_Column_Count=CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th")).size();
  		List<WebElement> Column_Header = CommonWebActions.wd.findElements(By.xpath("//*[@id='gview_s_3_l']/div[2]/div/table/thead/tr/th"));
  		List<WebElement> LineItem_Data=CommonWebActions.wd.findElements(By.xpath("//*[@id="+rowno+"]/td"));
     		for(int i=0;i<Line_Item_Column_Count;i++){
  			String Column_Name=Column_Header.get(i).getText();
//  			String ColumnHeader="Product";
  		

  			
  			if(("Due").trim().equalsIgnoreCase(Column_Name.trim())){
  				System.out.println("Entered in condition");
  				WebElement objName=LineItem_Data.get(i);
  		//          StrTexttoSend= "2019-02-24 00:00:00";
  				 JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
  				   executor.executeScript("arguments[0].click();", objName);
  				   executor.executeScript("$(document.getElementById('"+rowno+"_Due_Date').value='"+StrTexttoSend+"');");
  				   executor.executeScript("$(document.activeElement).trigger('change');");
//  				   executor.executeScript("arguments[0].style.border='4px groove green'", objName);
//  				   Thread.sleep(1000);
//  				   executor.executeScript("arguments[0].style.border=''", objName);
//  				   executor.executeScript("$(arguments[0]).blur();", objName);
//                     executor.executeScript("arguments[0].value='" + StrTexttoSend + "'", objName);
               //CommonWebActions.wd.findElement(ByAngularExactBinding.xpath("//*[@ng-model='orchesform.serviceName']")).sendKeys(strTextToSend);
                                 //sendkeys(“Test”);
                           //    //*[@ng-model='orchesform.serviceName'])").sendkeys(“Test”);
                     
                     //executor.executeScript("arguments[0].click();", lwebElement);
               //    executor.executeScript("element.focus();");
//                     executor.executeScript("$(arguments[0]).change();", objName);
//               executor.executeScript("$(document.activeElement).trigger('change');");
//                     executor.executeScript("$(arguments[0]).keydown();", objName);

  	     
//  	               executor.executeScript("arguments[0].value = '';", objName);
//  	               StringSelection stringSelection = new StringSelection(StrTexttoSend);
//  	               Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//  	               clipboard.setContents(stringSelection, stringSelection);
//  	               Robot robot = new Robot();
//  	               robot.keyPress(KeyEvent.VK_CONTROL);
//  	                robot.keyPress(KeyEvent.VK_A);
////  	               robot.keyPress(KeyEvent.VK_CONTROL);
//  	               robot.keyPress(KeyEvent.VK_DELETE);
//  	               robot.keyRelease(KeyEvent.VK_DELETE);
//  	               robot.keyRelease(KeyEvent.VK_CONTROL);
//  	                robot.keyRelease(KeyEvent.VK_A);
//  	               robot.keyPress(KeyEvent.VK_CONTROL);
//  	               robot.keyPress(KeyEvent.VK_V);
//  	               robot.keyRelease(KeyEvent.VK_V);
//  	               robot.keyRelease(KeyEvent.VK_CONTROL);
//  	               robot.delay(1000);
//  	               robot.keyPress(KeyEvent.VK_ENTER);
//  	               robot.keyRelease(KeyEvent.VK_ENTER);
//  	               robot.delay(1000);
//  				CommonWebActions.javaSet1(objName, StrTexttoSend);
  			
  				CommonWebActions.wait(1000);
  			}
//  			System.out.println(Column_Name);
  		}
  	}
      public static void voipphoneBook() throws Exception  {
      	try {
      		
      		CommonWebActions.webClick("Number_Lineitems");
      		CommonWebActions.waitUntil("PhoneSearchBtn");
      		CommonWebActions.webClick("PhoneSearchBtn");
      		CommonWebActions.waitForLoad1();
      		CommonWebActions.wait(4000);
      		CommonWebActions.waitUntil("Book_tab");
      		CommonWebActions.wd.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      		CommonWebActions.wait(2000);
      		List<WebElement> Phonenos = CommonWebActions.getWebElements("Phonelist");
      		Biglabel:
      		if(Phonenos.size()>0) {
      			System.out.println("Phone number LIST is DISPLAYED and hence booking one:"+Phonenos.size());
      			label:
      			for (int i=0;i<=Phonenos.size();i++) {
      				WebElement Number = Phonenos.get(i);
      				CommonWebActions.wait(2000);
      				JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
      				executor.executeScript("arguments[0].click();", Number);
      				CommonWebActions.waitUntil("Book_tab");
      				CommonWebActions.webClick("Book_tab");
      				CommonWebActions.webImplicitWait(10);
      				CommonWebActions.wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      				boolean alertpresent1=CommonWebActions.isAlertPresent();
      				if(alertpresent1){
      					CommonWebActions.closeAlerts();
      					CommonWebActions.waitForLoad1();
      					CommonWebActions.waitUntil("Book_tab");
      					continue label;
      				}else{
      					break Biglabel;
      				}
      			}
      			

      		}
      		else {
      			System.out.println("PHONE NUMBER LIST IS NOT DISPLAYED");
      		}
      		 
      		
      		
      	}
      	catch (Exception e) {
      		e.getMessage();
      		System.out.println("Some Exception is thrown please check");
      	}
      }
      
      ///-----------
      
      public static String orderNoFetch(String Btnlocator) {
          JavascriptExecutor js = (JavascriptExecutor)CommonWebActions.wd;
          WebElement OrderNum = CommonWebActions.getWebElement(Btnlocator);
          String OrderNo = js.executeScript("return arguments[0].value", OrderNum).toString();
          System.out.println(OrderNo);
          test.log(Status.PASS, OrderNo+ "was fetched");
          return OrderNo;
        }
      
      public static void refreshComplete(String Field, String Status2Chk) {
	    	try {		
//	    		JavascriptExecutor js = (JavascriptExecutor)driver;
//	    		WebElement Fieldelement = driver.findElement(Field);
//	    		String ActualStatus = js.executeScript("return arguments[0].value", Fieldelement).toString();
	    		
	    		label:
	    			for(int i=1;i<10;i++) {
	    				JavascriptExecutor js = (JavascriptExecutor)CommonWebActions.wd;
	    				
	    				WebElement Fieldelement = CommonWebActions.getWebElement(Field);
	    				String ActualStatus = js.executeScript("return arguments[0].value", Fieldelement).toString();
	    				if(Status2Chk.equalsIgnoreCase(ActualStatus)) {
	    					test.log(Status.PASS,"ACtual status:"+ActualStatus+"is same as expected"+Status2Chk);
	    					System.out.println("Speed Change is applied");	
	    					break label;
	    				}
	    				else {
	    					System.out.println("Status is not updated yet and hence refreshing.."+ActualStatus);
//	    					String press = Keys.chord(Keys.ALT,Keys.ENTER);
//	    					Fieldelement.click();
//	    					Thread.sleep(250);
//	    					Fieldelement.sendKeys(press);
//	    					CommonWebActions.wd.navigate().refresh();
	    					ActualStatus = null;
//	    					clickBtn(RefreshBttn);
	    					Thread.sleep(10000);
	    				}
	    				
	    			}
	    	}
	    	catch(Exception e) {
	    		e.getMessage();
	    		test.log(Status.FAIL, "Some other status is found ");
	    		System.out.println("Some other status is found ");	
	    	}
	    }
      
      public static void waitForLoad1(WebDriver driver) {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                  public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                  }
            };
            WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 30);
            wait.until(pageLoadCondition);
      }
      
      public static void emailAddifNot() throws Exception  {

    	  CommonWebActions.javaclick("Emailtable");
    	  CommonWebActions.wait(20);
    	  String emailservice=orderNoFetch("EmailIp");
    	  if(emailservice.isEmpty()) {
    		  CommonWebActions.webSet("EmailIp", "abc@hotmail.com");
    		  CommonWebActions.savePage();
    		  CommonWebActions.wait(500);
    	  }
    	  else {
    		  System.out.println("Email is already present and it reads: " +emailservice );
    	  }
      }
      
      public static void SearchAddressPopup(int rowno, String Columnname, String StrTexttoSend) throws Exception {
			try {
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
			catch(Exception e) {
	    		e.getMessage();
	    		test.log(Status.FAIL, "Some other status is found ");
	    		System.out.println("Some other status is found ");	
	    	}
		}

      public static void SelectAddress(String PointID) throws Exception {

			WebElement Input_Data = CommonWebActions.wd.findElement(By.xpath("//td[@title=" + PointID + "]"));
			Input_Data.click();
			CommonWebActions.wait(1000);
		}
      
      public static void listnotemptycheck(String list) throws Exception 
      {
      	List<WebElement> DynamicList = CommonWebActions.getWebElements(list);
      	if(DynamicList.size()>1)
      	{
      		System.out.println("The List is not empty so can continue"  + DynamicList.size());
      		
      	}
      	else {
      		System.out.println("The list is empty so terminating the flow");
      		test.log(Status.FAIL,  " Product List was empty before searching");
      		extent.flush();    		
      		Assert.assertTrue(false);
      	}
      }
      
      public static void promotioncount(String list)
      {
      	List<WebElement> DynamicList = CommonWebActions.getWebElements(list);
      	if(DynamicList.size()!=0) 
      	{
      		System.out.println("Promotion is found in the list");
      	}
      	else 
      	{
      		System.out.println("Promotion is not found in the list");
      		test.log(Status.FAIL,  " Promotion is not found on the list");
      		extent.flush();
      		Assert.assertTrue(false);
      	}
      }
      
      public static void lineItemCustomize(String Type, String Service, String GoBtn, String waitfor) throws Exception 
      {
      	CommonWebActions.webSet("LineTyp", Type );
      	CommonWebActions.webSet("LinePromo", Service);
      	CommonWebActions.webClick(GoBtn);
      	CommonWebActions.waitUntil(waitfor);

      }
      
    
}

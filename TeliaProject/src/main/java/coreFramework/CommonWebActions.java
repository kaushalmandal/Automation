package coreFramework;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Function;

//import telia.testautomation.move.Sprint3_Move_Service;

//import coreFramework.Sprint3_Move_Service;

/**
 * This class consists of all the common methods required to perform actions on
 * web application
 * 
 * @author kapildev J
 * @version 1.0
 * @since 10-Dec-2018
 */
public class CommonWebActions extends ExtentManager {

	//FIXME set to private again
	public static WebDriver wd = null;
	static JavascriptExecutor javaScriptDriver = (JavascriptExecutor) wd;
	public static WebDriverWait wait;
	public static boolean acceptNextAlert;
	private static TestStopper testStopper;
	private static boolean stopDialogEnabled = true;

	public static boolean isStopDialogEnabled() {
		return stopDialogEnabled;
	}



	public static void setStopDialogEnabled(boolean stopDialogEnabled) {
		CommonWebActions.stopDialogEnabled = stopDialogEnabled;
	}
	public static void webSetTab(String objName, String strTextToSend) throws Exception {
		WebElement lwebElement = null;
		try {
			lwebElement = findElement(objName);
			Actions actions = new Actions(wd);
			lwebElement.click();
			lwebElement.clear();
			lwebElement.sendKeys(strTextToSend);
			actions.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * This Method Enter Text and tabs using Robot class* 
	 * 
	 * @author kapildev J
	 * @version 1.0
	 * @since 10-Dec-2018
	 */
	public static void EntertextThenPressTabAndSave(String objName, String strTextToSend) throws Exception {
		WebElement lwebElement = null;
		try {
			Thread.sleep(1000);
			lwebElement = findElement(objName);
			Actions actions = new Actions(wd);
			lwebElement.click();
			lwebElement.clear();
			lwebElement.sendKeys(strTextToSend);
			actions.sendKeys(Keys.TAB).build().perform();
//  --Below Code Snippet to  Save the Application //
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_S);
			test.log(Status.PASS, "Enter the text "+strTextToSend+ "in the object "+objName+" and saved the application using "
					+ "shortcut Cntrl+S");
		} catch (Exception e) {
			test.log(Status.FAIL, "Object Not Found or May be due to exception "+e);
			
			throw e;
		}
	} 
	
	/**
	 * This Method will clear and save the screen 
	 * 
	 * @author kapildev J
	 * @version 1.0
	 * @since 10-Dec-2018
	 */
	 public static boolean clearValuesnSave(String Btnlocator) throws InterruptedException {
	    	WebElement Fieldvalues = CommonWebActions.getWebElement(Btnlocator);
	    	webExplicitWait(Btnlocator, 120);    	
	    	 	if(Fieldvalues.isDisplayed()) {
	    	 		Thread.sleep(500);
	    	 		Fieldvalues.click();
	    	 		Thread.sleep(250);
	    	 		Fieldvalues.clear();		 		
	    	 		Fieldvalues.sendKeys(Keys.CONTROL+"s");
	    	 		Thread.sleep(2000);
	    	 		System.out.println("CLEARED and SAVED successfully");
	    	 		return true;
	    	 	}
	    	 	else {
	    	 		System.out.println("Not able to pass values");
	    	 		return false;
	    	 	}
	    }
	 /**
		 * This Method Enter Text and save 
		 * @author kapildev J
		 * @version 1.0
		 * @since 10-Dec-2018
		 */
	   public static boolean passValuesnSave(String Btnlocator, String val) throws InterruptedException {
	    	WebElement Fieldvalues = CommonWebActions.getWebElement(Btnlocator);
	    	webExplicitWait(Btnlocator, 60);    	
	    	 	if(Fieldvalues.isDisplayed() && Fieldvalues.isEnabled()) {
	    	 		Fieldvalues.clear();		 		
	    	 		Fieldvalues.sendKeys(val);		
	    	 		Fieldvalues.sendKeys(Keys.CONTROL+"s");
	    	 		return true;
	    	 	}
	    	 	else {
	    	 		System.out.println("Not able to pass values");
	    	 		return false;
	    	 	}
	    }
	   public static void savePage()  {
		      //    NgWebDriver ngDriver;
		            try 
		            {
		            	Actions actions=new Actions(CommonWebActions.wd);
		            	actions.sendKeys(Keys.chord(Keys.CONTROL,"s")).build().perform();
		            	wait(2000);
		                  
		            }
		catch (Exception e) {
		                  
		            e.printStackTrace();
//		                ReportUtil.reporterEvent("fail", "Web Element [ " + objName
//		                            + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
//		                Assert.assertEquals(webExists(lwebElement), true,
//		                            "Object Not Found UI. Hence stoping the execution of test case");
		                  
//		                      test.log(Status.FAIL,"Web Element [ " + objName
//		                                  + " ] NOT FOUND on UI",MediaEntityBuilder.createScreenCaptureFromPath("screen.png").build());
		                  
		                  
		            }

		      }
	/**
	 * This Method Enter Text using ActionMethod 
	 * 
	 * @author kapildev J
	 * @version 1.0
	 * @since 10-Dec-2018
	 */
    public static boolean passWithoutClear(String Btnlocator, String val) throws InterruptedException {
    	WebElement Fieldvalues = CommonWebActions.getWebElement(Btnlocator);
    	webExplicitWait(Btnlocator, 120);    	
    	 	if(Fieldvalues.isDisplayed()) {	
    	 		Actions actions = new Actions(wd);
    	 		actions.moveToElement(Fieldvalues);
    	 		actions.click();
    	 		actions.sendKeys(val);
    	 		actions.build().perform();
    	 		return true;
    	 	}
    	 	else {
    	 		System.out.println("Not able to pass values");
    	 		return false;
    	 	}
    }
    

	/**
	 * This method is used to Login into  application with different User credentials
	 * 
	 * @author 
	 * @param 
	 *            
	 */
	              
    public static void transfer_login() {
		try {
/*--  Launching URL  --*/
			CommonWebActions.transfer_login();

/*-- Server Error Handling --*/
			if (CommonWebActions.wd.getTitle().toLowerCase().contains("error")) {
				CommonWebActions.wd.quit();
			} else {
				test.log(Status.PASS, "Login Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Unable to launch the application");
		}
	}
    
    
	/**
	 * This method is used to Login into  application.
	 * 
	 * @author 
	 * @param 
	 *            
	 */
	public static void login() {
		try {
/*--  Launching URL  --*/
			CommonWebActions.launch();

/*-- Server Error Handling --*/
			if (CommonWebActions.wd.getTitle().toLowerCase().contains("error")) {
				CommonWebActions.wd.quit();
			} else {
//				test.log(Status.PASS, "Login Success");
			}
		} catch (Exception e) {
			e.printStackTrace();
//			test.log(Status.FAIL, "Unable to launch the application");
		}
	}
	/**
	 * This method is used to launch the application.
	 * 
	 * @author 
	 * @param 
	 *            
	 */
	public static void launch() {
		try {
			TrippleDes td = new TrippleDes();
			String browserType = ORUtil.getConfigValue("BrowserType");
			String implicitWait = ORUtil.getConfigValue("Implicit_Wait");
			String username=ORUtil.getConfigValue("username");
			String password=ORUtil.getConfigValue("password");

			String ieDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe";
			String chromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver70.exe";
			if (browserType.equalsIgnoreCase("firefox")) {
				String useFirefoxprofile = System.getenv("ICM_TA_USE_FIREFOXPROFILE");
				if(useFirefoxprofile != null && useFirefoxprofile.equals("true")){
					
//					FirefoxProfile profile = new FirefoxProfile(new File("./../icm.testautomation.tools.firefox/TAProfile"));     
					FirefoxProfile profile = new FirefoxProfile();
					
					profile.addExtension(new File("./../icm.testautomation.tools.firefox/TAExtensions/firebug@software.joehewitt.com.xpi"));
					profile.addExtension(new File("./../icm.testautomation.tools.firefox/TAExtensions/FireXPath@pierre.tholence.com.xpi"));
					profile.setPreference("extensions.firebug.currentVersion", "2.0.17");
					profile.setPreference("extensions.firebug.onByDefault", true);
					profile.setPreference("extensions.firebug.defaultPanelName", "net");
					profile.setPreference("extensions.firebug.net.enableSites", true);
					DesiredCapabilities capa = DesiredCapabilities.firefox();
					capa.setBrowserName("firefox");
					capa.setCapability(FirefoxDriver.PROFILE, profile);
					capa.setCapability("binary", "./../icm.testautomation.tools.firefox/firefox.exe");
					wd = new FirefoxDriver(capa);
				} else {
					System.setProperty("webdriver.gecko.driver","C:\\Users\\dekapil\\Downloads\\Katalon_Studio_Windows_64-5.3.0\\configuration\\resources\\drivers\\firefox_win64\\geckodriver.exe");
					FirefoxOptions options = new FirefoxOptions();
					wd = new FirefoxDriver(options);
				}
				
			} else if (browserType.equalsIgnoreCase("iexplore")) {
				System.setProperty("webdriver.ie.driver", ieDriverPath);
				DesiredCapabilities capability = DesiredCapabilities
						.internetExplorer();
				capability
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				capability.setCapability("useLegacyInternalServer", true);
				capability.setCapability("nativeEvents", false);
				capability
						.setCapability(
								CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
								true);
				wd.manage().deleteAllCookies();
				capability.setCapability("requireWindowFocus", true);
				wd = new InternetExplorerDriver(capability);
			} else if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		        wd = new ChromeDriver();
		        //SIT
		        // wd.get("https://"+username+":"+new String(td.decrypt("hl4l9sGnxvniLSjaQXyseQ==").getBytes("UTF-8"), "UTF-8")+"@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmsit1-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe%3F&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe%3F&login_param=5");
		        
		      //AT
				//String username = "sco662";
				//String password = "Qwaszx12"
				wd.get("https://" + username + ":" + new String(td.decrypt("+S9+vaOKkAKJJSpQl9fUJg==").getBytes("UTF-8"), "UTF-8" )
						+ "@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmat-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe&login_param=5");
				//-----
				
				//AT
				/*username = "hxm810";
				password = "capG01/03";
				wd.get("https://" + username + ":" + password 
						+ "@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmat-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe&login_param=5");
				*/
			}
			webImplicitWait(30);
			wd.manage().window().maximize();
//			test.log(Status.PASS, "Launched browser [ "+ browserType + " ] ");
		} catch (Exception e) {
			e.printStackTrace();
//			test.log(Status.FAIL, "Failed to launch browser "+e);
		}
	}
	/**
	 * This method is used to Set data to text field using javascript Executor.
	 * 
	 * @author kapildev j
	 * @param ObjName StrTextToSend
	 * 				Objname is Object and StrTextToSend -text to Set in Text field
	 * @throws Exception 
	 * 
	 *            
	 */

	public static void javaSet1(WebElement Element, String strTextToSend) throws  Exception  {
//      WebElement lwebElement = null;
      try {
          JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
//          executor.executeScript("arguments[0].click();", Element);
//          Thread.sleep(1000);
//          WebElement editelement = (WebElement)executor.executeScript("return document.activeElement;");
//          editelement.sendKeys(strTextToSend);
//          editelement.sendKeys(Keys.ENTER);
//          executor.executeScript("$(document.activeElement).trigger('change');");
          executor.executeScript("arguments[0].click();", Element);
         Thread.sleep(1000);
        WebElement editelement = (WebElement)executor.executeScript("return document.activeElement;");
            executor.executeScript("$(document.activeElement.value='"+strTextToSend+"');");
//        executor.executeScript("$(arguments[0]).change();", Element);
          executor.executeScript("arguments[0].click();", Element);
          editelement.sendKeys(Keys.ENTER);
          wait(3000);
          WebElement editelement1 = (WebElement)executor.executeScript("return document.activeElement;");
//          executor.executeScript("$(document.activeElement).trigger('change');");
          executor.executeScript("arguments[0].click();", editelement1);
         
          executor.executeScript("document.activeElement.dispatchEvent(new Event('blur'));", editelement1);
          wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//         executor.executeScript("$(document.activeElement).dispatchEvent(new Event('change'));");
//          executor.executeScript("$(arguments[0]).keydown();", Element); 
//          executor.executeScript("$(arguments[0]).keyup();", Element); 
//          executor.executeScript("$(arguments[0]).keydown();", Element); 
//          editelement.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         wait(2000);
         test.log(Status.PASS,"Web Element  FOUND on UI");
      } catch (Exception e) {
          test.log(Status.INFO,"Web Element FOUND on UI"+test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "JavaSet")));    
          e.printStackTrace();
      }

}
	public static void javaSet2(WebElement Element, String strTextToSend) throws  Exception  {
//      WebElement lwebElement = null;
      try {
          JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
//          executor.executeScript("arguments[0].click();", Element);
//          Thread.sleep(1000);
//          WebElement editelement = (WebElement)executor.executeScript("return document.activeElement;");
//          editelement.sendKeys(strTextToSend);
//          editelement.sendKeys(Keys.ENTER);
//          executor.executeScript("$(document.activeElement).trigger('change');");
          executor.executeScript("arguments[0].click();", Element);
         Thread.sleep(1000);
         
        WebElement editelement = (WebElement)executor.executeScript("return document.activeElement;");
        editelement.sendKeys(strTextToSend);
//            executor.executeScript("$(document.activeElement.value='"+strTextToSend+"');");
//        executor.executeScript("$(arguments[0]).change();", Element);
//          executor.executeScript("arguments[0].click();", Element);
//          editelement.sendKeys(Keys.ENTER);
//          executor.executeScript("$(document.activeElement).trigger('change');");
//          executor.executeScript("document.activeElement.dispatchEvent(new Event('blur'));", Element);
//          wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//         executor.executeScript("$(document.activeElement).dispatchEvent(new Event('change'));");
//          executor.executeScript("$(arguments[0]).keydown();", Element); 
//          executor.executeScript("$(arguments[0]).keyup();", Element); 
//          executor.executeScript("$(arguments[0]).keydown();", Element); 
//          editelement.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         wait(2000);
         test.log(Status.PASS,"Web Element  FOUND on UI");
      } catch (Exception e) {
          test.log(Status.INFO,"Web Element FOUND on UI"+test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "JavaSet")));    
          e.printStackTrace();
      }

}
	public static void javaSet(String objName, String strTextToSend) throws  Exception  {
        WebElement lwebElement = null;
        try {
              lwebElement = findElement(objName);
              System.out.println(objName);
              JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
              for (int iCnt = 0; iCnt < 3; iCnt++) {
                    executor.executeScript("arguments[0].style.border='4px groove green'", lwebElement);
                     Thread.sleep(1000);
                     executor.executeScript("arguments[0].style.border=''", lwebElement);
               }
              executor.executeScript("arguments[0].click();", lwebElement);
              executor.executeScript("$(arguments[0]).blur();", lwebElement);
              fnHighlightMe(objName);
              executor.executeScript("arguments[0].value='" + strTextToSend + "'", lwebElement);
              StringSelection stringSelection = new StringSelection(strTextToSend);
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              clipboard.setContents(stringSelection, stringSelection);
              Robot robot = new Robot();
              robot.keyPress(KeyEvent.VK_CONTROL);
              robot.keyPress(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_CONTROL);
              executor.executeScript("$(arguments[0]).change();", lwebElement);
              test.log(Status.PASS,"Web Element [ " + objName
                    + " ]  FOUND on UI");
        } catch (Exception e) {
        	test.log(Status.FAIL,"Web Element [ " + objName
                    + " ]  FOUND on UI"+test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "JavaSet")));    
        	e.printStackTrace();
        }

  }
	/**
	 * This method is used to highlight object in application.
	 * 
	 * @author kapildev j
	 * @param Driver WebElement
	 * 				WebDriver and WebElement
	 * @throws InterruptedException 
	 * 
	 *            
	 */	      

	public static void fnHighlightMe(String objName) throws InterruptedException{
		  //Creating JavaScriptExecuter Interface
		WebElement element=null;
		
		 try {
			element = findElement(objName);
			   JavascriptExecutor js = (JavascriptExecutor)wd;
			   for (int iCnt = 0; iCnt < 3; iCnt++) {
			      //Execute javascript
			         js.executeScript("arguments[0].style.border='4px groove green'", element);
			         Thread.sleep(1000);
			         js.executeScript("arguments[0].style.border=''", element);
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 } 
	public static void waituntilElementToBeClickable(String objName) {

		try {
			WebElement lWebElement;
			lWebElement = findElement(objName);
			wait = new WebDriverWait(wd, 30);
			wait.until(ExpectedConditions.elementToBeClickable(lWebElement));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This method is used to locate the web object in the application.
	 * 
	 * 
	 * @param objLogicalName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @return WebElement This returns the WebElement if web object is found in
	 *         the AUT
	 * @throws NoSuchElementException
	 * @author kapilj        
	 */
	public static WebElement getWebElement(String objLogicalName)throws NoSuchElementException {
		WebElement webEle = null;
		String ORValue=null;
		try {
//			if (Sprint3_Move_Service.packagename().equalsIgnoreCase("move")) {
//				 ORValue=Sprint3_Move_Service.MOVE_OR(objLogicalName);
//				String objectPropertyVal = Sprint3_Move_Service.OBJECT_REPO_PATH_Move.getProperty(key, "ELEMENTNOTFOUND");
//			}
//			else {
			 ORValue = ORUtil.getValue(objLogicalName);
//			}
			String propType = null;
			String propActVal = null;
//			System.out.println(ORValue);
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				test.log(Status.FAIL, "Object with logical name [ "
						+ objLogicalName +" is found on AUT");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {
				String[] parts = ORValue.split(":=");
				if(parts.length != 2){
					throw new RuntimeException("Found mal formatted expression value in object repository: " + ORValue);
				}
				propType = parts[0];
				propActVal = parts[1];
				if (propType.equalsIgnoreCase("id")) {
					webEle = wd.findElement(By.id(propActVal));
				} else if (propType.equalsIgnoreCase("name")) {
					webEle = wd.findElement(By.name(propActVal));
				} else if (propType.equalsIgnoreCase("xpath")) {
					webEle = wd.findElement(By.xpath(propActVal));
//					System.out.println(webEle);
				} else if (propType.equalsIgnoreCase("linktext")) {
					webEle = wd.findElement(By.linkText(propActVal));
				} else if (propType.equalsIgnoreCase("cssselector")) {
					webEle = wd.findElement(By.cssSelector(propActVal));
					System.out.println(webEle);
				} else if (propType.equalsIgnoreCase("partiallinktext")) {
					webEle = wd.findElement(By.partialLinkText(propActVal));
				} else if (propType.equalsIgnoreCase("classname")) {
					webEle = wd.findElement(By.className(propActVal));
				} else if (propType.equalsIgnoreCase("tagName")) {
					webEle = wd.findElement(By.tagName(propActVal));
				} 				
				else {
					ExtentManager.test.log(Status.FAIL, "Invalid property type defined in Object Repository for web element [ "
									+ objLogicalName + " ]");
				}
			}
			
		} catch (Exception e) {
			ExtentManager.test.log(Status.FAIL, "Invalid property type defined in Object Repository for web element [ "
					+ objLogicalName + " ]");
			throw new AssertionError( "Invalid property type [ "+ objLogicalName + " ] defined in Repository", e);
			//FIXME this should only be printed for debug runs
		}
		return webEle;
	}
	/**
	 * This method is used to locate the web objects in the application.
	 * 
	 * @author 
	 * @param objLogicalName
	 *            This is the logical name of the web object in property file
	 *            (OR) findelements is used
	 * @return WebElements This returns the list of WebElements if web object is found in
	 *         the AUT
	 */
	
	
	public static  List<WebElement> getWebElements(String objLogicalName) {
		List<WebElement>  webEle = null;
		try {
			String ORValue = ORUtil.getValue(objLogicalName);
			String propType = null;
			String propActVal = null;
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				ReportUtil.reporterEvent("fail", "Object with logical name [ "
						+ objLogicalName
						+ " ] not found in Object Repository. Please check...");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {
				String[] parts = ORValue.split(":=");
				if(parts.length != 2){
					throw new RuntimeException("Found mal formatted expression value in object repository: " + ORValue);
				}
				propType = parts[0];
				propActVal = parts[1];

				if (propType.equalsIgnoreCase("id")) {
					webEle = wd.findElements(By.id(propActVal));
				} else if (propType.equalsIgnoreCase("name")) {
					webEle = wd.findElements(By.name(propActVal));
				} else if (propType.equalsIgnoreCase("xpath")) {
					webEle = wd.findElements(By.xpath(propActVal));
					System.out.println(webEle);
				} else if (propType.equalsIgnoreCase("linktext")) {
					webEle = wd.findElements(By.linkText(propActVal));
				} else if (propType.equalsIgnoreCase("cssselector")) {
					webEle = wd.findElements(By.cssSelector(propActVal));
					System.out.println(webEle);
				} else if (propType.equalsIgnoreCase("partiallinktext")) {
					webEle = wd.findElements(By.partialLinkText(propActVal));
				} else if (propType.equalsIgnoreCase("classname")) {
					webEle = wd.findElements(By.className(propActVal));
				} else if (propType.equalsIgnoreCase("tagName")) {
					webEle = wd.findElements(By.tagName(propActVal));
				} 				
				else {
					ReportUtil.reporterEvent("fail",
							"Invalid property type defined in Object Repository for web element [ "
									+ objLogicalName + " ]");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return webEle;
	}

	/**
	 * This method is used to check if the elements exists or not
	 * 
	 * 
	 * @author 
	 * @param element
	 *            This is the WebElement
	 * @return returns true if object exists else false
	 */
	public static boolean webExists(WebElement element) {
		try {
			if(element!=null){
			return element.isDisplayed();}
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, "Object doesnt exist on application");
			return false;
		}
		return false;
	}

	/**
	 * This method is used to click on the specified web element
	 * 
	 * @author 
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @throws Exception 
	 * 
	 */
	public static String webClick(String objName) throws  Exception {
		WebElement lwebElement = null;
		try {
			lwebElement = findElement(objName);
//			if(lwebElement.isEnabled()){
			lwebElement.click();
			test.log(Status.INFO,"Clicked on Object [" +  objName  +"]");
//			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL,"WebElement [" + objName+ " ] NOT FOUND on UI"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ClickNotFound")));
			Assert.assertEquals(webExists(lwebElement), true,
					"Object Not Found UI. Hence stoping the execution of test case");
		}
		return objName;

	}
	/**
	 * This method is used to wait until specified object is present 
	 * 
	 * @author kapilj
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * 
	 */
//	public static void waituntil(final String objName) {
//		FluentWait<WebDriver> wait = (FluentWait<WebDriver>) new FluentWait<WebDriver>(
//				wd).withTimeout(180, TimeUnit.SECONDS)
//				.pollingEvery(1000, TimeUnit.MILLISECONDS)
//				.ignoring(NoSuchElementException.class);
//		
//				
//		wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver webDriver) {
//				if(stopDialogEnabled && testStopper.getStopTest().equals(Boolean.TRUE)){
//					throw new RuntimeException("Test was aborted");
//				}
//				return CommonWebActions.findElement(objName);
//			}
//		});		
//
//	}

	/**
	 * This method is used to wait until specified object is present and returns webElement
	 * 
	 * @author kapilj
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * 
	 */
	public static WebElement findElement(final String locator) {
	
			try {
//				System.out.println("techsol" + locator);
				FluentWait<WebDriver> wait = (FluentWait<WebDriver>) new FluentWait<WebDriver>(
						wd).withTimeout(20, TimeUnit.SECONDS)
						.pollingEvery(1000, TimeUnit.MILLISECONDS)
						.ignoring(NoSuchElementException.class);
						
				WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver webDriver) {
						/*if(stopDialogEnabled && testStopper.getStopTest().equals(Boolean.TRUE)){
							throw new RuntimeException("Test was aborted");
						}*/
						return CommonWebActions.getWebElement(locator);
					}
				});
				return webElement;
			} catch (Exception e) {
				test.log(Status.FAIL, "WebElement [ "+ locator + " ] not found on WebPage");
				
			}
			return CommonWebActions.getWebElement(locator);
		} 
	public static boolean isAlertPresent(){ 
        boolean foundAlert = false; 
        WebDriverWait wait = new WebDriverWait(wd, 10 /*timeout in seconds*/); 
        try { 
            wait.until(ExpectedConditions.alertIsPresent()); 
            foundAlert = true; 
        } catch (TimeoutException eTO) { 
            foundAlert = false; 
        } 
        return foundAlert; 
    }

	
	/**
	 * This method is used to Close all the alerts by accepting ok 
	 * 
	 * @author kapilj
	 * @param 
	 * @throws Exception 
	 */

	public static void closeAlerts() throws  Exception {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHSS").format(Calendar.getInstance().getTime());
		try {
			Alert alert = wd.switchTo().alert();
			if (acceptNextAlert) {
				
				test.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\report-output\\"+timeStamp+".png");
				test.log(Status.PASS, "Web Element [ " + "Alert"
						+ " ]  FOUND on UI" + test.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\report-output\\"+timeStamp+".png"));
				alert.accept();
				test.log(Status.INFO, "Clicked on OK Alert window ");
				
			} else {
				wait(1000);
				BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    ImageIO.write(image, "png", new File(System.getProperty("user.dir")+ "\\report-output\\"+timeStamp+".png"));
//			 wd.switchTo().alert().accept();
				test.log(Status.INFO, "Web Element [ " + "Alert"
						+ " ]  FOUND on UI" + test.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\report-output\\"+timeStamp+".png"));
//				test.log(Status.PASS, "Web Element [ " + "Alert"
//						+ " ]  FOUND on UI" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "ALERT")));
				alert.dismiss();
				test.log(Status.INFO, "Clicked on Cancel/Dismiss Alert window ");
				
			}
			return;
		} catch (NoAlertPresentException Ex) {
			return;
		} finally {
			acceptNextAlert = true;
		}
	}
	/**
	 * This method is used to clear and set data to text field
	 * 
	 * @author kapilj
	 * @param objName ,Text
	 *           objName- This is the logical name of the web object in property file
	 *            (And)
	 * 			 Text-This is the text /Data input for text field
	 */

	public static void webSet(String objName, String strTextToSend) throws Exception  {
		WebElement lwebElement = null;
		try {
			lwebElement = findElement(objName);
            webExplicitWait(objName, 60);
			System.out.println(objName);
			if 	(lwebElement.isEnabled()){
				lwebElement.click();
				lwebElement.clear();
				lwebElement.sendKeys(strTextToSend.trim());
				test.log(Status.INFO, "Text [ " + strTextToSend+ " ] entered in the web element [ " + objName + " ]FOUND on UI" );
			}
		} catch (Exception e) {
			test.log(Status.INFO, "Text [ " + strTextToSend+ " ] entered in the web element [ " + objName + " ]FOUND on UI" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "WebSet method")));
			Assert.assertEquals(webExists(lwebElement), true,
					"Object Not Found UI. Hence stoping the execution of test case");
		}
	}
	
	
	
	/**
	 * This method is used to Navigate back to WebPage
	 * 
	 * @author kapilj
	 * @param 
	 */

	public static void back() {
		wd.navigate().back();
	}

	/**
	 * This method is used to verify inner text of an element
	 * 
	 * @author 
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @param expectedInnerText
	 *            This is the inner text to be verified or the column name in
	 *            the test data sheet
	 * @return returns true if the inner text matches or else returns false
	 */
	public static boolean webVerifyInnerText(String objName,
			String expectedInnerText) {
        boolean lResultFlag = false;
        WebElement lwebElement = null;
        try {
               lwebElement = findElement(objName);
               System.out.println(lwebElement);
               String actualInnerText = lwebElement.getText();
               /////////////////actualInnerText = actualInnerText.replaceAll("[-+.^:,?ï¿½]", " ");
               System.out.println(actualInnerText);
               if (actualInnerText.equals(expectedInnerText)) {
                     test.log(Status.PASS, "For [ " + objName
                                  + " ] actual text [ " + actualInnerText
                                  + "] same as expected [ " + expectedInnerText + " ]");
                     lResultFlag = true;
               } else {
                     test.log(Status.FAIL, "For [ " + objName
                                  + " ] actual text [ " + actualInnerText
                                  + "] is not same as expected [ " + expectedInnerText + " ]");
                     lResultFlag = false;
                     Assert.assertEquals(actualInnerText, expectedInnerText);
               }
        } catch (Exception e) {
               test.log(Status.FAIL, "Web Element [ " + objName
                            + " ] NOT FOUND on UI");
        }
        return lResultFlag;
  }


	/**
	 * This method is used to Navigate to new tab of Application using window Handling
	 * 
	 * @author 
	 * @param objName
	 *            This is the logical name of the web object in property file
	 * @throws Exception 
	 *  
	 */
	public static void Newtab(String objName) throws  Exception {

		try {
			Thread.sleep(5000);
			String parentHandle = wd.getWindowHandle();
			System.out.println(parentHandle);
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,
					Keys.RETURN);
			wd.findElement(By.linkText("application information")).sendKeys(
					selectLinkOpeninNewTab);
			Thread.sleep(5000);
			int a = wd.getWindowHandles().size();
			System.out.println(a);
			Set<String> b = wd.getWindowHandles();
			System.out.println(b);
			wd.switchTo().window((String) b.toArray()[1]);
			wd.close();
			Thread.sleep(15000);
			wd.close(); // close newly opened window when done with it
			wd.switchTo().window(parentHandle); //
		} catch (Exception e) {
			test.log(Status.FAIL, "Web Element [ " + objName + " ] NOT FOUND on UI" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Newtab")));
		}
	}
	/**
	 * This method is used to Navigate to new tab of Application using Robot Class
	 * 
	 * @author 
	 * @param 
	 */
	public static void Tab() {
		  Robot robot;
		try {
			robot = new Robot();
			 robot.keyPress(KeyEvent.VK_TAB);
			 robot.keyRelease(KeyEvent.VK_TAB);
			 wait(1000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * This method is used to navigate to new window and handled till new window is loaded
	 * 
	 * @author kapilj
	 * @param 
	 */
	private static void waitForNewWindowAndSwitchToIt()
			throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		String cHandle = wd.getWindowHandle();
		System.out.println(cHandle);
		String newWindowHandle = null;
		Set<String> allWindowHandles = wd.getWindowHandles();
		System.out.println(allWindowHandles);

		// Wait for 20 seconds for the new window and throw exception if not
		// found
		for (int i = 0; i < 20; i++) {
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(cHandle))
						newWindowHandle = allHandlers;
				}
				wd.switchTo().window(newWindowHandle);
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (cHandle == newWindowHandle) {
			throw new RuntimeException("Time out - No window found");
		}
	}

	/**
	 * This method is used to verify page title
	 * 
	 * @author 
	 * @param expectedPageTitle
	 *            This is the expected page title
	 * @param continueExecution
	 *            <b>true</b> if you want to continue the execution or else
	 *            <b>false</b> to stop the execution
	 */
	public static void webVerifyPageTitle(String expectedPageTitle,
			Boolean continueExecution) {
		try {

			expectedPageTitle = ExcelUtil.getDataFromExcel(onlyTestCaseName,
					expectedPageTitle);
			String actualTitle = wd.getTitle();
			System.out.println(actualTitle);
			System.out.println(expectedPageTitle);
			if (expectedPageTitle.equals(actualTitle)) {
				test.log(Status.PASS, " Actual page title [ "
						+ actualTitle + " ] same as expected title [ "
						+ expectedPageTitle + " ]");
			} else {
				test.log(Status.FAIL, " Actual page title [ "
						+ actualTitle + " ] not same as expected title [ "
						+ expectedPageTitle + " ]");
				if (continueExecution.equals(false)) {
					Assert.assertEquals(actualTitle, expectedPageTitle);
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, " Actual page title   not same as expected title");
			e.printStackTrace();
		}

	}


	

	/**
	 * This method is used to mouse hover on web element
	 * 
	 * @author 
	 * @param elementName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 *  @throws Exception          
	 */
	public static void webMouseHover(String elementName)throws Exception {
		WebElement lwebElement = null;
		Actions action=null;
		try {
			lwebElement = findElement(elementName);
			action = new Actions(wd);
			action.moveToElement(lwebElement).perform();
			test.log(Status.INFO, "Mouse hover done on element [ "
					+ elementName + " ]");
		} catch (Exception e) {
			test.log(Status.FAIL,"Web Element [ " + elementName
					+ " ] NOT FOUND on UI" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "MouseHover")));
			Assert.assertEquals(webExists(lwebElement), true,
					"Object Not Found UI. Hence stoping the execution of test case");
		}
	}


	/**
	 * This method is used to drag and drop an element
	 * 
	 * 
	 * @param sorceObjectName
	 *            This is the source element name
	 * @param targetObjectName
	 *            This is the target element name
	 * @author 
	 */
	public static void webDragAndDrop(String sorceObjectName,
			String targetObjectName) throws Exception{
		WebElement lwebElement1 = null;
		WebElement lwebElement2 = null;
		try {
			lwebElement1 = findElement(sorceObjectName);
			lwebElement2 = findElement(targetObjectName);
			Actions action = new Actions(wd);
			action.dragAndDrop(lwebElement1, lwebElement2).perform();
			test.log(Status.INFO, "Element [ " + sorceObjectName
					+ " ] dragged and dropped in the web element [ "
					+ targetObjectName + " ]");
		} catch (Exception e) {
			test.log(Status.FAIL, "Web Element [ " + sorceObjectName
					+ " ] and [ " + targetObjectName + " ] NOT FOUND on UI"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "webDragAndDrop")));
			Assert.assertEquals(webExists(lwebElement1), true,
					"Object Not Found UI. Hence stoping the execution of test case");
			Assert.assertEquals(webExists(lwebElement2), true,
					"Object Not Found UI. Hence stoping the execution of test case");
		}
	}

	/**
	 * This method is used to close the browser
	 * 
	 * 
	 * @author 
	 */
	public static void closeBrowser() {
		wd.close();
		test.log(Status.INFO,  "Closed the browser window");
	}

	/**
	 * This method is used to switch to a particular frame
	 * 
	 * @param frameNameOrID
	 *            frame ID
	 * @author
	 * @throws exception 
	 */
	public static void switchToFrameWithID(String frameID) throws Exception{
		try {
			wd.switchTo().frame(frameID);
			test.log(Status.PASS,  "Switched to Frame with ID [ "
					+ frameID + " ]");
		} catch (Exception e) {
			test.log(Status.FAIL, "Frame with ID [ " + frameID
					+ " ] NOT FOUND" + test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "switchToFrameWithID")));
		}
	}
	/**
	 * This method is used to Select value from Drop down using Select Class
	 * @param objname
	 *            This is the object name 
	 * @param objname1
	 *           This is value to be selected from Dropdown
	 * @author kapilj
	 * @throws Exception 
	 */

	public static void Selectvaluefromdropdown(String objname, String objname1)throws Exception
	{
		WebElement lwebElement = null;
		
		try {
			lwebElement = findElement(objname);
			Select dropdown = new Select(lwebElement);
			dropdown.selectByVisibleText(objname1);
			test.log(Status.PASS, "Selected the value [ " + objname1 + " ] from dropdown");
		} catch (Exception e) {
			test.log(Status.FAIL, "Selected the value [ " + objname1 + " ] from dropdown");
		}
	}


	/**
	 * This method is used to switch to a Default Content from Frame
	 * 
	 * @param 
	 *            
	 * @author 
	 */
	public static void switchToDefaultContent() {

		
		try {
			wd.switchTo().defaultContent();
			test.log(Status.PASS, "Switched to default content");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to switch to default content");
		}
		
	}
	
	/**
	 * This method is used to switch to a particular window
	 * 
	 * @param windowNameOrHandle
	 *            This is a window name or window handle
	 * @author 
	 */
	public static void switchToWindow(String windowNameOrHandle)throws Exception {
		try {
			wd.switchTo().window(windowNameOrHandle);
			test.log(Status.PASS,"Switched to Window with Name/Handle [ "
					+ windowNameOrHandle + " ]" +test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "switchToWindow")));
		} catch (Exception e) {
			test.log(Status.FAIL,"Switched to Window with Name/Handle failed[ "
					+ windowNameOrHandle + " ]" +test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "switchToWindow")));
		}
	}

	/**
	 * This method is used to get all the window handles
	 * 
	 * @return returns an array of window handles
	 * @author 
	 */
	public static Set<String> getAllWindowHandles() {
		Set<String> winhandles = null;
		try {
			winhandles = wd.getWindowHandles();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to retrive window handles");
		}
		return winhandles;
	}

	/**
	 * This method is used to get current window handle
	 * 
	 * @return returns current window handle
	 * @author 
	 */
	public static String getCurrentWindowHandle() {
		String winhandle = null;
		try {
			winhandle = wd.getWindowHandle();
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to retrive current window handle");
		}
		return winhandle;
	}

	/**
	 * This method is used to capture screen shot as BASE 64
	 * 
	 * 
	 * @author 
	 */
	public static String captureScreenshotAsBase64() {
		String screenshotBase64 = ((TakesScreenshot) wd)
				.getScreenshotAs(OutputType.BASE64);
		screenshotBase64 = "data:image/gif;base64," + screenshotBase64;
		try {
			ExtentTest imaggeInBase=test.addScreenCaptureFromPath(screenshotBase64);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String imageInBase64 = logger.addScreenCapture(screenshotBase64);
		return screenshotBase64;
	}
	

	/**
	 * This method is used to get run time value from the AUT
	 * 
	 * @param objectLogicalName
	 *            Logical name of the object in OR
	 * @param attributeName
	 *            Name of the attribute to be captured
	 * @return returns the captured value
	 * @author kapilj
	 * @throws exception
	 */
	public static String webGetAttribute(String objectLogicalName,
			String attributeName)throws Exception {
		WebElement lwebElement = null;
		String attributeValue = null;
		try {
			lwebElement = findElement(objectLogicalName);
			System.out.println(lwebElement);
			attributeValue = lwebElement.getAttribute(attributeName);
			System.out.println(attributeValue);
			test.log(Status.INFO, "Value [ " + attributeValue
					+ " ] retrived from web element [ " + objectLogicalName
					+ " ]");
		} catch (Exception e) {
			test.log(Status.FAIL, "WebElement  [ " + attributeValue
					+ " ] not found on UI [ " + objectLogicalName + " ] "
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "webGetAttribute")));
		}
		return attributeValue;
	}


	/**
	 * This method is used to explicitly wait for an element to be clickable
	 * 
	 * @param logicalNameOfObject
	 *            Logical name of the object in OR
	 * @param timeInSeconds
	 *            Time to wait
	 * @author kapilj
	 * @return
	 */
	public static void webExplicitWait(String logicalNameOfObject,
			int timeInSeconds) {
		WebElement lWebElement = null;
		lWebElement = findElement(logicalNameOfObject);
		(new WebDriverWait(wd, timeInSeconds)).until(ExpectedConditions.elementToBeClickable(lWebElement));
	}

	/**
	 * This method is used to check if the web element is enabled or not
	 * 
	 * @param objectLogicalName
	 *            Logical name of the web element in OR
	 * @param expectedValue
	 *            This is a boolean value
	 * @author 
	 */
	public static void webVerifyIsElementEnabled(String objectLogicalName,
			Boolean expectedValue)throws Exception {
		WebElement lWebElement = null;
		Boolean actualValue = null;
		try {
			lWebElement = findElement(objectLogicalName);
			actualValue = lWebElement.isEnabled();
			if (actualValue.equals(expectedValue)) {
				test.log(Status.PASS," Web element [ "
						+ objectLogicalName + " ] is as expected"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "webVerifyIsElementEnabled")));
			} else {
				test.log(Status.FAIL," Web element [ "
						+ objectLogicalName + " ] is not as expected"
						+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "webVerifyIsElementEnabled")));			}
		} catch (Exception e) {
			test.log(Status.FAIL," Object Not Found"
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "webVerifyIsElementEnabled")));
		}
	}

	/**
	 * This method is used for implicit wait
	 * @param timeInSeconds
	 *            Time to wait
	 * @author kapilj
	 */
	public static void webImplicitWait(int timeInSeconds) {
		wd.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method is used abort execution of a test case
	 * 
	 * @param reasonToExit
	 *            This is the reason to abort the test execution
	 * @author kapilj
	 */
	public static void endTestCaseExecution(String reasonToExit) {
		test.log(Status.FATAL, "Ending test case execution ["
				+ reasonToExit + " ]");
		Assert.assertEquals(true, false);
	}

	/**
	 * This method is used for debugging purpose
	 * 
	 * 
	 * @author 
	 */
	public static void msgbox(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	

	/**
	 * This method is used execute java script
	 * 
	 * @param script
	 *            This is the script to be executed
	 * @return Returns an object
	 * @author kapilj
	 */
	public static Object executeJavaScript(String script) {
		return javaScriptDriver.executeScript(script);
	}

	/**
	 * This method is used wait till the page is completely loaded
	 * 
	 * @author kapilj
	 */
	public static void waitTillPageIsLoadedFully() {
		try {
			String loading = "return document.readyState";
			Object state = executeJavaScript(loading);
			while (state.toString() != "complete") {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the properties from OR property file
	 * 
	 * @param objectLogicalName
	 *            This is the logical name of the object in OR
	 * @return Returns command as a string
	 * @author 
	 */
	public static String getJavaScriptPropertyAndCommand(
			String objectLogicalName) {
		String script = null;
		try {
			String ORValue = ORUtil.getValue(objectLogicalName);
			String propType = null;
			String propActVal = null;
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				test.log(Status.FAIL,  "Object with logical name [ "
						+ objectLogicalName
						+ " ] not found in Object Repository. Please check...");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {
				String[] parts = ORValue.split(":=");
				propType = parts[0];
				propActVal = parts[1];

				if (propType.equalsIgnoreCase("id")) {
					script = "document.getElementById('" + propActVal + "')";
				} else {
					test.log(Status.INFO,"Invalid property type defined in Object Repository for web element [ "
							+ objectLogicalName + " ]");
//					ReportUtil.reporterEvent("fail",
//							"Invalid property type defined in Object Repository for web element [ "
//									+ objectLogicalName + " ]");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return script;
	}

	
	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param objectLogicalName
	 *            This is the logical name of the object in OR
	 * @author 
	 */
	public static void scrollIntoWebElement(String objectLogicalName) {
		String script = null;
		try {
			System.out.println(objectLogicalName);
			script = getJavaScriptPropertyAndCommand(objectLogicalName);
			script = script + ".scrollIntoView();";
			System.out.println(script);
			executeJavaScript(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void scrollIntoWebElement1(String objectLogicalName) {
//		String script = null;
		WebElement iWebElement=null;
		
		try {
			iWebElement=findElement(objectLogicalName);
			JavascriptExecutor jse = (JavascriptExecutor)wd;
			jse.executeScript("arguments[0].scrollIntoView()", iWebElement); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param x
	 *            This will scroll down with X coordinates values
	 * @author 
	 */
	public static void scrollDown(int x) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("window.scrollBy(100," + x + ")", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param x
	 *            This will scroll Up with X coordinates values
	 * @author 
	 */
	public static void scrollup(int x) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("window.scrollBy(" + x + ",100)", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param x
	 *            This will scroll Down
	 * @author 
	 */
	public static void scrollDown() {

		try {
			System.out.println("Scrolling down...");
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight+1000)");
			System.out.println("Scroll down finished...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param x
	 *            This will scroll Up 
	 * @author 
	 */
	public static void scrollup() {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("window.scrollBy(100,-250)", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to wait 
	 * 
	 * @param milliseconds
	 *           waiting for WebElement in milliseconds
	 * @author 
	 */
	public static void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to switch to a particular iframeID type int
	 * 
	 * @param iframeID
	 *            frame ID
	 * @author 
	 */
	public static void switchToiFrame(int iframeID) throws Exception{
		try {
			wd.switchTo().defaultContent();
			wd.switchTo().frame(iframeID);
			test.log(Status.PASS, "Switched to Frame with Name/ID [ " + iframeID + " ]");
		} catch (Exception e) {
			test.log(Status.FAIL, "Frame with Name/ID [ " + iframeID
					+ " ] NOT FOUND" 
					+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "switchToiFrame")));
			
		}
	}
	/**
	 * This method is used to switch to a particular iframe string using CSS
	 * 
	 * @param iframestring
	 *            frame string
	 * @author 
	 */
	public static void switchToiFrameusingCSS(String iframeString) {
		try {
			wd.switchTo().defaultContent();
			wd.switchTo().frame(wd.findElement(By.cssSelector(iframeString)));
			test.log(Status.PASS, "Switched to Frame with Name/ID [ " + iframeString + " ]");
		} catch (Exception e) {
		}
	}
	/**
	 * This method is used to check element is visible
	 * 
	 * @param DivLocator
	 *           Object of the Application
	 * @author 
	 */

  	
  	
  	/**
	 * This method is used to wait for page load using JS
	 * @param 
	 * @author kapilj
	 */
  	  public static void waitForLoad1() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(CommonWebActions.wd, 30);
		wait.until(pageLoadCondition);
	}
  	  

  	public static void fnHighlightMe1(WebDriver driver,WebElement element) throws InterruptedException{
  		  //Creating JavaScriptExecuter Interface
  		   JavascriptExecutor js = (JavascriptExecutor)driver;
  		   for (int iCnt = 0; iCnt < 3; iCnt++) {
  		      //Execute javascript
  		         js.executeScript("arguments[0].style.border='4px groove green'", element);
  		         Thread.sleep(1000);
  		         js.executeScript("arguments[0].style.border=''", element);
  		   }
  		 } 
  	  
  	/**
  	 * This method is used to Click the object using Javascript Executor
  	 * @param ObjName
  	 * 			This is object name of application
  	 * @author kapilj
  	 */
  		public static void javaclick (String objName)  {
  			WebElement lwebElement = null;
            try {
                   lwebElement = findElement(objName);
                  JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
                  executor.executeScript("arguments[0].click();", lwebElement);
            }
  			catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL,"Web Element [ " + objName
                    + " ] NOT FOUND on UI");
            Assert.assertEquals(webExists(lwebElement), true,
            "Object Not Found UI. Hence stoping the execution of test case");
  			            }

  		}
/**
 * This method is used to wait until webelement is clickable
 * @param Driver ObjName seconds
 * 			Driver
 * 			This is object name of application
 * 			Seconds for timeout
 * @author kapilj
 */
  		public static void waitUntilLoaded(String Objname, int seconds) {
  			WebElement IwebElement=null;
  			try {
  				IwebElement = findElement(Objname);
				FluentWait<WebDriver> wait = new WebDriverWait(wd, seconds).pollingEvery(100, TimeUnit.SECONDS);
				WebElement we = wait.until(ExpectedConditions.elementToBeClickable(IwebElement));
//				return we;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			return IwebElement;
  		}
  		/**
  		 * This method is used to handle stale element exception
  		 * @param Driver ObjName seconds
  		 * 			Driver
  		 * 			This is object name of application
  		 * 			Seconds for timeout
  		 * @author kapilj
  		 * @return 
  		 * @throws Exception 
  		 * @throws  
  		 */
  		public static boolean retryingFindClick(String DivLocator) throws  Exception {
  			By Locatorval=CommonWebActions.getWebElement1(DivLocator);
  		    boolean result = false;
  		    int attempts = 0;
  		    loop:
  		    while(attempts < 5) {
  		        try {
  		        	waitUntil(DivLocator);
  		        	fnHighlightMe1(wd, findElement(DivLocator));
  		        	webClick(DivLocator);
//  		            wd.findElement(Locatorval).click();
  		            result = true;
  		            break loop;
  		        } catch(StaleElementReferenceException e) {
  		        }
  		        attempts++;
  		    }
  		    return result;
  		    }
  		
  		
  		 public static boolean Exists(WebElement element)
  	    {
  	        if (element.isDisplayed())
  	        { return true; }else
  	        {
  	        	return false;
  	        }
  	        
  	    }
  		 
  		public static boolean isPresentAndDisplayed(final WebElement element) {
    		  try {
    		    return element.isDisplayed();
    		  } catch (NoSuchElementException e) {
    		    return false;
    		  }
    		}
  		
  		public static By getWebElement1(String objLogicalName)throws NoSuchElementException {
  			By locator = null;
  			try {
  				String ORValue = ORUtil.getValue(objLogicalName);
  				String propType = null;
  				String propActVal = null;
//  				System.out.println(ORValue);
  				if (ORValue.equals("ELEMENTNOTFOUND")) {
  					test.log(Status.FAIL, "Object with logical name [ "
  							+ objLogicalName +" is found on AUT");
  					Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
  				} else {
  					String[] parts = ORValue.split(":=");
  					if(parts.length != 2){
  						throw new RuntimeException("Found mal formatted expression value in object repository: " + ORValue);
  					}
  					propType = parts[0];
  					propActVal = parts[1];
  					if (propType.equalsIgnoreCase("id")) {
  						locator = By.id(propActVal);
  					} else if (propType.equalsIgnoreCase("name")) {
  						locator = By.name(propActVal);
  					} else if (propType.equalsIgnoreCase("xpath")) {
  						locator = By.xpath(propActVal);
//  						System.out.println(locator);
  					} else if (propType.equalsIgnoreCase("linktext")) {
  						locator = By.linkText(propActVal);
  					} else if (propType.equalsIgnoreCase("cssselector")) {
  						locator = By.cssSelector(propActVal);
  						System.out.println(locator);
  					} else if (propType.equalsIgnoreCase("partiallinktext")) {
  						locator = By.partialLinkText(propActVal);
  					} else if (propType.equalsIgnoreCase("classname")) {
  						locator = By.className(propActVal);
  					} else if (propType.equalsIgnoreCase("tagName")) {
  						locator = By.tagName(propActVal);
  					} 				
  					else {
  						ExtentManager.test.log(Status.FAIL, "Invalid property type defined in Object Repository for web element [ "
  										+ objLogicalName + " ]");
  					}
  				}

  			} catch (Exception e) {
  				ExtentManager.test.log(Status.FAIL, "Invalid property type defined in Object Repository for web element [ "
  						+ objLogicalName + " ]");
  				throw new AssertionError( "Invalid property type [ "+ objLogicalName + " ] defined in Repository", e);
  				//FIXME this should only be printed for debug runs
  			}
  			return locator;
  		}
  		
  		public static WebElement explicitWait (WebDriver driver, int TimeinSecs, By locator) {
  			WebDriverWait wait = new WebDriverWait(wd, 40);
  			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  		}
  		
  		public static WebElement explicitWaitPrsnce (WebDriver driver, int TimeinSecs, By locator) {
  			WebDriverWait wait = new WebDriverWait(wd, 40);
  			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  		}
  		
  		public static WebElement explicitWait (WebDriver driver, int TimeinSecs, WebElement element) {
  			WebDriverWait wait = new WebDriverWait(wd, 40);
  			return wait.until(ExpectedConditions.visibilityOf(element));
  		}
  		
  		public static void implicitWait(WebDriver driver, int time) {
  			wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
  		}
  		
  		public static boolean explcitStrWait (WebDriver driver, int TimeinSecs, By element, String Text) {
  			WebDriverWait wait = new WebDriverWait(wd, 60);
  			return wait.until(ExpectedConditions.textToBePresentInElementLocated(element, Text));
  		}
  		
  		public static WebElement explicitClick (WebDriver driver, int TimeinSecs, By element) {
  			WebDriverWait wait = new WebDriverWait(wd, 60);
  			return wait.until(ExpectedConditions.elementToBeClickable(element));
  		}
  		
  		public static boolean waitUntil(String DivLocator) throws IOException, Exception {		
  			try {
  				By Locatorval=CommonWebActions.getWebElement1(DivLocator);
  				WebElement divVisibility= explicitClick(wd, 90, Locatorval);
  				if(divVisibility.isDisplayed()) {
  					Thread.sleep(1000);
//  					test.log(Status.INFO,"Div was visible [" +  DivLocator  +"]");
  					return true;
  				}
  				else {
  					System.out.println(DivLocator+ "DIV was not visible!");
  					test.log(Status.FAIL,"Div [" + DivLocator+ " ] NOT FOUND on UI"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "DivNotFound")));
  					return false;
  				}
  			} catch (Exception e) {
  				System.out.println(DivLocator+ "DIV was not visible till 30 sec!");
  				test.log(Status.INFO,"Div [" + DivLocator+ " ] NOT FOUND on UI"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "DivNotFound")));
  				return false;
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
  	  public static void logout() throws  Exception {
      	try {
      		CommonWebActions.wd.navigate().refresh();
      		CommonWebActions.waitForLoad1();
      		CommonWebActions.waitUntil("SettingsBtn");
  			CommonWebActions.webClick("SettingsBtn");
  			CommonWebActions.waitUntil("LogoutBtn");
  			CommonWebActions.webClick("LogoutBtn");
  			CommonWebActions.waitUntil("UserPopup");
  			CommonWebActions.wd.close();
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      }
}

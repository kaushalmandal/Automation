package telia.testautomation.regression;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mercury.qualitycenter.otaclient.IAttachment;
import com.mercury.qualitycenter.otaclient.IAttachmentFactory;
import com.mercury.qualitycenter.otaclient.IExtendedStorage;
import com.mercury.qualitycenter.otaclient.ITestSet;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;
//import coreFramework.ALMTestfactory;
import coreFramework.ExtentManager;

@Listeners({coreFramework.CoreListener.class}) 

public class Demo_Test1 extends ExtentManager{
	public static String url ="https://'+scm984+':'+Canada@1993+'@iwa.test.eam.telia.se/cleartrust/iwa/ct_home.asp?CT_ORIG_URL=https%3A%2F%2Frxdodcrmsit1-test%2Eeam%2Etelia%2Ese%2FSiebelcrm_enu%2Fstart%2Eswe%3FSWECmd%3DGotoView%26SWEView%3DTS%2BNumber%2BReservation%2BView%26SWERF%3D1%26SWEHo%3Drxdodcrmsit1-test%2Eeam%2Etelia%2Ese%26SWEBU%3D1%26SWEApplet0%3DOrder%2BEntry%2B-%2BOrder%2BForm%2BApplet%2BDashboard%2B%28Sales%29%26SWERowId0%3D1-4AAXOWE%26SWEApplet1%3DOrder%2BEntry%2B-%2BLine%2BItem%2BList%2BApplet%2B%28Sales%29%26SWERowId1%3D1-4AAXOXB&ct_orig_uri=%2FSiebelcrm_enu%2Fstart%2Eswe%3FSWECmd%3DGotoView%26SWEView%3DTS%2BNumber%2BReservation%2BView%26SWERF%3D1%26SWEHo%3Drxdodcrmsit1-test%2Eeam%2Etelia%2Ese%26SWEBU%3D1%26SWEApplet0%3DOrder%2BEntry%2B-%2BOrder%2BForm%2BApplet%2BDashboard%2B%28Sales%29%26SWERowId0%3D1-4AAXOWE%26SWEApplet1%3DOrder%2BEntry%2B-%2BLine%2BItem%2BList%2BApplet%2B%28Sales%29%26SWERowId1%3D1-4AAXOXB&login_param=5";
	private static String hostName;
	private static ITestSet testSet;
	String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
	@BeforeSuite
	public void init() throws Exception {
		try {
			
//			System.loadLibrary("C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\jacob-1.19-x86.dll");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//			Runtime.getRuntime().exec("taskkill /F /IM IExplore.exe");
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	@Test
	public void Demo_Test1() throws Exception {
		ExtentManager.startReporting(new Object() {}.getClass().getEnclosingMethod().getName(),Packagename);
		/*--  Launching URL  --*/
		System.setProperty("jacob.dll.path", "C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\jacob-1.17-M2-x86.dll");
		updateResults();
		
		String str_date = "2019-02-18 10:22:00";
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		date = formatter.parse(str_date);
		   LocalDateTime dateTime = LocalDateTime.parse(str_date).plus(Duration.of(10, ChronoUnit.MINUTES));
		    Date tmfn = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
//		attachReport("C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\report-output\\20190212\\Telia_Automation_20190212133816263.html","E2EMM Automation\\Demo");
//        ALMTestfactory.updateResults();
//		attachReport("C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\report-output\\20190212\\Telia_Automation_20190212133816263.html","E2EMM Automation\\Demo");
		/*CommonWebActions.login(url,"test","test");
		CommonWebActions.webClick("Account_Tab");
		CommonWebActions.webClick("AllAcount_Link");
		CommonWebActions.webClick("SearchAccount_Button");
		CommonWebActions.webSet("SSN_Org_No_TextBox","12345");
		updateResults();
		CommonWebActions.webClick("Go_Button");
		test.log(Status.PASS," Page is displayed after Go Button"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "TC1")));*/
		
		/*waitUntilLoaded(CommonWebActions.wd,By.xpath("//*[contains(text(),'Get started')]"),100);
		App_CommonFunctions.waitForAjax1(CommonWebActions.wd);
		CommonWebActions.scrollDown();
		CommonWebActions.fnHighlightMe(CommonWebActions.wd, CommonWebActions.wd.findElement(By.xpath("//*[contains(text(),'Get started')]")));
		CommonWebActions.webClick("btnGetStarted");
//********Deadline Selection*********
//		CommonWebActions.webClick("DeadlineSelection");
		CommonWebActions.fnHighlightMe(CommonWebActions.wd, CommonWebActions.wd.findElement(By.xpath("(//*[@name='selectItem'])[1]")));
		CommonWebActions.webClick("DeadlineSelectionValue");
		CommonWebActions.Selectvaluefromdropdown("DeadlineSelectionValue", "1 February");
		CommonWebActions.webClick("btnSaveandContinue");
//********Personal Details*********
		CommonWebActions.webClick("txtage");
		CommonWebActions.webSet("txtage","30");
		CommonWebActions.webClick("personalfinance");
		CommonWebActions.Selectvaluefromdropdown("personalfinance", "Sponsor Company");
		CommonWebActions.webClick("btnSaveandContinue");
//********Family information*********
		CommonWebActions.scrollup();
		waitUntilLoaded(CommonWebActions.wd,By.xpath("(//button[@class='imd-btn imd-btn--blue'])[2]"),100);
		CommonWebActions.webClick("btnfamilyadd");
		CommonWebActions.Selectvaluefromdropdown("familyrelation", "Child");
		CommonWebActions.webSet("familyfirstname", "Auto_FirstName");
		CommonWebActions.webSet("familylastname", "Auto_LastName");
		CommonWebActions.webSet("familyNationality", "Indian");
		CommonWebActions.webClick("familynationalitysearch");
		CommonWebActions.webClick("btnsave");
		CommonWebActions.wait(2000);
		CommonWebActions.webClick("btnSaveandContinue");
//********Contact Details*********
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Contact Details')]")).getText().contentEquals("Contact Details")){
			test.log(Status.PASS,"Contact Details Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Contact Details Page")));
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********Source of Information*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Source of Information')]")).getText().contentEquals("Source of Information")){
			test.log(Status.PASS,"Source of Information Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Source of information Page")));
			CommonWebActions.Selectvaluefromdropdown("DeadlineSelectionValue", "Other");
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********Alumni Contact*********
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Alumni')]")).getText().contentEquals("Alumni Contact")){
			test.log(Status.PASS,"Alumni Contact Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Alumni Page")));
			waitUntilLoaded(CommonWebActions.wd,By.xpath("(//button[@class='imd-btn imd-btn--blue'])[2]"),100);
			CommonWebActions.webClick("btnfamilyadd");
			CommonWebActions.Selectvaluefromdropdown("alumnititle", "Mr.");
			CommonWebActions.webSet("familyfirstname", "Auto_FirstName");
			CommonWebActions.webSet("familylastname", "Auto_LastName");
			CommonWebActions.webSet("emailaddress", "test@test.com");
			CommonWebActions.webClick("btnsave");
			CommonWebActions.wait(2000);
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********Academic Experience*********
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Academic')]")).getText().contentEquals("Academic Experience")){
			test.log(Status.PASS,"Academic Experience  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Academic Experience Page")));
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********GMAT/GRE*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'GMAT')]")).getText().contentEquals("GMAT/GRE")){
			test.log(Status.PASS,"GMAT/GRE  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "GMAT/GRE")));
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********English Test*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'English Test')]")).getText().contentEquals("English Test")){
			test.log(Status.PASS,"GMAT/GRE  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "English Test")));
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********Current Employment Status*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Current Employment Status')]")).getText().contentEquals("Current Employment Status")){
			test.log(Status.PASS,"Current Employment Status  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Current Employment Status")));
			CommonWebActions.Selectvaluefromdropdown("Employmentstatus", "Yes");
			CommonWebActions.webClick("btnSaveandContinue");
		}	
//********Professional Experience*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Professional Experience')]")).getText().contentEquals("Professional Experience")){
			test.log(Status.PASS,"Professional Experience  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Professional Experience")));
			CommonWebActions.webClick("btnSaveandContinue");
		}	
//********Career Development*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Career Development')]")).getText().contentEquals("Career Development")){
			test.log(Status.PASS,"Career Development  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Career Development")));
			CommonWebActions.Selectvaluefromdropdown("DeadlineSelectionValue", "Automotive");
			CommonWebActions.Selectvaluefromdropdown("CareerDevelopment", "Accounting");
			CommonWebActions.webSet("CareerGoal", "India");
			CommonWebActions.webClick("CareerGeography");
			List<WebElement> Wordpara=CommonWebActions.wd.findElements(By.xpath("//*[@name='Text Area']"));
			for(int i=0;i<Wordpara.size();i++){
				Wordpara.get(i).click();
				Wordpara.get(i).sendKeys("Automation");
			}
			CommonWebActions.webClick("btnSaveandContinue");
		}	
//********Essays*********
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Essays')]")).getText().contentEquals("Essays")){
			test.log(Status.PASS,"Essays  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Essays")));
			List<WebElement> Wordpara=CommonWebActions.wd.findElements(By.xpath("//*[@name='Text Area']"));
			for(int i=0;i<Wordpara.size();i++){
				Wordpara.get(i).click();
				Wordpara.get(i).sendKeys("Automation");
			}
			CommonWebActions.wd.findElement(By.xpath("(//*[@class='slds-textarea'])[3]")).sendKeys("Automation");
			CommonWebActions.webClick("btnSaveandContinue");
		}
//********References*********
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'References')]")).getText().contentEquals("References")){
			test.log(Status.PASS,"References  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "References")));
			CommonWebActions.webClick("btnreferenceAdd");
			CommonWebActions.Selectvaluefromdropdown("alumnititle", "Mr.");
			CommonWebActions.webSet("referencefirstname", "Auto_FirstName");
			CommonWebActions.webSet("referencelastname", "Auto_LastName");
			CommonWebActions.webSet("referenceemailaddress", "test@test.com");
			CommonWebActions.webClick("btnsave");
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("btnreferenceAdd");
			CommonWebActions.Selectvaluefromdropdown("alumnititle", "Mr.");
			CommonWebActions.webSet("referencefirstname", "Auto_FirstName1");
			CommonWebActions.webSet("referencelastname", "Auto_LastName2");
			CommonWebActions.webSet("referenceemailaddress", "test2@test1.com");
			CommonWebActions.webClick("btnsave");
			CommonWebActions.wait(6000);
			CommonWebActions.webClick("btnSaveandContinue");
		}	
//********Documents*********	
		if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Documents')]")).getText().contentEquals("Documents")){
			test.log(Status.PASS,"Documents Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Documents")));
			List<WebElement>Fileupload=CommonWebActions.wd.findElements(By.xpath("//*[@class='slds-file-selector__body']/span[1]/lightning-primitive-icon"));
			for(int j=0;j<Fileupload.size();j++){
				int k=j+1;
				CommonWebActions.fnHighlightMe(CommonWebActions.wd,CommonWebActions.wd.findElement(By.xpath("(//*[@class='slds-file-selector__body']/span[1]/lightning-primitive-icon)["+k+"]")));
				Fileupload.get(j).click();
//				WebElement ele = CommonWebActions.wd.findElement(By.xpath("(//*[@name='fileUploader'])["+j+"]"));
//				JavascriptExecutor executor = (JavascriptExecutor)CommonWebActions.wd;
//				executor.executeScript("arguments[0].click();", ele);
				Thread.sleep(1000);
					Screen s = new Screen();
			        Pattern fileInputTextBox = new Pattern("C:\\IMD\\imd.testautomation.project\\src\\test\\resources\\testobjects\\Filename.PNG");
			        Pattern openButton = new Pattern("C:\\IMD\\imd.testautomation.project\\src\\test\\resources\\testobjects\\Save.PNG");
			        Pattern DneButton=new Pattern("C:\\IMD\\imd.testautomation.project\\src\\test\\resources\\testobjects\\Done.PNG");
			        s.wait(fileInputTextBox, 20);
			        String inputFilePath = "C:\\IMD\\imd.testautomation.project\\src\\test\\resources\\testobjects\\";
			        s.type(fileInputTextBox, inputFilePath + "Done.PNG");
			        s.click(openButton);
			        Thread.sleep(8000);
			        s.click(DneButton);
//			        Alert alert = CommonWebActions.wd.switchTo().alert(); 
//			        alert.dismiss(); 
//			        Robot r = new Robot();
//			        r.keyPress(KeyEvent.VK_ESCAPE); 
//			        r.keyRelease(KeyEvent.VK_ESCAPE);
//				CommonWebActions.wd.switchTo().activeElement();
//				CommonWebActions.wd.findElement(By.xpath("//*[contains(text(),'Done')]")).click();
			}
			
//********Submit*********
			CommonWebActions.wait(3000);
			CommonWebActions.webClick("btnsave1");
//			CommonWebActions.waituntil("submit");
			if(CommonWebActions.wd.findElement(By.xpath("//h2[contains(text(),'Submit')]")).getText().contentEquals("Submit")){
				test.log(Status.PASS,"Submit  Page is displayed"+ test.addScreenCaptureFromPath(ExtentManager.takeScreenShot(CommonWebActions.wd, "Submit")));
				CommonWebActions.webClick("btnSaveandContinue");
			}*/	
//			CommonWebActions.webClick("btnSaveandContinue");
//		}
//		    String unencryptedEmail_Flag = ExcelUtil.getDataFromExcel(testcasename,"unencryptedEmail_Flag");
//	        String ordersuppression_Flag = ExcelUtil.getDataFromExcel(testcasename,"ordersuppression_Flag");
//	        boolean unencypted_flag=CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).isSelected();
//	        boolean ordersuppression_flag=CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).isSelected();
//	        if(unencryptedEmail_Flag == "Y" && ordersuppression_Flag=="N"){
//	        	if(!unencypted_flag) {
//	        		CommonWebActions.javaclick("unencryptedEmail_Flag");}
//	        		else if(ordersuppression_flag){
//	        		CommonWebActions.javaclick("ordersuppression_flag");
//	        		}
//	        	}
//	        if(unencryptedEmail_Flag == "N" && ordersuppression_Flag=="N"){
//	        	if(unencypted_flag) {
//	        		CommonWebActions.javaclick("unencryptedEmail_Flag");}
//	        		else if(ordersuppression_flag){
//	        		CommonWebActions.javaclick("ordersuppression_flag");
//	        		}
//	        	}
//	        if(unencryptedEmail_Flag == "N" && ordersuppression_Flag=="Y"){
//	        	if(unencypted_flag) {
//	        		CommonWebActions.javaclick("unencryptedEmail_Flag");}
//	        		else if(!ordersuppression_flag){
//	        		CommonWebActions.javaclick("ordersuppression_flag");
//	        		}
//	        	}
	        
	        
	        
	        
	        
	        
	        
	        
	        
//	        if(unencryptedEmail_Flag == "Y" && ordersuppression_Flag=="N"){
//	        	if(CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).isSelected()){
//	        		CommonWebActions.javaclick("unencryptedEmail_Flag");
//	          }
//	        	else if(unencryptedEmail_Flag == "N" && ordersuppression_Flag=="Y"){
//	        		
//	        		
//	        		CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_38_0']")).click();
//
//	        	}
//	        	else{
//	        		CommonWebActions.wd.findElement(By.xpath("//*[@class='siebui-ctrl-checkbox siebui-align-left siebui-input-align-left s_1_1_3_0']")).click();
//	        		
//	        	}
//	        	
//	        	}
	        	
	}
	
	@AfterTest
	public void logOut() {
		
//		 CommonWebActions.wd.quit();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	
	
	public WebElement waitUntilLoaded(WebDriver driver,By matcher, int seconds){
		FluentWait<WebDriver> wait = new WebDriverWait(driver,seconds).pollingEvery(100, TimeUnit.MILLISECONDS);
		WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(matcher));
		return we;

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
	public  void attachReport(String fileName, String folderName) {
		
		IAttachmentFactory attachfac = (IAttachmentFactory) testSet.attachments()
				.queryInterface(IAttachmentFactory.class);
		IAttachment attach = (IAttachment) attachfac.addItem(fileName).queryInterface(IAttachment.class);
		IExtendedStorage extAttach = (IExtendedStorage) attach.attachmentStorage()
				.queryInterface(IExtendedStorage.class);
		String folderN = folderName.replace("\\", "\\\\");
		extAttach.clientPath(folderN);
		extAttach.save(fileName, true);
		attach.description("Uploading.........");
		attach.post();
		attach.refresh();
}
}
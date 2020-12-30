package coreFramework;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import com.mercury.qualitycenter.otaclient.IAttachment;
import com.mercury.qualitycenter.otaclient.IAttachmentFactory;
import com.mercury.qualitycenter.otaclient.IExtendedStorage;
import com.mercury.qualitycenter.otaclient.ITestSet;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.ITestCase;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;

public class ALMTestfactory extends ExtentManager {
	
	private static ITestSet testSet;
	 static ALMServiceWrapper wrapper = new ALMServiceWrapper(
             "http://qc.teliacompany.net:8080/qcbin");
	 public static void updateResults(String TestSetFolder,String TestSetName,int TestSetID,String Testcasename,String Status) throws Exception {
try {
	        ALMServiceWrapper wrapper = new ALMServiceWrapper(
	                    "http://qc.teliacompany.net:8080/qcbin");
				
//	        wrapper.connect(QCUserid, new String(td.decrypt("9YTbRNkGw9XTsXa01bcc4w==").getBytes("UTF-8"), "UTF-8"), Domain, Project);
	         wrapper.connect("cbo823", "Today@123", "SWE", "E2EMassMarket");
	 		extent.flush();
			String filename=FileUtils.readFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt");
			System.out.println(filename);
			 ITestCase Test=wrapper.updateResult(TestSetFolder,TestSetName, TestSetID, Testcasename, StatusAs.NO_RUN);
			 if (Status.equalsIgnoreCase("Pass")){
				 System.setProperty("jacob.dll.path",
							System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
				  Test=wrapper.updateResult(TestSetFolder,TestSetName, TestSetID, Testcasename, StatusAs.PASSED);
//				  wrapper.newAttachment(System.getProperty("user.dir"), "Test Result",Test );
				  System.out.println(FileUtils.readFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt"));
//				  wrapper.newAttachment(filename, "Test Result",Test );
				  FileUtils.clearTheFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt"); 
				  wrapper.close();
			 }else if(Status.equalsIgnoreCase("Fail")) {
				 System.setProperty("jacob.dll.path",
							System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
				Test=wrapper.updateResult(TestSetFolder,TestSetName, TestSetID, Testcasename, StatusAs.FAILED);
//				 wrapper.newAttachment(filename, "TestResult",Test );
				 FileUtils.clearTheFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt"); 
		         wrapper.close();
			 }
			  else if(Status.equalsIgnoreCase("Not Completed")){
				  System.setProperty("jacob.dll.path",
							System.getProperty("user.dir")+"\\jacob-1.17-M2-x86.dll");
					FileUtils.readFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt");
				   Test=wrapper.updateResult(TestSetFolder,TestSetName, TestSetID, Testcasename,StatusAs.NOT_COMPLETED);
	//			   wrapper.newAttachment("C:\\Users\\rrelan\\Downloads\\telia.testautomation.test\\report-output\\20190212\\Telia_Automation_20190212133816263.html", "Test Result",Test );
//				     wrapper.newAttachment(filename, "Test Result",Test );
				     FileUtils.clearTheFile(System.getProperty("user.dir") + "\\report-output\\filepath.txt"); 
			         wrapper.close();
			  }
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
         
   } 
	 
	 public static void ConnectToALM(String QCUserid,String Domain,String Project) throws Exception {
//		 extent.flush();
		 ALMServiceWrapper wrapper = new ALMServiceWrapper(
                 "http://qc.teliacompany.net:8080/qcbin");
		 System.setProperty("jacob.dll.path",System.getProperty("user.dir")+ "\\jacob-1.17-M2-x86.dll");
//     wrapper.connect(QCUserid, new String(td.decrypt("9YTbRNkGw9XTsXa01bcc4w==").getBytes("UTF-8"), "UTF-8"), Domain, Project);
      wrapper.connect("cbo823", "Today@123", "SWE", "E2EMassMarket");
//		 TrippleDes td = new TrippleDes();
//		 wrapper.connect(QCUserid, new String(td.decrypt("9YTbRNkGw9XTsXa01bcc4w==").getBytes("UTF-8"), "UTF-8"), Domain, Project);
	 }
	public static void attachReport(String fileName, String folderName) {/*
		
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
*/}
}

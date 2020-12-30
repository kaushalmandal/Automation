package coreFramework;


import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;



/**
 * This class consists of all the common methods required to perform
 * actions on windows controls
 * 
 * @author  Nagaraj Jayagondra
 * @version 1.0
 * @since   23-Dec-2015 
 */
public class CommonWindowsActions extends ReportUtil{

	static Screen applicationScreen = new Screen();
	static Pattern controlImage = null;
	static String currDir = System.getProperty("user.dir");
	static String imageRepoLocation = "\\src\\test\\resources\\testArtifacts\\imageRepo\\";


	/**
	 * This method is used to click on windows controls or anything displayed on the GUI
	 * 
	 * @author Nagaraj Jayagondra 
	 * @param  imageLocationInRepository This is the logical name of the of the location of the image in the Image Repo
	 */
	public static void winClick(String imageLocationInRepository){
		try{
			Screen applicationScreen = new Screen();
//			String actualImageLocation = ORUtil.getImageLocationValue(imageLocationInRepository);
//			System.out.println(actualImageLocation);
			//checkImageValueExistsForKey(actualImageLocation);
			//
			//"\\"
//			actualImageLocation = currDir+imageRepoLocation+actualImageLocation+".PNG";
//			System.out.println(actualImageLocation);
			//controlImage = new Pattern(controlImage);
			Thread.sleep(10000);
			
//			applicationScreen.click(actualImageLocation);
			ReportUtil.reporterEvent("info", "Clicked on [ " + imageLocationInRepository + " ]");
		}catch(Exception e){
			ReportUtil.reporterEvent("fail", "Image/Control [ " + imageLocationInRepository + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	
	/**
	 * This method is used to enter text on windows text boxes or any text boxes
	 * 
	 * @author Nagaraj Jayagondra 
	 * @param  imageLocationInRepository This is the logical name of the of the location of the image in the Image Repo
	 * @param  textToEnter This is the column name in test data excel 
	 */
	public static void winSet(String imageLocationInRepository, String textToEnter){
		String textToEnter1 = null;
		try{
			Screen applicationScreen = new Screen();
//			String actualImageLocation = ORUtil.getImageLocationValue(imageLocationInRepository);
			//checkImageValueExistsForKey(actualImageLocation);
//			System.out.println(actualImageLocation);
			System.out.println(textToEnter);
			String onlyTestCaseName=ReportUtil.onlyTestCaseName;
			textToEnter1 = ExcelUtil.getDataFromExcel(onlyTestCaseName,textToEnter);
			System.out.println("PackageNumber"+ textToEnter1);
//			actualImageLocation = currDir + imageRepoLocation + actualImageLocation + ".PNG";
//			System.out.println(actualImageLocation);
			//controlImage = new Pattern(actualImageLocation);
			applicationScreen.type(textToEnter1);
			ReportUtil.reporterEvent("info", "Text [ " + textToEnter + " ] entered in the web element [ " + imageLocationInRepository + " ]" );
		}catch(Exception e){
			ReportUtil.reporterEvent("fail", "Text box [ " + imageLocationInRepository + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	/**
	 * This method is used to check if the image name is present in the image repository
	 * 
	 * @author Nagaraj Jayagondra 
	 * @param  imageKeyValue This is the logical name of the image in the repository
	 */
	public static void checkImageValueExistsForKey(String imageKeyValue){
		if (imageKeyValue.equals("IMAGELOCATIONNOTFOUND")) {
			ReportUtil.reporterEvent("fail","Image's logical name [ " + imageKeyValue + " ] not found in Image Repository. Please check...");
			Assert.assertEquals(imageKeyValue.equals("IMAGELOCATIONNOTFOUND"), false);
		}		
	}

}

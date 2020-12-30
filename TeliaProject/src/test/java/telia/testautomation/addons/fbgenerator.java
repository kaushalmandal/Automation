package telia.testautomation.addons;
import java.awt.Dimension;
import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import coreFramework.ALMTestfactory;
import coreFramework.CommonWebActions;
import coreFramework.ExcelUtil;
import coreFramework.ExtentManager;

public class fbgenerator extends ExtentManager {

private String actual_StatusXL;
static WebDriver fb;
String Packagename=new Object(){}.getClass().getPackage().getName().split("[.]")[2];
@BeforeTest
	public void init() {
		String hostName;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		System.out.println("hostName: " + hostName);
	}

	
@Test
	public void fbgenerate() throws Exception {
	 UIManager.put("OptionPane.minimumSize",new Dimension(100,200)); 
     UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(  
             "Arial", Font.BOLD, 18)));
    double lengthResult;
	try {
		lengthResult = Double.parseDouble(JOptionPane.showInputDialog("Please Enter how many fb numbers required"));
	} catch (NumberFormatException e) {
		 JOptionPane.showMessageDialog(null, "Please enter a number in digit format.","Error",JOptionPane.ERROR_MESSAGE);
	         lengthResult = Double.parseDouble(JOptionPane.showInputDialog("Please Enter how many fb numbers required"));
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String chromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	fb = new ChromeDriver();
//    fb.get("http://ow300eaimmat.ddc.teliasonera.net:7280/oss-core-ui/app/login.jsp");
    fb.get("http://ow200eaimmsit.ddc.teliasonera.net:7280/oss-core-ui/app/login.jsp");
   
    fb.findElement(By.xpath(".//*[@placeholder='Username']")).sendKeys("scr748");
//    fb.findElement(By.xpath(".//*[@placeholder='Password']")).sendKey
//    ("Hemasundara123");
    fb.findElement(By.xpath(".//*[@placeholder='Database Server']")).sendKeys("eaimmsit");
    fb.findElement(By.xpath(".//*[@placeholder='Database Name']")).sendKeys("teliamm");
    fb.findElement(By.xpath(".//*[@name='submit']")).click();
    fb.manage().window().maximize();
    fb.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    fb.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(fb, 40);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("isc_W")));
    
    waitForLoad1();
//    JTextPane jtp = new JTextPane();
//    Document doc = jtp.getDocument();
//    jtp.setSize(new Dimension(480, 10));
//    jtp.setPreferredSize(new Dimension(480, jtp.getPreferredSize().height));
    fb.findElement(By.xpath("(.//*[text()='Choose a Perspective'])[1]")).click();
	fb.findElement(By.xpath(".//*[@aria-posinset='2']")).click();
//    int int1 = Integer.parseInt(test1);
        JavascriptExecutor executor = (JavascriptExecutor)fb;
	for(int i=0;i<lengthResult;i++) {
		
//	    Thread.sleep(5000);
//	    explicitClick(fb,20,By.xpath("//td[text()='New' and @class='toolStripButton']"));
	    (new WebDriverWait(fb, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Identifier Management']")));
	    Thread.sleep(2000);

//        
//        executor.executeScript("arguments[0].click();", fb.findElement(By.xpath("//td[text()='New' and @class='toolStripButton']")));
		fb.findElement(By.xpath("(//td[text()='New'])[1]")).click();
		fb.findElement(By.xpath("(//td[text()='Create' and @class='buttonRounded'])[1]")).click();
		fb.findElement(By.xpath(".//*[text()='Status']/ancestor::tr/td[3]")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(fb);
//		actions.moveToElement(fb.findElement(By.xpath(".//*[text()='Status']/ancestor::tr/td[3]/div/nobr/span/table/tbody/tr/td/div")));
//		actions.click();
//		Thread.sleep(2000);
//		actions.sendKeys("Reserved");
////		actions.click();
//		actions.build().perform();
//		Thread.sleep(2000);
		fb.findElement(By.xpath(".//*[text()='Status']/ancestor::tr/td[3]/div/span/table/tbody/tr/td/div")).sendKeys("Reserved");
		fb.findElement(By.xpath(".//*[text()='Status']/ancestor::tr/td[3]/div/span/table/tbody/tr/td/div")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@eventproxy, 'isc_NumberCreateDialog_0') and @role='dialog']//*[@class='selectItemText']/../../td[2]")));
		executor.executeScript("arguments[0].scrollIntoView()", fb.findElement(By.xpath(".//*[contains(@eventproxy, 'isc_NumberCreateDialog_0') and @role='dialog']//*[@class='selectItemText']/../../td[2]")));
		WebElement type=fb.findElement(By.xpath(".//*[contains(@eventproxy, 'isc_NumberCreateDialog_0') and @role='dialog']//*[@class='selectItemText']/../../td[2]"));
		
//		WebElement type = fb.findElement(By.xpath("//img[@src='http://ow300eaimmat.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Link.svg']"));
		 for (int iCnt = 0; iCnt < 3; iCnt++) {
		      //Execute javascript
			 executor.executeScript("arguments[0].style.border='4px groove green'", type);
		         Thread.sleep(1000);
		         executor.executeScript("arguments[0].style.border=''", type);
		   }
//		actions.moveToElement(type);
//		actions.click();
		type.click();
		
		fb.findElement(By.xpath(".//*[@aria-posinset='2']")).click();
		
//		type.sendKeys("Number Range");
//		WebElement Link = fb.findElement(By.xpath("//img[@src='http://ow300eaimmat.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Link.svg']"));
		WebElement Link = fb.findElement(By.xpath("//img[@src='http://ow200eaimmsit.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Link.svg']"));
		
		Link.click();
//		fb.findElement(By.xpath("//*[@id=\"isc_AV\"]")).click();
		Thread.sleep(3000);
//		fb.switchTo().frame(0);
//		fb.switchTo().activeElement();
		
//		WebElement Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#isc_E1 > label")));
//		WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@src='http://ow300eaimmat.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Search_For.svg'])[2]")));
//		WebElement Search1 = fb.findElement(By.xpath("(//img[@src='http://ow300eaimmat.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Search_For.svg'])[2]"));
		WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@src='http://ow200eaimmsit.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Search_For.svg'])[2]")));
		WebElement Search1 = fb.findElement(By.xpath("(//img[@src='http://ow200eaimmsit.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Search_For.svg'])[2]"));
		Search1.click();
//		 executor.executeScript("arguments[0].click();",Search1 );
//		fb.findElement(By.xpath("//*[@id=\"isc_TJ\"]")).click();
//		fb.findElement(By.xpath("//*[@id=\"isc_B3\"]/table/tbody/tr/td/table/tbody/tr/td[1]")).click();
//		fb.findElement(By.xpath("//*[@id=\"isc_DN\"]/table/tbody/tr/td/table/tbody/tr/td[1]")).click();
		fb.findElement(By.xpath("//*[contains(@id, 'extra_icon_0')]")).click();
//		WebElement OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[text()='OK']")));
//		OK.click();
		Thread.sleep(1000);
//		WebElement OK=fb.findElement(By.xpath("(.//*[@class='buttonRounded']/div/div)[1]"));
		WebElement OK=fb.findElement(By.xpath(".//*[@class='buttonRounded']/div"));
		actions.moveToElement(OK);
		actions.click();
		executor.executeScript("arguments[0].scrollIntoView()", OK); 
		fb.findElement(By.xpath(".//*[text()='OK']")).click();
		Thread.sleep(1000);
		WebElement Savebutton=fb.findElement(By.xpath("//img[@src='http://ow200eaimmsit.ddc.teliasonera.net:7280/oss-core-ui/app/images/Actions/Save.svg']"));
		executor.executeScript("arguments[0].scrollIntoView()", Savebutton);
		Savebutton.click();
		Thread.sleep(3000);
//		fb.findElement(By.xpath("//*[@id=\"isc_7Atable\"]/tbody/tr/td[5]/div/nobr")).click();
		String fbnumber=fb.findElement(By.xpath("(//*[contains(@id, 'table')]/tbody/tr/td[5]/div)[1]")).getText();
		String finalfbnumber= fbnumber.replaceAll("[-+.^:,]","");
		System.out.println(finalfbnumber);
		
		fb.navigate().refresh();
//		fb.close();
//		fb.quit();
	}
    
    
    
	 
	
    
}
public static WebElement explicitClick (WebDriver driver, int TimeinSecs, By element) {
		WebDriverWait wait = new WebDriverWait(fb, 60);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

 public static void waitForLoad1() {
	ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	};
	WebDriverWait wait = new WebDriverWait(fb, 30);
	wait.until(pageLoadCondition);
}
}
package SwitchToWindow;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchFromParentToChild 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement ele=driver.findElement(By.xpath("//button[@id='windowButton' and text()='New Window']"));
	  ele.click();
	  String parent_window=driver.getWindowHandle();
	  Set<String>all_windows=driver.getWindowHandles();
	  Iterator<String>itr=all_windows.iterator();
	  while(itr.hasNext())
	  {
		  String child_window=itr.next();
		  if(!parent_window.equals(child_window))
		  {
			  driver.switchTo().window(child_window);
			  WebElement child_window_text=driver.findElement(By.xpath("//h1[@id='sampleHeading'])"));
			  Assert.assertEquals("This is a sample page",child_window_text.getText(),"text matched");
			  
		  }
		  driver.switchTo().window(parent_window);
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  ChromeDriver driver=new ChromeDriver();
	  driver.get("https://demoqa.com/browser-windows");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {

  }

}

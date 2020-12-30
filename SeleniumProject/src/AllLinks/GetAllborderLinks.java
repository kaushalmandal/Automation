package AllLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAllborderLinks 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement>ele=driver.findElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//ul//li//a"));
	  for(int i=0;i<ele.size();i++)
	  {
		  if(ele.get(i).getText().equalsIgnoreCase("Gift a Smile"));
		  {
			  try
			  {
				  ele.get(i).click();
			  }
			  catch(Exception e)
			  {
				JavascriptExecutor je=((JavascriptExecutor)driver);
				je.executeScript("arguments[0].click();", ele.get(i));
			  }
			  
		  }
			  
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
	  
  }

}

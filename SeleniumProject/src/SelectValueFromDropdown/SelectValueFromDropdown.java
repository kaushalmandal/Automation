package SelectValueFromDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectValueFromDropdown 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement>ele=driver.findElements(By.xpath("//select[@name='country']//option"));
	  System.out.println("Total size is :"+ele.size());
	  for(int i=0;i<ele.size();i++)
	  {
		  if(ele.get(i).getText().equalsIgnoreCase("ANGOLA"))
		  {
			  ele.get(i).click();
		  }
	  }
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://demo.guru99.com/test/newtours/register.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}

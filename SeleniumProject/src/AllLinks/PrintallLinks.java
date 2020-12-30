package AllLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintallLinks 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  List<WebElement>ele=driver.findElements(By.tagName("a"));
	  for(int i=0;i<ele.size();i++)
	  {
		  System.out.println(ele.get(i).getText());
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

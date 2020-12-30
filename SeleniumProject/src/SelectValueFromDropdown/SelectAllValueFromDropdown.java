package SelectValueFromDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectAllValueFromDropdown 
{
	public static WebDriver driver;
  @Test
  public void f() 
  {
	  WebElement ele=driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
	  ele.click();
	  List<WebElement>str=new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']//option"))).getOptions();
	  for(int i=0;i<str.size();i++)
	  {
		  if(str.get(i).getText().equalsIgnoreCase("5"))
		  {
			  new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"))).selectByVisibleText(str.get(i).getText());
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.spicejet.com/");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}

package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SupplyingData 
{
	public static WebDriver driver;
  @Test(dataProvider = "testdata")
  public void f(String username,String password) 
  {
	  WebElement uname=driver.findElement(By.xpath("//input[@id='email']"));
	  WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
	  uname.sendKeys(username);
	  uname.clear();
	  pass.sendKeys(password);
	  pass.clear();
	  
  }

  @DataProvider(name="testdata")
  public Object[][] getData() 
  {
	  Object[][]data=new Object[3][2];
	  data[0][0]="kaushal";
	  data[0][1]="kaushal123";
	  data[1][0]="abc";
	  data[1][1]="abc123";
	  data[2][0]="ankit123";
	  data[2][1]="ankit123";
	return data;
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}

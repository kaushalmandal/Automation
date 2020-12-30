package JXL;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadDataFromExcel 
{
	public static WebDriver driver;
	


	@Test()
	public void clickLogIn() {
		WebElement loginBtn = driver.findElement(
				By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
		loginBtn.click();
	}
	@Test(dependsOnMethods = { "clickLogIn" })
	public void doSignIn() {
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement login = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		username.sendKeys("kkumar000999@gmail.com");
		password.sendKeys("Kaushal123");
		login.click();
	}
	@Test(dependsOnMethods = { "doSignIn" })
	public void verifyMenu() 
	{
		List<WebElement>menu=driver.findElements(By.xpath("//div[@id='main-nav']//a"));
		for(int i=0;i<menu.size();i++)
		{
			if(menu.get(i).getText().equalsIgnoreCase("Companies"));
			menu.get(i).click();
		}
	}

  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://freecrm.co.in/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}

package TestNG;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grouping 
{
	public static WebDriver driver;
	
	public void verifyLinks(String linksURL) throws IOException
	{
		URL url=new URL(linksURL);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setConnectTimeout(300);
		con.connect();
		if(con.getResponseCode()==200)
		{
			System.out.println(linksURL+"----------"+con.getResponseMessage());
		}
		else if(con.getResponseCode()==400)
		{
			System.out.println(linksURL+"------------"+con.getResponseMessage());
		}
	}
  @Test(groups={"demo"})
  public void login() 
  {
	  WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
	  WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
	  username.sendKeys("kaushal.mandal000@gmail.com");
	  password.sendKeys("kaushal123");
	  WebElement loginBtn=driver.findElement(By.xpath("//button[@name='login']"));
	  loginBtn.click();
	  
  }
  @Test
  public void afterLogin()
  {
	String title=driver.getTitle();
	System.out.println("title is : "+title);
	Assert.assertEquals(title, "Facebook – log in or sign up","message");
  }
  @Test(groups={"demo"})
  public void clickAccountSetting() throws IOException
  {
	  List<WebElement>links=driver.findElements(By.tagName("a"));
	  for(int i=0;i<links.size();i++)
	  {
		  WebElement ele=links.get(i);
		  String url=ele.getAttribute("href");
		  verifyLinks(url);
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","E:\\Software\\driver\\chromedriver.exe");
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

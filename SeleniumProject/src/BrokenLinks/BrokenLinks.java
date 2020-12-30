package BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks 
{
	public static WebDriver driver;
	
	public static void verifyLinksActive(String linksURL)
	{
		try
		{
			URL url=new URL(linksURL);
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(300);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()==200)
			{
				System.out.println(linksURL+"----------"+httpURLConnect.getResponseMessage());
			}
			if(httpURLConnect.getResponseCode()==httpURLConnect.HTTP_NOT_FOUND)
			{
				System.out.println(linksURL+"-----------"+httpURLConnect.getResponseMessage());
			}
			
		}
		catch(Exception e)
		{
			
		}
		
	}
  @Test
  public void f() 
  {
	  List<WebElement>links=driver.findElements(By.tagName("a"));
	  System.out.println("links size are "+links.size());
	  for(int i=0;i<links.size();i++)
	  {
		  WebElement ele=links.get(i);
		  String url=ele.getAttribute("href");
		  verifyLinksActive(url);
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

package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDependency {
	public static WebDriver driver;

	@Test(dependsOnMethods = { "doSignIn" })
	public void doLogout() {
		WebElement settingBtn = driver.findElement(By.xpath("//div[@role='listbox']//i"));
		settingBtn.click();
		List<WebElement> opt = driver.findElements(By.xpath("//div[@class='menu transition visible']//a"));
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getText().equalsIgnoreCase("Log Out")) {
				opt.get(i).click();
				break;
			}
		}

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

	@Test()
	public void clickLogIn() {
		WebElement loginBtn = driver.findElement(
				By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
		loginBtn.click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}

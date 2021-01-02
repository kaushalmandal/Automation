package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	//By locator
	
	private By emailId=By.id("email");
	private By password=By.id("passwd");
	private By SignInButton=By.id("SubmitLogin");
	private By forgotPwdLink=By.linkText("Forgot your password?");
	
	
	//constructor of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public void enterUserName(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	public void enterPassword(String userpass)
	{
		driver.findElement(password).sendKeys(userpass);
	}
	public void clickLogin()
	{
		driver.findElement(SignInButton).click();
	}
	public AccountsPage doLogin(String un,String pwd)
	{
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignInButton).click();
		return new AccountsPage(driver);
		
	}

}


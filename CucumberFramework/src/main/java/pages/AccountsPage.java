package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountsPage 
{
	private WebDriver driver;
	
	private By accountSections=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public void getAccountsSectionCount()
	{
		int accountSectionSize=driver.findElements(accountSections).size()-1;
		System.out.println("size of accounts section is :"+accountSectionSize);
		
	}
	public void getAccountSectionList()
	{
		List<String>accountList=new ArrayList<>();
		List<WebElement>accountHeaderList=driver.findElements(accountSections);
		for(WebElement e:accountHeaderList)
		{
			String text=e.getText();
			System.out.println("text is :"+text);
			accountList.add(text);
			
			
		}
		if(accountHeaderList.containsAll(accountList))
		{
			System.out.println("account section list are matching");
		}
	}

}

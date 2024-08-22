package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends basePage{

	public MyaccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//h2[normalize-space()='My Account']
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement msgHeading;
	//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']
	
	
	
	@FindBy(xpath="//a[@title='My Account']") WebElement account;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a") 
	WebElement logout;
	
	
	public  boolean isMyAccountExists()
	{
		try {
			return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogout()
	{
		logout.click();
	}
	
	public void clickacc()
	{
		account.click();
	}
	
	

}

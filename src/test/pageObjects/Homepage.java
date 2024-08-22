package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends basePage{
	
	
	//constructor
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	


	//locators
	@FindBy(xpath="//span[@class='caret']") WebElement account;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement regbutton;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement loginbutton;
	
	
	
	public void clickMyAccount()
	{
		account.click();
	}
	
	public void clickReg()
	{
		regbutton.click();
	}
	
	public void login()
	{
		loginbutton.click();
	}
	
	

}

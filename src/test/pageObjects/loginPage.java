package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

	public loginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement submit;
	
	
	
	public void sendEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void sendpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clicksubmit()
	{
		submit.click();
	}
	

}

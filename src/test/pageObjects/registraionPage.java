package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registraionPage extends basePage {
	
	public registraionPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstname;
	
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastname;
	
	@FindBy(xpath="	//input[@id='input-email']") WebElement Email;

	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	
	
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confirmpass;
	
	
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	
	
	@FindBy(xpath="	//input[@value='Continue']") WebElement submit;
	

	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement message;
	
	
	public void setFirstName(String name)
	{
		firstname.sendKeys(name);
	}
   

	public void setLastName(String name)
	{
		lastname.sendKeys(name);
	}
	

	public void setEmail(String name)
	{
		Email.sendKeys(name);
	}
	
	public void setTelephone(String name)
	{
		telephone.sendKeys(name);
	}
	

	public void setPassword(String name)
	{
		password.sendKeys(name);
	}
	

	public void setConfirmpass(String name)
	{
		confirmpass.sendKeys(name);
	}
	

	public void setAgree()
	{
		agree.click();
		
	}
    
	
	public void setSubmit()
	{
		
		submit.click();
		
	}
	
	
	public String confirmmsg()
	{
		
		try {
			return message.getText();
		}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
}

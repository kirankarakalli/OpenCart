package testCases;

import org.testng.annotations.Test;

import Utillities.DataProviders;
import junit.framework.Assert;
import pageObjects.Homepage;
import pageObjects.MyaccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC003_DataDriverTestcase extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"datadriven","master"})
	public void login(String email,String password,String exp)
	{
		try {
		logger.info("*** starting TC002  LoginTest***");
		Homepage h=new Homepage(driver);
		h.clickMyAccount();
		logger.info("*** clicked on my account ***");
		h.login();
		logger.info("*** clicked on my login ***");
		
		loginPage lp=new loginPage(driver);
		lp.sendEmail(email);
		lp.sendpassword(password);
		lp.clicksubmit();
		
		MyaccountPage m=new MyaccountPage(driver);
		boolean target=m.isMyAccountExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				Assert.assertTrue(true);
				m.clickacc();
				m.clicklogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
	
			if(exp.equalsIgnoreCase("invalid"))
			{
				if(target==true)
				{
					m.clickacc();
					m.clicklogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
					
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
			
		logger.info("*** clicked on my login ***");
	}
	
	
	

}

package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homepage;
import pageObjects.MyaccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void login()
	{
		try {
		logger.info("*** starting TC002  LoginTest***");
		Homepage h=new Homepage(driver);
		h.clickMyAccount();
		logger.info("*** clicked on my account ***");
		h.login();
		logger.info("*** clicked on my login ***");
		
		loginPage lp=new loginPage(driver);
		lp.sendEmail(p.getProperty("email"));
		lp.sendpassword(p.getProperty("password"));
		lp.clicksubmit();
		
		MyaccountPage m=new MyaccountPage(driver);
		boolean target=m.isMyAccountExists();
		Assert.assertTrue(target);
		
		logger.info("*** finsihed TC002  LoginTest***");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	

}

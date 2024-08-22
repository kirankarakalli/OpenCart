package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Homepage;
import pageObjects.registraionPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	
	@Test(groups= {"sanity","master"})
	public void verifyAccountRegistration()
	{
		logger.info("*** starting TC001 ***");
		try {
		Homepage h=new Homepage(driver);
		h.clickMyAccount();
		logger.info("*** clicked on my account ***");
		h.clickReg();
		
		logger.info("*** clicked on register***");
		
		registraionPage r=new registraionPage(driver);
		
		logger.info("***providing all details***");
		r.setFirstName(randomString().toUpperCase());
		r.setLastName(randomString().toUpperCase());
		r.setEmail(randomString()+"@gmail.com");
		r.setTelephone("949494");
		String password=randomAlphaNumeric();
		r.setPassword(password);
		r.setConfirmpass(password);
		r.setAgree();
		r.setSubmit();
		
		logger.info("*** validating message***");
	    String confirmation=r.confirmmsg();
	    
	    Assert.assertEquals(confirmation, "Your Account Has Been Created!"); 
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("debug logs...");
			Assert.fail();
		}
		
		logger.info("*** Test case finished***");
		
	}
	
	

}

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
    
	@BeforeClass(groups= {"sanity","regression","master"})
	 @Parameters({"os","browser"})
	public void setup(@Optional("windows")String os,@Optional("chrome")String br) throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		String url=p.getProperty("url");
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os");
				return;
				
			}
			
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			default:return;
			}
			driver=new RemoteWebDriver(new URL("http://10.11.204.58:4444/wd/hub"),cap);

		}
				
		if(p.getProperty("execution_env").equals("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default:System.out.print("choose correct brwoser");return;
			}
			
		}
				
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
		
	}
	
	public String randomString()
	{
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	
	public String randomNumber()
	{
		String generatedstring= RandomStringUtils.randomNumeric(10);
		return generatedstring;
	}
	
	
	public String randomAlphaNumeric()
	{
		String generatedstring= RandomStringUtils.randomNumeric(5);
		String generatednumber= RandomStringUtils.randomAlphabetic(5);
		return generatedstring+"@"+generatednumber;
	}
	
	
	public String captureScreen(String tname)
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		
		String Targetpath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		File targetfile=new File(Targetpath);
		
		sourcefile.renameTo(targetfile);
		return Targetpath;
		
	}


}

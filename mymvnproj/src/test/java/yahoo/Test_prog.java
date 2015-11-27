package yahoo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Test_prog 
{

	WebDriver driver;
		
	 {
         System.setProperty("atu.reporter.config", "e:\\polaris_hyd\\myproj\\atu.properties");
	 }
	 
	@Test
	@Parameters({"browser"})
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
		   driver=new FirefoxDriver();
		}
		if(br.matches("ie"))
		{
			System.setProperty("webdriver.ie.driver","c:\\IEDriverServer.exe");
		   driver=new InternetExplorerDriver();
		}
		Home h=new Home(driver);
		h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.logout();
	}
}

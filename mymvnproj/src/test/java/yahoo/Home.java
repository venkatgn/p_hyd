package yahoo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;




@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Home 
{
    WebDriver driver;
    
    
    {
        System.setProperty("atu.reporter.config", "e:\\polaris_hyd\\myproj\\atu.properties");
	 }
    
    public Home(WebDriver driver)
    {
    	this.driver=driver;
    }
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
		
	}
	public void login() throws Exception
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
	    driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);	
		if(driver.findElement(By.linkText("Sign Out")).isDisplayed())
		{
			ATUReports.add("Login is pass", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		else
		{
			ATUReports.add("Login is failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			
		}
	}
	public void createacc() throws Exception
	{
		open();
		driver.findElement(By.id("login-signup")).click();
		Thread.sleep(8000);
		driver.findElement(By.name("firstname")).sendKeys("abcd");
		driver.findElement(By.name("secondname")).sendKeys("xyza");
		
		driver.findElement(By.xpath("//*[@class='country-code-arrow']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@data-code='91']")).click();
		driver.findElement(By.id("mobile")).sendKeys("8989898989");
		
		
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("June");
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1987");
		Thread.sleep(2000);
		//driver.findElement(By.id("male")).click();		
	}
}

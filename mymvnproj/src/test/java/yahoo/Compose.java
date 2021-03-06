package yahoo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Compose 
{

	WebDriver driver;
	
	 {
         System.setProperty("atu.reporter.config", "e:\\polaris_hyd\\myproj\\atu.properties");
	 }
	
	public Compose(WebDriver driver)
	{
		this.driver=driver;
	}
	public void sendmail() throws Exception
	{
		Thread.sleep(5000);
		System.out.println("This is to send mails");
        driver.findElement(By.xpath("//*[@class='composeicon']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("Subj")).sendKeys("hello");
        driver.findElement(By.name("Content")).sendKeys("this is sample mail");
        Thread.sleep(1000);
        driver.findElement(By.id("send_top")).click();
	}
	public void logout()
	{
		driver.findElement(By.linkText("Sign Out")).click();
	}
}

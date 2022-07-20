package Yammer;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ActiveUser
{
	WebDriver driver=null;
	//it will be invoked before each test.
	@Test
	public void activeUser() throws InterruptedException
	{

		System.setProperty("webdriver.edge.driver","C:\\Users\\ROSGAJAN\\Desktop\\SeleniumAppium\\project\\Driver\\msedgedriver.exe");//to configure the browser driver path
		driver = new EdgeDriver();	// instance of EdgeDriver
		driver.get("https://web.yammer.com/main/org/capgemini.com");//URL launch


		driver.manage().window().maximize(); //it is used to maximize the current browser.

		Thread.sleep(10000);
		// it will stop the execution of the script for the 10 seconds in the script

		driver.findElement(By.id("ms-searchux-input-0")).click(); // id locator for search-box
		Thread.sleep(5000);

		driver.findElement(By.id("ms-searchux-input-0")).sendKeys("OneTeamOneFamily"); // sending value as OneTeamOneFamily-demo

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/form/button[3]")).click(); //it will click on arrow icon 
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/button[2]/span/span/span/span")).click(); // it will now click on communities 
		Thread.sleep(2000);

		driver.findElement(By.linkText("OneTeamOneFamily-Demo")).click();// by using linkText locator finding OneTeamOneFamily-demo communities and clicking on it. 
		Thread.sleep(10000);

		//	     //About
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[4]/div/div/button[2]/span/span/span/span")).click();

		Thread.sleep(1000);
			     
		driver.findElement(By.linkText("See more")).click();
		Thread.sleep(2000);
		WebElement activeUser =driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/ul/li/div/div/div/div/div/div/div[4]/ul/li/span[2]/div/span[1]"));
		String s= activeUser.getText();
		System.out.println("====================================================================================");
		System.out.println("Active user : " + s);
		System.out.println("==================================================================================");

	}
}




package Yammer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Content 
{

	WebDriver driver=null;

	//it will be invoked before each test.
	@BeforeMethod
	
	public void launch() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\ROSGAJAN\\Desktop\\SeleniumAppium\\project\\Driver\\msedgedriver.exe");//to configure the browser driver path
		driver = new EdgeDriver();	// instance of EdgeDriver
		driver.get("https://web.yammer.com/main/org/capgemini.com");//URL launch


		driver.manage().window().maximize(); //it is used to maximize the current browser.

		Thread.sleep(10000);
		// it will stop the execution of the script for the 10 seconds in the script
	}



	@Test
	//it is the test method.
	public void content() throws InterruptedException
	{


		// id locator for search-box
		driver.findElement(By.id("ms-searchux-input-0")).click(); 
		Thread.sleep(5000);

		
		// sending value as OneTeamOneFamily-demo
		driver.findElement(By.id("ms-searchux-input-0")).sendKeys("OneTeamOneFamily"); 

		
		//it will click on arrow icon 
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/form/button[3]")).click(); 
		Thread.sleep(2000);

		
		// it will now click on communities 
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/button[2]/span/span/span/span")).click(); 
		Thread.sleep(2000);

		
		// by using linkText locator finding OneTeamOneFamily-demo communities and clicking on it. 
		driver.findElement(By.linkText("OneTeamOneFamily-Demo")).click();
		Thread.sleep(10000);

		
		// upload some content on yammer
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/div/div/div/ul/li[1]/button/div/div[2]/div/div")).click();// click on discussion button 
		Thread.sleep(5000);

		
		//Passing Quote 
		WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/span/div/div[2]/div/div/div/div")); 
		text.sendKeys("Take care of the trees, they will take care of you.");
		
		//post button
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[5]/div[2]/div/ul")).click();
		Thread.sleep(10000);
		
		driver.navigate().refresh();	

		
		Thread.sleep(6000);
		
	
		
		
		
	}

}

package Yammer;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MostLike {


	static WebDriver driver;
	@BeforeMethod
	public static void launch() throws InterruptedException, IOException {


		System.setProperty("webdriver.edge.driver","C:\\Users\\ROSGAJAN\\Desktop\\SeleniumAppium\\project\\Driver\\msedgedriver.exe");//to configure the browser driver path
		driver = new EdgeDriver();	// instance of EdgeDriver
		driver.get("https://web.yammer.com/main/org/capgemini.com");//URL launch
		driver.manage().window().maximize(); //it is used to maximize the current browser.

		Thread.sleep(10000);
		// it will stop the execution of the script for the 10 seconds in the script

	}
	@Test
	public static void test() throws IOException, InterruptedException
	{

		//Click on OneTeamONeFamily


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
		driver.findElement(By.linkText("OneTeamOneFamily")).click();
		Thread.sleep(10000);



		List like =new ArrayList();
		Map <Integer, WebElement> map = new HashMap<Integer, WebElement>();
		WebElement likeList=null;

		for(int j=1;j<10 ;j++)
		{
			likeList= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div/div[2]/ul/li[3]/div/div/div/div/div/div/div[1]/div[5]/div[2]/div/div/div/div/div[2]/div/div/div/button/span/div"));
			WebElement ele = likeList;
			String a=likeList.getText().substring(0, 2).replaceAll(" ","");
			Thread.sleep(3000);
			int num=Integer.parseInt(a);
			like.add(num);
			map.put(num, ele);
			Thread.sleep(2000);


		}
		Collections.sort(like);
		System.out.println(like);
		Object numberOfLike = (like.get(like.size()-1));

		int numberOfLikeOfMostLikedPost = (Integer) (numberOfLike);
		System.out.println("Number of like of most liked post is: "+(numberOfLikeOfMostLikedPost+1));
		WebElement mostLikedLocator = map.get(like.get(like.size()-1));





		driver.close();
	}
}
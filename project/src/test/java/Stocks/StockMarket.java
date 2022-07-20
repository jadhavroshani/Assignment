package Stocks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StockMarket 
{
	WebDriver driver=null;
	//it will be invoked before each test.

	@BeforeMethod
	public void launch() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ROSGAJAN\\Desktop\\excelcode\\selenium\\driver\\chromedriver.exe");//to configure the browser driver path
		driver = new ChromeDriver();	// instance of EdgeDriver
		driver.get("https://in.tradingview.com/markets/");//URL launch
		driver.manage().window().maximize(); //it is used to maximize the current browser.

		Thread.sleep(3000);
		// it will stop the execution of the script for the 10 seconds in the script
	}
	@Test
	public void stock() throws InterruptedException, IOException
	{
		
		WebElement Element = driver.findElement(By.linkText("Earnings Calendar"));
		Element.click();
				
		List<WebElement> Ticker = driver.findElements(By.xpath( "//*[@id=\"js-screener-container\"]/div[4]/table/tbody/tr/td/div/div/a"));

		System.out.println("=================================Ticker============================");
		System.out.println(Ticker.size()); 
		for(int i=0 ; i<Ticker.size();i++)
		{

			System.out.print("Ticker DATA:"+Ticker.get(i).getText()+" ");
		}

		List<WebElement> Price = driver.findElements(By.xpath( "//*[@id=\"js-screener-container\"]/div[4]/table/tbody/tr/td[2]"));

		System.out.println("=================================Price============================");
		System.out.println(Price.size()); 
		for(int i=0 ; i<Price.size();i++)
		{

			System.out.print("Price DATA:"+Price.get(i).getText()+" ");
		}

		List<WebElement> Date = driver.findElements(By.xpath( "	//*[@id=\"js-screener-container\"]/div[4]/table/tbody/tr/td[9]"));

		System.out.println("=================================Price============================");
		System.out.println(Date.size()); 
		for(int i=0 ; i<Date.size();i++)
		{

			System.out.print("Price DATA:"+Date.get(i).getText()+" ");
		}
		
	

		File file = new File("C:\\Users\\ROSGAJAN\\Desktop\\SeleniumAppium\\project\\excel\\stocksdata.csv");

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("Tricker,Price,Date");
		bw.newLine();
		for(int i=0;i<Ticker.size();i++)
		{
			bw.write(Ticker.get(i).getText().replaceAll("", "")+","+Price.get(i).getText().replaceAll("","")+","+Date.get(i).getText().replaceAll("",""));
			bw.newLine();
			
		}
		bw.close();
		fw.close(); 

	}


}

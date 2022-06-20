package coreJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Resume 
{
	public static void main(String[] args) throws IOException
	{

		Scanner scan= new Scanner(System.in); //to get user input

		System.out.println("Enter Keywords to be found : ");

		String Keyword = scan.next(); // To enter keyword manually

		boolean flag = false;  // condition is set to false

		int count = 0;       // initialize count as 0

		FileInputStream file = new FileInputStream("C:\\Users\\ROSGAJAN\\Desktop\\Resume.pdf"); //read the contents of the file
		Scanner sc = new Scanner(file);		//Creating a Scanner object

		while(sc.hasNextLine())
		{
			String Content = sc.nextLine();
			if(Content.indexOf(Keyword)!=-1)
			{
				flag = true;
				count = count+1;
			}
		}
		if(flag)
		{

			System.out.println("Number of occurrences is: "+count);
			if(count>=1)
			{
				System.out.println("This resume matches with the required Keyword- 100%");
			}

		}

		else
		{
			System.out.println("Number of occurrences is: "+count);
			System.out.println("This resume does not match with the Keyword - 0%");
		}


	}

}

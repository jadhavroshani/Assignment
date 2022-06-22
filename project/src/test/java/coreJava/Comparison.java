package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Comparison 
{
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		File file1 = new File("data\\BankSide.xlsx");   //creating a new file instance  
		File file2= new File("data\\userDetails.xlsx");

		FileInputStream f1 = new FileInputStream(file1);   //obtaining bytes from the file  
		FileInputStream f2 = new FileInputStream(file2);

		XSSFWorkbook wb1 = new XSSFWorkbook(f1);
		XSSFWorkbook wb2 = new XSSFWorkbook(f2);


		XSSFSheet s1=wb1.getSheet("bank");
		XSSFSheet s2=wb2.getSheet("user");


		int rowcount1=s1.getPhysicalNumberOfRows();
		int  rowcount2=s2.getPhysicalNumberOfRows();


		if( rowcount1== rowcount2) 
		{

			for(int i=0;i< rowcount1 ;i++)

			{
				for(int j=1 ;j < rowcount2 ;i++)
				{

					XSSFRow r1=s1.getRow(i);
					XSSFRow r2=s2.getRow(i);


					XSSFCell c1=r1.getCell(i);
					XSSFCell c2=r2.getCell(i);

					c1.setCellType(CellType.STRING);
					String str1=c1.getStringCellValue();


					c2.setCellType(CellType.STRING);
					String str2=c2.getStringCellValue();

					if(str1.equals(str2)) 
					{
						System.out.println(" Match    |    "+str1 +"  ==>  "+str2);
						System.out.println("---------------------------------------------------------------------------------------------");
						
					}
					else {
						

						System.out.println("Mismatch |    "+str1 +"  ==>  "+str2);
						System.out.println("---------------------------------------------------------------------------------------------");
					}
				}
			}
		}


	}

}

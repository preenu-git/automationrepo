package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;//inbuilt class to read data from the file
	static XSSFWorkbook wb;//java inbuilt class to read data from the workbook
	static XSSFSheet sh;// java inbuilt class to read data from sheet
	public static String getStringData(int a,int b,String sheet) throws IOException 
	{
		f=new FileInputStream("C:\\Users\\lenovo\\git\\automationrepo\\GroceryApplication\\src\\main\\resources\\testdata.xlsx");
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);//worksheet is a method used to get details from the sheet
		XSSFRow r =sh.getRow(a);//a represent row....xssf is an inbuilt class used to read data from the row
		//get row is a method used to get data from the row
		XSSFCell c = r.getCell(b);//b represent column...Xssf is an inbuilt class used to read data from the column
		//get column is a method used to get data from the column
		return c.getStringCellValue();// getStringcellValue method used to get string value
	}
	public static String getintData(int a,int b,String sheet) throws IOException
	{
		f=new FileInputStream("C:\\Users\\lenovo\\git\\automationrepo\\GroceryApplication\\src\\main\\resources\\testdata.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int d=(int)c.getNumericCellValue();//getNumericCellValue method used to get number value   (int)---typecasting..change double into int
		//typecasting---converting one datatype in to another datatype
		return String.valueOf(d);//valueOf is a type conversion method used to convert one datatype to string
		
		
	}
	public static String getfloatData(int a,int b,String sheet) throws IOException
	
	{
		f=new FileInputStream("C:\\Users\\lenovo\\git\\automationrepo\\GroceryApplication\\src\\main\\resources\\testdata.xlsx");
		wb=new XSSFWorkbook(f);
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		float d=(float)c.getNumericCellValue();//getNumericCellValue method used to get number value   (float)---typecasting
		//typecasting---converting one datatype in to another datatype
		return String.valueOf(d);//valueOf is a type conversion method used to convert one datatype to string
		
		
	}

}




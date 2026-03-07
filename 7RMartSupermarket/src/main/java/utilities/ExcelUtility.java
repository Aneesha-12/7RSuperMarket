package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public static String readStringData(int row, int col,String sheet) throws IOException 
	{
		f = new FileInputStream(Constant.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
     }
	//getNumericCellValue()-To get the numbers(double) from the cell
		public static String getIntData(int a,int b,String sheet) throws IOException
		{
			f= new FileInputStream(Constant.TESTDATAFILE);
			w= new XSSFWorkbook(f);
			sh=w.getSheet(sheet);
			XSSFRow r = sh.getRow(a);
			XSSFCell c = r.getCell(b);
			int value=(int)c.getNumericCellValue(); //Type casting
			return String.valueOf(value); //To convert int to String
		}
	

}

package dataReaders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	
	public static void main(String[] args) throws Exception{
		
	
	
	File f1=new File("C:\\Users\\rkandula\\Desktop\\apochepoi_Selenium.xlsx");
	
	FileInputStream fis=new FileInputStream(f1);
	
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	
	int sheetscount=workbook.getNumberOfSheets();
	
	for(int i=0; i<sheetscount;i++)
	{
		if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Dummy"))
		{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			Iterator<Row> rows =sheet.iterator();
			
			Row firstrow=rows.next();
			
			Iterator<Cell> cells=firstrow.cellIterator();
			
			int k=0;
			int column=0;
			while(cells.hasNext())
			{
				Cell value=cells.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column=k;
					}
				k++;
			}
			
			System.out.println(column);
			
		}
	}
	
	}

}

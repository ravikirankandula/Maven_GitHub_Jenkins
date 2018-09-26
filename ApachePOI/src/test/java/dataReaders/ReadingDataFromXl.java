package dataReaders;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromXl {
	
	public ArrayList<String> getData(String sheetname, String columnname)throws Exception
	{
		ArrayList<String> cellvalues=new ArrayList<String>();
		
		File f1=new File("C:\\Users\\rkandula\\Desktop\\apochepoi_Selenium.xlsx");
		
		FileInputStream fis = new FileInputStream(f1);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheetscount=workbook.getNumberOfSheets();
		
		System.out.println("Total no of sheets: "+sheetscount);
		
		for(int i=0; i<sheetscount; i++)
		{
			
			System.out.println("Sheet"+" "+ i +" "+"Name is :" +workbook.getSheetName(i));
		
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
		
				
				//identify test cases column by scanning the entrire row
				//once column is identified, scan entire test cases column to identify purchase test cases row
				//after you grab, purchase test case row, pull all the data of that row
				
				Iterator<Row> rows= sheet.iterator();
				
			    Row firstrow= rows.next();
			    
			    Iterator<Cell> cells=firstrow.cellIterator();
			   // cells.next();
			    
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
			       
			while(rows.hasNext())
			{
				Row fr=rows.next();
				if(fr.getCell(column).getStringCellValue().equalsIgnoreCase(columnname))
				{
					
					Iterator<Cell> cv=fr.cellIterator();
					
					while(cv.hasNext())
					{
						Cell check=cv.next();
						if(check.getCellTypeEnum()==CellType.STRING)
						{
							cellvalues.add(check.getStringCellValue());
						}
						
						else
						{
							cellvalues.add(NumberToTextConverter.toText(check.getNumericCellValue()));
							
						}
						
					}
				}
			}
			
			
			}
		}
		return cellvalues;
		
	}
	
	

}

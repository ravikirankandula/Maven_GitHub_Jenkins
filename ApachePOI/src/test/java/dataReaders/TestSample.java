package dataReaders;

import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ReadingDataFromXl RD = new ReadingDataFromXl();
		
		String sheetname="Dummy";
		String columname="VAM";
		
		ArrayList<String> values=RD.getData(sheetname, columname);
		
		System.out.println(values.get(0));
		
		System.out.println(values.get(1));
		
		System.out.println(values.get(2));
		
		System.out.println(values.get(3));
		
	
		
	}

}

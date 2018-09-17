package mypackage1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvider1 {

@Test(dataProvider= "getdataprovider")
public void dataproviderexmaple(String a, String b)
{
	System.out.println("Data provider examples");
	System.out.println(a);
	System.out.println(b);
}

@DataProvider
public Object[][] getdataprovider()
{
	Object[][] data=new Object[3][2];
	
	data[0][0]="ravi";
	data[0][1]="ravi1244";
	
	data[1][0]="ravikiran";
	data[1][1]="ravi1244asd";
	
	data[2][0]="ravikandula";
	data[2][1]="ravi1244456";
	
	return data;
	
}
}

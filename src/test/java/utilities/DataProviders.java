package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String excelFilepath=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(excelFilepath);//creating an object for XLUtility
		
		int noOfRows=xlutil.getRowCount("LoginData");	
		int noOfCols=xlutil.getCellCount("LoginData", 1);
				
		Object data[][]=new Object[noOfRows][noOfCols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=noOfRows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<noOfCols;j++)  //0    i is rows j is col
			{
				data[i-1][j]= xlutil.getCellData("LoginData",i, j);  //1,0
			}
		}
	return data;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	@DataProvider(name="registerData")
	public Object[][] getRegisterData() throws IOException
	{
		String excelFilepath=".\\testData\\Opencart_RegisterData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(excelFilepath);//creating an object for XLUtility
		
		int noOfRows=xlutil.getRowCount("UserRegisterData");	
		int noOfCols=xlutil.getCellCount("UserRegisterData", 1);
				
		Object data[][]=new Object[noOfRows][noOfCols];//created for two dimension array of object type
		
		for(int i=1;i<=noOfRows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<noOfCols;j++)  //0    i is rows j is col
			{
				data[i-1][j]= xlutil.getCellData("UserRegisterData", i, j);  //1,0
			}
		}
	return data;//returning two dimension array
				
	}
	
	
	//DataProvider 3
	
	//DataProvider 4
}

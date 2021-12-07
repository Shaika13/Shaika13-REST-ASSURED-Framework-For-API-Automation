package testData;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.XLUtils;

public class TestDataProvider {

	public static String path;
	
	public static void Filelocation() {
	if(System.getProperty("os.name").toLowerCase().contains("windows")) 
	{	
	path=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\testData.xlsx";
	}
	
	else if(System.getProperty("os.name").toLowerCase().contains("mac"))
	{
		path=System.getProperty("user.dir")+"/src/test/java/TestData/testData.xlsx";
	}
	}
	
	
	@DataProvider(name="PostData")
	String [][] getDataForSingleFutureTrip() throws IOException
	{
		
		Filelocation();
		int rownum=XLUtils.getRowCount(path, "PostData");
		int colcount=XLUtils.getCellCount(path,"PostData",1);
		
		String PostData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				PostData[i-1][j]=XLUtils.getCellData(path,"PostData", i,j);//1 0
				
			}
				
		}
		
	return PostData;
	}
	
	
	
}

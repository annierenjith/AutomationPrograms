package TestNG;


import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Program1 {
	@DataProvider(name = "dp")
	public Object[][] createData1() 
	{
		Object o1 [][] = new  Object[][] 
			{
				{ "Cedric", "Student1" },
				{ "Anne", "Student2"},
			};
		return o1;
	}


		@Test(dataProvider ="dp")
		public void verifyData1(String n1, String n2)
		{
			System.out.println(n1 + " " + n2);
		}

}

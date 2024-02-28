package practice;

import java.io.IOException;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;

public class Genericmethodpractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub'
		PropertyFileUtility PUTIL=new PropertyFileUtility();
		String U = PUTIL.readDataFromPropertyFile("url");
		System.out.println(U);
		
		ExcelFileUtility EUTIL=new ExcelFileUtility();
		String Data = EUTIL.readDataFromExcel("contacts", 1, 1);
		System.out.println(Data);
		
		JavaUtility JUTIL=new JavaUtility();
		String Date = JUTIL.getsystemDate();
		System.out.println(Date);
		
	}
	

}

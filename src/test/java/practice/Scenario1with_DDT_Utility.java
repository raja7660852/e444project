package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeliniumUtility;
import objectRepositary.HomePage;
import objectRepositary.LoginPage;

public class Scenario1with_DDT_Utility {
	public static void main(String[] args) throws InterruptedException, Exception {
		//
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeliniumUtility sUtil=new SeliniumUtility();
		
		//
		String URL = pUtil.readDataFromPropertyFile("url");  
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//read data from excel
	     String LASTNAME = eUtil.readDataFromExcel("contacts", 1, 2);
	
        //1.Launch Base browser
	   	WebDriver driver=new ChromeDriver();
		sUtil.maximizewindow(driver);
		sUtil.addimplicitywait(driver);
			
		//2.Open URL
		 driver.get(URL); 
		
		 //3.loin the application 
			
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		LoginPage lp=new LoginPage(driver);
		lp.clickonLogin(USERNAME, PASSWORD);
			
		//4.click on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
		//5.click on contactsLookup
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
		//6.enter data 
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
		//7.save the data
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		//8.validation
	     String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(contactHeader.contains(LASTNAME))
	     {
			System.out.println(contactHeader);
			System.out.println("Pass");
		 }
		    else
	     {
			System.out.println("Fail");
	     }
		  //9.Logout
//		   WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//		
//		   sUtil.moveToElementAction(driver, ele);
//		   Thread.sleep(1000);
//		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		    HomePage hp=new HomePage(driver);
	    	hp.logoutofApp(driver);
	     	System.out.println("scenario1DDT");
		    //10.close the browser
		    driver.quit();
	}

}

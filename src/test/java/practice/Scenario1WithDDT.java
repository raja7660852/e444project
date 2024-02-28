package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		      //Read Data From PropertyFile
		
		      FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		      Properties p = new Properties();
		      p.load(fisp);
		      String URL = p.getProperty("url");
		      String USERNAME = p.getProperty("username");
		      String PASSWORD = p.getProperty("password");
		
		      //ReadData From Excel
               FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		       Workbook wb = WorkbookFactory.create(fise);
		       String LASTNAME = wb.getSheet("contacts").getRow(1).getCell(2).getStringCellValue();
		
	            //1.Launch Base browser
				WebDriver driver=new ChromeDriver();
			
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//2.Open URL
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//3.click on contacts
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				
				
				//4.click on contactsLookup
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();		
				//5.enter data 
				
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//6.save the data
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//7.validation
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
			//8.Logout
			WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			
			Actions act =new Actions(driver);
			act.moveToElement(ele).perform(); 
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			//9.close the browser
			driver.quit();
	}

}

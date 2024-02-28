package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        //1.Launch Base browser
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//2.load the application
		driver.get("http://localhost:8888/");
		
		//3.Login the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//4.click on contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
	    //5.click on create contactsLookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();	
		
		//6.enter data 
		driver.findElement(By.name("lastname")).sendKeys("Spiderman");
		
		//7.save the data
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//8.validation
        String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(contactHeader.contains("Spiderman"))
    	{
		System.out.println(contactHeader);
		System.out.println("Pass");
	    }
	    else
	    {
		System.out.println("Fail");
	    }
	    
	    //9.Logout
	     WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	
	     Actions act =new Actions(driver);
	     act.moveToElement(ele).perform(); 
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    //10.close the browser
	     driver.quit();

	}

}

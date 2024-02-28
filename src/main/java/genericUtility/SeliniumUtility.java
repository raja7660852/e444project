package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * @author Rajir
 *
 */
/**
 * @author Rajir
 *
 */
/**
 * @author Rajir
 *
 */
/**
 * @author Rajir
 *
 */
public class SeliniumUtility {
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	
	public void fullscreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	public void waitForElementToBevisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void addimplicitywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void handleDropDown(WebElement element ,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void handleDropDown(WebElement element ,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void handleDropDown(String text,WebElement element )
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void moveToElementAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dragAndDropAction(WebDriver driver,WebElement srcele,WebElement desele)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcele, desele).perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);", "");
		
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void handleFrame(WebDriver driver,int Frameindex)
	{
		driver.switchTo().frame(Frameindex);
	}
	public void handleFrame(WebDriver driver,String framenameID)
	{
		driver.switchTo().frame(framenameID);
	}
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public String captureScreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver; 
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\screenshots\\"+screenshotname+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath();//d://mavenproject/e4/screenshots/create.png-giving full path
		//attaching screenshot to extent reports
	}
	public void handlewindows(WebDriver driver,String expPartialTitle) 
	{
		//capture all windows 
		Set<String>allWinIds=driver.getWindowHandles();
		
	}
	}	
			
	
	
	
	
	
	
	
	
	
	
	
	




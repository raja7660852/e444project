package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepositary.HomePage;
import objectRepositary.LoginPage;

public class Baseclass {
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeliniumUtility sUtil = new SeliniumUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void bs() {
		System.out.println("---------DB connection succesfully------");
	}

	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bc() throws IOException {//String browser
		String URL = pUtil.readDataFromPropertyFile("url");
		driver=new ChromeDriver();
		/*
		 * if (Browser.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
		 * if (Browser.equalsIgnoreCase("Firefox")) { driver = new FirefoxDriver();
		 * 
		 * }
		 */		
		sdriver=driver;
		sUtil.maximizewindow(driver);
		sUtil.addimplicitywait(driver);
		driver.get(URL);
		System.out.println("---------Browser launch succesfully------");
	}

	@BeforeMethod(alwaysRun = true)
	public void bm() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.clickonLogin(USERNAME, PASSWORD);
		System.out.println("---------login  succesfully------");
	}

	@AfterMethod(alwaysRun = true)
	public void am() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("---------logout succesfully------");
	}

//	@AfterTest
	 @AfterClass(alwaysRun = true)
	public void ac() {
		driver.quit();
		System.out.println("---------window close succesfully------");
	}

	@AfterSuite(alwaysRun = true)
	public void as() {
		System.out.println("---------DB connection closed succesfully------");

	}

}

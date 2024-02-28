package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name  = "user_name")
	private WebElement userEdt;
	
	@FindBy(name  ="user_password")
	private WebElement passEdt;
	
	@FindBys({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement subBtn;
	
	//create a constructor 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPassEdt() {
		return passEdt;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}
	
	//create generic method
	public void clickonLogin(String USERNAME,String PASSWORD)
	{
		userEdt.sendKeys(USERNAME);
		passEdt.sendKeys(PASSWORD);
		subBtn.click();
	}
	

}

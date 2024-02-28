package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage {
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontactsLookupimg;
	
	public contactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreatecontactsLookupimg() {
		return createcontactsLookupimg;
	}

	public void clickonCreateContactLookupImg()
	{
		createcontactsLookupimg.click();
	}
}

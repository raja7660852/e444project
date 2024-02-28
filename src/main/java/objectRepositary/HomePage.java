package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeliniumUtility;

public class HomePage extends SeliniumUtility {
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath = "(//td[@class='small'])[2]")
	private WebElement adminstarImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdminstarImg() {
		return adminstarImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void clickOncontactsLink()
	{
		contactsLink.click();
	}
	public void clickonproductLink()
	{
		productLink.click();
	}
	public void logoutofApp(WebDriver driver) throws Exception
	{
		moveToElementAction(driver, adminstarImg);
		Thread.sleep(10);
		signoutLink.click();
			
	}

	public void clickOnOrganizationLink()
	{
			
	}

}

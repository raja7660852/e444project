package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeliniumUtility;

public class CreateNewcontactPage extends SeliniumUtility{
	
	@FindBy(name = "lastname")
	private WebElement LastNameedt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadsouecedrpdwn;
	
	public CreateNewcontactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameedt() {
		return LastNameedt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
		
	}
	
	public WebElement getLeadsouecedrpdwn() {
		return leadsouecedrpdwn;
	}

	public void setLeadsouecedrpdwn(WebElement leadsouecedrpdwn) {
		this.leadsouecedrpdwn = leadsouecedrpdwn;
	}

	public void createNewcontact(String LASTNAME)
	{
		LastNameedt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void createNewcontact(String LASTNAME,String LEADSOURCEVALUE)
	{
		LastNameedt.sendKeys(LASTNAME);
		handleDropDown(leadsouecedrpdwn, LEADSOURCEVALUE);
		SaveBtn.click();
	}
	

}

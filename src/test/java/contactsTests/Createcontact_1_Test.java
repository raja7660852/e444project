package contactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.Baseclass;
import genericUtility.ExcelFileUtility;
import genericUtility.ListnerImplementation;
import genericUtility.PropertyFileUtility;
import genericUtility.SeliniumUtility;
import objectRepositary.ContactsInfoPage;
import objectRepositary.CreateNewcontactPage;
import objectRepositary.HomePage;
import objectRepositary.LoginPage;
import objectRepositary.contactsPage;

@Listeners(ListnerImplementation.class)
public class Createcontact_1_Test extends Baseclass {
	@Test(groups = "smokesuite")//(retryAnalyzer = genericUtility.RetryAnalyserImplementation.class)
	public void createcontactlastname() throws Exception{
		
		//read data from excel
	     String LASTNAME = eUtil.readDataFromExcel("contacts", 1, 2);
	     
		//4.click on contacts
		HomePage hp=new HomePage(driver);
		hp.clickOncontactsLink();
			
		//5.click on contactsLookup
		contactsPage cp=new contactsPage(driver);
		cp.clickonCreateContactLookupImg();
			
		//6.Create new contact
		CreateNewcontactPage cncp=new CreateNewcontactPage(driver);
		cncp.createNewcontact(LASTNAME);
		
			
		//7.validation
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader = cip.captureHeaderText();
		 if(contactHeader.contains(LASTNAME))
	     {
			System.out.println(contactHeader);
			System.out.println("Pass");
			System.out.println("kick");
		 }
		    else
	     {
			System.out.println("Fail");
			System.out.println("Hello");
	     }
	}
	

}

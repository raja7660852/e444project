package contactsTests;

import org.testng.annotations.Test;

import genericUtility.Baseclass;
import objectRepositary.ContactsInfoPage;
import objectRepositary.CreateNewcontactPage;
import objectRepositary.HomePage;
import objectRepositary.contactsPage;

public class Createcontact_2_Test extends Baseclass{
@Test	
public void createcontactlastname() throws Exception{
		
		//read data from excel
	     String LASTNAME = eUtil.readDataFromExcel("contacts", 4, 2);
	     
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
		 }
		    else
	     {
			System.out.println("Fail");
	     }
	}
	

}

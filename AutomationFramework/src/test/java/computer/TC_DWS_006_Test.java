package computer;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;


@Listeners(ListenerUtility.class)
public class TC_DWS_006_Test extends BaseClass {

	
	@Test()
	
	public void clickOnComputer() throws EncryptedDocumentException, IOException {
		
		
		
		hp=new HomePage(driver);
		hp.getComputerlink().click();
		
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("Computer", 1, 0),"Computer page is not display");
		
		test.log(Status.PASS, "computer page is display");
	}
}

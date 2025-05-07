package book;

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
public class TC_DWS_005_Test extends BaseClass {	
	@Test
	public void clickOnBook() throws EncryptedDocumentException, IOException{		
		hp=new HomePage(driver);
		
		//Thread.sleep(3000);
		hp.getBookLink().click();
		Assert.assertNotEquals(driver.getTitle(), eutil.getStringDataFromExcel("Book", 1, 0),"Book page is not display");
	 test.log(Status.PASS, "Book page is display");
	}
	
	

}

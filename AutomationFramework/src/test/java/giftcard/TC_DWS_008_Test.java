package giftcard;

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
public class TC_DWS_008_Test extends BaseClass {
	
	@Test
	
	public void clickOnGiftCard() throws EncryptedDocumentException, IOException {
		
		/*test=report.createTest("clickOnGiftCard");
		 * This method is directly create on ListenerUtilit
		*/
		hp=new HomePage(driver);
		hp.getGiftcardlink().click();
		
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("GiftCard", 1, 0), "Giftcard page is not display");
		
		test.log(Status.PASS, "Giftcard is display");
	}

}

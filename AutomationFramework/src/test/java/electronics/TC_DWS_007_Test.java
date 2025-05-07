package electronics;

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

public class TC_DWS_007_Test extends BaseClass {
	
	@Test
	
	public void clickOnElectrnoic() throws EncryptedDocumentException, IOException {
		
		//test=report.createTest("clickOnElectrnoic(");
		
		hp=new HomePage(driver);
		hp.getElectroniclink().click();
		
		Assert.assertEquals(driver.getTitle(), eutil.getStringDataFromExcel("Electrnoic", 1, 0), "Electrnoic page is not display");
		
		test.log(Status.PASS, "Electrnoic page is display");
	}

}

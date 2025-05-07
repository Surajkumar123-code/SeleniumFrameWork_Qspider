package genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		test = report.createTest(result.getName());//this method is not need to create each and every class
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, result.getName()+" is failed");
		
		
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));//To add ScreenShot in extent file
		
		
		File tem = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshort/"+result.getName()+jutil.getSystemTime()+".png");
		try {
			FileHandler.copy(tem, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}

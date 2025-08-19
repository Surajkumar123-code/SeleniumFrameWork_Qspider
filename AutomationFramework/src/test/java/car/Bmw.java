package car;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Bmw {
	
	
	@Test(groups = "Smoke")
	public void launch() {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.bmw.in/en/index.html");
		
		Reporter.log("bmw launch sucessfully", true);
	}
	
	



}

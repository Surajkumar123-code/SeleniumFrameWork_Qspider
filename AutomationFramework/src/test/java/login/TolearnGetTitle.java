package login;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TolearnGetTitle {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("online Shopping site for Mobiles,Electronics"))
		{
			System.out.println("user faield to negative");
		}
		else
		{
			System.out.println("user not invalid");
		}
		
		
	}
 
}
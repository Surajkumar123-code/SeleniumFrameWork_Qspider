package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v115.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "Email")
	private WebElement emailText;
	@FindBy(id = "Password")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getEmailText() {
		return emailText;
	}


	public WebElement getPasswordText() {
		return passwordText;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}

	
	
	
	

}

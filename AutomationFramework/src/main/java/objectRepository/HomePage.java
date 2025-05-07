package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(partialLinkText = "Books")
	private WebElement bookLink;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement computerlink;
	
	
	@FindBy(linkText  = "Log out")
	private WebElement logoutButton;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement electroniclink;
	
    @FindBy(partialLinkText = "Gift Cards")
    private WebElement giftcardlink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getComputerlink() {
		return computerlink;
	}

	public WebElement getElectroniclink() {
		return electroniclink;
	}

	public WebElement getGiftcardlink() {
		return giftcardlink;
	}
	

	
	

}

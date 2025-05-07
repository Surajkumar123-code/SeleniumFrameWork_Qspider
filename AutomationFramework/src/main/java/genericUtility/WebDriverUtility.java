package genericUtility;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Suraj Kumar 
 */

public class WebDriverUtility {
	/**
	 * This method is use to maxmize window
	 * 
	 * @param driver
	 */

	public void maxmizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to capture size of a window
	 * 
	 * @param driver
	 * @return dimension
	 */

	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}

	/**
	 * This method is used to swithch driver control to window base url
	 * 
	 * @param driver
	 * @return
	 */

	public void switchToWindow(WebDriver driver, String url) {
		// step 1 capture window id

		Set<String> allwindowid = driver.getWindowHandles();

		// step 2 navigate through all the window

		for (String id : allwindowid) {
			driver.switchTo().window(id);
			String currenturl = driver.getCurrentUrl();

			if (currenturl.contains(url)) {
				break;
			}
		}

	}

	public void rightClick(WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.contextClick().perform();
		;
	}

	public void clickHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void mouseHOver(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void mouseHover(WebDriver driver, int x, int y) {

		Actions act = new Actions(driver);
		act.scrollByAmount(x, y);
	}

	public void switchToFreame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void SwitchToFrame(WebDriver driver, String nameorIndex) {
		driver.switchTo().frame(nameorIndex);
	}

	public void SwitchToFrame(WebDriver driver, WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}

	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void selectDropdownByIndex(WebElement element, int Index) {
		Select sc = new Select(element);
		sc.selectByIndex(Index);

	}

	public void selectDropdownByIndex(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}
	public void selectDropdownByIndex1(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	public void switchToAlertAndDismissAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
		
	}
	public void switchToAlertAndDismissAcce(WebDriver driver) {
		driver.switchTo().alert().dismiss();
}
	public void switchToAlertAndsendKeys(WebDriver driver,String data) {
		driver.switchTo().alert().sendKeys(data);
}
	public void screenShot(WebDriver driver) throws IOException {
		
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tem = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshort/"+jUtil.getSystemTime()+".png");
		FileHandler.copy(tem, des);
	}
	public String switchToAlertAndGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	         
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.doubleClick(element).perform();;
	}
	
	public void javaScript(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element );
	}
	
	public void javaScriptScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void javaSriptTillBotton(WebDriver driver, int x) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript(""+x+",document.body.scrollHeight()");
	}
	public void actionClick(WebDriver driver,WebElement element) {
		
		Actions act=new Actions(driver);
		act.click(element).perform();;
		
	}
}



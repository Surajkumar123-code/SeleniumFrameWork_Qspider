package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {
	
	public static ExtentReports report;
	public static  ExtentTest test;	
	
	
	public WebDriverUtility Wutil=new WebDriverUtility();
	
	public WebDriver driver;
	
	public static WebDriver sdriver;
	public JavaUtility jutil=new JavaUtility();
	public FileUtility futil=new FileUtility();
	public HomePage hp;
	public  LoginPage lp;
	public WelcomePage wp;
	public ExcelUtility eutil=new ExcelUtility();
	
	
	
	
	
	
	
	@BeforeSuite
	
	public void repoetConfigration() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/ExtentReport"+jutil.getSystemTime()+".html");
		 report = new ExtentReports();
		 report.attachReporter(spark);		
	}
	
	@Parameters("Browser")
	
	@BeforeClass
	
	public void launchBrowser(@Optional("Chrome") String browserName) throws IOException {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver= (WebDriver) new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver= (WebDriver) new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=(WebDriver) new EdgeDriver();
		}
		
		sdriver=driver;
	Wutil.maxmizeWindow(driver);	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(futil.getDataFromProperties("url"));
		
	}
	@BeforeMethod
	public void login() throws IOException {
		wp=new WelcomePage(driver);
		wp.getLoginlink().click();
		lp=new LoginPage(driver);
		lp.getEmailText().sendKeys(futil.getDataFromProperties("email"));
		lp.getPasswordText().sendKeys(futil.getDataFromProperties("password"));
		lp.getLoginButton().click();
		
	}
	@AfterMethod
	public void logout() {
		hp=new HomePage(driver);
		hp.getLogoutButton().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@AfterSuite
	public void reportBackUp() {
		report.flush();
	}
}


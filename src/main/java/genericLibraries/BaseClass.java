package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactrUsPage;
import pompages.Homepage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

public class BaseClass {
	protected WebDriverUtility web;
	protected PropertyFileUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriver driver;
	protected Homepage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected ContactrUsPage contact;
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		web = new WebDriverUtility();
		property = new PropertyFileUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		
		property.propertyConfig(IConstantPath.PROPERTIES_PATH);
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
	    String a= property.fetchProperty("time");
		long e = Long.parseLong(a);
		driver = web.openApplication(browser, url, e);
	}
	
	@BeforeMethod
	public void methodConfiguration() {
		excel.excelIntialization(IConstantPath.EXCEL_PATH);
		
		home = new Homepage(driver);
		demoApp = new SkillraryDemoAppPage(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		contact = new ContactrUsPage(driver);
		
		Assert.assertTrue(home.getlogo().isDisplayed());
	}
	
	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkbook();
	}
	@AfterClass
	public void classTearDown() {
		web.quitBrowser();
	}
	//@AfterTest
	//@AfterSuite

}

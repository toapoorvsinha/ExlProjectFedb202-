package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		
		//to call the non static methods from LoginPage, we have to
		//create an object, LoginPage is the class, loginPage1 is the object name and LoginPage
		//after the "new" is the constructor. This constructor is usually invisible but created
		//by default. "New" keyword does not work in this case.
		
		//LoginPage loginPage1 =  new LoginPage();
		
		//To properly call such methods we have to use the PageFactory function.
		//The purpose is to bring the original BrowserFactory driver from LoginPage
		//to Login Test over here.
		
		//Creates an object loginPage of LoginPage class, with a parameter of the driver
		//type being referenced in the LoginPage.class constructor
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		
		loginPage.insertUserName(username); 
		loginPage.insertPassword(password);  
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
	
		//BrowserFactory.tearDown();
	}

}

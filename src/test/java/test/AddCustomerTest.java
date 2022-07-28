package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String FullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String CompanyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String Email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String Phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String Address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String City = exlRead.getCellData("AddContactInfo", "City", 2);
	String Country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String State = exlRead.getCellData("AddContactInfo", "State", 2);
	String Zip = exlRead.getCellData("AddContactInfo", "Zip", 2);

	@Test
	public void userShouldBeAbleToCreateCustomer()
	{
		//calls the init method and store in BrowserFactory return type WebDriver variable which is
		//now going to be the same as driver in this class
		driver = BrowserFactory.init();
		//we will now create an object that will allow us to call multiple methods from the LoginPage class.
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		//Now create object of Dashboard Page
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomerMenuElement();
		dashboardPage.clickAddCustomerMenuElement();
		
		//Now create an object of the addCustomerPage
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage("Add Contact");
		addCustomerPage.insertFullName(FullName);
		addCustomerPage.selectCompany(CompanyName);
		addCustomerPage.insertEmail(Email);
		addCustomerPage.insertPhoneNum(Phone);
		addCustomerPage.insertAddress(Address);
		addCustomerPage.insertCity(City);
		addCustomerPage.selectCountry(Country);
		addCustomerPage.insertState(State);
		addCustomerPage.insertZip(Zip);
		addCustomerPage.clickSaveButton();
	}

}

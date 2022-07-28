package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_HEADER;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ELEMENT;

	
	public void validateAddContactPage(String addContactHeader)
	{
		//if you get assertion errors try thread.sleep(2000) that might help
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), addContactHeader, "Add contact page not found");
	}
	//same name can't be passed twice, so we'll need to randomize.
	public void insertFullName(String fullName) {
		int genNum = generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(fullName + genNum);
	}
	
	
	public void selectCompany(String company)
	{
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		
		EMAIL_ELEMENT.sendKeys(generateRandomNo(9999)+ email);
	}
	
	public void insertPhoneNum (String phoneNo) {
		
		//Excel doesnt know how to auto read numbers as strings (xml does) so we added a letter to numeric values on spreadsheet
		PHONE_NUMBER_ELEMENT.sendKeys(phoneNo + generateRandomNo(999));
	}	
	
	public void insertAddress(String address) {

		ADDRESS_ELEMENT.sendKeys(address);
	}	
	
	public void insertCity(String city) {

		CITY_ELEMENT.sendKeys(city);
	}	
	
	public void insertZip(String zip) {

		ZIP_ELEMENT.sendKeys(zip);
	}	
	
	public void insertState(String state) {

		STATE_ELEMENT.sendKeys(state);
	}	
	
	public void selectCountry(String country)
	{
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}
	
	public void clickSaveButton() {

		SAVE_BUTTON_ELEMENT.click();
		
	}	
	
	
	
	
}



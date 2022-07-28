package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	//Lecture 10 Selenium 3:25 mark
	
	//this is the constructor with the driver parameter
	//that will hold the driver value in the pagefactory function in LoginTest
	public LoginPage(WebDriver driver) {
		//makes driver on line 10 = driver on 16
		this.driver = driver;
	}
	

	//in page object models we use annotations instead of
	//By and WebElement variables to store web elements
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")WebElement SIGNIN_BUTTON_ELEMENT;
	
	//Technique 1
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	//Technique 2
	public void performLogin(String userName, String password)
	{
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	
	
}


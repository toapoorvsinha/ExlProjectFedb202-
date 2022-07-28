package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	//This class can be used to store any common methods between other classes in the package
	
	public int generateRandomNo(int boundNo) {
		Random rnd = new Random();
		int generatedNo = rnd.nextInt(boundNo);
		return generatedNo;
		
	}
	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

}

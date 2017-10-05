package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {
	
	public GoogleMainPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Пошук']")
	public WebElement searchInput;
	
	@FindBy(xpath="//*[@value='Пошук Google']")
	public WebElement searchButton;

}

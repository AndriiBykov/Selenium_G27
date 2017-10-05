package google;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleBasePage {
	
	public GoogleBasePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='main']//h3")
	public List<WebElement> searchResultItem;
	
	@FindBy(css="#pnnext")
	public WebElement searchResultNextPageLink;

}

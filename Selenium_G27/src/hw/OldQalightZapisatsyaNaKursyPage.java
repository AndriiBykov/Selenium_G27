package hw;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OldQalightZapisatsyaNaKursyPage {
	
	public OldQalightZapisatsyaNaKursyPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='_7c8289bf6b8e80c1749ef54ab01b92b8']/option")
	public List<WebElement> courseDropdownItemsList;
	
	@FindBy(xpath="//select[@name='_7c8289bf6b8e80c1749ef54ab01b92b8']")
	public WebElement courseDropdown;
	
	@FindBy(xpath="//select[@name='_7c8289bf6b8e80c1749ef54ab01b92b8']/option[3]")
	public WebElement courseDropdownItemNumber3;
	
	@FindBy(css="#z_sender0")
	public WebElement surnameTextField;
	
	@FindBy(css="#z_text1")
	public WebElement nameTextField;
	
	@FindBy(css="#z_text0")
	public WebElement phoneNumberTextField;
	
	@FindBy(css="#z_sender1")
	public WebElement emailTextField;
	
	@FindBy(css="#z_text2")
	public WebElement skypeTextField;
	
	@FindBy(xpath="//select[@name='_e926ba2b2813f56de8fc13877057e908']/option")
	public List<WebElement> whereDidYouFindOutAboutDropdownItemsList;
	
	@FindBy(xpath="//select[@name='_e926ba2b2813f56de8fc13877057e908']")
	public WebElement whereDidYouFindOutAboutDropdown;
	
	@FindBy(xpath="//select[@name='_e926ba2b2813f56de8fc13877057e908']/option[4]")
	public WebElement whereDidYouFindOutAboutDropdownItemNumber4;
	
	@FindBy(xpath="//textarea[@name='_ad21040e29142e22bc370e7ecdb9e4b2']")
	public WebElement commentsTextarea;
	
	@FindBy(xpath="//*[@class='btn btn-success']")
	public WebElement submitButton;
	
	@FindBy(xpath="//*[@class='btn btn-danger']")
	public WebElement resetButton;
	
}

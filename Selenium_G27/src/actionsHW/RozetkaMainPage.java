package actionsHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaMainPage {

	public RozetkaMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='f-menu-l-i-link f-menu-l-i-link-arrow sprite-side novisited' and @data-title='Ноутбуки и компьютеры']")
	public WebElement elementNoteBooks;
	
	@FindBy(xpath="//a[@class='f-menu-sub-l-i-link novisited' and contains(@href,'asus')]")
	public WebElement elementAsus;
	
	@FindBy(xpath="//a[@class='sprite-side novisited hub-i-link hub-i-cart-link']")
	public WebElement elementTrash;
	
	@FindBy(xpath="//h3[@class='header-popup-info-title' and contains(text(),'пуста')]")
	public WebElement elementText1;
	
	@FindBy(xpath="//div[@id='empty_cart_popup_header']/child::p")
	public WebElement elementText2;
	
	
}

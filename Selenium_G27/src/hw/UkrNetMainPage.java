package hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UkrNetMainPage {
	
	public UkrNetMainPage (WebDriver driver) {
		  
		  PageFactory.initElements(driver, this);
		 }
	
	
@FindBy(css="input.login-block__input[name=Login]")
public WebElement login;

@FindBy(css="input.login-block__input[name=Password]")
public WebElement password;

@FindBy(css="button[type=submit]")
public WebElement submitBtn;

@FindBy(xpath="//a[@href='https://mail.ukr.net/q/start#msglist']")
public WebElement mailsBtn;

}

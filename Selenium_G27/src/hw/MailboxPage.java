package hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxPage {

	
	public MailboxPage (WebDriver driver) {
		  
		  PageFactory.initElements(driver, this);
		 }
	
	
@FindBy(xpath="//aside[@class='sidebar']/button[@class='default compose']")
public WebElement composeBtn;

@FindBy(css="input[type=text][name=toInput]")
public WebElement inputAdress;

@FindBy(css="input[type=text][name=subject]")
public WebElement inputSubj;

@FindBy(css="body.mce-content-body")
public WebElement inputMessage;

@FindBy(css="input#image-to-upload")
public WebElement pictureAttach;

@FindBy(css="button.default.send")
public WebElement sendBtn;


}


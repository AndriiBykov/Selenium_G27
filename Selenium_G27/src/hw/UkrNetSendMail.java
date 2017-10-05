package hw;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UkrNetSendMail {
	
WebDriver driver;
	
	@Before
	public void beforeEveryTest() {
		
	driver = new ChromeDriver();
	WebLibrary.setWebDriverSettings(driver, 15, "http://ukr.net/");
	}
	
	@Test
	public void loginAndSendMail() throws InterruptedException {
		
	UkrNetMainPage ukrNetStartPage = new UkrNetMainPage(driver);
	
	//Заполняем логин и пароль
	ukrNetStartPage.login.sendKeys("babay1011");
	ukrNetStartPage.password.sendKeys("101limp101");
	
	Actions actions = new Actions(driver);
	
	//Жмем "Увійти" потом "Листи"
	actions.click(ukrNetStartPage.submitBtn).perform();
	Thread.sleep(1000);
	actions.click(ukrNetStartPage.mailsBtn).perform();
	Thread.sleep(1000);
	
	//Создаем экземпляр страницы открытого почтового ящика
	MailboxPage mailBoxPage = new MailboxPage(driver);
	
	//Переключаем драйвер на вкладку открытого почтового ящика
	for(String winHandle : driver.getWindowHandles()){
		if (!winHandle.equals(ukrNetStartPage))	{
			System.out.println("Switching to..." + winHandle);
			driver.switchTo().window(winHandle);
		} else System.out.println("Stay on" + winHandle);
	
	}
	
	Thread.sleep(1000);
		
	//Нажимаем кнопку "Написати листа"
	actions.click(mailBoxPage.composeBtn).perform();
	
	//Заполняем поля
	mailBoxPage.inputAdress.sendKeys("vitalion2009@gmail.com");
	mailBoxPage.inputSubj.sendKeys("Sending message-test");
	
	//Переключаемся на фрейм с полем для ввода письма
	driver.switchTo().frame("mce_0_ifr");
	
	//Клацаем мышкой на поле ввода и вводим текст
	actions.moveToElement(mailBoxPage.inputMessage).click().sendKeys(mailBoxPage.inputMessage, "Hello, Andrey!").build().perform();
	
	//Аттачим файлик
	driver.switchTo().window(driver.getWindowHandle());
	mailBoxPage.pictureAttach.sendKeys("D:\\Test.txt");
	Thread.sleep(2000);
	
	//Жмем отправить
	//actions.click(mailBoxPage.sendBtn).perform();
		
	}
	
	@After
	public void after() {
		driver.quit();
	}
	

}

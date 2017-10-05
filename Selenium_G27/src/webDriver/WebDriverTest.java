package webDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverTest {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 driver.get("https://www.ukr.net/");
		 
		 UkrNetMainPage mainPage = new UkrNetMainPage(driver);
		 
		 mainPage.loginField.sendKeys("Login");
		 mainPage.passwordField.sendKeys("Password");
		 mainPage.submitButton.click();
		 
		 mainPage = new UkrNetMainPage(driver);
		 String errorMessageText = mainPage.errorMessage.getText();
		 
		 System.out.println(errorMessageText);
		 
//		 WebElement loginField = driver.findElement(By.cssSelector("[placeholder='Логiн']"));
//		 WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='Пароль']"));
//		 WebElement submitButton = driver.findElement(By.cssSelector("button[type=submit]"));
		 
//		 loginField.sendKeys("Login");
//		 passwordField.sendKeys("Password");
//		 submitButton.click();
		 
		 driver.quit();
	
	}

}

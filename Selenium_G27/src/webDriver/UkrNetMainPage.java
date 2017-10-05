package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UkrNetMainPage {
	
	public WebElement loginField;	
	public WebElement passwordField;	
	public WebElement submitButton;
	public WebElement errorMessage;
	
	public UkrNetMainPage(WebDriver driver) {
		
		loginField = driver.findElement(By.cssSelector("[placeholder='Логiн']"));
		passwordField = driver.findElement(By.cssSelector("[placeholder='Пароль']"));
		submitButton = driver.findElement(By.cssSelector("button[type=submit]"));
		errorMessage = driver.findElement(By.cssSelector(".error-text111"));
	}
	
//	 WebElement loginField = driver.findElement(By.cssSelector("[placeholder='Логiн']"));
//	 WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='Пароль']"));
//	 WebElement submitButton = driver.findElement(By.cssSelector("button[type=submit]"));

}

package actionsHW;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebPageHelper {
	
	/**
	 * Init Driver
	 * @param driver
	 * @param defaultWaitTime
	 * @param desiredStartUrl
	 * @return
	 */
	public static WebDriver setInitialDriverParameters( WebDriver driver, int defaultWaitTime, String desiredStartUrl)
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
		driver.get(desiredStartUrl);
		
		return driver;
	}
	
	/**
	 * Click on Element 
	 * @param elementToClick
	 */
	public static void clickOnElement(WebElement elementToClick) {
		elementToClick.click();
	}
	
	/**
	 * Click on Actions
	 * @param myActions
	 */
	public static Actions clickOnActions(Actions myActions, WebElement element) {
		return myActions.click();
	}
	
	
	
	/**
	 * Switch Driver to Frame
	 * @param driver
	 * @param frameName
	 */
	public static void switchToFrame(WebDriver driver, String  frameName) {
		driver.switchTo().frame(frameName);
	}
	
	/**
	 * Switch Driver to Window and Maximize if necessary
	 * @param driver
	 * @param windowHendler
	 * @param maximize
	 */
	public static void switchToWindow(WebDriver driver, String  windowHendler, boolean maximize) {
		driver.switchTo().window(windowHendler);
		if (maximize) {
			driver.manage().window().maximize();
		}
	}	
	
	/**
	 * Switch Driver to Default Content
	 * @param driver
	 */
	public static void switchBackToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * System.out.println()
	 * @param text
	 */
	public static void SysOut(String text) {
		System.out.println(text);
	}
		
	/**
	 * SendKeys to Element
	 * @param textToFill
	 * @param webElementToFill
	 */
	public static void sendKeysToElement(String textToFill, WebElement webElementToFill) {
    	webElementToFill.sendKeys(textToFill);    	 
    }
	
	/**
	 * Thread Sleep
	 * @param mSeconds
	 * @throws InterruptedException
	 */
	public static void threadSleep(long mSeconds) throws InterruptedException {
    	Thread.sleep(mSeconds);    	 
    }

	/**
	 * Close Driver
	 * @param driver
	 */
	public static void driverClose(WebDriver driver) {
    	driver.close();
    }
	
	/**
	 * Quit from Driver
	 * @param driver
	 */
	public static void driverQuit(WebDriver driver) {
    	driver.quit();
    }
	
	/**
	 * Move to SingleELement
	 * @param myAction
	 * @param element
	 * @return
	 */
	public static Actions moveToElement(Actions myAction, WebElement element) {
		return myAction.moveToElement(element);
	}
	
	/**
	 * Perfrom all Actions in myActions
	 * @param myActions
	 */
	public static void performActions(Actions myActions) {
		myActions.perform();
	}
	
	
	/**
	 * Get Text from Web Element
	 * @param element
	 * @return
	 */
	public static String getTextOfElement(WebElement element) {
		return element.getText();
	}
	
	
	
}

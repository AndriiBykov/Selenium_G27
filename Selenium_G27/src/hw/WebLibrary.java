package hw;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class WebLibrary {
	
	private static final Logger log = LogManager.getLogger(WebLibrary.class);

	public static void setWebDriverSettings(WebDriver driver, int timeout, String startUrl) {
		
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(startUrl);
	}
	
	public static void setPropertyChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		}
	
	public static void windowMaximize(WebDriver driver) {
		
	driver.manage().window().maximize();
	}
	
	
	
}

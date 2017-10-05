package actionsHW;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RozetkaTest {
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public static void prepareToTest() {
		
		driver = WebPageHelper.setInitialDriverParameters(driver, 10, "https://rozetka.com.ua/");		
		
		
	}
	
	
	@Test
	public void openNoteBookMenu() throws InterruptedException {
		RozetkaMainPage page = new RozetkaMainPage(driver);
		Actions myActions = new Actions(driver);
		WebPageHelper.moveToElement(myActions, page.elementNoteBooks);
		WebPageHelper.threadSleep(1000);
		WebPageHelper.moveToElement(myActions, page.elementAsus);
		WebPageHelper.performActions(myActions);
		
		WebPageHelper.threadSleep(1000);
		
		WebPageHelper.clickOnActions(myActions,page.elementAsus);
		WebPageHelper.performActions(myActions);
		WebPageHelper.threadSleep(2000);
		
		WebPageHelper.moveToElement(myActions, page.elementTrash);
		WebPageHelper.performActions(myActions);
		
		WebPageHelper.threadSleep(2000);
		
		WebPageHelper.SysOut(WebPageHelper.getTextOfElement(page.elementText1));
		WebPageHelper.SysOut(WebPageHelper.getTextOfElement(page.elementText1));
		
		
	}
	
	@AfterClass
	public static void endRozetkaTest() {
		driver.quit();
	}

}

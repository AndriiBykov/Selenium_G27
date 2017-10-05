package google;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice13Google {
	
	WebDriver driver;
	
	@Before
	public void before() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com.ua/");
	}
	
	@Test
	public void getSearchResultPageWithSpecifiedSearchResultItemTitle() {
		
		GoogleMainPage mainPage = new GoogleMainPage(driver);
		
		mainPage.searchInput.clear();
		mainPage.searchInput.sendKeys(GoogleTestData.requestPhrase);
		mainPage.searchButton.submit();
		
		GoogleBasePage basePage = new GoogleBasePage(driver);
		boolean searchPhraseIsPresented = false;
		int pageNumber = 1;
		
		while (searchPhraseIsPresented == false) {
			for (int i = 0; i < basePage.searchResultItem.size(); i++) {
				searchPhraseIsPresented = (basePage.searchResultItem.get(i).getText().equals(GoogleTestData.searchForPhrase));
				if (searchPhraseIsPresented == true) {
					break;
				}
			}
			if (searchPhraseIsPresented == false) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", basePage.searchResultNextPageLink);
				System.out.println("Searching phrase is not presented on the page #" + pageNumber + ".");
				basePage.searchResultNextPageLink.click();
				pageNumber ++;
			}
		}
		
		System.out.println("The phrase '" + GoogleTestData.searchForPhrase
				+ "' is presented on the page #" + pageNumber
				+ " of google.com.ua search results!");
	}
	
	@After
	public void after() {
		
		driver.quit();
	}

}

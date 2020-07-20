package Automation.AccessibleVersion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteTest {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.washington.edu/accesscomputing/AU/after.html");
		driver.manage().window().maximize();
	}

	@Test
	public void submitForm() throws InterruptedException {

		Actions a = new Actions(driver);
		for (int i = 0; i < 14; i++) {
			a.sendKeys(Keys.TAB).perform();
			Thread.sleep(400);
		}
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("Rainy").perform();
		Thread.sleep(200);
		
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("rainydsz@gmail.com").perform();
		Thread.sleep(200);
		
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("Bangalore").perform();
		Thread.sleep(200);
		
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("Karnataka").perform();
		Thread.sleep(200);
		
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("570013").perform();
		Thread.sleep(200);
		
		a.sendKeys(Keys.TAB).perform();
		a.sendKeys("India").perform();
		Thread.sleep(200);

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int j = 0; j < checkboxes.size(); j++) {
			a.sendKeys(Keys.TAB).perform();
			a.sendKeys(Keys.SPACE).perform();
			Thread.sleep(200);
		}

		a.sendKeys(Keys.TAB).perform();
		Thread.sleep(5000);

		a.sendKeys(Keys.TAB).perform();
		a.sendKeys(Keys.SPACE).perform();

		String actual = driver.findElement(By.id("feedback")).getText();
		String expected = "Thank you!" + "\n" + "Your application has been received.";
		Assert.assertEquals(actual, expected);
		Thread.sleep(200);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

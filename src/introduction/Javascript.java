package introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Javascript {

	public static void main(String[] args) throws InterruptedException {
		// Initiate driver and browser
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		int totalSum=0;
		//Scroll down to the windows
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		//Identify and scroll down on the table (using document.query
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//Get the column where the values are stored
		List<WebElement> tableValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		//Sum those values
		for (int i=0;i<tableValues.size();i++) {
			totalSum = totalSum + Integer.parseInt(tableValues.get(i).getText());
		}
		System.out.println(totalSum);
		//Get the total in the screen and compare it against the calculated vcalue
		int originalValue = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println("Original: " + originalValue);
		Assert.assertEquals(totalSum, originalValue);

	}

}

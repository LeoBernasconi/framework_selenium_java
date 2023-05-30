package exercises;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.GreenKart_Page;

public class GreenKart extends GreenKart_Page {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		// Define the array of vegetables and then convert it to list (for comparission purposes)
		String[] productsNeeded = { "Cucumber", "Brocolli", "Beans", "Beetroot" };
		// Initiate driver and browser
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Add items to cart
		addItemsToCart(driver, productsNeeded);
		//Continue to the cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//Insert discount code
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		//Get code discount response
		/*
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		*/
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}

}

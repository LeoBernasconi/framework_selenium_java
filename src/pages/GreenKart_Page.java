package pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GreenKart_Page {
	
	public static void addItemsToCart(WebDriver driver, String[] productsNeeded) throws InterruptedException {
		int productsAdded = 0;
		List productsNeeded_list = Arrays.asList(productsNeeded);
		// Get the list of products
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			String[] productName_array = products.get(i).getText().split("-");
			String productName = productName_array[0].trim();
			if (productsNeeded_list.contains(productName)) {
				productsAdded++;
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(100);
			}
			if (productsAdded == productsNeeded_list.size()) {
				break;
			}
		}
	}

}

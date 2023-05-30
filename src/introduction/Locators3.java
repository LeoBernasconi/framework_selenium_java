package introduction;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Get the child element from a parent and then moving to the 1st sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		//get the parent element from the child element
		WebElement header = driver.findElement(By.xpath("//header/div/button[1]/parent::div"));
		
		
		
	}

		
}

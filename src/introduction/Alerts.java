package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		String name = "Leopa";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Alert 1
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		String alert_one = driver.switchTo().alert().getText();
		System.out.println(alert_one);
		driver.switchTo().alert().accept();
		// Alert 2
		driver.findElement(By.id("confirmbtn")).click();
		String alert_two = driver.switchTo().alert().getText();
		System.out.println(alert_two);
		driver.switchTo().alert().dismiss();
		driver.quit();
	}

}

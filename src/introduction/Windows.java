package introduction;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		// Initiate driver and browser
		String url = "https://rahulshettyacademy.com/loginpagePractise/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Get a second windows and store them in a list
		driver.findElement(By.className("blinkingText")).click();
		Set <String> windowsList = driver.getWindowHandles();
		Iterator<String>it = windowsList.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		//Grab the text and format it 
		System.out.println(driver.findElement(By.className("red")).getText());
		String email = driver.findElement(By.className("red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		//Return to the 1st windows to paste it
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}

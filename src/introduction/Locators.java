package introduction;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Leo");
		driver.findElement(By.name("inputPassword")).sendKeys("321");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000 );
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Leopa");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("leo@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		//Using indexes to identify elements
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("leopa@gmail.com");
		//Using the parent to identify child elements
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("603269269");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		//Accesing the child element from a parent
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000 );
		driver.findElement(By.id("inputUsername")).sendKeys("Leopa");
		//Using a regular expression (with CSS selector)
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		//Using a regular expression (with Xpath)
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
	}

}

package introduction;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		String user = "Leo";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys(user);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.print(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + user + ",");
		//Get the element by the text in the button
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000 );
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split(",")[0];
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000 );
		return password;
	}

}

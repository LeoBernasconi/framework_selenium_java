package introduction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManage {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Maximize windows
		driver.manage().window().maximize();
		//Set the implicit waits
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Delete all the cockies
		driver.manage().deleteAllCookies();
	}

}

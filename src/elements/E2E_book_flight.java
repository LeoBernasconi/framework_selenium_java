package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E_book_flight {

	public static void main(String[] args) throws InterruptedException {
		//Initiate driver and access url
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(1000);
		//Option: One way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(200);
		//Dropdown "From"
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(500);
		//Dropdown "To" (opened automatically)
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//Calendar "Depart date"
		driver.findElement(By.className("ui-state-highlight")).click();
		//Dropdown "Passenger"
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);	
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//Dropdown "currency"
		Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdown.selectByVisibleText("USD");
		//Checkboxes
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		//Click on "Search"
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		
		//driver.quit();


	}

}

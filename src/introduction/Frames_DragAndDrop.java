package introduction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_DragAndDrop {

	public static void main(String[] args) {
		// Initiate driver and browser
		String url = "https://jqueryui.com/droppable/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Move the the iframe
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		//Index -->driver.switchTo().frame(0);
		//Drag and drop element
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).build().perform();
		//Get out of the frame
		driver.switchTo().defaultContent();
	}

}

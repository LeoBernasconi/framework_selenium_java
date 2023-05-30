package introduction;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CertificateHTTPS_and_otherOptions {

	public static void main(String[] args) {
		//Define the options
		ChromeOptions options_chrome = new ChromeOptions();
		options_chrome.setAcceptInsecureCerts(true);
		//Same for other browsers
		FirefoxOptions options_fire = new FirefoxOptions();
		EdgeOptions options_edge = new EdgeOptions();
		
		//Others interesting options
		//Add extensions to the browser
		options_chrome.addEncodedExtensions("file_to_extension");
		//Set special proxy
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy("ipadress:4444");//This information should be provided by seginf
		options_chrome.setCapability("proxy", proxy);
		//Disable popups (like the "Browser wants to know your location")
		options_chrome.setExperimentalOption("excludesSwitches", Arrays.asList("disable-popup-blocking"));
		//Change the download directory
		Map<String, Object>prefs = new HashMap<String, Object>();
		prefs.put("download.default_direcetory", "/directory/path");
		options_chrome.setExperimentalOption("prefs", prefs);
		
		//Call the driver "normally"
		WebDriver driver = new ChromeDriver(options_chrome);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}

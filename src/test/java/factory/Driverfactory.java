package factory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommanUtils;

public class Driverfactory {

	static WebDriver driver = null;

	public static WebDriver intializebrowser(String browserName) {
		
		
		if (browserName.equals("Chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("Safari")) {

			driver = new SafariDriver();

		} else if (browserName.equals("Firefox")) {

			driver = new FirefoxDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommanUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommanUtils.IMPLICIT_WAIT_TIME));
		
		return driver;

	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}

}

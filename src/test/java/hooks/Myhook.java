package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Myhook {

	WebDriver driver;

	@Before
	public void setup() {

		Properties prop = ConfigReader.intializeProperties();
		driver = Driverfactory.intializebrowser(prop.getProperty("browser"));

		// driver = Driverfactory.getDriver(); -optimized some steps
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {

		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}

		driver.quit();

	}

}

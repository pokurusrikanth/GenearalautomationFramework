package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private WebDriver driver;

	public Driver(String browsername) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			// this.driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			this.driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			this.driver = new InternetExplorerDriver();
			break;
		default:
			Assert.assertTrue(false, "The browser" + browsername
					+ "is invalid.Browser must be given in ('chrome','ie','edge','firefox')");
			break;
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}

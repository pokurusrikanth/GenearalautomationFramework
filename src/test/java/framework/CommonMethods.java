package framework;

import org.openqa.selenium.WebDriver;

public class CommonMethods extends WebEvents {

	private WebDriver driver;

	public CommonMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public void navigateToUrl(String url) {
		driver.get(url);

	}

}

package dcap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvoicePrebuilt {

	@Test
	public void Create_prebuilt_model() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://prd-aidcap.azurewebsites.net/#/login");
		driver.manage().window().maximize();
		// driver.navigate().refresh();
		// Thread.sleep(10000);
		driver.findElement(By.name("email")).sendKeys("srikanthpo.in@mouritech.com");
		driver.findElement(By.name("password")).sendKeys("Srikanth@339");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//div[@class=' css-hxesb-indicatorContainer'])[1]"));
		driver.close();
		// driver.quit();

	}

}

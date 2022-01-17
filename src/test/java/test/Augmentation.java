package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.UtilityMethods;
import framework.WebEvents;

public class Augmentation extends Configuration {

	@Test
	public void verify_Augumentation_Settings() throws InterruptedException, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 5);// project
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div/div[3]/div[1]/div/p/div/h5"), 5);// on
		// one
		// project
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[3]/div[1]/div/div[1]/div/div/div[2]/p[1]"), 6);// on
																													// one
																													// dataset
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[2]/span[2]"), 7);// augmentation
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[4]/div/div/div[1]/div[1]"), 6);// Image
																									// category
																									// select
		Thread.sleep(5000);
		Actions act = new Actions(driver.getDriver());
		act.moveByOffset(503, 20).sendKeys(Keys.ENTER).build().perform();
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[1]/div[1]/input"), 0);// click
																												// on
																												// flip
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[5]/input"), 0);// horizontal
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[8]/input"), 0);// vertical
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[5]/div[1]/div/div[1]/div[3]/div[2]"), 0);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[6]/div[1]/div/div[1]/div[1]/input"), 0);// rotate
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[6]/div[1]/div/div[1]/div[3]/img"), 0);// rotete
																											// image
		act.moveToElement(
				driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[7]/div[1]/div/div[1]/div[1]/input")))
				.click().build().perform();

		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[7]/div[1]/div/div[1]/div[3]/img"), 2);// brightness
																											// preview
		eventmethods.Scroll_Into_View("//*[@id='main']/div[8]/div[1]/div/div[1]/div[1]/input");// zoom
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[8]/div[1]/div/div[1]/div[1]/input"), 3);// zoom
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[8]/div[1]/div/div[1]/div[3]/img"), 3);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[9]/div[1]/div/div[1]/div[1]/input"), 3);// cutout
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[9]/div[1]/div/div[1]/div[3]/img"), 3);// cutout
																											// preview
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[10]/div[1]/div/div[1]/div[1]/input"), 3);// noise
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[10]/div[1]/div/div[1]/div[3]/img"), 5);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		js.executeScript("window.scrollBy(35,9)", "");
		// eventmethods.Scroll_Into_View("//*[@id=\"main\"]/div[2]/button");
		act.moveToElement(driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[2]/button"))).click().build()
				.perform();

		Thread.sleep(3000);
		WebElement savealert = driver.getDriver().findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		if (savealert.getText().equalsIgnoreCase("Augmentation Settings are successfully configured.!")) {
			System.out.println("passed");
			reports.writeReport(Status.PASS, "augumentation_settings_done", driver.getDriver(),
					"clickedon_save_button");
		}

	}
}
package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.UtilityMethods;
import framework.WebEvents;

public class Camera extends Configuration {

	@Test
	public void camera_search() throws InterruptedException, IOException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		Thread.sleep(2000);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		/*
		 * String otptxt = driver.getDriver() .findElement( By.
		 * xpath("//span[@style='font-size: 25px; font-weight: bold; color: rgb(105, 105, 105);']"
		 * )) .getText(); events.enter_Value_In_Text_Field(By.
		 * xpath("//input[@placeholder='Enter CAPTCHA']"), otptxt, 4);
		 */

		events.Click_On_Element(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div[2]/form/button"), 0);
		Thread.sleep(5000);
		events.Click_On_Element(By.xpath("//*[@id='mySidebar']/a[3]/span"), 2);
		Thread.sleep(2000);
		events.Click_On_Element(By.xpath("//input[@placeholder='Search']"), 0);
		events.enter_Value_In_Text_Field(By.xpath("//input[@placeholder='Search']"), "Meat", 0);// description
		Thread.sleep(3000);
		if (driver.getDriver().findElement(By.xpath("//*[text()='Meat Processing Quality Control 1']")).isEnabled()) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "camera results filtered", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "camera results is not filtered", driver.getDriver(), null);
		}

	}

	@Test
	public void camera_config() throws InterruptedException, IOException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		Thread.sleep(2000);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		/*
		 * String otptxt = driver.getDriver() .findElement( By.
		 * xpath("//span[@style='font-size: 25px; font-weight: bold; color: rgb(105, 105, 105);']"
		 * )) .getText(); events.enter_Value_In_Text_Field(By.
		 * xpath("//input[@placeholder='Enter CAPTCHA']"), otptxt, 4);
		 */

		events.Click_On_Element(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div[2]/form/button"), 0);
		Thread.sleep(5000);
		events.Click_On_Element(By.xpath("//*[@id='mySidebar']/a[3]/span"), 2);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		js.executeScript("arguments[0].click();", driver.getDriver().findElement(
				By.xpath("(//table[@class='table']//tr[@class='cTblDtAl']//td[7][text()='Configure'])[1]")));// toggle
		js.executeScript("arguments[0].click();", driver.getDriver().findElement(By
				.xpath("//div[@class='custom-control custom-switch switch1 col-1 mt-4']//input[@id='customSwitch1']")));// toggle

		Thread.sleep(2000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Camera is OFF.!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "camera is  turned on ", driver.getDriver(), "login screen is displayed");

		} else {
			Thread.sleep(3000);

			reports.writeReport(Status.FAIL, " camera is not turned off ", driver.getDriver(), "homepage is displayed");

		}
		// driver.getDriver().quit();
	}
}

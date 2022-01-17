package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.UtilityMethods;
import framework.WebEvents;

public class Login extends Configuration {

	@Test
	public void verifyvalidcredentials() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		String otptxt = driver.getDriver()
				.findElement(
						By.xpath("//span[@style='font-size: 25px; font-weight: bold; color: rgb(105, 105, 105);']"))
				.getText();
		events.enter_Value_In_Text_Field(By.xpath("//input[@placeholder='Enter CAPTCHA']"), otptxt, 4);
		events.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(3000);
		WebElement dashboard = driver.getDriver().findElement(By.xpath("//*[text()=' Dashboard']"));// dashboard xpath
		if (dashboard.isDisplayed()) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "application sucess fully navigated to home page", driver.getDriver(),
					"dashboard image");

		} else {
			Thread.sleep(2000);
			reports.writeReport(Status.FAIL, "appliaction is not navigated to home page", driver.getDriver(),
					"login screen");
		}
	}

	@Test
	public void verifyvalidEmail_invalidpassword_login() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC02");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		events.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(2000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Invalid Credentials!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "login failed ", driver.getDriver(), "login screen is displayed");

		} else {
			Thread.sleep(2000);
			reports.writeReport(Status.FAIL, " navigated to home page ", driver.getDriver(), "homepage is displayed");

		}
	}

	@Test
	public void verifyinvalidEmail_validpassword_login() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC03");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		events.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(2000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Invalid Credentials!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "login failed ", driver.getDriver(), "login screen is displayed");

		} else {
			reports.writeReport(Status.FAIL, " navigated to home page ", driver.getDriver(), "homepage is displayed");

		}
	}

	@Test
	public void verifyinvalidEmail_invalidpassword_login() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC04");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		events.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(2000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Invalid Credentials!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "login failed ", driver.getDriver(), "login screen is displayed");

		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, " navigated to home page ", driver.getDriver(), "homepage is displayed");

		}
	}

	@Test
	public void verifyemptydata_login() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC05");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		events.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(2000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Invalid Credentials!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "login failed ", driver.getDriver(), "login screen is displayed");

		} else {
			Thread.sleep(3000);

			reports.writeReport(Status.FAIL, " navigated to home page ", driver.getDriver(), "homepage is displayed");

		}
	}

}
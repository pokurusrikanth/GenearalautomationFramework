package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.UtilityMethods;
import framework.WebEvents;

public class Signup extends Configuration {

	@Test
	public void verifyinvalidemail() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC08");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.Click_On_Element(By.xpath("//*[text()=' Sign Up ']"), 5);
		events.enter_Value_In_Text_Field(By.xpath("//*[@type='email']"), Data.appconfiginfo.get("USERNAME").toString(),
				3);
		events.Click_On_Element(By.xpath("(//*[text()='Sign Up'])[2]"), 3);
		Thread.sleep(3000);
		if (driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText()
				.equalsIgnoreCase("Email is invalid")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "verified  invalid email is successfull ", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "verified  invalid email is not successfull ", driver.getDriver(), null);
		}
	}

	@Test
	public void verifyemptyemail() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC05");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();

		events.Click_On_Element(By.xpath("//*[text()=' Sign Up ']"), 5);
		events.Click_On_Element(By.xpath("(//*[text()='Sign Up'])[2]"), 3);
		Thread.sleep(3000);
		if (driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText()
				.equalsIgnoreCase("please enter email")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "verified  empty email is successfull ", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "verified  empty email is not successfull ", driver.getDriver(), null);
		}

	}
}

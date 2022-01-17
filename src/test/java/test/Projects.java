package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.UtilityMethods;
import framework.WebEvents;

public class Projects extends Configuration {

	@Test
	public void create_project() throws InterruptedException, FindFailed, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();

		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 2);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/button"), 5);
		System.out.println(utils.getvalueforkey("Project_Name"));
		System.out.println(Data.appconfiginfo.get("Project_Name"));
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Project_Name")),
				Data.appconfiginfo.get("PROJECTNAME").toString() + utils.gettimestamp(), 0);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div[2]/div/div/div[2]/div"), 6);
		eventmethods.Click_On_Element(By.xpath("//div[text()='face_recognition']"), 6);
		eventmethods.Click_On_Element(By.xpath("//*[text()='Next']"), 6);// next btn
		Thread.sleep(3000);
		if (driver.getDriver().findElement(By.xpath("//*[text()='Save']")).isDisplayed()) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Project successfully created", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "project is not created", driver.getDriver(), null);
		}
		// Thread.sleep(5000);

		/*
		 * eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey(
		 * "Dataset_Name")), Data.appconfiginfo.get("DATASETNAME").toString(), 0);
		 * eventmethods.Click_On_Element(By.xpath(
		 * "//*[@id=\"main\"]/div/div[3]/div/span[1]/input"), 4);
		 * eventmethods.Click_On_Element(By.xpath(
		 * "//*[@id=\"main\"]/div/div[3]/div/div[15]/div[1]/div[2]"), 3); String
		 * inputfile = "C:\\Users\\snehav\\Downloads\\Industry3.PNG"; String open =
		 * "C:\\Users\\snehav\\Automation\\Open.PNG"; String src =
		 * "C:\\Users\\snehav\\Automation\\Upload file.png";
		 * 
		 * FileUtils.upload_files(inputfile, open, src);
		 * 
		 * eventmethods.Click_On_Element(By.xpath(
		 * "//*[@id=\"main\"]/div/div[1]/button[2]"), 6); Thread.sleep(5000);
		 * reports.writeReport(Status.PASS, "datasetcreated", driver.getDriver(),
		 * "uploadfilescreen");
		 */
	}

	@Test
	public void createproject_withoutdetails() throws InterruptedException, FindFailed, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		// Object uername = Data.appconfiginfo.get("USERNAME");

		// System.out.println(uername);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/button"), 5);
		System.out.println(utils.getvalueforkey("Project_Name"));
		System.out.println(Data.appconfiginfo.get("Project_Name"));
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Project_Name")),
				Data.appconfiginfo.get("PROJECTNAME").toString(), 0);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div/div[2]/div/button"), 3);
		Thread.sleep(2000);
		if (driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText()
				.equalsIgnoreCase("Please enter project name!")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "project is not created w/o entering details", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "project is created w/o entering details", driver.getDriver(), null);
		}

	}

	@Test
	public void create_duplicatename_project() throws InterruptedException, FindFailed, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");

		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();

		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Email")),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Password")),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(By.xpath(utils.getvalueforkey("Signin")), 0);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/button"), 5);

		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Project_Name")), "Testing", 0);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div[2]/div/div/div[2]/div"), 6);
		eventmethods.Click_On_Element(By.xpath("//div[text()='face_recognition']"), 6);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div/div[2]/div/button"), 3);
		Thread.sleep(3000);
		if (driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText()
				.equalsIgnoreCase("Poject Name already exist")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Duplicated project is not created", driver.getDriver(), null);
		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "Duplicated project is  created", driver.getDriver(), null);
		}

	}

}

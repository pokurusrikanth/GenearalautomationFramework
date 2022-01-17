package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.FileUtils;
import framework.UtilityMethods;
import framework.WebEvents;

public class Model extends Configuration {

	@Test
	public void verify_Model_with_details() throws InterruptedException, IOException {

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
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//div[@style='display: inline;']//h5[text()='Project3']"), 5);// on
		// one
		// project
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[3]/div[1]/div/div[1]/div/div/div[2]/p[1]"), 6);// on
																													// one
																													// dataset
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[2]/span[3]"), 6);// model
																							// click
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Model_tag")),
				Data.appconfiginfo.get("MODELTAG").toString() + utils.gettimestamp(), 0);
		Thread.sleep(3000);
		eventmethods.Click_On_Element(
				By.xpath("//*[@id='main']/div[1]/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]"), 6);
		Thread.sleep(4000);
		eventmethods.Click_On_Element(By.xpath("//div[1]/div[text()='Face Recognition']"), 6);
		eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Description")),
				Data.appconfiginfo.get("DESCRIPTION").toString(), 0);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[3]/div/div[2]/div/label"), 6);

		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[4]/div/div[2]/button"), 6);// submit

	}

	@Test
	public void verify_Model_without_details() throws InterruptedException, IOException {

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
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//div[@style='display: inline;']//h5[text()='Project3']"), 5);// on
		// one
		// project
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[3]/div[1]/div/div[1]/div/div/div[2]/p[1]"), 6);// on
																													// one
																													// dataset
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[2]/span[3]"), 6);// model
																							// click
		/*
		 * eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey(
		 * "Model_tag")), Data.appconfiginfo.get("MODELTAG").toString() +
		 * utils.gettimestamp(), 0); Thread.sleep(3000);
		 * eventmethods.Click_On_Element( By.xpath(
		 * "//*[@id='main']/div[1]/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]"
		 * ), 6); Thread.sleep(4000); eventmethods.Click_On_Element(By.
		 * xpath("//div[1]/div[text()='Face Recognition']"), 6);
		 * eventmethods.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey(
		 * "Description")), Data.appconfiginfo.get("DESCRIPTION").toString(),
		 * 0);
		 */
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[4]/div/div[2]/button"), 6);// submit

	}

	@Test
	public void verify_Inference_with_details() throws InterruptedException, IOException {

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
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"), 5);// on
		// one
		// project
		eventmethods.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Classification label']"), 6);// on
		// one
		// dataset
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[2]/span[3]"), 6);// model
		Thread.sleep(3000); // click
		eventmethods.Click_On_Element(By.xpath("//div[@class='SubheaderForTrain']//div//ul//li[2]//a//span"), 6);// Inference
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//div[@class=' css-yk16xz-control']//div//div[text()='Select']"), 6);// Select

		Thread.sleep(8000);
		eventmethods.Click_On_Element(
				By.xpath(
						"//div[@class='react-select-container z-index-19 TagsDropI css-2b097c-container']//div[1]//div[text()='Model1']"),
				6);//
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//button[@class='UploadBtn1 hands btn btn-primary']"), 6);// upload
		String industry1image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry1.png";
		String capture = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\fileinput.PNG";
		String open = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\opn.PNG";
		Thread.sleep(3000);

		// eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"),
		// 4);
		Thread.sleep(3000);
		FileUtils.upload_files(capture, open, industry1image);
		eventmethods.Click_On_Element(By.xpath("//button[@class='SubmitBox1 hands btn btn-primary']"), 4);

	}

	@Test
	public void verify_Inference_without_details() throws InterruptedException, IOException {

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
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"), 5);// on
		// one
		// project
		eventmethods.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Classification label']"), 6);// on
		// one
		// dataset
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//*[@id='main']/div[1]/div[2]/span[3]"), 6);// model
		Thread.sleep(3000); // click
		eventmethods.Click_On_Element(By.xpath("//div[@class='SubheaderForTrain']//div//ul//li[2]//a//span"), 6);// Inference
		Thread.sleep(3000);
		eventmethods.Click_On_Element(By.xpath("//button[@class='SubmitBox1 hands btn btn-primary']"), 4);

	}
}

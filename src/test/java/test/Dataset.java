package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.FileUtils;
import framework.UtilityMethods;
import framework.WebEvents;

public class Dataset extends Configuration {

	@Test
	public void create_dataset_with_details() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div//button[@type='button']"), 2);// create
																				// new
																				// data
																				// set
																				// button
		Thread.sleep(3000);
		events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[2]/input"),
				"sample" + UtilityMethods.gettimestamp(), 3);// datasetname
																// field
		events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[4]/textarea"),
				"uploading labelled images", 0);// description
		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/span[1]/input"),
				2);// classification radio
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", driver.getDriver()
				.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[5]/div[2]/div[1]/div/div[1]")));// toggle
																												// bar

		// events.clear_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[3]/div/input"),2);//
		// label1
		// events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[3]/div/input"),
		// "label1", 3);// label

		String industry1image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry1.png";
		String industry2image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry2.png";
		String capture = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\fileinput.PNG";
		String open = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\opn.PNG";

		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"), 4);// My
																											// computer
		Thread.sleep(3000);
		FileUtils.upload_files(capture, open, industry1image);

		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[5]/div/img"),
		// 2);// +icon
		Thread.sleep(2000);
		// events.clear_Value_In_Text_Field(By.xpath("//div//input[@value='Tag2']"),
		// 3);// label2
		// events.enter_Value_In_Text_Field(By.xpath("//div//input[@value='Tag2']"),
		// "label2", 3);// label2
		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div[1]/div[1]/div/div"),
		// 3);// 1button

		// events.Click_On_Element(By.xpath("//div[text()='1']"), 3);// 1buttn
		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"),
		// 4);// click
		// on
		// my
		// computer
		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"), 4);// My
																											// computer

		FileUtils.upload_files(capture, open, industry2image);
		js.executeScript("arguments[0].click();",
				driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[2]/button[2]")));// save
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Dataset name already exists.")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Dataset created ", driver.getDriver(), "dataset page displayed");

		} else {
			reports.writeReport(Status.FAIL, " dataset not created  ", driver.getDriver(), "dataset page displayed");

		}
	}

	@Test
	public void duplicate_dataset() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div//button[@type='button']"), 2);// create
																				// new
																				// data
																				// set
																				// button
		Thread.sleep(3000);
		events.enter_Value_In_Text_Field(By.xpath(utils.getvalueforkey("Dataset_Name")),
				Data.appconfiginfo.get("DATASETNAME").toString(), 0);// dupliate
																		// name
		events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[4]/textarea"),
				"uploading labelled images", 0);// description
		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/span[1]/input"),
				2);// classification radio
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", driver.getDriver()
				.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[5]/div[2]/div[1]/div/div[1]")));// toggle
																												// bar

		// events.clear_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[3]/div/input"),2);//
		// label1
		// events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[3]/div/input"),
		// "label1", 3);// label

		String industry1image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry1.png";
		String industry2image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry2.png";
		String capture = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\fileinput.PNG";
		String open = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\opn.PNG";

		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"), 4);// My
																											// computer
		Thread.sleep(3000);
		FileUtils.upload_files(capture, open, industry1image);

		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div/div[5]/div/img"),
		// 2);// +icon
		Thread.sleep(2000);
		// events.clear_Value_In_Text_Field(By.xpath("//div//input[@value='Tag2']"),
		// 3);// label2
		// events.enter_Value_In_Text_Field(By.xpath("//div//input[@value='Tag2']"),
		// "label2", 3);// label2
		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/div[7]/div[1]/div[1]/div/div"),
		// 3);// 1button

		// events.Click_On_Element(By.xpath("//div[text()='1']"), 3);// 1buttn
		// events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"),
		// 4);// click
		// on
		// my
		// computer
		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"), 4);// My
																											// computer

		FileUtils.upload_files(capture, open, industry2image);
		js.executeScript("arguments[0].click();",
				driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[2]/button[2]")));// save
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Dataset name already exists.")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Dataset name already exists.", driver.getDriver(),
					"dataset page displayed");

		} else {
			reports.writeReport(Status.FAIL, " dataset created  ", driver.getDriver(), "dataset page displayed");

		}

	}

	@Test
	public void create_dataset_image_delete() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div//button[@type='button']"), 2);// create
																				// new
																				// data
																				// set
																				// button
		Thread.sleep(3000);

		String industry1image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry1.png";
		String industry2image = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\Industry2.png";
		String capture = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\fileinput.PNG";
		String open = "C:\\Users\\snehav\\Downloads\\general\\generalautomation\\Images\\opn.PNG";

		events.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[5]/div[1]/div[4]"), 4);// My
																											// computer
		Thread.sleep(3000);
		FileUtils.upload_files(capture, open, industry1image);
		Thread.sleep(3000);
		events.Click_On_Element(
				By.xpath("//div[@class='upload-block_new']//div//div//i[@class='fa fa-trash delColor']"), 4);// delete

	}

	@Test
	public void create_dataset_without_details() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div//button[@type='button']"), 2);// create
																				// new
																				// data
																				// set
																				// button
		js.executeScript("arguments[0].click();",
				driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div[2]/button[2]")));// save
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(3000);
		if (alert.equalsIgnoreCase("Please enter Dataset Name")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Required dataset name ", driver.getDriver(), "dataset page displayed");

		} else {
			Thread.sleep(3000);
			reports.writeReport(Status.FAIL, "no error popup  ", driver.getDriver(), "dataset page displayed");

		}

	}

	@Test
	public void Insidedataset_without_selectdelete_images() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		Thread.sleep(3000);
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Dataset Classification Label']"),
				6);// on dataset

		events.Click_On_Element(By.xpath("//*[@id='main']/img"), 2);// delete
		Thread.sleep(3000);
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("Atleast one image need to select")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "one image need to select ", driver.getDriver(), "dataset page displayed");

		} else {
			reports.writeReport(Status.FAIL, " you could not delete all images ", driver.getDriver(),
					"dataset page displayed");

		}

	}

	@Test
	public void Insidedataset_delete_images_withselect_label() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Dataset Classification Label']"),
				6);// on dataset
		events.Click_On_Element(
				By.xpath("//div[@class='datasets']//div//div//div//input[starts-with(@type,'checkbox')]"), 4);// Select
																												// image
		events.Click_On_Element(By.xpath("//div[@class='container-fluid datasets ']//img[@class='delete']"), 2);// delete
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(3000);
		if (alert.equalsIgnoreCase("Deleted successfully")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Image deleted successfully ", driver.getDriver(),
					"Image deleted successfully");

		} else {
			reports.writeReport(Status.FAIL, " not deleted ", driver.getDriver(), "dataset page displayed");

		}

	}

	@Test
	public void Insidedataset_delete_images_withselect_unlabel() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Dataset Object detection']"), 6);// on
																														// dataset
		events.Click_On_Element(
				By.xpath("//div[@class='datasets']//div//div//div//input[starts-with(@type,'checkbox')]"), 4);// Select
																												// image
		events.Click_On_Element(By.xpath("//div[@class='container-fluid datasets ']//img[@class='delete']"), 2);// c
		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		Thread.sleep(3000);
		if (alert.equalsIgnoreCase("Deleted successfully")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "Image deleted successfully ", driver.getDriver(),
					"Image deleted successfully");

		} else {
			reports.writeReport(Status.FAIL, " not deleted ", driver.getDriver(), "dataset page displayed");

		}

	}

	@Test
	public void Insidedataset_delete_images_select_All_images() throws InterruptedException, IOException {
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
		events.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		// js.executeScript("window.scrollBy(725,1779)", "");
		Thread.sleep(3000);
		WebElement test = driver.getDriver()
				.findElement(By.xpath("//div[@style='display: inline;']//h5[text()='Testing']"));
		Actions act = new Actions(driver.getDriver());
		act.moveToElement(test).build().perform();
		act.click(test).build().perform();
		Thread.sleep(3000);
		events.Click_On_Element(By.xpath("//div[@class='content col-7']//div[text()='Dataset Classification Label']"),
				6);// on dataset
		Thread.sleep(3000);
		List<WebElement> AllCheckboxes = driver.getDriver().findElements(
				By.xpath("//div[@class='datasets']//input[@aria-label='Checkbox for following text input']"));

		System.out.println(AllCheckboxes.size());

		try {
			for (int i = 0; i <= AllCheckboxes.size() - 1; i++) {

				AllCheckboxes.get(i).click();

			}
		} catch (ElementNotInteractableException e) {
			Thread.sleep(3000);
			act.moveToElement(driver.getDriver().findElement(By.xpath("//img[@class='delete']"))).build().perform();
			;
			events.Click_On_Element(By.xpath("//img[@class='delete']"), 2);// delete

		}
		Thread.sleep(3000);

		String alert = driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
		if (alert.equalsIgnoreCase("You could not delete all the images.")) {
			Thread.sleep(3000);
			reports.writeReport(Status.PASS, "could not delete ", driver.getDriver(),
					"You could not delete all the images.");

		} else {
			reports.writeReport(Status.FAIL, " deleted ", driver.getDriver(), "dataset page displayed");

		}
	}

}
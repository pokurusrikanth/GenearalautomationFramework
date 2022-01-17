package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.Driver;
import framework.FileUtils;
import framework.UtilityMethods;
import framework.WebEvents;

public class log extends Configuration {

	@Test
	public void verifyinvalidlogin() throws IOException, InterruptedException {
		UtilityMethods utils = new UtilityMethods();

		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents events = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC02");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		events.enter_Value_In_Text_Field(By.xpath("//*[@id='formBasicEmail']"),
				Data.appconfiginfo.get("USERNAME").toString(), 3);
		events.enter_Value_In_Text_Field(By.xpath("//*[@id=\"formBasicPassword\"]"),
				Data.appconfiginfo.get("PASSWORD").toString(), 4);
		events.Click_On_Element(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div[2]/form/button"), 0);
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
	public void create_project() throws InterruptedException, FindFailed, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		Object uername = Data.appconfiginfo.get("USERNAME");

		System.out.println(uername);
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id='formBasicEmail']"),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id=\"formBasicPassword\"]"),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(
				By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div[2]/form/button"), 0);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 2);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[1]/div[2]/button"), 5);
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div[1]/input"), "data1234", 6);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/div[2]/div/div/div[2]/div"), 6);
		eventmethods.Click_On_Element(By.xpath("//div[text()='face_recognition']"), 6);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[1]/div[3]/button"), 6);
		Thread.sleep(5000);
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/input"), "sampledata",
				4);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[3]/div/span[1]/input"), 4);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[15]/div[1]/div[2]"), 3);
		String inputfile = "C:\\Users\\snehav\\Downloads\\Industry3.PNG";
		String open = "C:\\Users\\snehav\\Automation\\Open.PNG";
		String src = "C:\\Users\\snehav\\Automation\\Upload file.png";

		FileUtils.upload_files(inputfile, open, src);

		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[1]/button[2]"), 6);
		Thread.sleep(5000);
		reports.writeReport(Status.PASS, "datasetcreated", driver.getDriver(), "uploadfilescreen");

	}

	@Test
	public void verify_Augumentation_Settings() throws InterruptedException, IOException {

		UtilityMethods utils = new UtilityMethods();
		Driver driver = new Driver(utils.getvalueforkey("browser"));
		CommonMethods commons = new CommonMethods(driver.getDriver());
		WebEvents eventmethods = new WebEvents(driver.getDriver());
		Data.appconfiginfo = DataUtil.get_Data_From_Excel_To_Hashmap(Data.Datafolderpath, "smarteye", "TC01");
		commons.navigateToUrl(utils.getvalueforkey("url"));
		driver.getDriver().manage().window().maximize();
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id='formBasicEmail']"),
				Data.appconfiginfo.get("USERNAME").toString(), 0);
		eventmethods.enter_Value_In_Text_Field(By.xpath("//*[@id=\"formBasicPassword\"]"),
				Data.appconfiginfo.get("PASSWORD").toString(), 0);
		eventmethods.Click_On_Element(
				By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div[2]/form/button"), 6);
		Thread.sleep(5000);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"mySidebar\"]/a[2]"), 5);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div/div[3]/div[3]/div/img"), 5);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[3]/div[1]/div/div[2]/div/div/div[1]/img"), 6);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/span[2]"), 6);
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[4]/div/div/div[1]/div[1]"), 6);
		Thread.sleep(5000);
		Actions act = new Actions(driver.getDriver());
		act.moveByOffset(503, 20).sendKeys(Keys.ENTER).build().perform();
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[1]/div[1]/input"), 0);// click
																												// on
																												// flip
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[5]/input"), 0);// horizontal
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[8]/input"), 0);// vertical
		eventmethods.Click_On_Element(By.xpath("//*[@id=\"main\"]/div[5]/div[1]/div/div[1]/div[3]/img"), 0);
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

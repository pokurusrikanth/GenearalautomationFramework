package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.CheckBoxNotSelectedException;
import exception.Element_Is_Not_Clicked_Exception;
import exception.ValueNotEnterdIntoTextFieldException;
import exception.ValueNotSelectedInListboxException;

public class WebEvents {
	private WebDriver driver;

	public WebEvents(WebDriver driver) {
		this.driver = driver;

	}

	public void Scroll_Into_View(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public boolean verify_element_exists(By by, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.pollingEvery(Duration.ofMillis(200));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * waits until element is found with given locator with in given time
	 * 
	 * @param locator
	 *            by locator is to find the element
	 * @param timeouts
	 *            max timeout if element is not found
	 * @return webelement if element is found <b>null</b> will be reuturned if
	 *         element is not found
	 */

	public WebElement wait_For_Element_To_be_Found(By locator, int timeouts) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.pollingEvery(Duration.ofMillis(200));
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;

		} catch (NoSuchElementException nse) {
			return null;
		}

	}

	public boolean Wait_until_Element_to_be_Enabled(WebElement element, int timeouts) {

		if (element != null) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeouts);
				wait.pollingEvery(Duration.ofMillis(200));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return true;

			} catch (Exception e) {
				return false;
			}
		}

		return false;

	}

	public boolean Wait_until_Element_to_be_Enabled(By by, int timeouts) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean Wait_until_Element_to_be_displyed(By by, int timeouts) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * click on element which has found with given locator with given time
	 * 
	 * @param by
	 *            locator which is to find element
	 * @param timeoutinseconds
	 *            max time to wait if element is not found
	 * @throws Element_Is_Not_Clicked_Exception
	 *             if element is not found not able to click on element it
	 *             throws element is not cliked exception
	 */
	public void Click_On_Element(By by, int timeoutinseconds) throws Element_Is_Not_Clicked_Exception {
		WebElement element = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (element != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					element.click();
				} else {
					throw new Element_Is_Not_Clicked_Exception(
							"clicking on element" + by.toString() + "is failed as element not enabled");
				}
			} else {
				throw new Element_Is_Not_Clicked_Exception(
						"clicking on element" + by.toString() + "is failed as element not displayed");

			}
		} else {
			throw new Element_Is_Not_Clicked_Exception(
					"clicking on element" + by.toString() + "is failed as element not found");

		}
	}

	/**
	 * Entering the value in text Field If Element Is Displayed/ if text field
	 * contains any value it clears
	 * 
	 * @param by
	 *            locator is to find the element
	 * @param input
	 *            is a value which is to enter in text field
	 * @param timeoutinseconds
	 *            max time out wait if element is not displayed
	 * @throws ValueNotEnterdIntoTextFieldException
	 *             if input is not entered in text field it throws a value not
	 *             entered into text field exception
	 */
	public void enter_Value_In_Text_Field(By by, String input, int timeoutinseconds)
			throws ValueNotEnterdIntoTextFieldException {
		WebElement element = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (element != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					element.clear();
					element.sendKeys(input);
				} else {
					throw new ValueNotEnterdIntoTextFieldException("entering the value " + input + "in to the field  "
							+ by.toString() + "is failed as element not enabled");
				}
			} else {
				throw new ValueNotEnterdIntoTextFieldException("entering the value " + input + "in to the field  "
						+ by.toString() + "is failed as element not enabled");

			}
		} else {
			throw new ValueNotEnterdIntoTextFieldException("entering the value " + input + "in to the field  "
					+ by.toString() + "is failed as element not enabled");

		}

	}

	public void clear_Value_In_Text_Field(By by, int timeoutinseconds) throws ValueNotEnterdIntoTextFieldException {
		WebElement element = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (element != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					element.clear();
				} else {
					throw new ValueNotEnterdIntoTextFieldException("entering the value in to the field  "
							+ by.toString() + "is failed as element not enabled");
				}
			} else {
				throw new ValueNotEnterdIntoTextFieldException(
						"entering the value in to the field  " + by.toString() + "is failed as element not enabled");

			}
		} else {
			throw new ValueNotEnterdIntoTextFieldException(
					"entering the value in to the field  " + by.toString() + "is failed as element not enabled");
		}

	}

	/**
	 * selecting the check box
	 * 
	 * @param by
	 *            locator to be used to find the element
	 * @param timeoutinseconds
	 *            max time to wait if element is not found
	 * @throws CheckBoxNotSelectedException
	 *             if element is not found ,not able to click on the element it
	 *             throws CheckBoxNotSelectedException
	 */
	public void selectCheckBox(By by, int timeoutinseconds) throws CheckBoxNotSelectedException {
		WebElement element = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (element != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					if (!element.isSelected()) {
						element.click();
					}

				} else {
					throw new CheckBoxNotSelectedException(
							"selecting the checkbox" + by.toString() + "is failed as checkbox is not enabled");
				}
			} else {
				throw new CheckBoxNotSelectedException(
						"selecting the checkbox" + by.toString() + "is failed as checkbox is not enabled");

			}
		} else {
			throw new CheckBoxNotSelectedException(
					"selecting the checkbox " + by.toString() + "is failed as checkbox is not enabled");

		}
	}

	/**
	 * selecting the check box
	 * 
	 * @param by
	 *            locator to be used to find the element
	 * @param timeoutinseconds
	 *            max time to wait if element is not found
	 * @throws CheckBoxNotSelectedException
	 *             if element is not found ,not able to click on the element it
	 *             throws CheckBoxNotSelectedException
	 */
	public void unSelectCheckBox(By by, int timeoutinseconds) throws CheckBoxNotSelectedException {
		WebElement element = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (element != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					if (element.isSelected()) {
						element.click();
					}

				} else {
					throw new CheckBoxNotSelectedException(
							"unselecting the checkbox" + by.toString() + "is failed as checkbox is not enabled");
				}
			} else {
				throw new CheckBoxNotSelectedException(
						"unselecting the checkbox" + by.toString() + "is failed as checkbox is not enabled");

			}
		} else {
			throw new CheckBoxNotSelectedException(
					"unselecting the checkbox " + by.toString() + "is failed as checkbox is not enabled");

		}
	}

	private int get_Option_Index_From_Listbox(WebElement Listbox, String optionvalue) {

		List<WebElement> alloptions = Listbox.findElements(By.tagName("Option"));

		for (int optionindex = 0; optionindex <= alloptions.size() - 1; optionindex++) {
			WebElement option = alloptions.get(optionindex);
			if (option.getText().equalsIgnoreCase(optionvalue)) {
				return optionindex;
			}

		}

		return -1;
	}

	/**
	 * select the value in the list box
	 * 
	 * @param by
	 *            locator is to find the element
	 * @param valuetoselect
	 *            the value which is to select from listbox
	 * @param timeoutinseconds
	 *            max time to wait untill the element is displyed
	 * @throws ValueNotSelectedInListboxException
	 *             if the value is not found in list box it throws
	 *             ValueNotSelectedInListboxException
	 */
	public void select_Value_In_Listbox(By by, String valuetoselect, int timeoutinseconds)
			throws ValueNotSelectedInListboxException {
		WebElement Listbox = wait_For_Element_To_be_Found(by, timeoutinseconds);
		if (Listbox != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					int optionindex = get_Option_Index_From_Listbox(Listbox, valuetoselect);
					if (optionindex >= 0) {
						Select list = new Select(Listbox);
						list.selectByIndex(optionindex);
					}
				} else {
					throw new ValueNotSelectedInListboxException("selecting the value" + valuetoselect + "in list box"
							+ by.toString() + "is failed as the value is not found listbox ");
				}
			} else {
				throw new ValueNotSelectedInListboxException("selecting the value" + valuetoselect + "in list box"
						+ by.toString() + "is failed as the value is not found listbox ");

			}
		} else {
			throw new ValueNotSelectedInListboxException("selecting the value" + valuetoselect + "in list box"
					+ by.toString() + "is failed as the value is not found listbox ");
		}

	}

	public void select_Values_From_List_Box(By by, String[] allOptionsToSelect, int timeoutinseconds)
			throws ValueNotSelectedInListboxException {

		WebElement Listbox = wait_For_Element_To_be_Found(by, timeoutinseconds);

		if (Listbox != null) {
			if (Wait_until_Element_to_be_displyed(by, timeoutinseconds)) {
				if (Wait_until_Element_to_be_Enabled(by, timeoutinseconds)) {
					String valuesNotFound = "";
					for (String optiontoselect : allOptionsToSelect) {
						int optionindex = get_Option_Index_From_Listbox(Listbox, optiontoselect);
						if (optionindex >= 0) {
							Select list = new Select(Listbox);
							list.selectByIndex(optionindex);
						} else {
							valuesNotFound = valuesNotFound + ";" + valuesNotFound;
						}
						if (!valuesNotFound.isEmpty()) {
							throw new ValueNotSelectedInListboxException(" the the following values" + valuesNotFound
									+ "in list box" + by.toString() + "is failed as the value is not found listbox ");
						}
					}

				} else {
					throw new ValueNotSelectedInListboxException("selecting the values" + allOptionsToSelect
							+ "in list box" + by.toString() + "is failed as the value is not found listbox ");
				}
			} else {
				throw new ValueNotSelectedInListboxException("selecting the values" + allOptionsToSelect + "in list box"
						+ by.toString() + "is failed as the value is not found listbox ");

			}
		} else {
			throw new ValueNotSelectedInListboxException("selecting the values" + allOptionsToSelect + "in list box"
					+ by.toString() + "is failed as the value is not found listbox ");
		}

	}

}

package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verifications {

	public boolean verify_Textbox_isempty(WebElement textbox) {

		String strTextBoxValue = textbox.getAttribute("value");

		if (!strTextBoxValue.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verify_Value_Pattern_In_Textbox(WebElement textbox, String valuepattern) {

		String strTextBoxValue = textbox.getAttribute("value");

		if (!strTextBoxValue.trim().matches(valuepattern)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verify_TextBox_Value(WebElement textbox, String expectedvalue, boolean ignorecase) {

		String strTextBoxValue = textbox.getAttribute("value");

		if (ignorecase) {
			if (strTextBoxValue.equalsIgnoreCase(expectedvalue)) {

				return true;
			} else {
				return false;
			}

		} else {
			if (strTextBoxValue.equals(expectedvalue)) {

				return true;
			} else {
				return false;
			}

		}

	}

	public boolean verify_Is_Checkbox_Selected(WebElement checkbox) {

		if (checkbox.isSelected()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verify_Is_Checkbox_NotSelected(WebElement checkbox) {

		if (checkbox.isSelected()) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verify_Link_Text_Colour(WebElement link, String textcolour) {

		String colour = link.getCssValue(textcolour);

		if (colour.equalsIgnoreCase(textcolour)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verify_page_title(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verify_page_title_Contains(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.toLowerCase().contains(expectedTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verify_element_Text(WebElement element, String expectedText) {
		String actualText = element.getText();
		if (actualText.equalsIgnoreCase(expectedText)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verify_element_TextContains(WebElement element, String expectedText) {
		String actualText = element.getText();
		if (actualText.toLowerCase().equalsIgnoreCase(expectedText)) {
			return true;
		} else {
			return false;
		}
	}

}

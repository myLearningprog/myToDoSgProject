package com.eComm.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericWrappers {

	public static WebDriver driver;
	protected static Properties props;

	public static Properties loadObjects() {
		try {
			props = new Properties();
			props.load(new FileInputStream(new File("./src/test/resources/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}

	public By locatorValue(String propertyName) {
		By ele = null;
		try {
			String locator = propertyName.substring(propertyName.lastIndexOf(".") + 1);
			System.out.println("Index Count+++++++" + propertyName.lastIndexOf(".") + 1);
			System.out.println("Identified locator name -." + locator);
			String finder = props.getProperty(propertyName);
			switch (locator) {
			case "id":
				ele = By.id(finder);
				break;
			case "Name":
				ele = By.name(finder);
				break;
			case "Linktext":
				ele = By.name(finder);
				break;
			case "Partiallinktext":
				ele = By.partialLinkText(finder);
				break;
			case "Classname":
				ele = By.className(finder);
				break;
			case "Tagname":
				ele = By.className(finder);
				break;
			case "CSSSelector":
				ele = By.cssSelector(finder);
				break;
			case "Xpath":
				ele = By.xpath(finder);
				break;
			default:
				System.out.println("Invalid locator passed-Failed");
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ele;

	}

	public void enterText(String propertyName, String data) {
		try {
			By ele = locatorValue(propertyName);
			driver.findElement(ele).clear();
			driver.findElement(ele).sendKeys(data);
			System.out.println("The data:" + data + "entered successfully in field property" + propertyName + "PASSED");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(
					"The data:" + data + "could not be entered in the field property" + propertyName + "FAILED");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception occured while entering" + data + " in the field property"
					+ propertyName + "FAILED");
			e.printStackTrace();
		}
	}

	public void clickElement(String propertyName) {
		try {
			By ele = locatorValue(propertyName);
			driver.findElement(ele).click();
			System.out.println("The element with property:" + propertyName + "is clicked.-PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The element with property:" + propertyName + "cloud not be clicked" + "FAIL");
			Assert.fail("The element with property:" + propertyName + "cloud not be clicked");
		}
	}

	public void verifyText(String propertyName, String text) {
		try {
			By ele = locatorValue(propertyName);
			String sText = driver.findElement(ele).getText();
			if (sText.equalsIgnoreCase(text)) {
				System.out.println("The text :" + sText + "matches with the value:" + text + "PASS");
			} else {
				System.out.println("The text :" + sText + "did not match with the value:" + text + "FAIL");
				Assert.fail("Assertion of the text did not matach and stopping the test to continue further");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception occurred while verifying the Text" + e + "FAIL");
			Assert.fail("Unknown exception occured while verifying the Text");
		}
	}

	public String getText(String propertyName)

	{
		String text = null;
		try {
			By ele = locatorValue(propertyName);
			text = driver.findElement(ele).getText();
			System.out.println("The element with property: " + propertyName + "is clicked." + "PASS");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("The element with property: " + propertyName + "is clicked." + "PASS");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception occured while entering" + propertyName + " in the field property"
					+ propertyName + "FAILED");
			e.printStackTrace();
		}
		return text;

	}

	public void enterTextbyJavaScripts(String propertyName, String data) {
		try {
			By ele = locatorValue(propertyName);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('ele').value=data;");
			System.out.println("the data:" + data + "entered successfully in field property " + propertyName + "PASS");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println(
					"The data:" + data + "could not be entered in the field property" + propertyName + "FAILED");
			Assert.fail("Assertion of the text did not matach and stopping the test to continue further");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception occured while entering" + data + " in the field property"
					+ propertyName + "FAILED");
			Assert.fail("Unknown exception occured while verifying the entered text");
			e.printStackTrace();
		}

	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().contains(title)) {
				System.out.println("The title of the page matces with the value:" + title + "PASS");
				bReturn = true;
			} else {
				System.out.println("The title of the page matces with the value:" + title + "FAIL");
				Assert.fail("Assetion of the title did not match and stopping the test to cont. further");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception occurred while verifying the title" + e.getMessage() + "FAIL");
			Assert.fail("Unknown exception occured while verifying the title");
			e.printStackTrace();
		}
		return bReturn;

	}

	public WebElement verifyElementPresent(String propertyName, WebDriver driver) {

		try {
			By ele = locatorValue(propertyName);
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(ele));
			if (driver.findElement(ele).isEnabled()) {
				return driver.findElement(ele);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The element is not found FAIL");
			Assert.fail("The element is not found & stopping the test");
			e.printStackTrace();
		}

		return null;

	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The browser could not closed" + e + "WARN");
			e.printStackTrace();
		}
	}

}

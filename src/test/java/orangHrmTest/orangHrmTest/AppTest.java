package orangHrmTest.orangHrmTest;

import java.awt.Desktop.Action;
import java.awt.Frame;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends testData {

	@BeforeTest
	public void mySetup() {

		Setup();

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		WebElement userNameField = driver.findElement(By.name("username"));
		userNameField.sendKeys(Username);
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(Password);
		WebElement loginButton = driver
				.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
		loginButton.click();
	}

	@Test(priority = 2)
	public void addAdmin() throws InterruptedException {

		WebElement moveToAdminPage = driver.findElement(By.linkText("Admin"));
		moveToAdminPage.click();

		WebElement addButton = driver.findElement(By.cssSelector(".orangehrm-header-container"))
				.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary"));
		addButton.click();

		List<WebElement> selectButton = driver.findElements(By.className("oxd-select-wrapper"));
		WebElement userRole = selectButton.get(0);
		userRole.click();

		WebElement selectAdmin = userRole.findElement(By.cssSelector(".oxd-select-text-input"));
		selectAdmin.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement status = selectButton.get(1);
		status.click();

		WebElement enabled = status.findElement(By.cssSelector(".oxd-select-text-input"));
		enabled.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employeeName.sendKeys(employeeSugg[randomSelect]);
		Thread.sleep(2000);
		employeeName.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		List<WebElement> inputFeild = driver.findElements(By.cssSelector(".oxd-input.oxd-input--active"));
		WebElement theUserName = inputFeild.get(1);
		theUserName.sendKeys(theEmployeeName);

		WebElement passwordField = inputFeild.get(2);
		passwordField.sendKeys(Password);

		WebElement confirmPasswordField = inputFeild.get(3);
		confirmPasswordField.sendKeys(Password);

		WebElement saveAllData = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveAllData.click();
	}

	@Test(priority = 3)
	public void editAdmin() throws InterruptedException {
		Thread.sleep(4000);
		js.executeScript("window.scrollTo(0,500)");

		List<WebElement> allButton = driver
				.findElements(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space"));

		List<WebElement> editButton = new ArrayList<>();
		for (int i = 1; i < allButton.size(); i = i + 2) {
			editButton.add(allButton.get(i));
		}

		if (editButton.isEmpty()) {
			System.out.println("No edit buttons available to click.");
			return;
		}

		int randomSelectEmployee = rand.nextInt(editButton.size());
		editButton.get(randomSelectEmployee).click();
		Thread.sleep(1000);
		WebElement editUserName = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		editUserName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		editUserName.sendKeys(Keys.DELETE);
		editUserName.sendKeys(randomUserName);

		WebElement saveTheEdit = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveTheEdit.click();
	}

	@Test(priority = 4)
	public void deleteAdmin() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,500)");

		List<WebElement> allButton = driver
				.findElements(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space"));
		List<WebElement> deleteButton = new ArrayList<>();
		for (int i = 2; i < allButton.size(); i = i + 2) {
			deleteButton.add(allButton.get(i));

		}
		int randomDeleteOne = rand.nextInt(deleteButton.size());
		deleteButton.get(randomDeleteOne).click();

		WebElement confirmDelete = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin"));
		confirmDelete.click();

	}

	@Test(priority = 5)
	public void searchAdminRecords() {

		WebElement userNameFieldSearch = driver
				.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));

		userNameFieldSearch.sendKeys(Username);
		WebElement searchButton = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		searchButton.click();
	}

}

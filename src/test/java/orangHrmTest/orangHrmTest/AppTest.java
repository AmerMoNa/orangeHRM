package orangHrmTest.orangHrmTest;

import static org.testng.Assert.assertEquals;

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
		editUserName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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

	@Test(priority = 6)
	public void addEmployee() throws InterruptedException {
		WebElement PIMbutton = driver.findElement(By.linkText("PIM"));
		PIMbutton.click();

		WebElement addEmployeeButton = driver.findElement(By.linkText("Add Employee"));
		addEmployeeButton.click();

		WebElement firstNameField = driver.findElement(By.name("firstName"));
		firstNameField.sendKeys(firstName);

		WebElement middleNameField = driver.findElement(By.name("middleName"));
		middleNameField.sendKeys(middleName);

		WebElement lastNameField = driver.findElement(By.name("lastName"));
		lastNameField.sendKeys(lastName);

		WebElement employeeIdField = driver.findElement(By.cssSelector(".oxd-grid-2.orangehrm-full-width-grid"))
				.findElement(By.cssSelector(".oxd-input.oxd-input--active"));
		employeeIdField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		employeeIdField.sendKeys(randomId);

		WebElement saveButton = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveButton.click();

		Thread.sleep(6000);
		List<WebElement> allFieldPersonalDetails = driver.findElements(By.cssSelector(".oxd-input.oxd-input--active"));
		WebElement otherId = allFieldPersonalDetails.get(5);
		otherId.sendKeys(randomId2);

		WebElement driverLicenseNumber = allFieldPersonalDetails.get(6);
		driverLicenseNumber.sendKeys(randomId + randomId2);

		WebElement licenseExpiryDate = allFieldPersonalDetails.get(7);
		licenseExpiryDate.sendKeys(nextYear);

		List<WebElement> selectsField = driver.findElements(By.cssSelector(".oxd-select-text-input"));

		WebElement nationality = selectsField.get(0);
		nationality.sendKeys(countries[randomCountries] + Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement maritalStatus = selectsField.get(1);
		maritalStatus.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement dateOfBirth = allFieldPersonalDetails.get(8);
		dateOfBirth.sendKeys(dayOfBirth);

		List<WebElement> gender = driver
				.findElements(By.cssSelector(".oxd-radio-input.oxd-radio-input--active.--label-right.oxd-radio-input"));
		int randomGender = rand.nextInt(gender.size());
		gender.get(randomGender).click();

		WebElement saveButton2 = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveButton2.click();

	}

	@Test(priority = 7)
	public void editEmployee() throws InterruptedException {

		WebElement employeeList = driver.findElement(By.cssSelector(".oxd-topbar-body-nav-tab.--visited"));
		employeeList.click();

		List<WebElement> allButton = driver
				.findElements(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space"));
		List<WebElement> editButton = new ArrayList<>();
		for (int i = 0; i < allButton.size(); i = i + 2) {

			editButton.add(allButton.get(i));
		}

		int randomEditButton = rand.nextInt(editButton.size());
		editButton.get(randomEditButton).click();

		Thread.sleep(2000);
		WebElement employeeId = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));

		employeeId.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		employeeId.sendKeys(randomId);

		WebElement saveButton = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		saveButton.click();

	}

	@Test(priority = 8)
	public void deleteEmployee() {

		WebElement employeeList = driver.findElement(By.cssSelector(".oxd-topbar-body-nav-tab.--visited"));
		employeeList.click();

		List<WebElement> allButton = driver
				.findElements(By.cssSelector(".oxd-icon-button.oxd-table-cell-action-space"));
		List<WebElement> deleteButton = new ArrayList<>();
		for (int i = 1; i < allButton.size(); i = i + 2) {

			deleteButton.add(allButton.get(i));
		}

		int randomEditButton = rand.nextInt(deleteButton.size());
		deleteButton.get(randomEditButton).click();

		WebElement confirmDelete = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin"));
		confirmDelete.click();

	}

	@Test(priority = 9)
	public void employeeSearch() throws InterruptedException {

		WebElement employeeName = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		employeeName.sendKeys(employeeSugg[randomSelect]);
		Thread.sleep(1500);
		employeeName.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement searchButton = driver.findElement(
				By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
		searchButton.click();

	}
}

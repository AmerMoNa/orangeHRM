package orangHrmTest.orangHrmTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testData {
	
	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String Username = "Admin";
	String adminPassword = "admin123";
	String adminPassword2 = "123admin";
	String essPassword = "user123";
	String firstName = "Ahmed";
	String middleName = "Omer";
	String lastName = "Naser";

	Random rand = new Random();
	
	String theAdminName = "admin" + new Random().nextInt(1000);
	String theEmployeeName = "emplyee" + new Random().nextInt(1000);
	String[] employeeSugg = { "a", "s", "d", "f" ,"5","7","w","r"};
	int randomSelect = rand.nextInt(employeeSugg.length);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String randomUserName = "user" + new Random().nextInt(9999);
	int randomInt = new Random().nextInt(1000);
	String randomId = String.valueOf(randomInt );
	String randomId2 = String.valueOf(randomInt + 274 );
	String nextYear = "2026-01-06";
	String [] countries = {"a","s","d","f","g","h"};
	int randomCountries = rand.nextInt(countries.length);
	String dayOfBirth = "1999-04-08";
	
	String expectedRecord = "(1) Record Found";
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate today = LocalDate.now();
	LocalDate afterTwoDay = today.plusDays(2);
	String formatterToday = today.format(formatter);
	String formatterAfterTwoDay = afterTwoDay.format(formatter);
		

	


	
	public void Setup() {
		driver.get(theWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

}

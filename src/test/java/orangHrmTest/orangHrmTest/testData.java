package orangHrmTest.orangHrmTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testData {
	
	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String Username = "Admin";
	String Password = "admin123";
	Random rand = new Random();
	
	String theEmployeeName = "user" + new Random().nextInt(1000);
	String[] employeeSugg = { "a", "s", "d", "f" };
	int randomSelect = rand.nextInt(employeeSugg.length);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String randomUserName = "user" + new Random().nextInt(9999);

	
	public void Setup() {
		driver.get(theWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

}

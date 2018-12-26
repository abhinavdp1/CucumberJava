package Tests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RegistrationStepDefinitions {
	
	WebDriver driver = null;
	
	@Given("^User goes to https://demoqa\\.com/registration/$")
	public void GoToRegistrationPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		File file = new File("C:\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
	    driver.get("https://demoqa.com/registration");
	}

	@When("^user fills in the given details registrataion form$")
	public void FilltheForm(DataTable testData) throws Throwable {
	   
		Map<String,String> testDataMap = testData.asMap(String.class,String.class);
		
		driver.findElement(By.id("name_3_firstname")).sendKeys(testDataMap.get("FirstName"));
		driver.findElement(By.id("name_3_lastname")).sendKeys(testDataMap.get("LastName"));
		driver.findElement(By.id("phone_9")).sendKeys(testDataMap.get("PhoneNumber"));
		driver.findElement(By.id("username")).sendKeys(testDataMap.get("UserName"));
		
		
	}

}

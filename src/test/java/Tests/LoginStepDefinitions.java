package Tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinitions {
	
	WebDriver driver = null;
 //Alternation	
	@Given("^User (?:is on|navigates to|launches) (http.*com)$")
	public void NavigateTo(String URL) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
		//System.setProperty(	"webdriver.gecko.driver.driver", "./geckodriver.exe"); 
	
		File file = new File("C:\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(850,TimeUnit.MILLISECONDS);
		
	}

	@When("^user clicks on MyAccounts link$")
	public void user_clicks_on_MyAccounts_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement MyAccountlink = driver.findElement(By.className("account_icon"));
	    MyAccountlink.click();
	}

	@And("^user enters a valid username (.*) and passoword (.*)$")
	public void LoginDemoQA(String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement LoginField = driver.findElement(By.id("log"));
	    LoginField.sendKeys(username);
	    
	    
	    WebElement PasswordField = driver.findElement(By.id("pwd"));
	    PasswordField.sendKeys(password);
	    
	    WebElement loginButton = driver.findElement(By.id("login"));
	    loginButton.click();
	}

	@Then("^user is taken to myaccounts page$")
	public void user_is_taken_to_myaccounts_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement logOutButton = null;
		try 
		{		
			logOutButton = driver.findElement(By.id("account_logout"));
		}
		catch(Exception exp)
		{
		System.out.println("Not able to find element");
		}
		Assert.assertNotNull("Logout button is not Null",logOutButton);
	}
	
	
}

package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageCusBank {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

	@Given("user is on manager page")
	public void user_is_on_manager_page() throws Throwable {
		System.out.println("hello everyone! Hope you are doing well");
		 System.setProperty("Webdriver.chrome.driver", projectPath + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

	}
	
	//Verify manage page
	@Given("verify manage page")
	public void verify_manage_page() throws Throwable {
		//Verify url
		String manageCusPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		//Verify title
		String manageCusPageTitle = driver.getTitle();
		Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
		Thread.sleep(2*1000);
	}

	//Add new customer
	@When("user click on Add Customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(2*1000);
	}

	@When("user enter <firstname> and <lastname> and <postcode>")
	public void user_enter_firstname_and_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Thuy");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Nguyen");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("abc345");
		Thread.sleep(1000);
	}
	
	@When("user enter <lastname> and <postcode>")
	public void user_enter_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ngo");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("abc789");
		Thread.sleep(1000);
	}
	
	@And("click Add on Customer button")
	public void click_add_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2*1000);
	}
	
	@And("click ok of alert box")
	public void click_ok_of_alert_box() throws Throwable {
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	//Verify data when add a new customer successful
	@And("verify data")
	public void verify_data() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Nu");
		int verifyDataAdd = driver.findElements(By.xpath("//td[contains(text(),'Nu')]")).size();
		if (verifyDataAdd > 1) {
			System.out.println(verifyDataAdd - 1 + " " + "result found");
		}else {
			System.out.println("No result");
		}
		Thread.sleep(2*1000);
	}
	
	
	//Open Account
	@When("user click on Open Account button")
	public void user_click_on_open_account_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("select <account> and <currency>")
	public void select_account_and_currency() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Hermoine Granger')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}

	@When("select <account>")
	public void select_account() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Hermoine Granger')]")).click();
		Thread.sleep(1000);
	}

	@And("click on process button")
	public void click_on_process_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(2*1000);
		
	}
	
	//Search Customer
	@When("user click on Customer button")
	public void user_click_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("user search customer exist")
	public void user_search_customer_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
		Thread.sleep(2*1000);
	}

	@When("user search customer does not exist")
	public void user_search_customer_does_not_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Trung");
		Thread.sleep(2*1000);
	}
	//Verify search customer with name
	@When("verify search customer")
	public void verify_search_customer() {
		int verifyDataSearch = driver.findElements(By.xpath("//td[contains(text(),'Hermoine')]")).size();
		if (verifyDataSearch > 0) {
			System.out.println(verifyDataSearch + " " + "result found");
		}else {
			System.out.println("No result");
		}
	}
	@Then("message is display")
	public void message_is_display() {
		driver.quit();
	    System.out.println("Successfully execution");
	}

}

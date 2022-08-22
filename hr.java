package StepDefinitions;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class banking {
		WebDriver driver=null;
		@Given("HR Management is open")
		public void hr_site_open()
		{
			System.out.println("Inside Step - HR site opened in browser");
			String projectPath = System.getProperty("user.dir");
			System.out.println("Project path is : "+projectPath);
			String filePath = new File("drivers/chromedriver.exe").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", filePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Inside Step - user is on Orange HR Site");
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
		@And("Login as a HR")
		public void hr_login() throws InterruptedException
		{
			Thread.sleep(5000);
			System.out.println("Inside Step - Logging in as a HR");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		}
		@When("Create new employee")
		public void new_employee() throws InterruptedException
		{
			Thread.sleep(2500);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys("Kirubakaran");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys("B");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]")).sendKeys("0314");
		}
		@Then("Update Employee Details")
		public void empoloyee_details() throws InterruptedException
		{
			Thread.sleep(2500);

			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		}
}

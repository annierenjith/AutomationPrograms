package h2kinfosys.Automation;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenMRS2Wait {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.openmrs.org");
		//Username:Admin
		//Password:Admin123
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("//i[@class='icon-user']")).click();
		driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Manju");
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Raj");
		driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("YYY");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		WebElement gender = driver.findElement(By.id("gender-field"));
		Select dropdownGender = new Select(gender);
		dropdownGender.selectByValue("F");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		driver.findElement(By.xpath("//input[@name='birthdateDay']")).sendKeys("5");
		
		WebElement month = driver.findElement(By.id("birthdateMonth-field"));
		Select dropdownMonth = new Select(month);
		dropdownMonth.selectByValue("3");
		
		driver.findElement(By.xpath("//input[@name='birthdateYear']")).sendKeys("2000");
		driver.findElement(By.cssSelector("#next-button")).click();
	
		driver.findElement(By.id("address1")).sendKeys("Genesee Avenue");
		driver.findElement(By.id("address2")).sendKeys("SN Lane");
		driver.findElement(By.id("cityVillage")).sendKeys("Lajolla");
		driver.findElement(By.id("stateProvince")).sendKeys("CA");
		driver.findElement(By.id("country")).sendKeys("USA");
		driver.findElement(By.id("postalCode")).sendKeys("92122");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		WebElement relationship = driver.findElement(By.xpath(" //select[@id='relationship_type']"));
		Select relationshipDropdown = new Select(relationship);
		relationshipDropdown .selectByVisibleText("Parent");
		
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys("Paul");
		driver.findElement(By.cssSelector("#next-button")).click();
		
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.click();
		
	//	Thread.sleep(2000);
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement HomeButton = driver.findElement(By.xpath("(//i[@class='icon-home small'])"));
		wait.until(ExpectedConditions.elementToBeClickable(HomeButton));
		HomeButton.click();
	
		WebElement SearchButton = driver.findElement(By.cssSelector("i.icon-search"));
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		SearchButton.click();
		
		driver.findElement(By.cssSelector("#patient-search")).sendKeys("Manju");
	//	Thread.sleep(4000);
		String actualText = "100JJ6Recent";
		String expectedText = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText();
		System.out.println(expectedText);
		if(actualText.contains(expectedText))
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	
	
}

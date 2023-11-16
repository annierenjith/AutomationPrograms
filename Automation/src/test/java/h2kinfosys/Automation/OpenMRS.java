package h2kinfosys.Automation;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenMRS {
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
		
		//Click Register button
		//	driver.findElement(By.xpath("//i[@class='icon-user']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register a patient']")).click();
		driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Mini");
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
		
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='icon-home small'])")).click();
	
		driver.findElement(By.cssSelector("i.icon-search")).click();
		driver.findElement(By.cssSelector("#patient-search")).sendKeys("Ambili");
		
	//	Thread.sleep(1000);
		String actualText = "100K34Recent";
		String expectedText  =driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText();
		System.out.println(expectedText);
		if(actualText.contains(expectedText)) {
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	
	
}

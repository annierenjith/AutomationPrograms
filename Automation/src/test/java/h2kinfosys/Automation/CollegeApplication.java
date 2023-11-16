package h2kinfosys.Automation;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CollegeApplication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://bangalorecitycollege.org/application-form.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ambili");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("05");
		driver.findElement(By.xpath("//input[@name='mm']")).sendKeys("05");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		driver.findElement(By.xpath("//input[@id='nationality']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='religion']")).sendKeys("null");
		driver.findElement(By.xpath("//input[@value='BT']")).click();
		driver.findElement(By.xpath("//input[@id='course']")).sendKeys("Computer Science");
		driver.findElement(By.xpath("//input[@id='marks2']")).sendKeys("80");
		driver.findElement(By.xpath("//input[@id='marks3']")).sendKeys("80");
		driver.findElement(By.xpath("//input[@id='marks4']")).sendKeys("80");
		driver.findElement(By.xpath("//input[@id='marks5']")).sendKeys("80");
		driver.findElement(By.xpath("//textarea[@id='padd']")).sendKeys("shfsh");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("365748767");
		driver.findElement(By.xpath("//textarea[@id='cadd']")).sendKeys("4000 SNlane");
		driver.findElement(By.xpath("//input[@id='phone1']")).sendKeys("64545");
		driver.findElement(By.xpath("//input[@id='parent']")).sendKeys("Krishnan");
		driver.findElement(By.xpath("//textarea[@id='occ']")).sendKeys("90000");
		driver.findElement(By.xpath("//input[@value='No']")).click();
		driver.findElement(By.xpath("//textarea[@id='ladd']")).sendKeys("2000 Wollaston");
		driver.findElement(By.xpath("//input[@id='phone3']")).sendKeys("678575");
		driver.findElement(By.xpath("//textarea[@id='exam']")).sendKeys("2000");
		driver.findElement(By.xpath("//textarea[@id='sadd']")).sendKeys("Christian college");
		driver.findElement(By.xpath("//input[@id='date']")).sendKeys("November 2008");
		
		WebElement course = driver.findElement(By.xpath("//select[@id='capp']"));
		Select dropDown = new Select(course);
		dropDown.selectByValue("M.Sc Computer Science");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@yahoo.com");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

}

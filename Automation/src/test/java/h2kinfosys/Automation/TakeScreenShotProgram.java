package h2kinfosys.Automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotProgram {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://bangalorecitycollege.org/application-form.html");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.manage().window().minimize();
		Thread.sleep(1000);
		driver.manage().window().fullscreen();
		
		TakesScreenshot tsh = (TakesScreenshot)driver;
		File srcFile = tsh.getScreenshotAs(OutputType.FILE);
		File desFile = new File("Bangalore.jpg");
		FileUtils.copyFile(srcFile, desFile);
		
		
	}

}

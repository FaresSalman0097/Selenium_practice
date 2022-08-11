package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(10000);
		driver.findElement(By.id("fileupload")).sendKeys("E:\\Java Besant Technology\\SkExports.png");
		Thread.sleep(3000);
		driver.quit();
	}

}

package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(10000);
		driver.findElement(By.id("name")).sendKeys("salman");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		Select course_DD = new Select(driver.findElement(By.id("course")));
		course_DD.selectByVisibleText("Python");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("sameera");
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.findElement(By.id("name")).sendKeys("Frame3");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Select course_DDfram3 = new Select(driver.findElement(By.id("course")));
		course_DDfram3.selectByVisibleText("Java");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Frame3 executed");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Salmeera");
		
		//driver.quit();

	}

}

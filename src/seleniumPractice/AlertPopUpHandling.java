package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String alert_msg = alert.getText();
		System.out.println(alert.getText());    // get the text of the alert box
		
		if(alert_msg.equals("Please enter a valid user name")) {
			System.out.println("Correct message");
		}else {
			System.out.println("Wrong message");
		}
		
		
		alert.accept();    // click OK on the alert box
		
		// alert.dismiss();    // click CANCEL on the alert box
		
		driver.quit();

	}

}

package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		// Maximise the window
		driver.manage().window().maximize();
		// Delete Cookies
		driver.manage().deleteAllCookies();
		//wait
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		// Open URL
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// Get Site title
		String title = driver.getTitle();
		System.out.println("Site title is: " + title);
		// Enter Username
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		// Enter Password
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		// Click submit
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		//Site Actual URL
		String actual_URl = driver.getCurrentUrl();
		//System.out.println(actual_URl);
		//Desired URL
		String desired_URL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		//Verify URL
		if(actual_URl.equals(desired_URL)) {
			System.out.println("Pass");
		}else {
			System.out.println("fail");
		}
		//search for employee Aravind
		Thread.sleep(5000);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("aravind");
		Thread.sleep(3000);
		Select user_role = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		user_role.selectByIndex(2);
		driver.findElement(By.className("searchbutton")).click();
		driver.findElement(By.xpath("//a[text()='Aravind']")).click();
		Thread.sleep(5000);
		//Change status to disabled
		driver.findElement(By.id("btnSave")).click();
		Select user_status = new Select(driver.findElement(By.id("systemUser_status")));
		user_status.selectByIndex(1);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		
		
		//Add new employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("MOHAMED SALMAN");
		driver.findElement(By.id("lastName")).sendKeys("FARES");
		driver.findElement(By.id("employeeId")).sendKeys("20097");
		//Employee photo upload
		driver.findElement(By.id("photofile")).sendKeys("E:\\Java Besant Technology\\SkExports.png");
		String uploaded_file = driver.findElement(By.id("photofile")).getAttribute("value");
		//System.out.println(uploaded_file);
		
		if(uploaded_file.contains("SkExports.png")) {
			System.out.println("File Uploaded Successfully");
		}else {
			System.out.println("File not uploaded");
		}
		Thread.sleep(5000);
		//Create Login Details
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys("Salman097");
		driver.findElement(By.id("user_password")).sendKeys("Salman@0097");
		driver.findElement(By.id("re_password")).sendKeys("Salman@0097");
		Select status = new Select(driver.findElement(By.id("status")));
		status.selectByIndex(0);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		//Enter Personal details
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_optGender_1")).click();
		Select marital_status = new Select(driver.findElement(By.id("personal_cmbMarital")));
		marital_status.selectByValue("Married");
		Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
		nationality.selectByVisibleText("Indian");
		driver.findElement(By.id("btnSave")).click();
		
		Thread.sleep(5000);
		
		//Enter blood group
		
		driver.findElement(By.id("btnEditCustom")).click();
		Select blood_grp = new Select(driver.findElement(By.className("editable valid")));
		blood_grp.selectByVisibleText("A+");
		driver.findElement(By.id("btnEditCustom")).click();
		
		
		
		driver.close();
	}

}

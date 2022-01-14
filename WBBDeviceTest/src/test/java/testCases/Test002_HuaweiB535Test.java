package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test002_HuaweiB535Test {
	
	@Test
	public static void TC002_HuaweiB535Test() throws InterruptedException {
		
		
		String DevicePassword =null;
		String PrimaryPCI =null;
		String Primaryband =null;
		String DeviceRestartingText=null;
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gaurav.prakash\\OneDrive - 2degrees New Zealand Limited\\Gaurav 2 Degrees\\Projects\\Automation GP\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.8.1");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		//Device Login
		

		
		DevicePassword = driver.findElement(By.xpath("//div[contains(text(),\"Device login password\")]")).getText();
		System.out.println("Please Enter : "+DevicePassword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"login_password_close\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id=\"login_username_div\"]/input")).sendKeys("2degreeswbb");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()=\"Log In\"]")).click();
		Thread.sleep(4000);
		
		//Fetching PCI Advance>System
		driver.findElement(By.xpath("//div[text()=\"Advanced\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"System\"]")).click();
		Thread.sleep(2000);
		PrimaryPCI=driver.findElement(By.xpath("//div[@id=\"di-pci\"]/span")).getText();
		Thread.sleep(2000);
		System.out.println("The PCI is : "+PrimaryPCI);
		
		//Fetching Band
		Primaryband=driver.findElement(By.xpath("//div[@id=\"di-band\"]/span")).getText();
		Thread.sleep(2000);
		System.out.println("The Primary band is : "+Primaryband);
		
		//Restart
		driver.findElement(By.xpath("//div[text()=\"Restart\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Restart\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"The device will restart. Continue?\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=\"Continue\"]")).click();
		Thread.sleep(2000);
		
		try {
			do {
			DeviceRestartingText=null;
			Thread.sleep(2000);
			DeviceRestartingText=driver.findElement(By.xpath("//div[text()=\"The device is restarting … Please wait\"]")).getText();
			System.out.println(DeviceRestartingText);
			Thread.sleep(15000);
			}
			while(DeviceRestartingText !=null);
		} catch (Exception e1) {
			System.out.println("Restart Completed");
		}
		
		//Device Login
		DevicePassword = driver.findElement(By.xpath("//div[contains(text(),\"Device login password\")]")).getText();
		System.out.println("Please Enter : "+DevicePassword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"login_password_close\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"login_username_div\"]/input")).sendKeys("2degreeswbb");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()=\"Log In\"]")).click();
		Thread.sleep(4000);
}
}

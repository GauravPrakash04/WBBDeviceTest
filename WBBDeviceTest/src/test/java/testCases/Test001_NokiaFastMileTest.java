package testCases;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test001_NokiaFastMileTest {

	
	public static void TC001_NokiaFastMileTest() throws InterruptedException {

		
try {
		String Status5G_Nokia=null;
		String PCIValue5G_Nokia=null;
		String Band5G_Nokia=null;
		String Status4G_Nokia=null;
		String PCIValue4G_Nokia=null;
		String BandPrimary4G_Nokia=null;

		String SecondaryCell1=null;
		String PCISecondaryCell1=null;
		String BandSecondaryCell1_4G_Nokia=null;

		String SecondaryCell2=null;
		String PCISecondaryCell2=null;
		String BandSecondaryCell2_4G_Nokia=null;
		String SecondaryCell3=null;
		String PCISecondaryCell3=null;
		String BandSecondaryCell3_4G_Nokia=null;

		String Overview5GConnectionStatus=null;
		String Overview4GConnectionStatus=null;
		String RestartingText=null;
		String RebootWarning=null;
		
		
		WebDriver driver;
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\gaurav.prakash\\OneDrive - 2degrees New Zealand Limited\\Gaurav 2 Degrees\\Projects\\Automation GP\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.get("http://192.168.1.1");
			driver.manage().window().maximize();
			
			 System.out.println("Running Test 1 --------CA--------");
			 
			 //Logging to Status > Cellular 
			 System.out.println("Logging Into Nokia UI");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//a[text()=\" Status \"]")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//a[text()=\" Cellular \"]")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).click(); 
			 driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("admin");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).click(); 
			 driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("daa9828399"); 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//span[text()=\"Log in\"]")).click();
			 Thread.sleep(4000);
			 
			 
			 //Click on 5G Tab 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//div[text()=\"5G\"]")).click();
			 
			 //Fetch 5G Status 
			 System.out.println("Fetching 5G information");
			 Thread.sleep(2000); 
			 Status5G_Nokia = driver.findElement(By.xpath("//div[text()=\"5G\"]/ancestor::mat-tab-header/following-sibling::div/mat-tab-body/div/div/div/div")).getText();
			 System.out.println("The Status of 5G connection is : "+Status5G_Nokia);
			 
			 //Fetch 5G PCI 
			 Thread.sleep(1000); 
			 PCIValue5G_Nokia = driver.findElement(By.xpath("//div[@id=\"5gpci\"]")).getText();
			 System.out.println("The PCI Value for 5G is : "+PCIValue5G_Nokia);
			 
			 //Fetch Supported Bands 
			 Thread.sleep(1000); 
			 Band5G_Nokia = driver.findElement(By.xpath("//div[@id=\"5gband\"]")).getText();
			 System.out.println("The supported 5G band is : "+Band5G_Nokia);
			 
			//Getting to 4G TAB 
			 System.out.println("Fetching 4G information");
			 Thread.sleep(1000);
			  driver.findElement(By.xpath("//div[text()=\"4G\"]")).click();
			
			  
			  //Fetch 4G Status 
			  Thread.sleep(2000); 
			  Status4G_Nokia = driver.findElement(By.xpath("//div[text()=\"4G\"]/ancestor::mat-tab-header/following-sibling::div/mat-tab-body/div/div/div/div")).getText();
			  System.out.println("The Status of 4G Primary connection is : "+Status4G_Nokia);
			 
			 //Fetch 4G PCI 
			  Thread.sleep(1000); 
			  PCIValue4G_Nokia = driver.findElement(By.xpath("//div[@id=\"4gpci\"]")).getText();
			  System.out.println("The PCI Value for 4G Primary is : "+PCIValue4G_Nokia);
			 
			  //Fetch 4G Supported Primary Band 
			  Thread.sleep(1000); BandPrimary4G_Nokia =
			  driver.findElement(By.xpath("//div[@id=\"4gband\"]")).getText();
			  System.out.println("The supported 4G Primary Band is : "+BandPrimary4G_Nokia);
			  
			  //Fetch 4G Secondary Cell 1 If available
			  
			  try { 
				  Thread.sleep(1000); 
				  SecondaryCell1 = driver.findElement(By.
			  xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[1]/td[1]"
			  )).getText();
			  System.out.println("The secondary cell available is : "+SecondaryCell1);
			 
			  //Fetch Secondary Cell 1 PCI 
			  Thread.sleep(1000);
			  PCISecondaryCell1 = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[1]/td[2]")).getText(); 
			  System.out.println("The PCI value for "+SecondaryCell1+" : "+PCISecondaryCell1);
			  
			  //Fetch 4G Supported Secondary Band Cell 1 
			  Thread.sleep(1000);
			  BandSecondaryCell1_4G_Nokia = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[1]/td[3]")).getText();
			  System.out.println("The supported 4G band for "+SecondaryCell1+" : "+BandSecondaryCell1_4G_Nokia); } 
			  catch (Exception e) { // TODO Auto-generated
			   System.out.println("Secondary Cell not Available");	  
			  }
			  
//Fetch 4G Secondary Cell 2 If available
			  
			  try { 
				  Thread.sleep(1000); 
				  SecondaryCell2 = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[2]/td[1]")).getText();
			  System.out.println("The secondary cell available is : "+SecondaryCell2);
			  
			  //Fetch Secondary Cell 2 PCI 
			  Thread.sleep(1000); 
			  PCISecondaryCell2 = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[2]/td[2]")).getText(); 
			  System.out.println("The PCI value for "+SecondaryCell2+" : "+PCISecondaryCell2);
			  
			  //Fetch 4G Supported Secondary Band Cell 2 
			  Thread.sleep(1000);
			  BandSecondaryCell2_4G_Nokia = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[2]/td[3]")).getText();
			  System.out.println("The supported 4G band for "+SecondaryCell2+" : "+BandSecondaryCell2_4G_Nokia); 
			  } 
			  catch (Exception e) { // TODO Auto-generated
				   System.out.println("Secondary Cell 2 not Available");
			  }
			  
//Fetch 4G Secondary Cell 3 If available
			  
			  try { 
				  Thread.sleep(1000); 
				  SecondaryCell3 = driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[3]/td[1]")).getText();
			  System.out.println("The secondary cell available is : "+SecondaryCell3);
			  
			  //Fetch Secondary Cell 3 PCI 
			  Thread.sleep(1000); 
			  PCISecondaryCell3 =driver.findElement(By.xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[3]/td[2]")).getText(); 
			  System.out.println("The PCI value for "+SecondaryCell3+" : "+PCISecondaryCell3);
			  
			  //Fetch 4G Supported Secondary Band Cell 2 
			  Thread.sleep(1000);
			  BandSecondaryCell3_4G_Nokia = driver.findElement(By.
			  xpath("//td[text()=\" Carrier Aggregation - Downlink\"]/parent::tr/following-sibling::tr[3]/td[3]")).getText();
			  
			  System.out.println("The supported 4G band for "+SecondaryCell3+" : "+BandSecondaryCell3_4G_Nokia);
			  
			  } catch (Exception e7) 
			  { 
				  System.out.println("Secondary Cell 3 not Available");
			  }
			 
				
				
				// Speedtest CLI ---

				System.out.println("Running Test 2 --------Throughput (Speedtest CLI)--------");
				// Executing CMD
				System.out.println("Running Speedtest CLI command ......");
				try {
					Process process = Runtime.getRuntime().exec("cmd /c speedtest", null, new File("C:\\Users\\gaurav.prakash\\OneDrive - 2degrees New Zealand Limited\\Gaurav 2 Degrees\\Projects\\Speedtest CLI"));
					StringBuilder output = new StringBuilder();
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

					String line;

					while ((line = reader.readLine()) != null) {
						output.append(line + "\n");
					}
					int exitVal = process.waitFor();
					if (exitVal == 0) {
						System.out.println(output);
					} else {
						System.out.println("Something wrong in executing command");
					}

				} catch (Exception e5) {
					
					
				}

				// IPerf-------------

				System.out.println("Running Test 3 --------Throughput (Iperf)--------");
				System.out.println("Running IperfI command (Download)......");
				try {
					Process process2 = Runtime.getRuntime().exec("cmd /c iperf3 -c 111.69.32.122 -R", null, new File("C:\\Users\\gaurav.prakash\\OneDrive - 2degrees New Zealand Limited\\Gaurav 2 Degrees\\Projects\\iperf-3.1.3"));
					StringBuilder output = new StringBuilder();
					BufferedReader reader = new BufferedReader(new InputStreamReader(process2.getInputStream()));

					String line;

					while ((line = reader.readLine()) != null) {
						output.append(line + "\n");
					}
					int exitVal = process2.waitFor();
					if (exitVal == 0) {
						System.out.println(output);
					} else {
						System.out.println("Something wrong in executing command");
					}

				} catch (Exception e6) {

				}
				
				
				
				
				  
					// Restart ----------
					Thread.sleep(1000);
					System.out.println("Restarting from UI");
					driver.findElement(By.xpath("//a[text()=\" System \"]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[text()=\" System \"]/parent::div/following-sibling::app-menu[1]/div/a")).click();

					try {
						String Login = driver.findElement(By.xpath("//div[text()=\"Log in \"]")).getText();
						System.out.println("Current Page is : " + Login + " /. User needs to login to Admin");
						System.out.println("Logging into Admin");

						driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).click();
						driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("admin");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).click();
						driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("daa9828399");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//span[text()=\"Log in\"]")).click();

						Thread.sleep(1000);
						driver.findElement(By.xpath("//div[text()=\"Reboot\"]")).click();
						Thread.sleep(1000);
						
						RebootWarning = driver.findElement(By.xpath("//div[contains(text(),\"Warning: Your network will be offline for around 2 minutes.\")]")).getText();
						System.out.println(RebootWarning);
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
						Thread.sleep(1000);
						RestartingText = driver.findElement(By.xpath("//div[contains(text(),\"This could take up to 2 minutes. \")]")).getText();
						System.out.println(RestartingText);

					} catch (Exception e1) {
						System.out.println("User is already logged into admin. Proceeding with restart ...");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//a[text()=\" System \"]/parent::div/following-sibling::app-menu[1]/div/a")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//div[text()=\"Reboot\"]")).click();
						Thread.sleep(1000);
						
						RebootWarning = driver.findElement(By.xpath("//div[contains(text(),\"Warning: Your network will be offline for around 2 minutes.\")]")).getText();
						System.out.println(RebootWarning);
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
						Thread.sleep(1000);
						RestartingText = driver.findElement(By.xpath("//div[contains(text(),\"This could take up to 2 minutes. \")]")).getText();
						System.out.println(RestartingText);
					}
					
					
					//Waiting for reboot to complete
					//If "This could take up to 2 minutes" message showing do nothing and continue looping
					
					try {
						do {
							RestartingText=null;
							Thread.sleep(15000);
							RestartingText = driver.findElement(By.xpath("//div[contains(text(),\"This could take up to 2 minutes. \")]")).getText();
							System.out.println("Please wait.Restart is in progress....");
						}
						while (RestartingText!=null);
					} catch (Exception e10) {
						System.out.println("Restart Completed");
						driver.navigate().refresh();
						Thread.sleep(5000);
						driver.navigate().refresh();
						Thread.sleep(5000);
					}
						
					
					
					
					
/*			
					
					// Waiting for Status button to be clickable

					for (int i = 0; i < 3; i++) {
						try {
							Thread.sleep(5000);
							WebDriverWait wait = new WebDriverWait(driver, 60);
							WebElement Status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\" Status \"]")));
							
							Thread.sleep(15000);
							Status.click();
							Thread.sleep(4000);
							driver.findElement(By.xpath("//a[text()=\" Cellular \"]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("admin");
							Thread.sleep(1000);
							driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("daa9828399");
							Thread.sleep(1000);
							driver.findElement(By.xpath("//span[text()=\"Log in\"]")).click();
							break;
						} catch (Exception e4) {
							System.out.println("Restart is still in progress. Re-checking for : "+i+" time");
							driver.navigate().refresh();
							continue;
						}
					}

*/
					
					
					
					
					
					
					
					
					// Checking if 5G/4G is reconnected after restart

					
					
					for (int j = 0; j < 5; j++) {
					try {
						
							Thread.sleep(5000);
							driver.findElement(By.xpath("//a[text()=\" Overview \"]")).click();
							Thread.sleep(4000);
							Overview5GConnectionStatus = driver.findElement(By.xpath("//div[text()=\"5G Signal \"]/following-sibling::mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div")).getText();
							Thread.sleep(2000);
							Overview4GConnectionStatus = driver.findElement(By.xpath("//div[text()=\"4G Signal \"]/following-sibling::mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div")).getText();

							if (Overview5GConnectionStatus.equalsIgnoreCase("Connected")) {
								System.out.println("Test pass. 5G status is : " + Overview5GConnectionStatus);

							} else {
								System.out.println("Retrying since 5G status is " + Overview5GConnectionStatus);
								driver.navigate().refresh();
								continue;
							}

							if (Overview4GConnectionStatus.equalsIgnoreCase("Connected")) {
								System.out.println("Test pass. 4G status is : " + Overview4GConnectionStatus);
								break;

							} else {
								System.out.println("Retrying since 4G status is " + Overview4GConnectionStatus);
								driver.navigate().refresh();
								continue;
							}

						}
					 catch (Exception e1) {
						 
						System.out.println("Unable to fetch the Connection Status. Retrying... "+j+" times");
						driver.navigate().refresh();

					}
					}
		} catch (Exception e11) {
		 System.out.println("Please make sure that the device is connected via LAN");
		 
		}
		

	
			
			
			
			
			
			
		  
   

	}
}

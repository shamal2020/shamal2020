//Impersonate scripts are broken into several scripts.  Each script goes through each screen and validates variables on the screen.  There are no updates made in any of the impersonate scripts.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC35OwnerIMPERSONATEFleetOverviewPage extends testEnvironment  {

	public static void main(String[] args) throws InterruptedException {
		
		getEnvironment();

	    //login to Portal as ABS Admin
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("absadmin1");
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
		
	    //Wait for page to load
	    Thread.sleep(3000);
	    
	    //Search for WCN
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys("016015");
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys(Keys.ENTER);
	        
	    //click on IMPERSONATE
	    Thread.sleep(3000);
	    List<WebElement> test = driver.findElements(By.xpath("//*[contains(text(), ' Impersonate')]"));
	    test.get(0).click();	//tells it how many buttons to go down
	     
	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 90);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    
	    //Validate Landing Page
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating FLEET OVERVIEW");
	    
	    
	    //Validate Fleet Overview and display
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[1]/div/h2"));
	    System.out.println("All Vessels Section is displayed--PASS");
	    Thread.sleep(3000);
	    System.out.println("Fleet Overview Page Loaded--PASS");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/li[2]/div"));
	    System.out.println("DISPLAY-My Eagle Logo--PASS");    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"doughnutChart\"]"));
	    System.out.println("DISPLAY-Donut Chart--PASS");
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/button"));
	    System.out.println("DISPLAY-Total Number of vessels--PASS");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/button"));
	    System.out.println("DISPLAY-Survey/Audit-Overdue--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/button"));
	    System.out.println("DISPLAY-Survey/Audit-Due--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[1]/button"));
	    System.out.println("DISPLAY-Findings-Overdue--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div[2]/div[2]/button"));
	    System.out.println("DISPLAY-Findings-Due--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/div[1]/button"));
	    System.out.println("DISPLAY-Attendance-Submitted--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/div[2]/button"));
	    System.out.println("DISPLAY-Attendance-In Progress--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[5]/div[2]/button"));
	    System.out.println("DISPLAY-Certificates-Expiring within 180 days--PASS");
	    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture();
	    
	    //Validate Exclude Laid-Up Vessels 
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[2]/h4"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[2]/div/div/label/span")).click();
	    System.out.println("Exclude Laid-Up Vessels toggle on");
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/button"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[2]/div/div/label/span")).click();
	    System.out.println("Exclude Laid-Up Vessels toggle off");	
	    
	    //Validate Fleet Panel is present
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div/div[1]/div"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div/div[2]/div[1]/a/div"));
	    System.out.println("DISPLAY-Fleet Panel and List of Fleets--PASS");
	    Thread.sleep(3000);

	    //Validate Fleet Panel expand and contract
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[1]/i")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[1]/i")).click();
	    System.out.println("Fleet Panel contracts and expands-PASS");
	    
	    //Validate Card and Timeline toggle
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[3]/div/div/label[2]")).click();
	    System.out.println("Timeline Button can be clicked");
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[1]/div/div/h1"));
	    System.out.println("Timeline displayed");
	    
	    //toggle Exclude Laid-up-Vessels level
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div/div/label/span")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[4]/div/div/div/div/div/div/div/div/div[1]"));
	    System.out.println("Exclude Laid-Up Vessels toggle on");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[1]/div/div/label/span")).click();
	    Thread.sleep(10000);	    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[4]/div/div/div/div/div/div/div/div/div[1]"));
	    System.out.println("Exclude Laid-Up Vessels toggle off");
	    
	    //Validate CARD goes back to Fleet Overview
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[2]/div/div/label[1]")).click();
	    System.out.println("Card Button can be clicked");
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[1]/div/div/h1"));
	    System.out.println("All Vessels Displayed");
	    System.out.println("DISPLAY-Card/Timeline toggle--PASS");
	   
	    //Validate Search for Vessel
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//*[@id=\"searchinput\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"searchinput\"]")).sendKeys("OCEAN BLACKHAWK");
	    driver.findElement(By.xpath("//*[@id=\"searchinput\"]")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[5]/div/div/div/div/div"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[4]/div/span")).click();
	    System.out.println("DISPLAY-Search Vessel--PASS");
	    
	    System.out.println("IMPERSONATE-Vessel Overview--SANITY CHECK PASSED");
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();

	}
}

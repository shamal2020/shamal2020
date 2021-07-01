//Impersonate scripts are broken into several scripts.  Each script goes through each screen and validates variables on the screen.  There are no updates made in any of the impersonate scripts.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC41OwnerIMPERSONATEReports extends testEnvironment{

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
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating REPORTS");
	    
	    //Validate Reports
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[7]/li/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/h2"));
	    System.out.println("DISPLAY-Vessel Reports--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[3]/div/div/div/h2"));
	    System.out.println("DISPLAY-Fleet Reports--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[4]/div/div/div/h2"));
	    System.out.println("DISPLAY-Company Reports--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[5]/div/div/div/h2"));
	    System.out.println("DISPLAY-Access Manager Reports--PASS");
	    System.out.println("DISPLAY-Reports--PASS");
	    
	    
	    //Validate Vessel Status Report
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/div[2]/a/h3")).click();
	    Thread.sleep(2000);	  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[3]/button[1]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    System.out.println("GENERATE-Vessel Summary Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();
	    
	    
	    //Validate Vessel Aspect Report
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/div[4]/a/h3")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div/input")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div/ul/li[1]/span/label")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[4]/button[1]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    Thread.sleep(1000);
	    System.out.println("GENERATE-Vessel Aspect Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();

	    
	    //Validate Fleet Summary Report
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[3]/div/div/div/div[2]/a/h3")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[3]/button[1]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    Thread.sleep(2000);
	    System.out.println("GENERATE-Fleet Summary Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();	
	    
	    
	    //Validate Fleet Status Report
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[3]/div/div/div/div[4]/a/h3")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[3]/button[1]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    Thread.sleep(3000);
	    System.out.println("GENERATE-Fleet Status Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();	 
	    
	    
	    //Validate Company Status Report
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[4]/div/div/div/div[1]/div[2]")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[3]/button[1]")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    Thread.sleep(3000);
	    System.out.println("GENERATE-Company Status Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();	
	    
	    
	    //Validate Company Aspect Report
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[4]/div/div/div/div[1]/div[4]/a/h3")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/ul/li[2]/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div/ul/li[1]/span/label")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div/div[4]/button[1]")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/canvas"));
	    Thread.sleep(2000);
	    System.out.println("GENERATE-Company Aspect Report--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();
	    
	    
	    //Validate Users and Their Assigned Fleets Report
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[5]/div/div/div/div[2]/a/h3")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]"));
	    System.out.println("GENERATE-Users and Their Assigned Fleets Report--PASS");
	    
	    
	    //Validate Users and Their Assigned Vessels Report
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[5]/div/div/div/div[4]/a/h3")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]"));
	    System.out.println("GENERATE-Users and Their Assigned Vessels Report--PASS");
	    
	    
	    //Validate Users and Their Assigned Project Groups Report
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[5]/div/div/div/div[6]/a/h3")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]"));
	    System.out.println("GENERATE-Users and Their Assigned Project Groups Report--PASS");
	    
		 
	    //Validate Users and Their Assigned Projects Report
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[5]/div/div/div/div[8]/a/h3")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]"));
	    System.out.println("GENERATE-Users and Their Assigned Projects Report--PASS");  
	    
	    
	    Thread.sleep(30000);
	    System.out.println("Reports --SIT PASS");  
	    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture();
	    
	    //Log out
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    Thread.sleep(3000);
	    driver.close();
	    	    

	}

}

//Impersonate scripts are broken into several scripts.  Each script goes through each screen and validates variables on the screen.  There are no updates made in any of the impersonate scripts.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC36OwnerIMPERSONATEVesselInfo extends testEnvironment  {

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
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating VESSEL INFO");
	    
	    //Validate Vessel Info
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[5]/div/div/div/div[3]/div/div/div/div")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[1]/li/a"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    System.out.println("Going to Vessel Overview for 2nd Vessel listed");
	    	    
	    //Validate Vessel Overview
	    //Vessel Header
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[1]/h2"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[1]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[3]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[4]"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[5]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[6]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[7]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[8]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[9]"));
	    System.out.println("DISPLAY-Vessel Header--PASS");
	    
	    //Surveys, Findings, Certificates, Parts
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/h1"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div/div[2]/h1"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/h1"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/h1"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[3]/div/div/div[2]/div/div/h1"));  
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div/div/div[4]/div/div/div[2]/div/div/h1"));
	    System.out.println("DISPLAY-Summary Count Survey, Findings, Certificates, Parts--PASS");
	    
	    //Surveys, Findings, Certificates
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/h3"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/h3"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div[1]/h3"));
	    System.out.println("DISPLAY-List Survey, Findings, Certificates, Parts Due or Overdue--PASS");
	    
	    //Alerts
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/div[1]/div[1]/h2"));
	    System.out.println("DISPLAY-Alerts--PASS");
	    
	    //View All Surveys
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]/a")).click();
	    Thread.sleep(2000);    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    Thread.sleep(1000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[1]/li/a")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div"));
	    System.out.println("LINK-View All Surveys--PASS");
	    
	    //View All Findings
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a")).click();
	    Thread.sleep(2000);    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    Thread.sleep(1000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[1]/li/a")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div"));
	    System.out.println("LINK-View All Findings--PASS");
	    
	    //View All Certificates
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div[1]/div/div[1]/a")).click();
	    Thread.sleep(2000);    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    Thread.sleep(1000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[1]/li/a")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div"));
	    System.out.println("LINK-View All Certificates--PASS");
	    
	    
	    //View All Alerts
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/div[1]/div[2]/a")).click();
	    Thread.sleep(2000);    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    Thread.sleep(1000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[1]/li/a")).click();
	    Thread.sleep(2000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div"));
	    System.out.println("LINK-View All Alerts Archive--PASS");    
	    
	    //Vessel Details
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[2]/li/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    System.out.println("DISPLAY-Vessel Details--PASS");  

	    //Owner
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[3]/li/a"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    System.out.println("DISPLAY-Owner--PASS"); 
	    
	    //Vessel Assets
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[4]/li/a")).click();
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div/ol/li/div[2]/ol/li/div/div[1]/div"));
	    System.out.println("DISPLAY-Vessel Assets--PASS");
	    
 	    //Parts
	    Thread.sleep(6000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[5]/li/a")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[4]/div/div/div/div[2]/div[3]/div/div/ol/li/div[2]/ol/li/div[1]"));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div/h1"));
	    System.out.println("DISPLAY-Parts--PASS"); 
	    
	    //Condition
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[6]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/button"));
	    System.out.println("DISPLAY-Condition--PASS"); 
	    
	    //Surveys
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[7]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/div"));
	    System.out.println("DISPLAY-Surveys--PASS"); 
	    
	    //Findings
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[8]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div[1]/div/strong"));
	    System.out.println("DISPLAY-Findings--PASS"); 
	    
	    //Certificates
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[9]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div/div/div/div[1]/div/div[1]/strong"));
	    System.out.println("DISPLAY-Certificates--PASS"); 
	    
	    //Documents
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[10]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[4]/div/div[3]/div/div/div/div[1]/div/div[1]/strong"));
	    System.out.println("DISPLAY-Documents--PASS"); 
	    
	    //Alerts Archive
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[11]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/strong"));
	    System.out.println("DISPLAY-Alerts Archive--PASS"); 
	    
	    //Orders
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[12]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div/div[2]/div/div/div/ul/li[2]/a"));
	    System.out.println("DISPLAY-Orders--PASS"); 
	    
	    //Timeline
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[13]/li/a")).click();
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div/div/div/div/div/div/div/div[5]/div[1]/div/div[1]/div"));
	    System.out.println("DISPLAY-Timeline--PASS"); 
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
	    
	    System.out.println("/IMPERSONATE-Vessel Overview--SANITY CHECK PASSED");
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();



	}

	}


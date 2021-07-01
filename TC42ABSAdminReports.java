///This script runs the ABS Admin reports.  For the Customer Search report it always searches for WCN 016015, then checks the first checkbox, then checks for the generating report to pop up.  If all of this happens its a pass.
//The Customer List report checks for the downloading pop up if this is present it is considered a pass.
package sanityTest;

import org.openqa.selenium.By;

public class TC42ABSAdminReports extends testEnvironment {


		public static void main(String[] args) throws InterruptedException {
			
			getEnvironment();

		    //login to Portal as ABS Admin
		    driver.findElement(By.xpath("//div[2]/div")).click();
		    driver.findElement(By.xpath("//input")).sendKeys("absadmin1");
		    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
		    driver.findElement(By.xpath("//button")).click();
			
		    //Wait for page to load
		    Thread.sleep(3000);
		    
		    //Validate Customer Search Report
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();
		    System.out.println("Customer Search Report clicked");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/div[2]/a/h3")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div[2]/div/input")).sendKeys("016015");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div/div/div[7]/button[1]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[3]/div/div/div/ol/li/div/div/div/div/div[3]/div[2]/div")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[2]/button")).click();
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/h1"));
		    Thread.sleep(10000);		    
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/button")).click();
		    System.out.println("Customer Search Report Generated"); 
		    
		    //Validate Customer List Report
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/div[4]/a/h3")).click();
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[1]/div[2]/div/div/div[2]"));
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/div[2]/div/div/div/h2"));
		    System.out.println("Customer List Report Generated"); 
		    
	        //screen capture
		    Thread.sleep(6000);
			 new newScreenCapture().createNewCapture();

		    //if it makes it this far the report has run
		    Thread.sleep(6000);
		    System.out.println("Reports --SIT PASS");  
		    
		    //Log out
		    Thread.sleep(6000);
		    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

		    Thread.sleep(3000);
		    driver.close();
		    
		    
		    
		  }

}

//This script impersonates for WCN 016015 then goes to the first order in the history and clicks on the survey and invoice report buttons.  If an error message does not pop, it is a pass.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC44OwnerIMPERSONATESurveyInvoiceReport extends testEnvironment  {

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
	    WebDriverWait wait1 = new WebDriverWait(driver, 120);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    System.out.println("IMPERSONATE PAGE DISPLAYED");
	    
	    //Validate Survey Requirements
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();		//click on Fleet Overview
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[5]/div/div/div/div[2]/div/div/div")).click();		//click on 2nd Vessel
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[12]/li/a")).click();		//click on Orders
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div/div[2]/div/div/div/ul/li[2]/a")).click();	//click on HISTORY button
    	System.out.println("Orders History Displays");
	    
    	//Validate Survey Report Downloads
	    System.out.println("IMPERSONATE PAGE DISPLAYED, validating Survey and Invoice Reports download works");
    	Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/div[2]/button[1]")).click();		//click on Survey Report Button
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> filedownloaded = driver.findElements(By.xpath("//div[contains(text(), 'No file available for download')]"));
	    
	    if (filedownloaded.size() > 0) {
	    	System.out.println("SURVEY REPORT DOWNLOAD NOT SUCCESSFUL - SIT FAIL"); 
	    } else {
	    	System.out.println("SURVEY REPORT DOWNLOAD SUCCESSFUL - SIT PASS");
	    
	    }
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();

                
       	//Validate Invoice Report Downloads
	    System.out.println("IMPERSONATE PAGE DISPLAYED, validating Survey and Invoice Reports download works");
    	Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/div[2]/button[2]")).click();		//click on Invoice Report Button
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> filedownloaded1 = driver.findElements(By.xpath("//div[contains(text(), 'No file available for download')]"));
	    
	    if (filedownloaded1.size() > 0) {
	    	System.out.println("SURVEY REPORT DOWNLOAD NOT SUCCESSFUL - SIT FAIL"); 
	    } else {
	    	System.out.println("SURVEY REPORT DOWNLOAD SUCCESSFUL - SIT PASS");
	    
	    }
	    //screen capture
	    Thread.sleep(3000);	
        new screenCapture().createCapture();
        
	    Thread.sleep(3000);
	    driver.close();
 	    
	}
}

	 
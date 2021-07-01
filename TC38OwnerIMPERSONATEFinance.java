//Impersonate scripts are broken into several scripts.  Each script goes through each screen and validates variables on the screen.  There are no updates made in any of the impersonate scripts.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC38OwnerIMPERSONATEFinance extends testEnvironment  {

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
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating Finance");
	    
	    //Validate Finance
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[4]/li/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div/div/h1"));
	    
	    //Balance, Aging, and Balance Distribution per Vessel
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[4]/div/div[1]/div[1]/div/div/div[2]/div/h1"));
	    System.out.println("DISPLAY-Balance--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[4]/div/div[1]/div[2]/div/div/div[2]/div/div/canvas"));
	    System.out.println("DISPLAY-Aging--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[4]/div/div[1]/div[3]/div/div/div[2]/div/div/canvas"));
	    System.out.println("DISPLAY-Balance Distribution per Vessel--PASS");
	    
	    //Download Statement of Account
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[4]/div/div[1]/div[1]/div/div/div[2]/div/div[2]/button")).click();
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'statement.pdf cannot be downloaded at this time')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("SIT FAILED STATEMENT OF ACCOUNT COULD NOT DOWNLOAD"); 
	    } else {
	    	System.out.println("SIT PASS STATEMENT OF ACCOUNT DOWNLOADED");
	    }
	    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture();
	    
	    //close error message
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div")).click();
	    
	    //download Invoice
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[4]/div/div[2]/div/div[9]/div/div/div/div/div[2]/button")).click();
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> statementDownloaded = driver.findElements(By.xpath("//div[contains(text(), 'statement.pdf cannot be downloaded at this time')]"));
	    
	    if (statementDownloaded.size() > 0) {
	    	System.out.println("SIT FAILED INVOICE COULD NOT DOWNLOAD"); 
	    } else {
	    	System.out.println("SIT PASS INVOICE DOWNLOADED");
	    }
	    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture();
	    
	    System.out.println("IMPERSONATE-Company Dashboard--SANITY CHECK PASSED");
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	       

	}

	} 
	    
	    
	    
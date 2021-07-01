//03/09/2020
//This script always selects the first uses and resets the password.  If a specific user is necessary the script will need to be changed.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC14ResetOwnerUserPassword extends testEnvironment {

	public static void main(String[] args) throws InterruptedException {
		
		getEnvironment();

	    //login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("transocean");
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();

	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    
	    //Select Access Manager
	    driver.findElement(By.xpath("//a[contains(text(),\'Access Manager\')]")).click();
      
		//Wait for page to finish loading
	    Thread.sleep(10000);
	    
	    //Select User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[4]/div/div/div/div/div[2]/div[2]/div/div/div[1]/ol/li/div/div/div[2]/div[1]/div[1]/strong")).click();
	    Thread.sleep(3000);
	    
	    //Reset Password
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[1]/div/div/div/button")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[1]/div/div/div/div[2]/div/div/div[3]/button[2]")).click();

	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Reset Password Email Sent to User')]"));
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("SANITY TEST PASS"); 
	    } else {
	    	System.out.println("SANITY TEST FAIL");
	    }
	         
	    
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click();
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
		
		

	}

}

//3/9/2020
//This script searches for WCN 068446 and resets the password for this account manager.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class TC33ResetOwnerAccountManagerPassword extends testEnvironment  {

	public static void main(String[] args) throws InterruptedException {
		
		getEnvironment();

	    //login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("absadmin1");
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
  
		//Wait for page to load
	    Thread.sleep(3000);
	    
	    //Search for Account Manager to replace
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys("068446");
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys(Keys.ENTER);
	    
	    //Click on Company
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[2]/div/div/ol/li/div/div/div[1]/div[1]/div[1]/strong")).click();  
	    
	    //Reset Password
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[1]/div/div/div/button")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[1]/div/div/div/div[2]/div/div/div[3]/button[2]")).click();

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
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div")).click();
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click();
	    
	    //Log out
	    //Thread.sleep(2000);
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();

	}

}

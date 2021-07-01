//This script creates a new user then adds a Sanity Check Fleet and Project Group to the user.  This script must be run after a users is created and also after a Project Group and Fleet is created.

package sanityTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC15AddPGFTToUser extends testEnvironment {

	public static void main(String[] args) throws InterruptedException {

		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
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
	    
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(3000);	 
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityCkAddUserwpgf"+ nxt);
	    driver.findElement(By.xpath("//input[@name=\'userFirstNameValue\']")).sendKeys("Gina");
	    driver.findElement(By.xpath("//input[@name=\'userLastNameValue\']")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//input[@name=\'emailValue\']")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//input[@name=\'phoneValue\']")).sendKeys("281-299-0000");
	    driver.findElement(By.xpath("//input[@value=\'Choose Administrator\']")).click();
	    Thread.sleep(2000);		    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/ul/li[2]/span")).click();
	    System.out.println("User info input");
	    
	    //add Plan Review and Vessel permissions
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div/div/div[3]/div/div/label/span")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div/div/div[4]/div/div/label/span")).click();
	    System.out.println("Plan Review and Vessel permissions added");
	    
	    //search for "SanityAddFleet" and Add Fleet
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/input")).sendKeys("SanityAddFleet");
	    Thread.sleep(2000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[3]/div/div[1]/div/div/label/span")).click();
	    System.out.println("SanityAddFleet added");
	    
	    //search for "SanityAddPG" and Add Project Group
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/div/div/input")).sendKeys("SanityAddPG");
	    Thread.sleep(2000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[3]/div/div[1]/div/div/label/span")).click();
	    System.out.println("SanityAddPG added");
	    
		//Select Access Profile
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/input")).click();
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/ul/li[2]/span")).click();
	    System.out.println("Access Profile added");	    
	    	    
	    //Submit
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[5]/button")).click();    
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("SANITY TEST PASS"); 
	    } else {
	    	System.out.println("SANITY TEST FAIL");
	    }
 
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
	    
	    //close System Response message
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div")).click();
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click();
	    
	    //Log out
	    //Thread.sleep(2000);
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
	    
	}


}

//03/09/2020
//This script is written to create a fleet selecting the first project in the list.  If more is required, the script will have to be changed.

package sanityTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC13CreateFleet extends testEnvironment {

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
	    Thread.sleep(15000);
	    
	    //Capture Fleet Count ** BEFORE
	    int fleetBeforeCount = 0;
	    	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[2]/div/a[1]/h1"));
        for (WebElement webElement : dateBox) {
        
        //Convert int to var
        fleetBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nCreateFleet.main()--fleetBeforeCount = "+fleetBeforeCount);
	    
	    //Add Fleet
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[1]/div/button")).click();
	    WebDriverWait wait3 = new WebDriverWait(driver, 20);
	    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/h2")));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div/div/fragment/div/input")).sendKeys("SanityAddFleet"+ nxt);	    							   
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[4]/div[1]/div[1]/div/div/label/span")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/button")).click();
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("FLEET ADDED SUCCESSFULLY"); 
	    } else {
	    	System.out.println("FLEET NOT ADDED SUCCESSFULLY");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
	    
	  //Capture Fleet Count ** AFTER
	    int fleetAfterCount = 0;
	    
	   List <WebElement> fleetAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[2]/div/a[1]/h1"));

	   //Print after Count
	   Thread.sleep(3000);
        for (WebElement webElement : fleetAfterCountList) {
            System.out.println("CreateFleet.main()--fleetAfterCount = " +webElement.getText());
            fleetAfterCount = Integer.parseInt(webElement.getText());
        } 
             
        if (fleetBeforeCount != 0 && fleetAfterCount != 0 && fleetBeforeCount < fleetAfterCount)
        {
        	System.out.println("CreateFleet.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("CreateFleet.main() -- SANITY TEST FAIL");
	    }
    
        //click on Oversight Project Groups
        Thread.sleep(3000);
        driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[2]/div/a[1]/h1")).click();
        
        
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();

	}

}

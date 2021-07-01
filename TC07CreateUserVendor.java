//03/09/2020
//**This script is written for a Vendor Company Type that has Plan Review and NO Vessel permission.  If this changes, the script will have to be re-written as the location of the 
//xpaths changed depending on what permissions display.
//**To check to see if any new users have been added, the quickest way is to run the Customer List Report in ABS Admin, open the spreadsheet and filter on column Company Type = Vendor.

package sanityTest;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC07CreateUserVendor extends testEnvironment {

	public static void main(String[] args) throws InterruptedException {
		
		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
		getEnvironment();

	    //login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("hydril4787");	//VENDOR
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
	    Thread.sleep(60);

	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[5]/li/a")));
	    
	    //Select Access Manager
	    driver.findElement(By.xpath("//a[contains(text(),\'Access Manager\')]")).click();
      
		//Wait for page to finish loading
	    Thread.sleep(10000);
	    
	    //Capture User Count ** BEFORE
	    int userBeforeCount = 0;
	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));
        for (WebElement webElement : dateBox) {

        //Convert int to var
            userBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nTC1CreateVendorUserOwner.main()--userBeforeCount = "+userBeforeCount);
        
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityAddVendorUser"+ nxt); 
	    driver.findElement(By.xpath("//input[@name=\'userFirstNameValue\']")).sendKeys("Gina");
	    driver.findElement(By.xpath("//input[@name=\'userLastNameValue\']")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//input[@name=\'emailValue\']")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//input[@name=\'phoneValue\']")).sendKeys("281-299-0000");
	    driver.findElement(By.xpath("//input[@value=\'Choose Administrator\']")).click();
	    Thread.sleep(2000);		    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/ul/li[2]/span")).click();
	    System.out.println("User info input");
	    
	    //add Plan Review permission
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div/div/div[3]/div/div/label/span")).click();
	    System.out.println("Plan Review permission added");
	    Thread.sleep(6000);
	    
		//Scroll Down
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
	  	    
	    //pick first Project Group
	    Thread.sleep(6000);
	    //click on Project Group tab
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/ul/li[1]/a/h4")).click();
	    Thread.sleep(6000);
	    //select first Project
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[3]/div/div[1]/div/div/label/span")).click(); 
	    System.out.println("Project Group added");
	    
		//Select Access Profile
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/input")).click();
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/ul/li[2]/span")).click();
	    System.out.println("Access Profile added");
	    Thread.sleep(6000);
	    
	    //Submit
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[4]/button")).click();   
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("USER ADDED SUCCESSFULLY"); 
	    } else {
	    	System.out.println("USER NOT ADDED SUCCESSFULLY");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
	    
	  //Capture User Count ** AFTER
		Thread.sleep(3000);
	    int userAfterCount = 0;
	    
	   List <WebElement> userAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));

	   //Get after Count
        for (WebElement webElement : userAfterCountList) {
            System.out.println("TC1CreateVendorUserOwner.main()--userAfterCount = " +webElement.getText());
            userAfterCount = Integer.parseInt(webElement.getText());
        } 
        
        if (userBeforeCount != 0 && userAfterCount != 0 && userBeforeCount < userAfterCount)
        {
        	System.out.println("TC1CreateVendorUserOwner.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("TC1CreateVendorUserOwner.main() -- SANITY TEST FAIL");
	    }
    
        
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
	    

}

}



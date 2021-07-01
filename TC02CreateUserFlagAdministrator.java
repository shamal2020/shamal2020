//03/09/2020
//This script is written assuming that the Flag Admin user being created will have both Plan Review and Vessel permissions.  If this changes the script will need to be
//adjusted as the location of xpaths on the screen change depending on permissions.
//**To check to see if any new users have been added, the quickest way is to run the Customer List Report in ABS Admin, open the spreadsheet and filter on column Company Type = Flag Administrator.

package sanityTest;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC02CreateUserFlagAdministrator extends testEnvironment {

	public static void main(String[] args) throws InterruptedException {
		
		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
		getEnvironment();
		
	    //login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("canada");		//FLAG ADMINISTRATOR  
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
	    Thread.sleep(60);

	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\'Reports\')]")));
	    
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
        
        System.out.println("\nTC2CreateUserFlagAdministrator.main()--userBeforeCount = "+userBeforeCount);
        
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityAddFlagAdminUser"+ nxt);  
	    driver.findElement(By.xpath("//input[@name=\'userFirstNameValue\']")).sendKeys("Gina");
	    driver.findElement(By.xpath("//input[@name=\'userLastNameValue\']")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//input[@name=\'emailValue\']")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//input[@name=\'phoneValue\']")).sendKeys("281-299-0000");
	    driver.findElement(By.xpath("//input[@value=\'Choose Administrator\']")).click();
	    Thread.sleep(2000);		    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/ul/li[2]/span")).click();
	    System.out.println("User info input");
	    
	    //add Vessel permissions
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/div/div/div[2]/div/div/div/div[3]/div/div/label/span")).click();
	    System.out.println("Vessel permission added");
	        
	    //select vessels and projects
	    //pick first Fleet
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/input")).sendKeys("Gina");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/button")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/label/span")).click(); 
	    System.out.println("Fleet Added");
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
            System.out.println("TC2CreateUserFlagAdministrator.main()--userAfterCount = " +webElement.getText());
            userAfterCount = Integer.parseInt(webElement.getText());
        } 
        
        if (userBeforeCount != 0 && userAfterCount != 0 && userBeforeCount < userAfterCount)
        {
        	System.out.println("TC2CreateUserFlagAdministrator.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("TC2CreateUserFlagAdministrator.main() -- SANITY TEST FAIL");
	    }
    
        
        //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
	    

}

}

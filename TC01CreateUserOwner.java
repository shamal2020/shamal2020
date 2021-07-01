//03/09/2020
//This script is written assuming that the Owner user being created will have both Plan Review and Vessel permissions.  If this changes the script will need to be
//adjusted as the location of xpaths on the screen change depending on permissions.
//**To check to see if any new users have been added, the quickest way is to run the Customer List Report in ABS Admin, open the spreadsheet and filter on column Company Type = Owner.

package sanityTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC01CreateUserOwner extends testEnvironment {

	public static void main(String[] args) throws InterruptedException, AWTException {

		Random ran = new Random();
		int nxt = ran.nextInt(1000);
	
		getEnvironment();
		
		//login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("transocean");		//OWNER  
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
	    Thread.sleep(3000);


	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 90);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    
	    //refresh to close ChatBot window
	    driver.navigate().refresh();		//refreshes the page so that Chatbot will close
	    
	    //Select Access Manager
	    driver.findElement(By.xpath("//a[contains(text(),\'Access Manager\')]")).click();
      
		//Wait for page to finish loading
	    Thread.sleep(15000);
	    
	    //Capture User Count ** BEFORE
	    int userBeforeCount = 0;
	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));
        for (WebElement webElement : dateBox) {

        //Convert int to var
            userBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nTC1CreateUserOwner.main()--userBeforeCount = "+userBeforeCount);
        
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityAddOwnerUser"+ nxt);  //Fail: "BargeSup712"   //Pass: "SanityAddOwnerUser"+ nxt
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
	    
	    //select vessels and projects
	    //pick first Fleet
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/input")).sendKeys("Gina");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div/div/button")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/label/span")).click(); 
	    System.out.println("Fleet Added");
	    
	    //pick first Project Group
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/div/div/input")).sendKeys("Gina");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/div/div/button")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/label/span")).click(); 
	    System.out.println("Project Group added");
	    
	    //pick first oversight project group
	    driver.findElement(By.xpath("//li[3]/a/h4")).click();    
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[3]/div/div/div/div[3]/div[3]/div/div[1]/div/div/label/span")).click();
	    System.out.println("Oversight Project Group added");
	    
		//Select Access Profile
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/input")).click();
	    Thread.sleep(3000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/ul/li[2]/span")).click();
	    System.out.println("Access Profile added");
	    Thread.sleep(6000);
	    
	    //Submit
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[5]/button")).click();    
	     
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("ACTION SUCCESSFUL"); 
	    } else {
	    	System.out.println("ACTION NOT SUCCESSFUL");
	    }
	    
    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture(); 
	    
	  //Capture User Count ** AFTER
		Thread.sleep(3000);
	    int userAfterCount = 0;
	    
	   List <WebElement> userAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));

	   //Get after Count
        for (WebElement webElement : userAfterCountList) {
            System.out.println("TC1CreateUserOwner.main()--userAfterCount = " +webElement.getText());
            userAfterCount = Integer.parseInt(webElement.getText());
        } 
        
        if (userBeforeCount != 0 && userAfterCount != 0 && userBeforeCount < userAfterCount)
        {
        	System.out.println("TC1CreateUserOwner.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("TC1CreateUserOwner.main() -- SANITY TEST FAIL");
	    }
    
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
		}


	}
	    
	    




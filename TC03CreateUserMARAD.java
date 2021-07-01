//03/09/2020
//**Currently there is only one MARAD user and there are no vessels or Projects assigned.  So just a User would be added with Access Manager/Design permissions.
//**To check to see if any new users have been added, the quickest way is to run the Customer List Report in ABS Admin, open the spreadsheet and filter on column Company Type = MARAD

package sanityTest;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC03CreateUserMARAD extends testEnvironment {


	public static void main(String[] args) throws InterruptedException {
		
		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
		getEnvironment();

	    //login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("usdept06");		//MARAD	
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
	    Thread.sleep(60);

	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[5]/li/a")));
	    
	    //Select Access Manager
	    driver.findElement(By.xpath("//a[contains(text(),\'Access Manager\')]")).click();
      
		//Wait for page to finish loading
	    Thread.sleep(5000);
	    
	    //Capture User Count ** BEFORE
	    int userBeforeCount = 0;
	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));
        for (WebElement webElement : dateBox) {

        //Convert int to var
            userBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nCreateMARADUser.main()--userBeforeCount = "+userBeforeCount);
        
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityAddMARADUser"+ nxt);  
	    driver.findElement(By.xpath("//input[@name=\'userFirstNameValue\']")).sendKeys("Gina");
	    driver.findElement(By.xpath("//input[@name=\'userLastNameValue\']")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//input[@name=\'emailValue\']")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//input[@name=\'phoneValue\']")).sendKeys("281-299-0000");
	    driver.findElement(By.xpath("//input[@value=\'Choose Administrator\']")).click();
	    Thread.sleep(2000);		    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/ul/li[2]/span")).click();
	    System.out.println("User info input");
	    Thread.sleep(6000);
	    	    
	    //Submit
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/button")).click();   
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("USER ADDED SUCCESSFULLY"); 
	    } else {
	    	System.out.println("USER NOT ADDED SUCCESSFULLY");
	    }
	    
	  //Capture User Count ** AFTER
		Thread.sleep(3000);
	    int userAfterCount = 0;
	    
	   List <WebElement> userAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));

	   //Get after Count
        for (WebElement webElement : userAfterCountList) {
            System.out.println("CreateMARADUser.main()--userAfterCount = " +webElement.getText());
            userAfterCount = Integer.parseInt(webElement.getText());
        } 
        
        if (userBeforeCount != 0 && userAfterCount != 0 && userBeforeCount < userAfterCount)
        {
        	System.out.println("CreateMARADUser.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("CreateMARADUser.main() -- SANITY TEST FAIL");
	    }
    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
        
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
	    

}

}

//03/09/2020
//**This script is written for a Owner Company Type that has Plan Review and Vessel permissions.  If this changes, the script will have to be re-written as the location of the 
//xpaths changed depending on what permissions display.


package sanityTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC10CreateAdmin extends testEnvironment  {

	//private static final Function JavascriptExecuter = null;

	public static void main(String[] args) throws InterruptedException {
		
		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
		getEnvironment();
		
	    //login to Portal
	    //driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("transocean");		//OWNER
	    //driver.findElement(By.xpath("//input")).sendKeys("canada");		//FLAG ADMINISTRATOR
	    //driver.findElement(By.xpath("//input")).sendKeys("usdept06");		//MARAD	
	    //driver.findElement(By.xpath("//input")).sendKeys("RinaAm");		//CLASSIFICATION SOCIETY
	    //driver.findElement(By.xpath("//input")).sendKeys("Austal4824");	//DESIGNER
	    //driver.findElement(By.xpath("//input")).sendKeys("imabariadmin");	//SHIPYARD
	    //driver.findElement(By.xpath("//input")).sendKeys("jtmadmin024");	//VENDOR
	    //driver.findElement(By.xpath("//input")).sendKeys("uscg9743");		//USCG ACP	
		driver.findElement(By.xpath("//html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div[3]/button")).click();

	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 59);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[6]/li/a")));
	    
	    //Select Access Manager
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[5]/li/a")).click();
      
		//Wait for page to finish loading
	    Thread.sleep(9000);	 
	    
	    //Capture User Count ** BEFORE
	    int userBeforeCount = 0;
	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));
        for (WebElement webElement : dateBox) {

        //Convert int to var
            userBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nCreateAdmin.main()--userBeforeCount = "+userBeforeCount);
        	    
	    //Add User
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/button")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//input[@name=\'userIdValue\']")).sendKeys("SanityAddOwnerAdmin"+ nxt);  //Fail: "SanityAddAdmin599"   //Pass: "SanityAddAdmin"+ nxt
	    driver.findElement(By.xpath("//input[@name=\'userFirstNameValue\']")).sendKeys("Gina");
	    driver.findElement(By.xpath("//input[@name=\'userLastNameValue\']")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//input[@name=\'emailValue\']")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//input[@name=\'phoneValue\']")).sendKeys("281-299-0000"); 
	    driver.findElement(By.xpath("//select[@id=\'role\']")).click();
	    WebElement dropdown = driver.findElement(By.id("role"));
	    dropdown.findElement(By.xpath("//option[. = 'Administrator']")).click();
	    driver.findElement(By.xpath("//select[@id=\'role\']")).click(); 
	    
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
	    Thread.sleep(2000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/input")).click();
	    Thread.sleep(2000);	
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/ul/li[2]/span")).click();
	    System.out.println("Access Profile added");
	    
	    //Submit
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[5]/button")).click();    

	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("ADMIN ADDED SUCCESSFULLY"); 
	    } else {
	    	System.out.println("ADMIN NOT ADDED SUCCESSFULLY");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
        
	  //Capture User Count ** AFTER
		Thread.sleep(3000);
	    int userAfterCount = 0;
	    
	   List <WebElement> userAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));

	   //Get After Count
        for (WebElement webElement : userAfterCountList) {
            System.out.println("CreateAdmin.main()--userAfterCount = " +webElement.getText());
            userAfterCount = Integer.parseInt(webElement.getText());
        } 
        
        if (userBeforeCount != 0 && userAfterCount != 0 && userBeforeCount < userAfterCount)
        {
        	System.out.println("CreateAdmin.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("CreateAdmin.main() -- SANITY TEST FAIL");
	    }
    
        
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	    
	    	    	
	}
}



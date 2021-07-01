//03/09/2020
//This script is written to create a oversight project group by selecting the first project in the list.  If more is required, the script will have to be changed.

package sanityTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC12CreateOversightProjectGroup extends testEnvironment  {

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
	    Thread.sleep(9000);
	    
	    //Capture Oversight Project Group Count ** BEFORE
	    int oversightProjectGroupBeforeCount = 0;
	    	    
	    List <WebElement> dateBox = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/a[1]/h1"));
        for (WebElement webElement : dateBox) {
        
        //Convert int to var
        oversightProjectGroupBeforeCount = Integer.parseInt(webElement.getText());    
        } 
        
        System.out.println("\nCreateOversightProjectGroup.main()--oversightProjectGroupBeforeCount = "+oversightProjectGroupBeforeCount);
	    
	    //Add Oversight Project Group
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[1]/div/button")).click();
	    WebDriverWait wait3 = new WebDriverWait(driver, 10);
	    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[1]")));
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div/input")).sendKeys("SanityAddOPG"+ nxt);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[4]/div[1]/div[1]/div/div/label/span")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/button")).click();
		
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("OVERSIGHT PROJECT GROUP ADDED SUCCESSFULLY"); 
	    } else {
	    	System.out.println("OVERSIGHT PROJECT GROUP NOT ADDED SUCCESSFULLY");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture(); 
	    
	  //Capture Oversight Project Group Count ** AFTER
		Thread.sleep(3000);
	    int oversightProjectGroupAfterCount = 0;
	    
	   List <WebElement> oversightProjectGroupAfterCountList = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/a[1]/h1"));

	   //Print all the which are sibling of the the element named as 'SELENIUM' in 'Popular course'
        for (WebElement webElement : oversightProjectGroupAfterCountList) {
            System.out.println("CreateOversightProjectGroup.main()--oversightProjectGroupAfterCount = " +webElement.getText());
            oversightProjectGroupAfterCount = Integer.parseInt(webElement.getText());
        } 
             
        if (oversightProjectGroupBeforeCount != 0 && oversightProjectGroupAfterCount != 0 && oversightProjectGroupBeforeCount < oversightProjectGroupAfterCount)
        {
        	System.out.println("CreateOversightProjectGroup.main() -- SANITY TEST PASS");
	    } else {
	    	System.out.println("CreateOversightProjectGroup.main() -- SANITY TEST FAIL");
	    }
    
        //click on Oversight Project Groups
        Thread.sleep(3000);
        driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/a[1]/h1")).click();
        
        
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 	
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();

	}

}

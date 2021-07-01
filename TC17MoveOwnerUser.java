//this script moves users. In order to move users an admin must have users assigned to them. 
//this script will always use arispoli and move the first user.  It has issues though and is not complete as of 4/1/2020.

package sanityTest;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC17MoveOwnerUser extends testEnvironment {

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
    
	    //Search for Admin: "ARispoli"
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).sendKeys("ARispoli");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).sendKeys(Keys.ENTER);
	    
	    //Click on Admin
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[4]/div/div/div/div/div[2]/div[2]/div/div/div/ol/li/div/div/div[2]/div[1]/div[4]/span")).click();
	    
	    //Click on Move User and confirm the page has popped
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/button")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[1]/h4"));
	    System.out.println("Move User List loaded");

	    //Select Administrator
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/input")).click();
	    Thread.sleep(3000);	   
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/ul/li[2]/span")).click();
	    
	    //De-select Users and Save
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[4]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[5]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[6]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[7]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[8]/div/div[1]/div/div/label/span")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[4]/div[2]/div/div/div/div/div[2]/div/div/div[3]/button[2]")).click();
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded1 = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded1.size() > 0) {
	    	System.out.println("ACTION SUCCESSFUL"); 
	    } else {
	    	System.out.println("ACTION NOT SUCCESSFUL");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
        
        //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 
	    System.out.println("User moved, now moving him back...");
	    
	    //Search for user diegoreixash and move him back to ARispoli
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/span")).click();
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).sendKeys("diegoreixach");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[4]/div/div/div/div/div[2]/div[2]/div/div/div/ol/li/div/div/div[2]/div[1]/div[1]/strong")).click();
	    Thread.sleep(3000);
	    System.out.println("diegoreixach found");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/input")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/div[2]/div/ul/li[4]/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[4]/button")).click();
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded2 = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded2.size() > 0) {
	    	System.out.println("diegoreixach moved back to rispoli successfully, SANITY TEST PASS"); 
	    } else {
	    	System.out.println("diegoreixach NOT moved back to rispoli successfully, SANITY TEST FAIL");
	    }
	    
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();


		}
		
	}
	    
	    
	    